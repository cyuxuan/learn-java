/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.job.redis;

import club.beenest.blog.service.blog.BlogService;
import club.beenest.blog.support.common.service.redis.RedisService;
import club.beenest.blog.support.common.service.redis.impl.RedisKeyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * Redis相关定时任务
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Component
public class RedisSyncScheduleTask {
	@Autowired
	RedisService redisService;

	@Autowired
	BlogService blogService;

	/**
	 * 从Redis同步博客文章浏览量到数据库
	 */
	public void syncBlogViewsToDatabase() {
		String redisKey = RedisKeyConstants.BLOG_VIEWS_MAP;
		Map blogViewsMap = redisService.getMapByHash(redisKey);
		Set<Integer> keys = blogViewsMap.keySet();
		for (Integer key : keys) {
			Integer views = (Integer) blogViewsMap.get(key);
			blogService.updateViews(key.longValue(), views);
		}
	}
}
