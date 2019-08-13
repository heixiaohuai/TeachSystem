package com.hk.pojo.mypojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hk.pojo.Teacher;

import java.sql.Date;

/**
 * @Classname MyCourse
 * @Description TODO
 * @Date 2019/7/10 8:50
 * @Created by HK
 */
public class MyCourse {
    private int uid;
    private String uno;
    private String uname;
    private int ucredit;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ustart;
    private String uaddr;
    private String ukind;
    private Teacher teacher;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUcredit() {
        return ucredit;
    }

    public void setUcredit(int ucredit) {
        this.ucredit = ucredit;
    }

    public Date getUstart() {
        return ustart;
    }

    public void setUstart(Date ustart) {
        this.ustart = ustart;
    }

    public String getUaddr() {
        return uaddr;
    }

    public void setUaddr(String uaddr) {
        this.uaddr = uaddr;
    }

    public String getUkind() {
        return ukind;
    }

    public void setUkind(String ukind) {
        this.ukind = ukind;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "MyCourse{" +
                "uid=" + uid +
                ", uno='" + uno + '\'' +
                ", uname='" + uname + '\'' +
                ", ucredit=" + ucredit +
                ", ustart=" + ustart +
                ", uaddr='" + uaddr + '\'' +
                ", ukind='" + ukind + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public MyCourse() {
    }

    public MyCourse(String uno, String uname, int ucredit, Date ustart, String uaddr, String ukind, Teacher teacher) {

        this.uno = uno;
        this.uname = uname;
        this.ucredit = ucredit;
        this.ustart = ustart;
        this.uaddr = uaddr;
        this.ukind = ukind;
        this.teacher = teacher;
    }
}
