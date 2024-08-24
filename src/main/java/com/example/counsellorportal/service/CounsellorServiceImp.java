package com.example.counsellorportal.service;

import com.example.counsellorportal.dto.DashboardResponse;
import com.example.counsellorportal.Counsellor;
import com.example.counsellorportal.Enquiry;
import com.example.counsellorportal.repository.CounsellorRepo;
import com.example.counsellorportal.repository.EnquiryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CounsellorServiceImp implements CounsellorService{
    private CounsellorRepo counsellorRepo;
    private EnquiryRepo enquiryRepo;

    public CounsellorServiceImp(CounsellorRepo counsellorRepo,EnquiryRepo enquiryRepo){
        this.counsellorRepo=counsellorRepo;
        this.enquiryRepo=enquiryRepo;
    }
    public boolean register(Counsellor counsellor){
        Counsellor savedCounsellor=counsellorRepo.save(counsellor);
        if(savedCounsellor.getCounsellor_id()!=null){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public Counsellor findByEmail(String email) {
        Counsellor counsellor=counsellorRepo.findByEmail(email);
        return counsellor;
    }

    public Counsellor login(String email, String pwd){
        return counsellorRepo.findByEmailAndPwd(email, pwd);
    }

    public DashboardResponse getDashboardInfo(Integer counsellorId){
        DashboardResponse response=new DashboardResponse();
        List< Enquiry> enqList =enquiryRepo.getEnquiriesByCounsellorId(counsellorId);
        int totalEnq=enqList.size();

        int enrolledEnqs=enqList.stream()
                .filter(e->e.getEnq_status().equals("Enrolled"))
                .collect(Collectors.toList())
                .size();

        int lostEnqs=enqList.stream()
                .filter(e->e.getEnq_status().equals("Lost"))
                .collect(Collectors.toList())
                .size();

        int openEnqs=enqList.stream()
                .filter(e->e.getEnq_status().equals("Open"))
                .collect(Collectors.toList())
                .size();

        response.setTotalEnqs(totalEnq);
        response.setLostEnqs(lostEnqs);
        response.setOpenEnqs(openEnqs);
        response.setEnrolledEnqs(enrolledEnqs);

        return response;
    }
}
