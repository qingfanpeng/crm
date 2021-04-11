package com.peng.crm.controller;

import com.peng.crm.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author qingfan
 * @creat 2021-04-09-21:56
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            model.addAttribute("msg","用户验证失败：" + e.getMessage());
            return "login";
        }
        return "redirect:/admin";
    }
    @GetMapping("/unauthorize")
    public String unauthorize() {
        return "unauthorize";
    }


}
