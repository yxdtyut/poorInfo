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

    @RequestMapping("/stuIndex")
    public String stuIndex() {
        return "stuIndex";
    }

    @RequestMapping("/teacherIndex")
    public String teacherIndex() {
        return "teacherIndex";
    }

    @RequestMapping("/teacherInfo")
    public String teacherInfo() {
        return "teacherInfo";
    }

    @RequestMapping("/poorInfo/add")
    public String poorInfoAdd() {
        return "poorInfoAdd";
    }

    @RequestMapping("/poorInfo")
    public String poorInfo() {
        return "poorInfo";
    }

    @RequestMapping("/stuInfo_mf")
    public String stuInfo_mf() {
        return "stuInfo_mf";
    }


    @RequestMapping("/parseStu")
    public String parseStu() {
        return "parseStu";
    }

    @RequestMapping("/registView")
    public String StuRegister() {
        return "registView";
    }

    @RequestMapping("/stuModi")
    public ModelAndView stuModi(ModelAndView mav, @RequestParam("num") String num) {
        mav.addObject("num", num);
        mav.setViewName("stuModi");
        return mav;
    }


    @RequestMapping("/stuScore")
    public String stuScore() {
        return "stuScore";
    }


    @RequestMapping("/teaAdd")
    public String teaAdd() {
        return "teaAdd";
    }

    @RequestMapping("/teacherInfo_mf")
    public String teacherInfo_mf() {
        return "teacherInfo_mf";
    }


    @RequestMapping("/teaModi")
    public ModelAndView teaModi(ModelAndView mav, @RequestParam("num") String num) {
        mav.addObject("num", num);
        mav.setViewName("teaModi");
        return mav;
    }


    @RequestMapping("/claCouModi")
    public ModelAndView claCouModi(ModelAndView mav, @RequestParam("coursename") String coursename, @RequestParam("num") String num) {
        mav.addObject("num", num);
        System.out.println(coursename);
        mav.addObject("coursename", coursename);
        mav.setViewName("claCouModi");
        return mav;
    }


    @RequestMapping("/claCouScore")
    public String claCouScore() {
        return "claCouScore";
    }

    @RequestMapping("/ClaCouSco")
    public String ClaCouSco() {
        return "ClaCouSco";
    }

    @RequestMapping("/ClaCouTea")
    public String ClaCouTea() {
        return "ClaCouTea";
    }

    @RequestMapping("/parseClaCouSco")
    public String parseClaCouSco() {
        return "parseClaCouSco";
    }


    @RequestMapping("/parseClaComp")
    public String parseClaComp() {
        return "parseClaComp";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/announce")
    public String announce() {
        return "announce";
    }


}
