package com.hk.pojo.mypojo;

/**
 * @Classname MyTeacher
 * @Description TODO
 * @Date 2019/7/9 20:35
 * @Created by HK
 */
public class MyTeacher {
    private int uid;
    private String uno;
    private String uname;
    private String sex;
    private int uage;
    private String udept;//部门
    private String utitle;//职称
    private String upwd;
    private String timg;
    private String uremark;//备注

    public MyTeacher(String uno, String uname, String sex, int uage, String udept, String utitle, String upwd, String timg, String uremark) {
        this.uno = uno;
        this.uname = uname;
        this.sex = sex;
        this.uage = uage;
        this.udept = udept;
        this.utitle = utitle;
        this.upwd = upwd;
        this.timg = timg;
        this.uremark = uremark;
    }

    public MyTeacher() {

    }

    @Override
    public String toString() {
        return "MyTeacher{" +
                "uid=" + uid +
                ", uno='" + uno + '\'' +
                ", uname='" + uname + '\'' +
                ", sex='" + sex + '\'' +
                ", uage=" + uage +
                ", udept='" + udept + '\'' +
                ", utitle='" + utitle + '\'' +
                ", upwd='" + upwd + '\'' +
                ", timg='" + timg + '\'' +
                ", uremark='" + uremark + '\'' +
                '}';
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

    public String getUdept() {
        return udept;
    }

    public void setUdept(String udept) {
        this.udept = udept;
    }

    public String getUtitle() {
        return utitle;
    }

    public void setUtitle(String utitle) {
        this.utitle = utitle;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getTimg() {
        return timg;
    }

    public void setTimg(String timg) {
        this.timg = timg;
    }

    public String getUremark() {
        return uremark;
    }

    public void setUremark(String uremark) {
        this.uremark = uremark;
    }
}
