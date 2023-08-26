/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.controller.index;

import club.beenest.blog.entity.blog.NewBlog;
import club.beenest.blog.entity.blog.RandomBlog;
import club.beenest.blog.entity.catagory.Category;
import club.beenest.blog.entity.tag.Tag;
import club.beenest.blog.service.blog.BlogService;
import club.beenest.blog.service.category.CategoryService;
import club.beenest.blog.service.site.SiteSettingService;
import club.beenest.blog.service.tag.TagService;
import club.beenest.blog.support.request.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 站点相关
 *
 * @author 陈玉轩
 * @since　1.0
 */

@RestController
public class IndexController {
	@Autowired
	SiteSettingService siteSettingService;

	@Autowired
	BlogService blogService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	TagService tagService;

	/**
	 * 获取站点配置信息、最新推荐博客、分类列表、标签云、随机博客
	 *
	 * @return
	 */
	@GetMapping("/site")
	public Result site() {
		Map<String, Object> map = siteSettingService.getSiteInfo();
		List<NewBlog> newBlogList = blogService.getNewBlogListByIsPublished();
		List<Category> categoryList = categoryService.getCategoryNameList();
		List<Tag> tagList = tagService.getTagListNotId();
		List<RandomBlog> randomBlogList = blogService.getRandomBlogListByLimitNumAndIsPublishedAndIsRecommend();
		map.put("newBlogList", newBlogList);
		map.put("categoryList", categoryList);
		map.put("tagList", tagList);
		map.put("randomBlogList", randomBlogList);
		return Result.ok("请求成功", map);
	}
}
