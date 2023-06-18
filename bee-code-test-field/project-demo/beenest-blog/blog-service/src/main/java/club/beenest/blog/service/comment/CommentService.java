package club.beenest.blog.service.comment;


import club.beenest.blog.entity.comment.Comment;
import club.beenest.blog.entity.comment.PageComment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface CommentService {
	List<Comment> getListByPageAndParentCommentId(Integer page, Long blogId, Long parentCommentId);

	List<PageComment> getPageCommentList(Integer page, Long blogId, Long parentCommentId);

	Comment getCommentById(Long id);

	void updateCommentPublishedById(Long commentId, Boolean published);

	void updateCommentNoticeById(Long commentId, Boolean notice);

	void deleteCommentById(Long commentId);

	void deleteCommentsByBlogId(Long blogId);

	void updateComment(Comment comment);

	int countByPageAndIsPublished(Integer page, Long blogId, Boolean isPublished);

	void saveComment(Comment comment);

	/**
	 *
	 *
	 * @return
	 */
	/**
	 * 分页查询评论信息
	 * @param page 页面类型
	 * @param blogId 博客id
	 * @param pageNum 当前页码
	 * @param pageSize 分页大小
	 * @param jwt jwt token
	 * @return 评论信息
	 */
	Map<String, Object> selectCommentsForPage(Integer page, Long blogId,
											  Integer pageNum, Integer pageSize, String jwt);

	/**
	 * 执行文件评论
	 *
	 */
	void doCommnet(Comment comment, HttpServletRequest request, String jwt);
}
