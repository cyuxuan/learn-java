package club.beenest.blog.entity.user;

/**
 * 受保护文章密码DTO
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class BlogPassword {
	private Long blogId;
	private String password;

	public BlogPassword() {}

	public BlogPassword(Long blogId, String password) {
		this.blogId = blogId;
		this.password = password;
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "BlogPassword{" +
				"blogId=" + blogId +
				", password='" + password + '\'' +
				'}';
	}
}
