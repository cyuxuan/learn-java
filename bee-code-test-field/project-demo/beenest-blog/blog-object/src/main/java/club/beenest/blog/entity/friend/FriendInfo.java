package club.beenest.blog.entity.friend;

/**
 * 友链页面信息
 *
 * @author 陈玉轩
 * @since　1.0
 */
public class FriendInfo {
    private String content;
    private Boolean commentEnabled;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getCommentEnabled() {
		return commentEnabled;
	}

	public void setCommentEnabled(Boolean commentEnabled) {
		this.commentEnabled = commentEnabled;
	}

	@Override
	public String toString() {
		return "FriendInfo{" +
				"content='" + content + '\'' +
				", commentEnabled=" + commentEnabled +
				'}';
	}
}
