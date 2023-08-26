/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.controller.archive;

import club.beenest.blog.service.blog.BlogService;
import club.beenest.blog.support.log.annotation.VisitLogger;
import club.beenest.blog.support.log.enums.VisitBehavior;
import club.beenest.blog.support.request.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 归档页面
 *
 * @author 陈玉轩
 * @since 1.0
 */
@RestController
public class ArchiveController {
	@Autowired
	BlogService blogService;

	/**
	 * 按年月分组归档公开博客 统计公开博客总数
	 *
	 * @return
	 */
	@VisitLogger(VisitBehavior.ARCHIVE)
	@GetMapping("/archives")
	public Result archives() {
		Map<String, Object> archiveBlogMap = blogService.getArchiveBlogAndCountByIsPublished();
		return Result.ok("请求成功", archiveBlogMap);
	}
}
