package club.beenest.blog.entity.blog;

import club.beenest.blog.entity.catagory.Category;
import club.beenest.blog.entity.tag.Tag;
import club.beenest.blog.entity.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文章实体类
 *
 * @author 陈玉轩
 * @since 1.0
 */

public class Blog {
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章首图，用于随机文章展示
     */
    private String firstPicture;

    /**
     * 文章正文
     */
    private String content;

    /**
     * 描述
     */
    private String description;

    /**
     * 公开或私密
     */
    private Boolean published;

    /**
     * 推荐开关
     */
    private Boolean recommend;

    /**
     * 赞赏开关
     */
    private Boolean appreciation;

    /**
     * 评论开关
     */
    private Boolean commentEnabled;

    /**
     * 是否置顶
     */
    private Boolean top;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 浏览次数
     */
    private Integer views;

    /**
     * 文章字数
     */
    private Integer words;

    /**
     * 阅读时长(分钟)
     */
    private Integer readTime;

    /**
     * 密码保护
     */
    private String password;


    /**
     * 文章作者(因为是个人博客，也可以不加作者字段，暂且加上)
     */
    private User user;

    /**
     * 文章分类
     */
    private Category category;

    /**
     * 页面展示层传输的分类对象：正常情况下为 字符串 或 分类id
     */
    private Object cate;

    /**
     * 页面展示层传输的标签对象：正常情况下为 List<Integer>标签id 或 List<String>标签名
     */
    private List<Object> tagList;

    /**
     * 文章标签
     */
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

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Object getCate() {
        return cate;
    }

    public void setCate(Object cate) {
        this.cate = cate;
    }

    public List<Object> getTagList() {
        return tagList;
    }

    public void setTagList(List<Object> tagList) {
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                ", recommend=" + recommend +
                ", appreciation=" + appreciation +
                ", commentEnabled=" + commentEnabled +
                ", top=" + top +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", views=" + views +
                ", words=" + words +
                ", readTime=" + readTime +
                ", password='" + password + '\'' +
                ", user=" + user +
                ", category=" + category +
                ", cate=" + cate +
                ", tagList=" + tagList +
                ", tags=" + tags +
                '}';
    }
}
