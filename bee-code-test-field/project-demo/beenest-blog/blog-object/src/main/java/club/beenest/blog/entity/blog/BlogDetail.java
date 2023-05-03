package club.beenest.blog.entity.blog;


import club.beenest.blog.entity.catagory.Category;
import club.beenest.blog.entity.tag.Tag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 博客详情
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class BlogDetail {
    private Long id;

    /**
     * 文章标题
     **/
    private String title;

    /**
     *文章正文
     **/
    private String content;

    /**
     *赞赏开关
     **/
    private Boolean appreciation;

    /**
     *评论开关
     **/
    private Boolean commentEnabled;

    /**
     *是否置顶
     **/
    private Boolean top;

    /**
     *创建时间
     **/
    private Date createTime;

    /**
     *更新时间
     **/
    private Date updateTime;

    /**
     *浏览次数
     **/
    private Integer views;

    /**
     *文章字数
     **/
    private Integer words;

    /**
     *阅读时长(分钟)
     **/
    private Integer readTime;

    /**
     *密码保护
     **/
    private String password;


    /**
     *文章分类
     **/
    private Category category;

    /**
     *文章标签
     **/
    private List<Tag> tags = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Boolean appreciation) {
        this.appreciation = appreciation;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getWords() {
        return words;
    }

    public void setWords(Integer words) {
        this.words = words;
    }

    public Integer getReadTime() {
        return readTime;
    }

    public void setReadTime(Integer readTime) {
        this.readTime = readTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "BlogDetail{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", appreciation=" + appreciation +
                ", commentEnabled=" + commentEnabled +
                ", top=" + top +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", views=" + views +
                ", words=" + words +
                ", readTime=" + readTime +
                ", password='" + password + '\'' +
                ", category=" + category +
                ", tags=" + tags +
                '}';
    }
}
