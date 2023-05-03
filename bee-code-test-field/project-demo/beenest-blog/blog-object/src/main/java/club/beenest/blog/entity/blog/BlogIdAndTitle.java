package club.beenest.blog.entity.blog;


/**
 * 评论管理页面按博客title查询评论
 *
 * @author 陈玉轩
 * @since 1.0
 */

public class BlogIdAndTitle {
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BlogIdAndTitle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
