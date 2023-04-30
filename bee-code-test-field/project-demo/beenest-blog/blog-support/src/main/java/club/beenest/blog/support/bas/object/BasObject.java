/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.bas.object;

/**
 * 基本实体类
 */
public class BasObject {
    /**
     * 物理主键
     */
    private Long pId;

    /**
     * 当前数据创建人
     */
    private String creationUserId;

    /**
     * 当前数据创建时间
     */
    private String creationDate;

    /**
     * 当前数据最后更新人
     */
    private String lastUpdateUserId;

    /**
     * 当前数据最后更新时间
     */
    private String lastUpdateDate;



    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getCreationUserId() {
        return creationUserId;
    }

    public void setCreationUserId(String creationUserId) {
        this.creationUserId = creationUserId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
