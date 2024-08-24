package com.example.counsellorportal.repository;

import com.example.counsellorportal.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnquiryRepo extends JpaRepository<Enquiry,Integer> {
    @Query(value="select * from enquiry_table where counsellor_id=:counsellorId",nativeQuery = true)
    public List<Enquiry> getEnquiriesByCounsellorId(@Param("counsellorId") Integer counsellorId);
}
