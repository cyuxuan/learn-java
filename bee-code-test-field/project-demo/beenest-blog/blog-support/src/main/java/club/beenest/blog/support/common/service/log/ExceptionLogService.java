package club.beenest.blog.support.common.service.log;

import club.beenest.blog.support.common.entity.log.ExceptionLog;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface ExceptionLogService {
	List<ExceptionLog> getExceptionLogListByDate(String startDate, String endDate);

	@Async
	void saveExceptionLog(ExceptionLog log);

	void deleteExceptionLogById(Long id);
}
