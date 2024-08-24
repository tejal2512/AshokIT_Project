package com.example.counsellorportal.controller;

import com.example.counsellorportal.Enquiry;
import com.example.counsellorportal.dto.ViewEnqFilterRequest;
import com.example.counsellorportal.service.CounsellorService;
import com.example.counsellorportal.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EnquiryController {
    private CounsellorService counsellorService;
    private EnquiryService enquiryService;
    public EnquiryController(CounsellorService counsellorService,EnquiryService enquiryService){
        this.counsellorService=counsellorService;
        this.enquiryService=enquiryService;
    }
    @GetMapping("/addEnquiry")
    public String addEnquiry(Enquiry enquiry,Model model){
        model.addAttribute("enquiry",enquiry);
        return "enquiries";
    }
    @GetMapping("/editEnquiry")
    public String editEnquiry(@RequestParam("enqid") int enqid, Model model){

        Enquiry enquiry=enquiryService.getEnquiryById(enqid);
        model.addAttribute("enquiry",enquiry);
        return "enquiries";
    }

    @PostMapping("/addEnquiryPage")
    public String addEnquiryData(Enquiry enquiry, HttpServletRequest request, Model model) throws Exception{
        HttpSession session=request.getSession(false);
        Integer cid=(Integer) session.getAttribute("counsellorId");
        boolean isSaved=enquiryService.addEnquiry(enquiry,cid);
        if(isSaved){
            model.addAttribute("smsg","Enquiry added");
        }else{
            model.addAttribute("errmsg","Enquiry not added");
        }
        return "enquiries";
    }
    @GetMapping("/viewenquiries")
    public String viewEnquiry(HttpServletRequest request,Model model){
        HttpSession session=request.getSession(false);
        Integer cid=(Integer) session.getAttribute("counsellorId");
        ViewEnqFilterRequest viewEnqFilterRequest=new ViewEnqFilterRequest();
        model.addAttribute("viewEnqFilterRequest",viewEnqFilterRequest);
        List<Enquiry> enquiries=enquiryService.getAllEnquiries(cid);
        model.addAttribute("enquiries",enquiries);
        return "viewenquiry";
    }

    @GetMapping("/viewfilteredEnquiry")
    public String viewfilteredenquiry(HttpServletRequest request, ViewEnqFilterRequest viewEnqFilterRequest, Model model){
        HttpSession session=request.getSession(false);
        Integer cid=(Integer) session.getAttribute("counsellorId");
        List<Enquiry> enquiries=enquiryService.getEnquiriesWithFilter(viewEnqFilterRequest,cid);
        model.addAttribute("enquiries",enquiries);
        return "viewenquiry";
    }

}
