package com.mizhi.yxd.controller.viewcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Sys")
public class ViewRoute {
    @RequestMapping("/loginView")
    public String loginView(HttpSession httpSession) {

        return "login";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession httpSession) {
        httpSession.removeAttribute("name");
        httpSession.removeAttribute("account");
        httpSession.removeAttribute("photo");
        return "redirect:/Sys/loginView";
    }

    @RequestMapping("/adminIndex")
    public String adminIndex(HttpSession s) {
            return "adminIndex";
    }

    @RequestMapping("/poorInfo/add")
    public String poorInfoAdd() {
        return "poorInfoAdd";
    }

    @RequestMapping("/poorInfo")
    public String poorInfo() {
        return "poorInfo";
    }

    @RequestMapping("/registView")
    public String poorRegister() {
        return "registView";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/subsidize")
    public String subsidize() {
        return "subsidize";
    }

    @RequestMapping("/subsidizeInfo")
    public String subsidizeInfo() {
        return "subsidizeInfo";
    }

    @RequestMapping("/studentInfo")
    public String studentInfo() {
        return "studentInfo";
    }

    @RequestMapping("/studentInfo/add")
    public String studentInfoAdd() {
        return "studentInfoAdd";
    }

    @RequestMapping("/learningPeriod")
    public String learningPeriod() {
        return "learningPeriod";
    }

    @RequestMapping("/learningPeriodInMizhi")
    public String learningPeriodInMizhi() {
        return "learningPeriodInMizhi";
    }

    @RequestMapping("/schoolPeriodInMizhi")
    public String schoolPeriodInMizhi() {
        return "schoolPeriodInMizhi";
    }
}
