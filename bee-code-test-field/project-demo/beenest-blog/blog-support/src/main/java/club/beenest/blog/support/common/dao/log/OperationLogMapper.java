package club.beenest.blog.support.common.dao.log;

import club.beenest.blog.support.common.entity.log.OperationLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 操作日志持久层接口
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface OperationLogMapper {
    List<OperationLog> getOperationLogListByDate(@Param("startDate") String startDate
            ,@Param("startDate") String endDate);

    int saveOperationLog(OperationLog log);

    int deleteOperationLogById(Long id);
}
