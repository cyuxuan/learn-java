package club.beenest.blog.controller.acount;

import club.beenest.blog.entity.user.User;
import club.beenest.blog.service.user.UserService;
import club.beenest.blog.support.request.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 账号后台管理
 *
 * @author 陈玉轩
 * @since　1.0
 */
@RestController
@RequestMapping("/admin")
public class AccountController {
    @Autowired
    UserService userService;

    /**
     * 账号密码修改
     */
    @PostMapping("/account")
    public Result account(@RequestBody User user,
						  @RequestHeader(value = "Authorization", defaultValue = "") String jwt) {
        boolean res = userService.changeAccount(user, jwt);
        return res ? Result.ok("修改成功") : Result.error("修改失败");
    }
}
