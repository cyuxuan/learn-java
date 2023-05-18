package club.beenest.blog.dao.blog;

import club.beenest.blog.entity.archive.ArchiveBlog;
import club.beenest.blog.entity.blog.*;
import club.beenest.blog.entity.search.SearchBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章分类查询
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface BlogMapper {
    List<Blog> getListByTitleAndCategoryId(@Param("title") String title,
                                           @Param("categoryId") Integer categoryId);

    List<SearchBlog> getSearchBlogListByQueryAndIsPublished(@Param("query") String query);

    List<Blog> getIdAndTitleList();

    List<NewBlog> getNewBlogListByIsPublished();

    List<BlogInfo> getBlogInfoListByIsPublished();

    List<BlogInfo> getBlogInfoListByCategoryNameAndIsPublished(@Param("categoryName") String categoryName);

    List<BlogInfo> getBlogInfoListByTagNameAndIsPublished(@Param("tagName") String tagName);

    List<String> getGroupYearMonthByIsPublished();

    List<ArchiveBlog> getArchiveBlogListByYearMonthAndIsPublished(@Param("yearMonth") String yearMonth);

    List<RandomBlog> getRandomBlogListByLimitNumAndIsPublishedAndIsRecommend(@Param("limitNum") Integer limitNum);

    List<BlogView> getBlogViewsList();

    int deleteBlogById(@Param("id") Long id);

    int deleteBlogTagByBlogId(@Param("blogId") Long blogId);

    int saveBlog(@Param("blog") Blog blog);

    int saveBlogTag(@Param("blogId") Long blogId, @Param("tagId") Long tagId);

    int updateBlogRecommendById(@Param("blogId") Long blogId, @Param("recommend") Boolean recommend);

    int updateBlogVisibilityById(@Param("blogId") Long blogId, @Param("bv") BlogVisibility bv);

    int updateBlogTopById(@Param("blogId") Long blogId, @Param("top") Boolean top);

    int updateViews(@Param("blogId") Long blogId, @Param("views)") Integer views);

    Blog getBlogById(@Param("id") Long id);

    String getTitleByBlogId(@Param("id") Long id);

    BlogDetail getBlogByIdAndIsPublished(@Param("id") Long id);

    String getBlogPassword(@Param("blogId") Long blogId);

    int updateBlog(@Param("blog") Blog blog);

    int countBlog();

    int countBlogByIsPublished();

    int countBlogByCategoryId(@Param("categoryId") Long categoryId);

    int countBlogByTagId(@Param("tagId") Long tagId);

    Boolean getCommentEnabledByBlogId(@Param("blogId") Long blogId);

    Boolean getPublishedByBlogId(@Param("blogId") Long blogId);

    List<CategoryBlogCount> getCategoryBlogCountList();
}
