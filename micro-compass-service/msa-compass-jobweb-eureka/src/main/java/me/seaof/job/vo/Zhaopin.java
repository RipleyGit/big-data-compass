package me.seaof.job.vo;

import java.io.Serializable;

/**
 * 智联招聘信息
 *
 * Created by Watter on 2018-02-28
 */
public class Zhaopin implements Serializable {
    private String zwmc;    //职位名称
    private String gsmc;    //公司名称
    private String zwyx;    //职位月薪
    private String gzdd;    //工作地点
    private String gxsj;    //发布日期

    public String getZwmc() {
        return zwmc;
    }

    public void setZwmc(String zwmc) {
        this.zwmc = zwmc;
    }

    public String getGsmc() {
        return gsmc;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc;
    }

    public String getZwyx() {
        return zwyx;
    }

    public void setZwyx(String zwyx) {
        this.zwyx = zwyx;
    }

    public String getGzdd() {
        return gzdd;
    }

    public void setGzdd(String gzdd) {
        this.gzdd = gzdd;
    }

    public String getGxsj() {
        return gxsj;
    }

    public void setGxsj(String gxsj) {
        this.gxsj = gxsj;
    }
}
