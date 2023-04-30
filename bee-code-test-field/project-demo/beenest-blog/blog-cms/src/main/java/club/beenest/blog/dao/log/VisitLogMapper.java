package club.beenest.blog.dao.log;

import club.beenest.blog.entity.log.VisitLog;
import club.beenest.blog.entity.log.VisitLogUuidTime;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 访问日志持久层接口
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface VisitLogMapper {
    List<VisitLog> getVisitLogListByUUIDAndDate(String uuid, String startDate, String endDate);

    List<VisitLogUuidTime> getUUIDAndCreateTimeByYesterday();

    int saveVisitLog(VisitLog log);

    int deleteVisitLogById(Long id);

    int countVisitLogByToday();
}
