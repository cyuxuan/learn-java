package club.beenest.blog.support.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * GitHub配置(目前用于评论中QQ头像的图床)
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Configuration
@ConfigurationProperties(prefix = "upload.github")
public class GithubProperties {
	/**
	 * GitHub token
	 */
	private String token;
	/**
	 * GitHub username
	 */
	private String username;
	/**
	 * GitHub 仓库名
	 */
	private String repos;
	/**
	 * GitHub 仓库路径
	 */
	private String reposPath;

	public GithubProperties() {
	}

	public GithubProperties(String token, String username, String repos, String reposPath) {
		this.token = token;
		this.username = username;
		this.repos = repos;
		this.reposPath = reposPath;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRepos() {
		return repos;
	}

	public void setRepos(String repos) {
		this.repos = repos;
	}

	public String getReposPath() {
		return reposPath;
	}

	public void setReposPath(String reposPath) {
		this.reposPath = reposPath;
	}
}
