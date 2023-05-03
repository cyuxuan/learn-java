package club.beenest.blog.dao.visit;

import club.beenest.blog.entity.visit.VisitRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 访问记录持久层接口
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface VisitRecordMapper {
    List<VisitRecord> getVisitRecordListByLimit(Integer limit);

    int saveVisitRecord(VisitRecord visitRecord);
}
