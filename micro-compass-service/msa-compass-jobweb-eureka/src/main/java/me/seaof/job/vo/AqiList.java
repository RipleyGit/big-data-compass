package me.seaof.job.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Watter on 2018-03-05
 */
public class AqiList implements Serializable{

    private static final long serialVersionUID = 1L;

    private List<Aqi> aqiList;

    public List<Aqi> getAqiList() {
        return aqiList;
    }

    public void setAqiList(List<Aqi> aqiList) {
        this.aqiList = aqiList;
    }
}
