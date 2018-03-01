package me.seaof.job.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;
/**
 * 将XML转为指定的POJO
 * Created by Watter on 2018-02-28
 */
public class XmlBuilderUtils {

	/**
	 * 将XML转为指定的POJO
	 * @param clazz
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	public static Object xmlStrToOject(Class<?> clazz, String xmlStr) throws Exception {
		Object xmlObject = null;
		Reader reader = null;
		JAXBContext context = JAXBContext.newInstance(clazz);
		
		// XML 转为对象的接口
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		reader = new StringReader(xmlStr);
		xmlObject = unmarshaller.unmarshal(reader);
		
		if (null != reader) {
			reader.close();
		}
		
		return xmlObject;
	}
}