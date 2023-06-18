package club.beenest.blog.dao.about;

import club.beenest.blog.entity.about.About;
import club.beenest.blog.vo.about.AdminAboutVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 关于我持久层接口
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Mapper
@Repository
public interface AboutMapper {
	About selectAboutByUserId(@Param("userId") long userId);

	int updateAbout(@Param("v") AdminAboutVO adminAbout);

	Boolean getAboutCommentEnabled(long id);
}
