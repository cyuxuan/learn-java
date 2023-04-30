package club.beenest.blog.entity.tag;


/**
 * 标签及标签下博客数量
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class TagBlogCount {
    private Long id;

	/**
	 * 标签名
	 */
    private String name;
	/**
	 * 标签下博客数量
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

	@Override
	public String toString() {
		return "TagBlogCount{" +
				"id=" + id +
				", name='" + name + '\'' +
				", value=" + value +
				'}';
	}
}
