package com.hk.pojo;

/**
 * @Classname StuScore
 * @Description TODO
 * @Date 2019/7/12 10:16
 * @Created by HK
 */
public class StuScore {
    private String sno;
    private String cname;
    private String year;
    private String term;
    private double score;
    private String flag;


    public StuScore() {
    }
    public StuScore(String sno, String cname, String year, String term, double score, String flag) {
        this.sno = sno;
        this.cname = cname;
        this.year = year;
        this.term = term;
        this.score = score;
        this.flag = flag;
    }
    @Override
    public String toString() {
        return "MyScore [sno=" + sno + ", cname=" + cname + ", year=" + year + ", term=" + term + ", score=" + score
                + ", flag=" + flag + "]";
    }
    public String getSno() {
        return sno;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
}
