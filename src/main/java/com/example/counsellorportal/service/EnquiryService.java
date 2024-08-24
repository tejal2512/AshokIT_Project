package com.example.counsellorportal.service;

import com.example.counsellorportal.dto.ViewEnqFilterRequest;
import com.example.counsellorportal.Enquiry;

import java.util.List;

public interface EnquiryService {
    public boolean addEnquiry(Enquiry enq,Integer counsellorId) throws Exception;
    public List<Enquiry> getAllEnquiries(Integer counsellorId);
    public List<Enquiry> getEnquiriesWithFilter(ViewEnqFilterRequest filterRequest,Integer counsellorId);
    public Enquiry getEnquiryById(Integer enqId);
}
