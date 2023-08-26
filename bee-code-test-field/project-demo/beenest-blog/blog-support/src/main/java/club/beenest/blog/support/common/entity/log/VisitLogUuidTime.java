/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.common.entity.log;

import java.util.Date;

/**
 * 访客更新
 *
 * @author 陈玉轩
 * @since 1.0
 */

public class VisitLogUuidTime {
    private String uuid;
    private Date time;
    private Integer pv;

    public VisitLogUuidTime(String uuid, Date time, Integer pv) {
        this.uuid = uuid;
        this.time = time;
        this.pv = pv;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    @Override
    public String toString() {
        return "VisitLogUuidTime{" +
                "uuid='" + uuid + '\'' +
                ", time=" + time +
                ", pv=" + pv +
                '}';
    }
}
