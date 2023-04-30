package club.beenest.blog.entity.blog;

/**
 * 博客浏览量
 *
 * @author 陈玉轩
 * @since 1.0
 */

public class BlogView {
    private Long id;
	/**
	 * 浏览数量
	 */
    private Integer views;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "BlogView{" +
				"id=" + id +
				", views=" + views +
				'}';
	}
}
