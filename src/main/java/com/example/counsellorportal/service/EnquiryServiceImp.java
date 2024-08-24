package com.example.counsellorportal.service;

import com.example.counsellorportal.dto.ViewEnqFilterRequest;
import com.example.counsellorportal.Counsellor;
import com.example.counsellorportal.Enquiry;
import com.example.counsellorportal.repository.CounsellorRepo;
import com.example.counsellorportal.repository.EnquiryRepo;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnquiryServiceImp implements EnquiryService{
    private EnquiryRepo enquiryRepo;
    private CounsellorRepo counsellorRepo;
    public EnquiryServiceImp(EnquiryRepo enquiryRepo,CounsellorRepo counsellorRepo){
        this.enquiryRepo=enquiryRepo;
        this.counsellorRepo=counsellorRepo;
    }
    public boolean addEnquiry(Enquiry enq, Integer counsellorId) throws Exception {
        Counsellor counsellor=counsellorRepo.findById(counsellorId).orElse(null);
        if(counsellor==null){
            throw new Exception("No counsellor found");
        }
        enq.setCounsellor(counsellor);
        Enquiry save=enquiryRepo.save(enq);
        if(save.getEnq_id()==null){
            return false;
        }
        return true;
    }
    public List<Enquiry> getAllEnquiries(Integer counsellorId){
        return enquiryRepo.getEnquiriesByCounsellorId(counsellorId);

    }
    public List<Enquiry> getEnquiriesWithFilter(ViewEnqFilterRequest filterRequest, Integer counsellorId){
        Enquiry enquiry=new Enquiry();
        if(StringUtils.isNotEmpty(filterRequest.getClassMode())){
            enquiry.setClass_mode(filterRequest.getClassMode());
        }
        if(StringUtils.isNotEmpty(filterRequest.getCourseName())){
            enquiry.setCourse_name(filterRequest.getCourseName());
        }
        if(StringUtils.isNotEmpty(filterRequest.getEnqStatus())){
            enquiry.setEnq_status(filterRequest.getEnqStatus());
        }

        Counsellor counsellor=counsellorRepo.findById(counsellorId).orElse(null);
        enquiry.setCounsellor(counsellor);
        Example<Enquiry> of=Example.of(enquiry);
        List<Enquiry> enquiryList=enquiryRepo.findAll(of);
        return enquiryList;
    }

    public Enquiry getEnquiryById(Integer enqId){
        return enquiryRepo.findById(enqId).orElse(null);
    }
}
