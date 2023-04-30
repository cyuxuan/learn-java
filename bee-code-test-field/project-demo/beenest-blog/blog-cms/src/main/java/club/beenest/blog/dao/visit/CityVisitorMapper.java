package club.beenest.blog.dao.visit;

import club.beenest.blog.entity.visit.CityVisitor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 城市访客数量统计持久层接口
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface CityVisitorMapper {
    List<CityVisitor> getCityVisitorList();

    int saveCityVisitor(CityVisitor cityVisitor);
}
