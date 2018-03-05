package me.seaof.job.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Watter on 2018-03-05
 */
public class Aqi {
    @JsonIgnore
    private Integer aqi;    //29
    @JsonIgnore
    private String area;    //"大庆"
    @JsonIgnore
    private String position_name;    //"大同区"
    @JsonIgnore
    private String primary_pollutant;    //null
    @JsonIgnore
    private String quality;         //"优"
    @JsonIgnore
    private String station_code;    //"1789A"
    @JsonIgnore
    private String time_point;    //"2018-03-05T07:00:00Z"

    public Integer getAqi() {
        return aqi;
    }

    public void setAqi(Integer aqi) {
        this.aqi = aqi;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getPrimary_pollutant() {
        return primary_pollutant;
    }

    public void setPrimary_pollutant(String primary_pollutant) {
        this.primary_pollutant = primary_pollutant;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getStation_code() {
        return station_code;
    }

    public void setStation_code(String station_code) {
        this.station_code = station_code;
    }

    public String getTime_point() {
        return time_point;
    }

    public void setTime_point(String time_point) {
        this.time_point = time_point;
    }
}
