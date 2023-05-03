package club.beenest.blog.support.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 又拍云配置(目前用于评论中QQ头像的图床)
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "upload.upyun")
public class UpyunProperties {
	/**
	 * 又拍云存储空间名称
	 */
	private String bucketName;
	/**
	 * 操作员名称
	 */
	private String username;
	/**
	 * 操作员密码
	 */
	private String password;
	/**
	 * 存储路径
	 */
	private String path;
	/**
	 * CDN访问域名
	 */
	private String domain;

	public UpyunProperties() {
	}

	public UpyunProperties(String bucketName, String username,
						   String password, String path, String domain) {
		this.bucketName = bucketName;
		this.username = username;
		this.password = password;
		this.path = path;
		this.domain = domain;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}
