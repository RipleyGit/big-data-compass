package me.seaof.job.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 通过链接爬取网页中的信息
 * Created by Watter on 2018-02-28
 */
public class GetInfoForWebUtils {
    public static String getHtmlCode(String url,String encoding){
        URL uri = null;
        URLConnection urlConnection = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();

        try{
            //建立网络连接
            uri = new URL(url);
            //打开连接
            urlConnection = uri.openConnection();
            //输入流
            inputStream = urlConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream,encoding);
            bufferedReader = new BufferedReader(inputStreamReader);
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null){
                stringBuffer.append(temp + "\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            if(bufferedReader != null){
                try{
                    bufferedReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return stringBuffer.toString();
    }
}
