package club.beenest.blog.entity.login;


/**
 * 登录账号密码
 *
 * @author 陈玉轩
 * @since　1.0
 */

public class LoginInfo {
	private String username;

	private String password;

	public LoginInfo() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginInfo{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
