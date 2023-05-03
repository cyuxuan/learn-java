package club.beenest.blog.dao.site;

import club.beenest.blog.entity.site.SiteSetting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 站点设置持久层接口
 *
 * @author Administrator
 * @since　1.0
 */
@Mapper
@Repository
public interface SiteSettingMapper {
    List<SiteSetting> getList();

    List<SiteSetting> getFriendInfo();

    String getWebTitleSuffix();

    int updateSiteSetting(SiteSetting siteSetting);

    int deleteSiteSettingById(Integer id);

    int saveSiteSetting(SiteSetting siteSetting);

    int updateFriendInfoContent(String content);

    int updateFriendInfoCommentEnabled(Boolean commentEnabled);
}
