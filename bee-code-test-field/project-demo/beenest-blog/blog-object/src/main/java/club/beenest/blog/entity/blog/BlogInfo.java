/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.entity.blog;

import club.beenest.blog.entity.catagory.Category;
import club.beenest.blog.entity.tag.Tag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 博客摘要信息
 *
 * @author 陈玉轩
 * @since 1.0
 */

public class BlogInfo {
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

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
     * 是否置顶
     */
    private Boolean top;

    /**
     * 文章密码
     */
    private String password;

    /**
     * 是否私密文章
     */
    private Boolean privacy;

    /**
     * 文章分类
     */
    private Category category;

    /**
     * 文章标签
     */
    private List<Tag> tags = new ArrayList<>();//

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

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
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
        return "BlogInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", views=" + views +
                ", words=" + words +
                ", readTime=" + readTime +
                ", top=" + top +
                ", password='" + password + '\'' +
                ", privacy=" + privacy +
                ", category=" + category +
                ", tags=" + tags +
                '}';
    }
}
