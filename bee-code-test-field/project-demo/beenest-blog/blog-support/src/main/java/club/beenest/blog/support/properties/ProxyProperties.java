package club.beenest.blog.support.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

/**
 * 代理配置(目前用于RestTemplate发送tg消息)
 *
 * @author 陈玉轩
 * @since　1.0
 */

@Configuration
@ConfigurationProperties(prefix = "http.proxy.server")
public class ProxyProperties {
	/**
	 * 代理服务器地址
	 */
	private String host;
	/**
	 * 代理服务器端口
	 */
	private Integer port;
	/**
	 * 连接超时(单位毫秒)，通常不应该为0，0为无限超时时间，-1为系统的默认超时时间
	 *
	 * @see SimpleClientHttpRequestFactory#setConnectTimeout(int)
	 */
	private Integer timeout;

	public ProxyProperties() {
	}

	public ProxyProperties(String host, Integer port, Integer timeout) {
		this.host = host;
		this.port = port;
		this.timeout = timeout;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
}
