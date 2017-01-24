package com.spring.controller;
/**
 * Created by Gerry on 2017/1/4.
 */

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.spring.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String getController(HttpServletRequest request) {
        log.info("这是controller层,调用service方法 : ");
        //userService.getService();
        String username = request.getParameter("username");
        request.getSession().setAttribute("user", username);
        log.info("uer/login,username:" + request.getSession().getAttribute("user"));
        return "success";
    }

    @RequestMapping("/hello")
    public String hellotest() {
        return "success";
    }

    @RequestMapping("/userexists")
    public void userexsit(@RequestParam(value = "name") String name, HttpServletResponse response) throws Exception {
        String result = userService.isexsits(name);
        PrintWriter out = response.getWriter();
        out.write(result);
        out.close();
    }

    @RequestMapping("/showuser")
    public String showuser(ModelAndView modelAndView) {
        List ulist=null;
        return "showuser";
    }


}