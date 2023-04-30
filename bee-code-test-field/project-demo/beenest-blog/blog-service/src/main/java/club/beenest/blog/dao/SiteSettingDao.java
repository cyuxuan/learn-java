/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.dao;

import club.beenest.blog.entity.SiteSetting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 配置信息查询
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface SiteSettingDao {
    List<SiteSetting> getList();

    List<SiteSetting> getFriendInfo();

    String getWebTitleSuffix();

    int updateSiteSetting(SiteSetting siteSetting);

    int deleteSiteSettingById(Integer id);

    int saveSiteSetting(SiteSetting siteSetting);

    int updateFriendInfoContent(String content);

    int updateFriendInfoCommentEnabled(Boolean commentEnabled);
}
