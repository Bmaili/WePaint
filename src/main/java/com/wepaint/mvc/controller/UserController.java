package com.wepaint.mvc.controller;

import com.wepaint.mvc.bean.User;
import com.wepaint.mvc.service.UserService;
import com.wepaint.mvc.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    private UserService userService = new UserServiceImpl();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    /**
     * 用户登录
     *
     * @param user
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session) {
        //获取用户名和密码
        String username = user.getUsername();
        String password = user.getPassword();

        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 如果等于null,说明登录 失败!
        if (loginUser != null) {
            //将用户对象添加到Session中，重定向到主页面的跳转方法
            session.setAttribute("USER_SESSION", user);
            return "redirect:home";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        model.addAttribute("username", username);
        return "login";
    }

    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String toRegist() {
        return "regist";
    }


    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(User user, Model model, HttpSession session) {
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();
//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
//        if ("abcde".equalsIgnoreCase(code)) {
////        3、检查 用户名是否可用
        if (userService.existsUsername(username)) {

            // 回显信息
            model.addAttribute("msg", "用户名已存在！");
            model.addAttribute("username", username);
            model.addAttribute("email", email);
            return "regist";
        } else {

            userService.registUser(new User(null, username, password, email));

            model.addAttribute("msg", "注册成功！");
            model.addAttribute("username", username);
            return "login";
//            }
//        } else {
//            model.addAttribute("msg", "验证码错误！");
//            model.addAttribute("username", username);
//            model.addAttribute("email", email);
//            return "regist";
//        }
//        return "regist";

//        }
        }
    }

    @RequestMapping(value = "/home")
    public String toSuccess() {
        return "home";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到登录页面的跳转方法
        return "redirect:login";
    }
}
