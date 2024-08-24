package com.example.counsellorportal.repository;

import com.example.counsellorportal.Counsellor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounsellorRepo extends JpaRepository<Counsellor,Integer> {
    public Counsellor findByEmail(String email);
    public Counsellor findByEmailAndPwd(String email,String pwd);
}
