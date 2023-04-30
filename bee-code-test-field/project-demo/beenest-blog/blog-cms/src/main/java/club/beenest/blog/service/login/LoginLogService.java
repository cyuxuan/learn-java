/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.service.login;

import club.beenest.blog.entity.LoginLog;
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
