package com.isoftstone.honorplatform.controller;

import com.isoftstone.honorplatform.core.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class AuthController {
    @PostMapping("/login")
    @ResponseBody
    public RestResult login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        return RestResult.success();
    }

    @GetMapping("/logout")
    public RestResult logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return RestResult.success();
    }
}
