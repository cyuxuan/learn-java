package club.beenest.blog.dao.category;

import club.beenest.blog.entity.catagory.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 博客分类持久层接口
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface CategoryMapper {
    List<Category> getCategoryList();

    List<Category> getCategoryNameList();

    int saveCategory(Category category);

    Category getCategoryById(Long id);

    Category getCategoryByName(String name);

    int deleteCategoryById(Long id);

    int updateCategory(Category category);
}
