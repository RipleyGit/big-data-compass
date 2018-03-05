package me.seaof.job.service;

import me.seaof.job.vo.City;

import java.util.List;

/**
 * Created by Watter on 2018-02-28
 */
public interface ZhaopinDataService {
    /**
     * 返回十大城市的职位数量信息
     * @return
     */
    List<City> getDataByCity();


    /**
     * 对数据信息进行同步
     * @param cname
     */
    void syncDateByCityName(City c);

}
