package com.example.counsellorportal;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="enquiry_table")
public class Enquiry {
    public Integer getEnq_id() {
        return enq_id;
    }

    public void setEnq_id(Integer enq_id) {
        this.enq_id = enq_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_phno() {
        return student_phno;
    }

    public void setStudent_phno(String student_phno) {
        this.student_phno = student_phno;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getClass_mode() {
        return class_mode;
    }

    public void setClass_mode(String class_mode) {
        this.class_mode = class_mode;
    }

    public String getEnq_status() {
        return enq_status;
    }

    public void setEnq_status(String enq_status) {
        this.enq_status = enq_status;
    }

    public Counsellor getCounsellor() {
        return counsellor;
    }

    public void setCounsellor(Counsellor counsellor) {
        this.counsellor = counsellor;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public LocalDateTime getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(LocalDateTime updated_date) {
        this.updated_date = updated_date;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer enq_id;
    private String student_name;
    private String student_phno;
    private String course_name;
    private String class_mode;
    private String enq_status;

    @ManyToOne
    @JoinColumn(name="counsellor_id")
    private Counsellor counsellor;
    @CreationTimestamp
    private LocalDateTime created_date;
    @UpdateTimestamp
    private LocalDateTime updated_date;
}
