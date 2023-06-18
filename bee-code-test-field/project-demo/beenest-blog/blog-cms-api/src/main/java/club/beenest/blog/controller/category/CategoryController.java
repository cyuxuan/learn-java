package club.beenest.blog.controller.category;

import club.beenest.blog.entity.catagory.Category;
import club.beenest.blog.service.category.CategoryService;
import club.beenest.blog.support.log.annotation.OperationLogger;
import club.beenest.blog.support.request.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 分类信息
 *
 * @author 陈玉轩
 * @since 1.0
 */
@RestController
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 获取博客分类列表
     *
     * @param pageNum  页码
     * @param pageSize 每页个数
     * @return 博客分类分页数据
     */
    @GetMapping("/categories")
    public Result categories(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestBody(required = false) Category category) {
        return Result.ok("请求成功", categoryService.getCategoryListForPage(pageNum, pageSize, category));
    }

    /**
     * 添加新分类
     *
     * @param category 分类实体
     * @return 是否添加成功
     */
    @OperationLogger("添加分类")
    @PostMapping("/category")
    public Result saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return Result.ok("新增成功");
    }

    /**
     * 修改分类名称
     *
     * @param category 分类实体
     * @return 是否修改成功
     */
    @OperationLogger("修改分类")
    @PutMapping("/category")
    public Result updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
        return Result.ok("更新成功");
    }

    /**
     * 按id删除分类
     *
     * @param id 分类id
     * @return 是否删除成功
     */
    @OperationLogger("删除分类")
    @DeleteMapping("/category")
    public Result delete(@RequestParam Long id) {
        categoryService.deleteCategoryById(id);
        return Result.ok("删除成功");
    }
}
