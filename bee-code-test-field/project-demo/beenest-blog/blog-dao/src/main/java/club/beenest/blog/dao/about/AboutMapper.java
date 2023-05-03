package club.beenest.blog.dao.about;

import club.beenest.blog.entity.about.About;
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
	List<About> getList();

	int updateAbout(@Param("nameEn") String nameEn, @Param("value") String value);

	String getAboutCommentEnabled();
}
