package club.beenest.blog.entity.blog;

/**
 * 博客可见性DTO
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class BlogVisibility {
    /**
     * 赞赏开关
     */
    private Boolean appreciation;

    /**
     * 推荐开关
     */
    private Boolean recommend;

    /**
     * 评论开关
     */
    private Boolean commentEnabled;

    /**
     * 是否置顶
     */
    private Boolean top;

    /**
     * 公开或私密
     */
    private Boolean published;

    /**
     * 密码保护
     */
    private String password;

    public Boolean getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Boolean appreciation) {
        this.appreciation = appreciation;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Boolean getCommentEnabled() {
        return commentEnabled;
    }

    public void setCommentEnabled(Boolean commentEnabled) {
        this.commentEnabled = commentEnabled;
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BlogVisibility{" +
                "appreciation=" + appreciation +
                ", recommend=" + recommend +
                ", commentEnabled=" + commentEnabled +
                ", top=" + top +
                ", published=" + published +
                ", password='" + password + '\'' +
                '}';
    }
}
