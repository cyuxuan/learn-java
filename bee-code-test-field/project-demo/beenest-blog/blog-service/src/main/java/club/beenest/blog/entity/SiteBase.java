/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.entity;

public class SiteBase {
    /**
     * 站点设置
     */
    SiteSetting siteSetting;

    public SiteSetting getSiteSetting() {
        return siteSetting;
    }

    public void setSiteSetting(SiteSetting siteSetting) {
        this.siteSetting = siteSetting;
    }

    @Override
    public String toString() {
        return "SiteBase{" +
                "siteSetting=" + siteSetting.toString() +
                '}';
    }
}
