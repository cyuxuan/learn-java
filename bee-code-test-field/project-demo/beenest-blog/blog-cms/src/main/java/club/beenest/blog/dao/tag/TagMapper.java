package club.beenest.blog.dao.tag;

import club.beenest.blog.entity.tag.Tag;
import club.beenest.blog.entity.tag.TagBlogCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 博客标签持久层接口
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface TagMapper {
    List<Tag> getTagList();

    List<Tag> getTagListNotId();

    List<Tag> getTagListByBlogId(Long blogId);

    int saveTag(Tag tag);

    Tag getTagById(Long id);

    Tag getTagByName(String name);

    int deleteTagById(Long id);

    int updateTag(Tag tag);

    List<TagBlogCount> getTagBlogCount();
}
