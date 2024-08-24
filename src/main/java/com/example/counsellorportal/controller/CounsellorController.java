package com.example.counsellorportal.controller;

import com.example.counsellorportal.Counsellor;
import com.example.counsellorportal.dto.DashboardResponse;
import com.example.counsellorportal.service.CounsellorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CounsellorController {

    private CounsellorService counsellorService;
    public CounsellorController(CounsellorService counsellorService){
        this.counsellorService=counsellorService;
    }
    @GetMapping("/")
    public String loginPage(Model model){
        Counsellor counsellor=new Counsellor();
        model.addAttribute("counsellor",counsellor);
        return "index";
    }

    @PostMapping("/login")
    public String loginbuttonhandle(HttpServletRequest request, Counsellor counsellor, Model model){

        Counsellor counsellor1=counsellorService.login(counsellor.getEmail(),counsellor.getPwd());
        if(counsellor1!=null){
            Integer cid=counsellor1.getCounsellor_id();
            HttpSession session=request.getSession(true);
            session.setAttribute("counsellorId",cid);

            return "redirect:/dashboard";
        }else{
            model.addAttribute("errmsg", "Invalid credentials");

        }
        return "index";
    }
    @GetMapping("/dashboard")
    public String displayDashboard(HttpServletRequest request,Model model){
        HttpSession session=request.getSession(false);
        Integer cid=(Integer) session.getAttribute("counsellorId");
        DashboardResponse response =counsellorService.getDashboardInfo(cid);
        model.addAttribute("response",response);
        return "dashboard";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Counsellor counsellor, Model model){

        HttpSession session=request.getSession(false);
        session.invalidate();
        return "redirect:/";

    }

    @GetMapping("/register")
    public String registerPage(Model model){
        Counsellor counsellor=new Counsellor();
        model.addAttribute("counsellor",counsellor);
        return "register";
    }
    @PostMapping("/register")
    public String saveDetails(Counsellor counsellor,Model model){
        String email=counsellor.getEmail();
        String errmsg=null;
        if(counsellorService.findByEmail(email)!=null) {
            errmsg = "Duplicate email";
            model.addAttribute("errmsg", errmsg);
            return "register";
        }

        if(counsellorService.register(counsellor)){
            errmsg="Successfully registered";
            model.addAttribute("smsg", errmsg);
        }
        return "register";
    }
}
