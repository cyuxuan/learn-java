package club.beenest.blog.entity.site;

import java.util.ArrayList;
import java.util.List;

/**
 * 侧边栏资料卡
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class Introduction {
    private String avatar;

    private String name;

    private String github;

    private String telegram;

    private String qq;

    private String bilibili;

    private String netease;

    private String email;

    private List<String> rollText = new ArrayList<>();

    private List<Favorite> favorites = new ArrayList<>();

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getTelegram() {
		return telegram;
	}

	public void setTelegram(String telegram) {
		this.telegram = telegram;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getBilibili() {
		return bilibili;
	}

	public void setBilibili(String bilibili) {
		this.bilibili = bilibili;
	}

	public String getNetease() {
		return netease;
	}

	public void setNetease(String netease) {
		this.netease = netease;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRollText() {
		return rollText;
	}

	public void setRollText(List<String> rollText) {
		this.rollText = rollText;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	@Override
	public String toString() {
		return "Introduction{" +
				"avatar='" + avatar + '\'' +
				", name='" + name + '\'' +
				", github='" + github + '\'' +
				", telegram='" + telegram + '\'' +
				", qq='" + qq + '\'' +
				", bilibili='" + bilibili + '\'' +
				", netease='" + netease + '\'' +
				", email='" + email + '\'' +
				", rollText=" + rollText +
				", favorites=" + favorites +
				'}';
	}
}
