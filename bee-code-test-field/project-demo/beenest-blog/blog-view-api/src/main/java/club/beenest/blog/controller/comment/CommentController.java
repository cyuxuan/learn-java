/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.controller.comment;

import club.beenest.blog.entity.comment.Comment;
import club.beenest.blog.service.comment.CommentService;
import club.beenest.blog.service.comment.comment.CommentUtils;
import club.beenest.blog.service.user.impl.UserServiceImpl;
import club.beenest.blog.support.interceptor.access.annotation.AccessLimit;
import club.beenest.blog.support.request.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 评论
 *
 * @author 陈玉轩
 * @since　1.0
 */
@RestController
public class CommentController {
	@Autowired
	CommentService commentService;

	/**
	 * 根据页面分页查询评论列表
	 *
	 * @param page     页面分类（0普通文章，1关于我...）
	 * @param blogId   如果page==0，需要博客id参数
	 * @param pageNum  页码
	 * @param pageSize 每页个数
	 * @param jwt      若文章受密码保护，需要获取访问Token
	 * @return
	 */
	@GetMapping("/comments")
	public Result comments(@RequestParam Integer page,
						   @RequestParam(defaultValue = "") Long blogId,
						   @RequestParam(defaultValue = "1") Integer pageNum,
						   @RequestParam(defaultValue = "10") Integer pageSize,
						   @RequestHeader(value = "Authorization", defaultValue = "") String jwt) {
		return Result.ok("获取成功", commentService.selectCommentsForPage(page, blogId, pageNum, pageSize, jwt));
	}

	/**
	 * 单个ip，30秒内允许提交1次评论
	 *
	 * @param comment 评论DTO
	 * @param request 获取ip
	 * @param jwt     博主身份Token
	 * @return
	 */
	@AccessLimit(seconds = 30, maxCount = 1, msg = "30秒内只能提交一次评论")
	@PostMapping("/comment")
	public Result postComment(@RequestBody Comment comment,
							  HttpServletRequest request,
							  @RequestHeader(value = "Authorization", defaultValue = "") String jwt) {
		commentService.doCommnet(comment, request, jwt);
		return Result.ok("评论成功");
	}
}