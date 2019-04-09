package com.fnl.demo.controller;

import com.google.common.base.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        //如果已经认证通过，直接跳转到首页
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        return "login";
    }

    @PostMapping("/login")
    public Object login(String userName, String password, Model model){
        if(Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(password)){
            model.addAttribute("message", "账号或密码不能为空!");
        }else{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            try {
                subject.login(token);
                return "redirect:/index";
            }  catch (UnknownAccountException e) {
                //账号不存在和下面密码错误一般都合并为一个账号或密码错误，这样可以增加暴力破解难度
                model.addAttribute("message", "账号不存在！");
            } catch (DisabledAccountException e) {
                model.addAttribute("message", "账号未启用！");
            } catch (IncorrectCredentialsException e) {
                model.addAttribute("message", "密码错误！");
            } catch (Throwable e) {
                model.addAttribute("message", "未知错误！");
            }
        }
        return "login";
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "login";
    }

}
