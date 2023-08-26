/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.vo.category;

import club.beenest.blog.entity.catagory.Category;
import club.beenest.blog.entity.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 分类和标签的试图对象
 *
 * @author 陈玉轩
 * @since　1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoriesAndTagsVO {
    List<Category> categories;

    List<Tag> tags;
}
