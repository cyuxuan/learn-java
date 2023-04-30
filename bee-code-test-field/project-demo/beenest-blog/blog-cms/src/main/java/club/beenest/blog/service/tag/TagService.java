package club.beenest.blog.service.tag;


import club.beenest.blog.entity.tag.Tag;

import java.util.List;

/**
 * 标签服务
 *
 * @author 陈玉轩
 * @since　1.0
 */
public interface TagService {
    List<Tag> getTagList();

    List<Tag> getTagListNotId();

    List<Tag> getTagListByBlogId(Long blogId);

    void saveTag(Tag tag);

    Tag getTagById(Long id);

    Tag getTagByName(String name);

    void deleteTagById(Long id);

    void updateTag(Tag tag);
}
