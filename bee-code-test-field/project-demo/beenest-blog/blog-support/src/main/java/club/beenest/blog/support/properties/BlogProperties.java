package club.beenest.blog.support.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 博客配置(目前用于评论提醒模板中的超链接)
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Configuration
@ConfigurationProperties(prefix = "blog")
public class BlogProperties {
	/**
	 * 博客名称
	 */
	private String name;
	/**
	 * 博客后端接口URL
	 */
	private String api;
	/**
	 * 博客前端后台管理URL
	 */
	private String cms;
	/**
	 * 博客前端前台页面URL
	 */
	private String view;

	public BlogProperties(){}

	public BlogProperties(String name, String api, String cms, String view) {
		this.name = name;
		this.api = api;
		this.cms = cms;
		this.view = view;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getCms() {
		return cms;
	}

	public void setCms(String cms) {
		this.cms = cms;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return "BlogProperties{" +
				"name='" + name + '\'' +
				", api='" + api + '\'' +
				", cms='" + cms + '\'' +
				", view='" + view + '\'' +
				'}';
	}
}
