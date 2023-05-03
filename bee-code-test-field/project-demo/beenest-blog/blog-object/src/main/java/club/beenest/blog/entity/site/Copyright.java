package club.beenest.blog.entity.site;

/**
 * copyright
 *
 * @author 陈玉轩
 * @since　1.0
 */
public class Copyright {
    private String title;
    private String siteName;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@Override
	public String toString() {
		return "Copyright{" +
				"title='" + title + '\'' +
				", siteName='" + siteName + '\'' +
				'}';
	}
}
