package com.hk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

/**
 * 教师 查看选课情况实体类
 */
public class MyCour {
    private int id; //选课表ID
    private String no; //学生学号
    private String cno; //课程号
    private String cname; //课程名称
    private String ccredit; //学分
    private String tname;  //教师
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date cstart;  //开始时间
    private String caddr; //上课地点
    private String ckind; //课程类型
    private String flag;   //标志

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCcredit() {
        return ccredit;
    }

    public void setCcredit(String ccredit) {
        this.ccredit = ccredit;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Date getCstart() {
        return cstart;
    }

    public void setCstart(Date cstart) {
        this.cstart = cstart;
    }

    public String getCaddr() {
        return caddr;
    }

    public void setCaddr(String caddr) {
        this.caddr = caddr;
    }

    public String getCkind() {
        return ckind;
    }

    public void setCkind(String ckind) {
        this.ckind = ckind;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "MyCourse{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", cno=" + cno +
                ", cname='" + cname + '\'' +
                ", ccredit='" + ccredit + '\'' +
                ", tname='" + tname + '\'' +
                ", cstart=" + cstart +
                ", caddr='" + caddr + '\'' +
                ", ckind='" + ckind + '\'' +
                ", flag=" + flag +
                '}';
    }
}
