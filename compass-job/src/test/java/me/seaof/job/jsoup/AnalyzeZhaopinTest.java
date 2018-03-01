package me.seaof.job.jsoup;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Watter on 2018-02-28
 */
public class AnalyzeZhaopinTest {
    @Test
    public void test(){
        Integer num = AnalyzeZhaopin.zhaoPinNum("http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E4%B8%8A%E6%B5%B7&kw=java&sm=0&p=1", "UTF-8");
        System.out.println("数量："+ num);
    }

}