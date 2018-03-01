package me.seaof.job.jsoup;

import me.seaof.job.util.GetInfoForWebUtils;
import me.seaof.job.vo.Zhaopin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Watter on 2018-02-28
 */
public class AnalyzeZhaopin {
    /**
     * 将网页信息解析成职位对象
     * @param url
     * @param encoding
     * @return
     */
    public static List<Zhaopin> zhaoPinData(String url, String encoding){
        String htmlCode = GetInfoForWebUtils.getHtmlCode(url, encoding);
        Document document = Jsoup.parse(htmlCode);
        Elements elements = document.getElementsByClass("newlist");
        List<Zhaopin> zhaoPinList = new ArrayList<>();
        for ( Element e : elements) {
            Zhaopin zhaopin = new Zhaopin();
            zhaopin.setZwmc(e.getElementsByClass("zwmc").text());
            zhaopin.setGsmc(e.getElementsByClass("gsmc").text());
            zhaopin.setZwyx(e.getElementsByClass("zwyx").text());
            zhaopin.setGzdd(e.getElementsByClass("gzdd").text());
            zhaopin.setGxsj(e.getElementsByClass("gxsj").text());
            zhaoPinList.add(zhaopin);
        }
        return zhaoPinList;
    }

    /**
     * 解析网页信息 获取招聘职位的数量信息
     * @param url
     * @param encoding
     * @return
     */
    public static Integer zhaoPinNum(String url,String encoding){
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        String htmlCode = GetInfoForWebUtils.getHtmlCode(url, encoding);
        Document document = Jsoup.parse(htmlCode);
        Element element = document.getElementsByClass("search_yx_tj").last();
        Matcher m = p.matcher(element.text());
        String str =  m.replaceAll("").trim();
        Integer num = Integer.parseInt(str);
        return  num;
    }
}
