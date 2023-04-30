/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.bas.model.dto;

/**
 * UserAgent解析DTO
 *
 * @author 陈玉轩
 * @since 1.0
 */

public class UserAgentDTO {
    private String os;
    private String browser;


	public UserAgentDTO(String os, String browser) {
		this.os = os;
		this.browser = browser;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}
}
