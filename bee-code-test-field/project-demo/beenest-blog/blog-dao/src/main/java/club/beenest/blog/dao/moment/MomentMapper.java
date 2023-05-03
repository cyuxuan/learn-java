package club.beenest.blog.dao.moment;

import club.beenest.blog.entity.moment.Moment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 博客动态持久层接口
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface MomentMapper {
    List<Moment> getMomentList();

    int addLikeByMomentId(Long momentId);

    int updateMomentPublishedById(@Param("momentId") Long momentId, @Param("published") Boolean published);

    Moment getMomentById(Long id);

    int deleteMomentById(Long id);

    int saveMoment(Moment moment);

    int updateMoment(Moment moment);
}
