package club.beenest.blog.support.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 静态文件上传访问路径配置(目前用于评论中QQ头像的本地存储)
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Configuration
@ConfigurationProperties(prefix = "upload.file")
public class UploadProperties {
	/**
	 * 本地文件路径
	 */
	private String path;
	/**
	 * 请求地址映射
	 */
	private String accessPath;
	/**
	 * 本地文件路径映射
	 */
	private String resourcesLocations;

	public UploadProperties() {
	}

	public UploadProperties(String path, String accessPath, String resourcesLocations) {
		this.path = path;
		this.accessPath = accessPath;
		this.resourcesLocations = resourcesLocations;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getAccessPath() {
		return accessPath;
	}

	public void setAccessPath(String accessPath) {
		this.accessPath = accessPath;
	}

	public String getResourcesLocations() {
		return resourcesLocations;
	}

	public void setResourcesLocations(String resourcesLocations) {
		this.resourcesLocations = resourcesLocations;
	}
}
