package club.beenest.blog.entity.comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 页面评论
 *
 * @author 陈玉轩
 * @since 1.0
 */

public class PageComment {

    /**
     *
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

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
     * 博主回复
     */
    private Boolean adminComment;

    /**
     * 父评论id
     */
    private String parentCommentId;

    /**
     * 父评论昵称
     */
    private String parentCommentNickname;


    /**
     * 回复该评论的评论
     */
    private List<PageComment> replyComments = new ArrayList<>();

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

	public Boolean getAdminComment() {
		return adminComment;
	}

	public void setAdminComment(Boolean adminComment) {
		this.adminComment = adminComment;
	}

	public String getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(String parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	public String getParentCommentNickname() {
		return parentCommentNickname;
	}

	public void setParentCommentNickname(String parentCommentNickname) {
		this.parentCommentNickname = parentCommentNickname;
	}

	public List<PageComment> getReplyComments() {
		return replyComments;
	}

	public void setReplyComments(List<PageComment> replyComments) {
		this.replyComments = replyComments;
	}

	@Override
	public String toString() {
		return "PageComment{" +
				"id=" + id +
				", nickname='" + nickname + '\'' +
				", content='" + content + '\'' +
				", avatar='" + avatar + '\'' +
				", createTime=" + createTime +
				", website='" + website + '\'' +
				", adminComment=" + adminComment +
				", parentCommentId='" + parentCommentId + '\'' +
				", parentCommentNickname='" + parentCommentNickname + '\'' +
				", replyComments=" + replyComments +
				'}';
	}
}
