package com.hk.pojo;

public class MyScore {
    private int no;
    private String grade;
    private String cname;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "MyScore{" +
                "no=" + no +
                ", grade='" + grade + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
