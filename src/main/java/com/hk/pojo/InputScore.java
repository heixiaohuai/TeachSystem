package com.hk.pojo;

public class InputScore {
    private int num;
    private String no;
    private String name;
    private String cname;
    private String tname;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "InputScore{" +
                "num=" + num +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", cname='" + cname + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}
