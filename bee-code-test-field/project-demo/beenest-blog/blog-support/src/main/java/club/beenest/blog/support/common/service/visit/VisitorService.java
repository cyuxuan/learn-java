/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.common.service.visit;

import club.beenest.blog.entity.visit.Visitor;
import club.beenest.blog.support.common.entity.log.VisitLogUuidTime;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface VisitorService {
	List<Visitor> getVisitorListByDate(String startDate, String endDate);

	List<String> getNewVisitorIpSourceByYesterday();

	boolean hasUUID(String uuid);

	@Async
	void saveVisitor(Visitor visitor);

	void updatePVAndLastTimeByUUID(VisitLogUuidTime dto);

	void deleteVisitor(Long id, String uuid);
}
