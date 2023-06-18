package club.beenest.blog.controller.blog;

import club.beenest.blog.entity.user.User;
import club.beenest.blog.entity.blog.Blog;
import club.beenest.blog.entity.blog.BlogVisibility;
import club.beenest.blog.entity.catagory.Category;
import club.beenest.blog.entity.tag.Tag;
import club.beenest.blog.service.blog.BlogService;
import club.beenest.blog.service.category.CategoryService;
import club.beenest.blog.service.comment.CommentService;
import club.beenest.blog.service.tag.TagService;
import club.beenest.blog.support.log.annotation.OperationLogger;
import club.beenest.blog.support.request.Result;
import club.beenest.blog.support.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;

/**
 * 博客文章后台管理
 *
 * @author 陈玉轩
 * @since 1.0
 */
@RestController
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    TagService tagService;

    @Autowired
    CommentService commentService;

    /**
     * 获取博客文章列表
     *
     * @param title      按标题模糊查询
     * @param categoryId 按分类id查询
     * @param pageNum    页码
     * @param pageSize   每页个数
     * @return 博客结果
     */
    @GetMapping("/blogs")
    public Result blogs(@RequestParam(defaultValue = "") String title,
                        @RequestParam(defaultValue = "") Integer categoryId,
                        @RequestParam(defaultValue = "1") Integer pageNum,
                        @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.ok("请求成功",
                blogService.getListByTitleAndCategoryIdForPage(title, categoryId, pageNum, pageSize));
    }

    /**
     * 删除博客文章、删除博客文章下的所有评论、同时维护 blog_tag 表
     *
     * @param id 文章id
     * @return
     */
    @OperationLogger("删除博客")
    @DeleteMapping("/blog")
    public Result delete(@RequestParam Long id) {
        blogService.deleteBlogById(id);
        return Result.ok("删除成功");
    }

    /**
     * 获取分类列表和标签列表
     *
     * @return 分类列表和标签列表
     */
    @GetMapping("/categoryAndTag")
    public Result categoryAndTag() {
        return Result.ok("请求成功", blogService.getCategoriesAndTags());
    }

    /**
     * 更新博客置顶状态
     *
     * @param id  博客id
     * @param top 是否置顶
     * @return
     */
    @OperationLogger("更新博客置顶状态")
    @PutMapping("/blog/top")
    public Result updateTop(@RequestParam Long id, @RequestParam Boolean top) {
        blogService.updateBlogTopById(id, top);
        return Result.ok("操作成功");
    }

    /**
     * 更新博客推荐状态
     *
     * @param id        博客id
     * @param recommend 是否推荐
     * @return
     */
    @OperationLogger("更新博客推荐状态")
    @PutMapping("/blog/recommend")
    public Result updateRecommend(@RequestParam Long id, @RequestParam Boolean recommend) {
        blogService.updateBlogRecommendById(id, recommend);
        return Result.ok("操作成功");
    }

    /**
     * 更新博客可见性状态
     *
     * @param id             博客id
     * @param blogVisibility 博客可见性DTO
     * @return
     */
    @OperationLogger("更新博客可见性状态")
    @PutMapping("blog/{id}/visibility")
    public Result updateVisibility(@PathVariable Long id, @RequestBody BlogVisibility blogVisibility) {
        blogService.updateBlogVisibilityById(id, blogVisibility);
        return Result.ok("操作成功");
    }

    /**
     * 按id获取博客详情
     *
     * @param id 博客id
     * @return
     */
    @GetMapping("/blog")
    public Result getBlog(@RequestParam Long id) {
        Blog blog = blogService.getBlogById(id);
        return Result.ok("获取成功", blog);
    }

    /**
     * 保存草稿或发布新文章
     *
     * @param blog 博客文章DTO
     * @return 博客保存结果
     */
    @OperationLogger("发布博客")
    @PostMapping("/blog")
    public Result saveBlog(@RequestBody Blog blog) {
        blogService.saveBlog(blog);
        return Result.ok("新增博客成功", blog);
    }

    /**
     * 更新博客
     *
     * @param blog 博客文章DTO
     * @return 博客更新结果
     */
    @OperationLogger("更新博客")
    @PutMapping("/blog")
    public Result updateBlog(@RequestBody Blog blog) {
        blogService.updateBlog(blog);
        return Result.ok("更新博客成功", blog);
    }
}
