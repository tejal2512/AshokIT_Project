package com.example.counsellorportal.dto;
public class DashboardResponse {
    private Integer totalEnqs;
    private Integer openEnqs;
    private Integer lostEnqs;
    private Integer enrolledEnqs;
    public Integer getTotalEnqs() {
        return totalEnqs;
    }

    public void setTotalEnqs(Integer totalEnqs) {
        this.totalEnqs = totalEnqs;
    }

    public Integer getOpenEnqs() {
        return openEnqs;
    }

    public void setOpenEnqs(Integer openEnqs) {
        this.openEnqs = openEnqs;
    }

    public Integer getLostEnqs() {
        return lostEnqs;
    }

    public void setLostEnqs(Integer lostEnqs) {
        this.lostEnqs = lostEnqs;
    }

    public Integer getEnrolledEnqs() {
        return enrolledEnqs;
    }

    public void setEnrolledEnqs(Integer enrolledEnqs) {
        this.enrolledEnqs = enrolledEnqs;
    }


}
