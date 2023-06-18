package club.beenest.blog.service.comment.impl;

import club.beenest.blog.dao.comment.CommentMapper;
import club.beenest.blog.entity.comment.Comment;
import club.beenest.blog.entity.comment.PageComment;
import club.beenest.blog.entity.user.User;
import club.beenest.blog.service.comment.CommentService;
import club.beenest.blog.service.comment.comment.CommentUtils;
import club.beenest.blog.service.user.impl.UserServiceImpl;
import club.beenest.blog.support.constant.JwtConstants;
import club.beenest.blog.support.enums.comment.CommentOpenStateEnum;
import club.beenest.blog.support.exception.PersistenceException;
import club.beenest.blog.support.request.PageResult;
import club.beenest.blog.support.request.Result;
import club.beenest.blog.support.util.JwtUtils;
import club.beenest.blog.support.util.StringUtils;
import cn.hutool.core.exceptions.ValidateException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 博客评论业务层实现
 * @author  陈玉轩
 * @since　1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentMapper commentMapper;

	@Autowired
	CommentUtils commentUtils;

	@Autowired
	UserServiceImpl userService;

	@Override
	public List<Comment> getListByPageAndParentCommentId(Integer page, Long blogId, Long parentCommentId) {
		List<Comment> comments = commentMapper.getListByPageAndParentCommentId(page, blogId, parentCommentId);
		for (Comment c : comments) {
			//递归查询子评论及其子评论
			List<Comment> replyComments = getListByPageAndParentCommentId(page, blogId, c.getId());
			c.setReplyComments(replyComments);
		}
		return comments;
	}

	@Override
	public List<PageComment> getPageCommentList(Integer page, Long blogId, Long parentCommentId) {
		List<PageComment> comments = getPageCommentListByPageAndParentCommentId(page, blogId, parentCommentId);
		for (PageComment c : comments) {
			List<PageComment> tmpComments = new ArrayList<>();
			getReplyComments(tmpComments, c.getReplyComments());
			//对于两列评论来说，按时间顺序排列应该比树形更合理些
			//排序一下
			Comparator<PageComment> comparator = Comparator.comparing(PageComment::getCreateTime);
			tmpComments.sort(comparator);

			c.setReplyComments(tmpComments);
		}
		return comments;
	}

	@Override
	public Comment getCommentById(Long id) {
		Comment comment = commentMapper.getCommentById(id);
		if (comment == null) {
			throw new PersistenceException("评论不存在");
		}
		return comment;
	}

	/**
	 * 将所有子评论递归取出到一个List中
	 *
	 * @param comments
	 */
	private void getReplyComments(List<PageComment> tmpComments, List<PageComment> comments) {
		for (PageComment c : comments) {
			tmpComments.add(c);
			getReplyComments(tmpComments, c.getReplyComments());
		}
	}

	private List<PageComment> getPageCommentListByPageAndParentCommentId(Integer page, Long blogId, Long parentCommentId) {
		List<PageComment> comments = commentMapper.getPageCommentListByPageAndParentCommentId(page, blogId, parentCommentId);
		for (PageComment c : comments) {
			List<PageComment> replyComments = getPageCommentListByPageAndParentCommentId(page, blogId, c.getId());
			c.setReplyComments(replyComments);
		}
		return comments;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateCommentPublishedById(Long commentId, Boolean published) {
		//如果是隐藏评论，则所有子评论都要修改成隐藏状态
		if (!published) {
			List<Comment> comments = getAllReplyComments(commentId);
			for (Comment c : comments) {
				hideComment(c);
			}
		}

		if (commentMapper.updateCommentPublishedById(commentId, published) != 1) {
			throw new PersistenceException("操作失败");
		}
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateCommentNoticeById(Long commentId, Boolean notice) {
		if (commentMapper.updateCommentNoticeById(commentId, notice) != 1) {
			throw new PersistenceException("操作失败");
		}
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteCommentById(Long commentId) {
		List<Comment> comments = getAllReplyComments(commentId);
		for (Comment c : comments) {
			delete(c);
		}
		if (commentMapper.deleteCommentById(commentId) != 1) {
			throw new PersistenceException("评论删除失败");
		}
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteCommentsByBlogId(Long blogId) {
		commentMapper.deleteCommentsByBlogId(blogId);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateComment(Comment comment) {
		if (commentMapper.updateComment(comment) != 1) {
			throw new PersistenceException("评论修改失败");
		}
	}

	@Override
	public int countByPageAndIsPublished(Integer page, Long blogId, Boolean isPublished) {
		return commentMapper.countByPageAndIsPublished(page, blogId, isPublished);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveComment(Comment comment) {
		if (commentMapper.saveComment(comment) != 1) {
			throw new PersistenceException("评论失败");
		}
	}

	/**
	 * 递归删除子评论
	 *
	 * @param comment 需要删除子评论的父评论
	 */
	private void delete(Comment comment) {
		for (Comment c : comment.getReplyComments()) {
			delete(c);
		}
		if (commentMapper.deleteCommentById(comment.getId()) != 1) {
			throw new PersistenceException("评论删除失败");
		}
	}

	/**
	 * 递归隐藏子评论
	 *
	 * @param comment 需要隐藏子评论的父评论
	 */
	private void hideComment(Comment comment) {
		for (Comment c : comment.getReplyComments()) {
			hideComment(c);
		}
		if (commentMapper.updateCommentPublishedById(comment.getId(), false) != 1) {
			throw new PersistenceException("操作失败");
		}
	}

	/**
	 * 按id递归查询子评论
	 *
	 * @param parentCommentId 需要查询子评论的父评论id
	 * @return
	 */
	private List<Comment> getAllReplyComments(Long parentCommentId) {
		List<Comment> comments = commentMapper.getListByParentCommentId(parentCommentId);
		for (Comment c : comments) {
			List<Comment> replyComments = getAllReplyComments(c.getId());
			c.setReplyComments(replyComments);
		}
		return comments;
	}

	@Override
	public Map<String, Object> selectCommentsForPage(Integer page, Long blogId,
													 Integer pageNum, Integer pageSize, String jwt) {
		CommentOpenStateEnum openState = commentUtils.judgeCommentState(page, blogId);
		switch (openState) {
			case NOT_FOUND:
				throw new ValidateException("该博客不存在");
			case CLOSE:
				throw new ValidateException("评论已关闭");
			case PASSWORD:
				//文章受密码保护，需要验证Token
				if (JwtUtils.judgeTokenIsExist(jwt)) {
					try {
						String subject = JwtUtils.getTokenBody(jwt).getSubject();
						if (subject.startsWith(JwtConstants.ADMIN_PREFIX)) {
							//博主身份Token
							String username = subject.replace(JwtConstants.ADMIN_PREFIX, "");
							User admin = (User) userService.loadUserByUsername(username);
							if (admin == null) {
								throw new ValidateException("博主身份Token已失效，请重新登录！");
							}
						} else {
							//经密码验证后的Token
							Long tokenBlogId = Long.parseLong(subject);
							//博客id不匹配，验证不通过，可能博客id改变或客户端传递了其它密码保护文章的Token
							if (!tokenBlogId.equals(blogId)) {
								throw new ValidateException("Token不匹配，请重新验证密码！");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new ValidateException("Token已失效，请重新验证密码！");
					}
				} else {
					throw new ValidateException("此文章受密码保护，请验证密码！");
				}
				break;
			default:
				break;
		}
		//查询该页面所有评论的数量
		Integer allComment = this.countByPageAndIsPublished(page, blogId, null);
		//查询该页面公开评论的数量
		Integer openComment = this.countByPageAndIsPublished(page, blogId, true);
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<PageComment> pageInfo = new PageInfo<>(this.getPageCommentList(page, blogId, -1L));
		PageResult<PageComment> pageResult = new PageResult<>(pageInfo.getPages(), pageInfo.getList());
		Map<String, Object> map = new HashMap<>(8);
		map.put("allComment", allComment);
		map.put("closeComment", allComment - openComment);
		map.put("comments", pageResult);
		return map;
	}

	@Override
	public void doCommnet(Comment comment, HttpServletRequest request, String jwt) {
		//评论内容合法性校验
		if (StringUtils.isEmpty(comment.getContent()) || comment.getContent().length() > 250 ||
				comment.getPage() == null || comment.getParentCommentId() == null) {
			throw new ValidateException("参数有误");
		}
		//是否访客的评论
		boolean isVisitorComment = false;
		//父评论
		Comment parentComment = null;
		//对于有指定父评论的评论，应该以父评论为准，只判断页面可能会被绕过“评论开启状态检测”
		if (comment.getParentCommentId() != -1) {
			//当前评论为子评论
			parentComment = this.getCommentById(comment.getParentCommentId());
			Integer page = parentComment.getPage();
			Long blogId = page == 0 ? parentComment.getBlog().getId() : null;
			comment.setPage(page);
			comment.setBlogId(blogId);
		} else {
			//当前评论为顶级评论
			if (comment.getPage() != 0) {
				comment.setBlogId(null);
			}
		}
		//判断是否可评论
		CommentOpenStateEnum openState = commentUtils.judgeCommentState(comment.getPage(), comment.getBlogId());
		switch (openState) {
			case NOT_FOUND:
				throw new ValidateException("该博客不存在");
			case CLOSE:
				throw new ValidateException("评论已关闭");
			case PASSWORD:
				//文章受密码保护
				//验证Token合法性
				if (JwtUtils.judgeTokenIsExist(jwt)) {
					String subject;
					try {
						subject = JwtUtils.getTokenBody(jwt).getSubject();
					} catch (Exception e) {
						e.printStackTrace();
						throw new ValidateException("Token已失效，请重新验证密码！");
					}
					//博主评论，不受密码保护限制，根据博主信息设置评论属性
					if (subject.startsWith(JwtConstants.ADMIN_PREFIX)) {
						//Token验证通过，获取Token中用户名
						String username = subject.replace(JwtConstants.ADMIN_PREFIX, "");
						User admin = (User) userService.loadUserByUsername(username);
						if (admin == null) {
							throw new ValidateException("博主身份Token已失效，请重新登录！");
						}
						commentUtils.setAdminComment(comment, request, admin);
						isVisitorComment = false;
					} else {//普通访客经文章密码验证后携带Token
						//对访客的评论昵称、邮箱合法性校验
						if (StringUtils.isEmpty(comment.getNickname(), comment.getEmail()) || comment.getNickname().length() > 15) {
							throw new ValidateException("参数有误");
						}
						//对于受密码保护的文章，则Token是必须的
						Long tokenBlogId = Long.parseLong(subject);
						//博客id不匹配，验证不通过，可能博客id改变或客户端传递了其它密码保护文章的Token
						if (!tokenBlogId.equals(comment.getBlogId())) {
							throw new ValidateException("Token不匹配，请重新验证密码！");
						}
						commentUtils.setVisitorComment(comment, request);
						isVisitorComment = true;
					}
				} else {//不存在Token则无评论权限
					throw new ValidateException("此文章受密码保护，请验证密码！");
				}
				break;
			case OPEN:
				//评论正常开放
				//有Token则为博主评论，或文章原先为密码保护，后取消保护，但客户端仍存在Token
				if (JwtUtils.judgeTokenIsExist(jwt)) {
					String subject;
					try {
						subject = JwtUtils.getTokenBody(jwt).getSubject();
					} catch (Exception e) {
						e.printStackTrace();
						throw new ValidateException("Token已失效，请重新验证密码");
					}
					//博主评论，根据博主信息设置评论属性
					if (subject.startsWith(JwtConstants.ADMIN_PREFIX)) {
						//Token验证通过，获取Token中用户名
						String username = subject.replace(JwtConstants.ADMIN_PREFIX, "");
						User admin = (User) userService.loadUserByUsername(username);
						if (admin == null) {
							throw new ValidateException("博主身份Token已失效，请重新登录！");
						}
						commentUtils.setAdminComment(comment, request, admin);
						isVisitorComment = false;
					} else {//文章原先为密码保护，后取消保护，但客户端仍存在Token，则忽略Token
						//对访客的评论昵称、邮箱合法性校验
						if (StringUtils.isEmpty(comment.getNickname(), comment.getEmail()) || comment.getNickname().length() > 15) {
							throw new ValidateException("参数有误");
						}
						commentUtils.setVisitorComment(comment, request);
						isVisitorComment = true;
					}
				} else {
					//访客评论
					//对访客的评论昵称、邮箱合法性校验
					if (StringUtils.isEmpty(comment.getNickname(), comment.getEmail()) || comment.getNickname().length() > 15) {
						throw new ValidateException("参数有误");
					}
					commentUtils.setVisitorComment(comment, request);
					isVisitorComment = true;
				}
				break;
			default:
				break;
		}
		this.saveComment(comment);
		commentUtils.judgeSendNotify(comment, isVisitorComment, parentComment);
	}
}
