package club.beenest.blog.support.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Telegram配置
 *
 * @author 陈玉轩
 * @since　1.0
 */

@Configuration
@ConfigurationProperties(prefix = "tg.bot")
public class TelegramProperties {
	/**
	 * Telegram bot的api，默认是https://api.telegram.org/bot
	 * 如果使用自己的反代，可以修改它
	 */
	private String api;
	/**
	 * bot的token，可以从 @BotFather 处获取
	 */
	private String token;
	/**
	 * 自己账号和bot的聊天会话id
	 */
	private String chatId;
	/**
	 * 是否使用代理
	 */
	private Boolean useProxy;
	/**
	 * 是否使用反向代理
	 */
	private Boolean useReverseProxy;
	/**
	 * 反向代理URL
	 */
	private String reverseProxyUrl;

	public TelegramProperties() {
	}

	public TelegramProperties(String api, String token, String chatId,
							  Boolean useProxy, Boolean useReverseProxy, String reverseProxyUrl) {
		this.api = api;
		this.token = token;
		this.chatId = chatId;
		this.useProxy = useProxy;
		this.useReverseProxy = useReverseProxy;
		this.reverseProxyUrl = reverseProxyUrl;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public Boolean getUseProxy() {
		return useProxy;
	}

	public void setUseProxy(Boolean useProxy) {
		this.useProxy = useProxy;
	}

	public Boolean getUseReverseProxy() {
		return useReverseProxy;
	}

	public void setUseReverseProxy(Boolean useReverseProxy) {
		this.useReverseProxy = useReverseProxy;
	}

	public String getReverseProxyUrl() {
		return reverseProxyUrl;
	}

	public void setReverseProxyUrl(String reverseProxyUrl) {
		this.reverseProxyUrl = reverseProxyUrl;
	}
}
