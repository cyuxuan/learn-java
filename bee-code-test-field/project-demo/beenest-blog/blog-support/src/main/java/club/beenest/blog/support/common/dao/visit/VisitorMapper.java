/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.common.dao.visit;

import club.beenest.blog.entity.visit.Visitor;
import club.beenest.blog.support.common.entity.log.VisitLogUuidTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 访客统计持久层接口
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Mapper
@Repository
public interface VisitorMapper {
    List<Visitor> getVisitorListByDate(@Param("startDate") String startDate, @Param("startDate") String endDate);

    List<String> getNewVisitorIpSourceByYesterday();

    int hasUUID(String uuid);

    int saveVisitor(Visitor visitor);

    int updatePVAndLastTimeByUUID(VisitLogUuidTime dto);

    int deleteVisitorById(Long id);
}
