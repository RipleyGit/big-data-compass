package me.seaof.job.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 城市信息
 *
 * Created by Watter on 2018-02-28
 */
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
	@XmlAttribute(name = "cname")
	private String cname;
	
	@XmlAttribute(name = "value")
	private Integer val;

	@XmlAttribute(name = "geo")
	private String geos;

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public String getGeos() {
		return geos;
	}

	public void setGeos(String geos) {
		this.geos = geos;
	}
}
