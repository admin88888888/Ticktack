package com.qianfeng.controller;


import com.qianfeng.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login.do")
    public String Login(String no, String password){

        UsernamePasswordToken token = new UsernamePasswordToken(no, password);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            return "redirect:/index.html";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "login";
        }

    }

    @RequestMapping("loginOut.do")
    public String LoginOut(){
        Subject subject = SecurityUtils.getSubject();

        subject.logout();
        return "redirect:/login.html";

    }
}
