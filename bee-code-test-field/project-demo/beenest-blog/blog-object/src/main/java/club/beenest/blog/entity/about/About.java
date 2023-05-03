package club.beenest.blog.entity.about;

/**
 * 关于我
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class About {
	private Long id;
	private String nameEn;
	private String nameZh;
	private String value;

	public About() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameZh() {
		return nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "About{" +
				"id=" + id +
				", nameEn='" + nameEn + '\'' +
				", nameZh='" + nameZh + '\'' +
				", value='" + value + '\'' +
				'}';
	}
}
