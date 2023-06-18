package club.beenest.blog.controller.about;

import club.beenest.blog.service.about.AboutService;
import club.beenest.blog.support.log.annotation.OperationLogger;
import club.beenest.blog.support.request.Result;
import club.beenest.blog.vo.about.AdminAboutVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * 关于我页面后台管理
 *
 * @author 陈玉轩
 * @since 1.0
 */
@RestController
@RequestMapping("/admin")
public class AboutController {
    @Autowired
	AboutService aboutService;

    /**
     * 获取关于我页面配置
     *
     * @return
     */
    @GetMapping("/about")
    public Result about() {
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
        aboutService.updateAbout(adminAbout);
        return Result.ok("修改成功");
    }
}
