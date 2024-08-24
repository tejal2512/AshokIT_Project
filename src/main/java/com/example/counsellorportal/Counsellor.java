package com.example.counsellorportal;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="counsellor_table")
public class Counsellor  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer counsellor_id;
    private String name;

    @Column(unique = true)
    private String email;
    private String pwd;

    public Integer getCounsellor_id() {
        return counsellor_id;
    }

    public void setCounsellor_id(Integer counsellor_id) {
        this.counsellor_id = counsellor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
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

    private String phno;
    @CreationTimestamp
    private LocalDateTime created_date;
    @UpdateTimestamp
    private LocalDateTime updated_date;


}
