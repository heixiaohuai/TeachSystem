package com.hk.pojo.mypojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

/**
 * @Classname MyStudent
 * @Description TODO
 * @Date 2019/7/9 12:27
 * @Created by HK
 */
public class MyStudent {
    private int uid;
    private String uno;
    private String uname;
    private String sex;
    private int uage;
    private String umajor;
    private String uuniversity;
    private String uphone;
    private String uaddr;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date uindate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date uoutdate;
    private String upwd;
    private String uclass;
    private String simg;

    @Override
    public String toString() {
        return "MyStudent{" +
                "uid=" + uid +
                ", uno='" + uno + '\'' +
                ", uname='" + uname + '\'' +
                ", sex='" + sex + '\'' +
                ", uage=" + uage +
                ", umajor='" + umajor + '\'' +
                ", uuniversity='" + uuniversity + '\'' +
                ", uphone='" + uphone + '\'' +
                ", uaddr='" + uaddr + '\'' +
                ", uindate=" + uindate +
                ", uoutdate=" + uoutdate +
                ", upwd='" + upwd + '\'' +
                ", uclass='" + uclass + '\'' +
                ", simg='" + simg + '\'' +
                '}';
    }

    public MyStudent(String uno, String uname, String sex, int uage, String umajor, String uuniversity, String uphone, String uaddr, Date uindate, Date uoutdate, String upwd, String uclass, String simg) {
        this.uno = uno;
        this.uname = uname;
        this.sex = sex;
        this.uage = uage;
        this.umajor = umajor;
        this.uuniversity = uuniversity;
        this.uphone = uphone;
        this.uaddr = uaddr;
        this.uindate = uindate;
        this.uoutdate = uoutdate;
        this.upwd = upwd;
        this.uclass = uclass;
        this.simg = simg;
    }

    public MyStudent() {

    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public String getUmajor() {
        return umajor;
    }

    public void setUmajor(String umajor) {
        this.umajor = umajor;
    }

    public String getUuniversity() {
        return uuniversity;
    }

    public void setUuniversity(String uuniversity) {
        this.uuniversity = uuniversity;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUaddr() {
        return uaddr;
    }

    public void setUaddr(String uaddr) {
        this.uaddr = uaddr;
    }

    public Date getUindate() {
        return uindate;
    }

    public void setUindate(Date uindate) {
        this.uindate = uindate;
    }

    public Date getUoutdate() {
        return uoutdate;
    }

    public void setUoutdate(Date uoutdate) {
        this.uoutdate = uoutdate;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUclass() {
        return uclass;
    }

    public void setUclass(String uclass) {
        this.uclass = uclass;
    }

    public String getSimg() {
        return simg;
    }

    public void setSimg(String simg) {
        this.simg = simg;
    }
}
