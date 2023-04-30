package club.beenest.blog.entity.archive;


/**
 * 归档页面博客简要信息
 *
 * @author 陈玉轩
 * @since 1.0
 */

public class ArchiveBlog {
    private Long id;
    private String title;
    private String day;
    private String password;
    private Boolean privacy;

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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Boolean privacy) {
		this.privacy = privacy;
	}

	@Override
	public String toString() {
		return "ArchiveBlog{" +
				"id=" + id +
				", title='" + title + '\'' +
				", day='" + day + '\'' +
				", password='" + password + '\'' +
				", privacy=" + privacy +
				'}';
	}
}
