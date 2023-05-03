package club.beenest.blog.entity.tag;

import club.beenest.blog.entity.blog.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客标签
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class Tag {
    private Long id;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 标签颜色(与Semantic UI提供的颜色对应，可选)
     */
    private String color;

    /**
     * 该标签下的博客文章
     */
    private List<Blog> blogs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
