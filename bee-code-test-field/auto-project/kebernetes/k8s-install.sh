package club.beenest.blog.controller.about;

// 导入关于我页面后台管理的接口
import club.beenest.blog.service.about.AboutService;
// 导入日志注解
import club.beenest.blog.support.log.annotation.OperationLogger;
// 导入请求参数
import club.beenest.blog.support.request.Result;
// 导入请求参数
import club.beenest.blog.vo.about.AdminAboutVO;
// 导入请求参数
import org.springframework.beans.factory.annotation.Autowired;
// 导入请求参数
import org.springframework.web.bind.annotation.GetMapping;
// 导入请求参数
import org.springframework.web.bind.annotation.PutMapping;
// 导入请求参数
import org.springframework.web.bind.annotation.RequestMapping;
// 导入请求参数
import org.springframework.web.bind.annotation.RestController;
// 导入请求参数
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

// 导入请求参数

/**
 * 关于我页面后台管理
 *
 * @author 陈玉轩
 * @since 1.0
 */
@RestController
@RequestMapping("/admin")
public class AboutController {
    // 声明一个注入的AboutService
    @Autowired
	AboutService aboutService;

    /**
     * 获取关于我页面配置
     *
     * @return
     */
    @GetMapping("/about")
    public Result about() {
        // 返回请求成功，返回关于我页面配置
        return Result.ok("请求成功", aboutService.getAboutSetting());
    }

    /**
     * 修改关于我页面
     *
     * @param map
     * @return
     */
    @OperationLogger("修改关于我页面")
    @PutMapping("/about")
    public Result updateAbout(@RequestBody AdminAboutVO adminAbout) {
        // 修改关于我页面
        aboutService.updateAbout(adminAbout);
        // 返回修改成功
        return Result.ok("修改成功");
    }
}