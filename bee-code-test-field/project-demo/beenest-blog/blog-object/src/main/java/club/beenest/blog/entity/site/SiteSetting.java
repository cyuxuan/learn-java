package club.beenest.blog.entity.site;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 站点设置
 *
 * @author 陈玉轩
 * @since 1.0
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteSetting {
    private Long id;
    private String nameEn;
    private String nameZh;
    private String value;
    private Integer type;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SiteSetting{" +
				"id=" + id +
				", nameEn='" + nameEn + '\'' +
				", nameZh='" + nameZh + '\'' +
				", value='" + value + '\'' +
				", type=" + type +
				'}';
	}
}
