package club.beenest.blog.service.about;

import club.beenest.blog.entity.about.About;
import club.beenest.blog.vo.about.AdminAboutVO;

import java.util.Map;

public interface AboutService {
	About getAboutInfo();

	About getAboutSetting();

	void updateAbout(AdminAboutVO adminAbout);

	boolean getAboutCommentEnabled();
}
