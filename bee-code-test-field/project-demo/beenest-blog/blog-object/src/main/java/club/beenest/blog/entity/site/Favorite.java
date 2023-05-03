package club.beenest.blog.entity.site;

/**
 * 自定义爱好
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class Favorite {
    private String title;
    private String content;

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
		return "Favorite{" +
				"title='" + title + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}
