package club.beenest.blog.entity.search;

/**
 * 通过关键字搜索博客
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class SearchBlog {
    private Long id;
    private String title;
    private String content;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "SearchBlog{" +
				"id=" + id +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}
