package club.beenest.blog.entity.friend;

import java.util.Date;

/**
 * 友链
 *
 * @author 陈玉轩
 * @since　1.0
 */
public class Friend {
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 描述
     */
    private String description;

    /**
     * 站点
     */
    private String website;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 公开或隐藏
     */
    private Boolean published;

    /**
     * 浏览次数
     */
    private Integer views;

    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", description='" + description + '\'' +
                ", website='" + website + '\'' +
                ", avatar='" + avatar + '\'' +
                ", published=" + published +
                ", views=" + views +
                ", createTime=" + createTime +
                '}';
    }
}
