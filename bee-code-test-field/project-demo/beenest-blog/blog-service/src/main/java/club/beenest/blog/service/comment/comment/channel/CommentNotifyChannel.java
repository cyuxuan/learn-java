/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.service.comment.comment.channel;

import club.beenest.blog.entity.comment.Comment;

/**
 * 评论提醒方式
 *
 * @author 陈玉轩
 * @since　1.0
 */
public interface CommentNotifyChannel {
	/**
	 * 通过指定方式通知自己
	 *
	 * @param comment 当前收到的评论
	 */
	void notifyMyself(Comment comment);
}
