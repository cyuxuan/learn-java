package club.beenest.blog.entity.comment;

import club.beenest.blog.entity.blog.BlogIdAndTitle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 博客评论
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class Comment {
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 头像(图片路径)
     */
    private String avatar;

    /**
     * 评论时间
     */
    private Date createTime;

    /**
     * 个人网站
     */
    private String website;

    /**
     * 评论者ip地址
     */
    private String ip;

    /**
     * 公开或回收站
     */
    private Boolean published;

    /**
     * 博主回复
     */
    private Boolean adminComment;

    /**
     * 0普通文章，1关于我页面
     */
    private Integer page;

    /**
     * 接收邮件提醒
     */
    private Boolean notice;

    /**
     * 父评论id
     */
    private Long parentCommentId;

    /**
     * 如果评论昵称为QQ号，则将昵称和头像置为QQ昵称和QQ头像，并将此字段置为QQ号备份
     */
    private String qq;


    /**
     * 所属的文章
     */
    private BlogIdAndTitle blog;

	/**
	 * 所属的文章id
	 */
	private Long blogId;

    /**
     * 回复该评论的评论
     */
    private List<Comment> replyComments = new ArrayList<>();

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public Boolean getAdminComment() {
		return adminComment;
	}

	public void setAdminComment(Boolean adminComment) {
		this.adminComment = adminComment;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Boolean getNotice() {
		return notice;
	}

	public void setNotice(Boolean notice) {
		this.notice = notice;
	}

	public Long getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(Long parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public BlogIdAndTitle getBlog() {
		return blog;
	}

	public void setBlog(BlogIdAndTitle blog) {
		this.blog = blog;
	}

	public List<Comment> getReplyComments() {
		return replyComments;
	}

	public void setReplyComments(List<Comment> replyComments) {
		this.replyComments = replyComments;
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	@Override
	public String toString() {
		return "Comment{" +
				"id=" + id +
				", nickname='" + nickname + '\'' +
				", email='" + email + '\'' +
				", content='" + content + '\'' +
				", avatar='" + avatar + '\'' +
				", createTime=" + createTime +
				", website='" + website + '\'' +
				", ip='" + ip + '\'' +
				", published=" + published +
				", adminComment=" + adminComment +
				", page=" + page +
				", notice=" + notice +
				", parentCommentId=" + parentCommentId +
				", qq='" + qq + '\'' +
				", blog=" + blog +
				", blogId=" + blogId +
				", replyComments=" + replyComments +
				'}';
	}
}
