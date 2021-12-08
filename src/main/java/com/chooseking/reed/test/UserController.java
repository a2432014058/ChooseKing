package com.chooseking.reed.test;

import com.chooseking.reed.entity.User;
import com.chooseking.reed.http.ErrorMessage;
import com.chooseking.reed.http.Result;
import com.chooseking.reed.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;


/**
 * @author Administrator
 * @version 1.0
 * @date 2021/11/17 16:51
 */
@RestController
public class UserController {
    @Resource
    UserService userService;

    /**
     * 登陆
     *
     * @return 是否成功
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {
        User user1 = userService.selectUserForLogin(user.getUsername());
        if (user1!=null && Objects.equals(user1.getPassword(),user.getPassword())) {
            return Result.success(user1);
        }
        return Result.error(ErrorMessage.loginError);
    }


    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if (userService.isExist(user.getUsername())) {
            return Result.error(ErrorMessage.nameError);
        }
        boolean suc = userService.insertUser(user);
        if (suc) {
            return Result.success();
        } else {
            return Result.error(ErrorMessage.registerError);
        }
    }
}
