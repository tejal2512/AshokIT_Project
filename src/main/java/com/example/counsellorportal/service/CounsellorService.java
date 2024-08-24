package com.example.counsellorportal.service;

import com.example.counsellorportal.dto.DashboardResponse;
import com.example.counsellorportal.Counsellor;

public interface CounsellorService {
    public Counsellor findByEmail(String email);
    public Counsellor login(String email,String pwd);
    public boolean register(Counsellor counsellor);
    public DashboardResponse getDashboardInfo(Integer counsellorId);
}
