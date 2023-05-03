package club.beenest.blog.support.common.dao.log;

import club.beenest.blog.support.common.entity.log.ExceptionLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 异常日志持久层接口
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Mapper
@Repository
public interface ExceptionLogMapper {
	List<ExceptionLog> getExceptionLogListByDate(@Param("startDate") String startDate
			,@Param("startDate") String endDate);

	int saveExceptionLog(ExceptionLog log);

	int deleteExceptionLogById(Long id);
}
