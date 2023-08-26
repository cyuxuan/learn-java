/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.common.entity.log;


import java.util.Date;

/**
 * 登录日志
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class LoginLog {
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户ip
     */
    private String ip;
    /**
     * ip来源-地区
     */
    private String ipSource;
    /**
     * 来源操作系统
     */
    private String os;
    /**
     * 来源浏览器
     */
    private String browser;
    /**
     * 登录状态
     */
    private Boolean status;
    /**
     * 操作信息
     */
    private String description;
    /**
     * 操作时间
     */
    private Date createTime;
    /**
     * 用户代理
     */
    private String userAgent;

    public LoginLog() {

    }

    public LoginLog(String username, String ip, boolean status, String description, String userAgent) {
        this.username = username;
        this.ip = ip;
        this.status = status;
        this.description = description;
        this.createTime = new Date();
        this.userAgent = userAgent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpSource() {
        return ipSource;
    }

    public void setIpSource(String ipSource) {
        this.ipSource = ipSource;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}