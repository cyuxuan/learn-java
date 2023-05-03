package club.beenest.blog.entity.blog;

/**
 * 分类及该分类下的博客数量
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class CategoryBlogCount {
    private Long id;

    /**
     * 分类名
     */
    private String name;

    /**
     * 分类下博客数量
     */
    private Integer value;

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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
