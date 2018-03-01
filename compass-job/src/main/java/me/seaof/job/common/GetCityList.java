package me.seaof.job.common;

import me.seaof.job.util.XmlBuilderUtils;
import me.seaof.job.vo.City;
import me.seaof.job.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Watter on 2018-02-28
 */
public class GetCityList {
    public static List<City> listCity() throws Exception {
        // 读取XML文件
        Resource resource = new ClassPathResource("citylists.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = br.readLine()) !=null) {
            buffer.append(line);
        }

        br.close();

        // XML转为Java对象
        CityList cityList = (CityList) XmlBuilderUtils.xmlStrToOject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}
