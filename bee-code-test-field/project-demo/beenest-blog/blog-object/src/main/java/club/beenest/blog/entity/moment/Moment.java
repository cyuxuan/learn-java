package club.beenest.blog.entity.moment;

import java.util.Date;

/**
 * 博客动态
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class Moment {
    private Long id;
    /**
     * 动态内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 点赞数量
     */
    private Integer likes;

    /**
     * 是否公开
     */
    private Boolean published;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "Moment{" +
				"id=" + id +
				", content='" + content + '\'' +
				", createTime=" + createTime +
				", likes=" + likes +
				", published=" + published +
				'}';
	}
}
