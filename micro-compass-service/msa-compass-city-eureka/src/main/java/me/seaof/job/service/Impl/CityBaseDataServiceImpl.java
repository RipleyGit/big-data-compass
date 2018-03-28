package me.seaof.job.service.Impl;

import me.seaof.job.service.CityBaseDataService;
import me.seaof.job.util.XmlBuilderUtils;
import me.seaof.job.vo.City;
import me.seaof.job.vo.CityList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Watter on 2018-03-05
 */
@Service
public class CityBaseDataServiceImpl implements CityBaseDataService {

    private final static Logger logger = LoggerFactory.getLogger(CityBaseDataServiceImpl.class);

    @Override
    public List<City> cityList() {
        CityList cityList = null;
        // 读取XML文件
        try{
            logger.info("read xml file");
            Resource resource = new ClassPathResource("citylists.xml");
            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) !=null) {
                buffer.append(line);
            }
            br.close();
            // XML转为Java对象
            cityList = (CityList) XmlBuilderUtils.xmlStrToOject(CityList.class, buffer.toString());
        }catch (Exception e){
            logger.info("read xml file failed!");
            e.printStackTrace();
        }
        return cityList.getCityList();
    }
}
