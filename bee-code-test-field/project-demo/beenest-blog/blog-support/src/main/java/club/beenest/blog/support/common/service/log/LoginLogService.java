/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.common.service.log;

import club.beenest.blog.support.common.entity.log.LoginLog;
import org.springframework.scheduling.annotation.Async;


import java.util.List;

/**
 * 登录信息
 */
public interface LoginLogService {
	List<LoginLog> getLoginLogListByDate(String startDate, String endDate);

	@Async
	void saveLoginLog(LoginLog log);

	void deleteLoginLogById(Long id);
}
