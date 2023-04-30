package club.beenest.blog.entity.visit;


/**
 * 访问记录
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class VisitRecord {
    private Long id;

	/**
	 * 访问量
	 */
    private Integer pv;

	/**
	 *独立用户
	 */
    private Integer uv;


	/**
	 *日期"02-23"
	 */
    private String date;

    public VisitRecord(Integer pv, Integer uv, String date) {
        this.pv = pv;
        this.uv = uv;
        this.date = date;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public Integer getUv() {
		return uv;
	}

	public void setUv(Integer uv) {
		this.uv = uv;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "VisitRecord{" +
				"id=" + id +
				", pv=" + pv +
				", uv=" + uv +
				", date='" + date + '\'' +
				'}';
	}
}
