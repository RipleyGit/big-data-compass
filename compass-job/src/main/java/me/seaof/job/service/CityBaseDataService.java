package me.seaof.job.service;

import me.seaof.job.vo.City;

import java.util.List;

/**
 * 城市基础信息
 * Created by Watter on 2018-03-05
 */
public interface CityBaseDataService {

    /**
     * 获取City列表
     * @return
     */
    List<City> cityList();
}
