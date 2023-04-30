package club.beenest.blog.entity.visit;

/**
 * 城市访客数量
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class CityVisitor {
	/**
	 * 城市名称
	 */
    private String city;
	/**
	 * 独立访客数量
	 */
    private Integer uv;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getUv() {
		return uv;
	}

	public void setUv(Integer uv) {
		this.uv = uv;
	}

	@Override
	public String toString() {
		return "CityVisitor{" +
				"city='" + city + '\'' +
				", uv=" + uv +
				'}';
	}
}
