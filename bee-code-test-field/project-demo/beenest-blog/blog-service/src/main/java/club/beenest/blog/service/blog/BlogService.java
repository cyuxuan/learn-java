package club.beenest.blog.service.blog;


import club.beenest.blog.entity.blog.*;
import club.beenest.blog.entity.search.SearchBlog;
import club.beenest.blog.support.exception.AuthException;
import club.beenest.blog.support.request.PageResult;
import club.beenest.blog.vo.blog.BlogsAndCategoriesVO;
import club.beenest.blog.vo.category.CategoriesAndTagsVO;

import java.util.List;
import java.util.Map;

/**
 * 博客文章服务
 *
 * @author 陈玉轩
 * @since 1.0
 */
public interface BlogService {
    BlogsAndCategoriesVO getListByTitleAndCategoryIdForPage(String title,
                                                            Integer categoryId, Integer pageNum, Integer pageSize);

    List<SearchBlog> getSearchBlogListByQueryAndIsPublished(String query);

    List<Blog> getIdAndTitleList();

    List<NewBlog> getNewBlogListByIsPublished();

    PageResult<BlogInfo> getBlogInfoListByIsPublished(Integer pageNum);

    PageResult<BlogInfo> getBlogInfoListByCategoryNameAndIsPublished(String categoryName, Integer pageNum);

    PageResult<BlogInfo> getBlogInfoListByTagNameAndIsPublished(String tagName, Integer pageNum);

    Map<String, Object> getArchiveBlogAndCountByIsPublished();

    List<RandomBlog> getRandomBlogListByLimitNumAndIsPublishedAndIsRecommend();

    /**
     * 通过id删除博客数据
     * 同时删除博客对应的tag以及博客对应的评论信息
     *
     * @param id 博客id
     */
    void deleteBlogById(Long id);

    void deleteBlogTagByBlogId(Long blogId);

    void saveBlog(Blog blog);

    void saveBlogTag(Long blogId, Long tagId);

    void updateBlogRecommendById(Long blogId, Boolean recommend);

    void updateBlogVisibilityById(Long blogId, BlogVisibility blogVisibility);

    void updateBlogTopById(Long blogId, Boolean top);

    void updateViewsToRedis(Long blogId);

    void updateViews(Long blogId, Integer views);

    Blog getBlogById(Long id);

    String getTitleByBlogId(Long id);

    BlogDetail getBlogByIdAndIsPublished(Long id);

    String getBlogPassword(Long blogId);

    void updateBlog(Blog blog);

    int countBlogByIsPublished();

    int countBlogByCategoryId(Long categoryId);

    int countBlogByTagId(Long tagId);

    Boolean getCommentEnabledByBlogId(Long blogId);

    Boolean getPublishedByBlogId(Long blogId);

    /**
     * 获取分类和标签数据
     *
     * @return 分类和标签数据
     */
    CategoriesAndTagsVO getCategoriesAndTags();

    /**
     * 获取博客信息
     *
     * @param id 查询条件
     * @param jwt token信息
     * @return 查询到的博客信息
     */
    BlogDetail getBlogDetail(Long id, String jwt) throws AuthException;
}
