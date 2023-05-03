package club.beenest.blog.entity.visit;

/**
 * 访问日志备注
 *
 * @author 陈玉轩
 * @since　1.0
 */

public class VisitLogRemark {
	/**
	 * 访问内容
	 */
	private String content;

	/**
	 * 备注
	 */
	private String remark;

	public VisitLogRemark() {}

	public VisitLogRemark(String content, String remark) {
		this.content = content;
		this.remark = remark;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "VisitLogRemark{" +
				"content='" + content + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}
