package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrtech.action.app.issue.HouseWebJhAction;

public class test {
	
	private static final Log logger = LogFactory.getLog(HouseWebJhAction.class.getName());  
    @SuppressWarnings("unused")
	private final static int CONNECT_TIMEOUT = 5000; // in milliseconds  
    private final static String DEFAULT_ENCODING = "UTF-8";  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                  String t="C:\\apache-tomcat-6.0.39\\webapps\\rerp\\file\\ImportResult1543827646945.log";
                  
                  
                  System.out.println(t.substring(t.indexOf("\\rerp"),t.length()));
     
	}
	public static String addZeroForNum(String str,int strLength) {  
		  int strLen =str.length();  
		  if (strLen <strLength) {  
		   while (strLen< strLength) {  
		    StringBuffer sb = new StringBuffer();  
		    sb.append("0").append(str);//左补0  
//		    sb.append(str).append("0");//右补0  
		    str= sb.toString();  
		    strLen= str.length();  
		   }  
		  }  

		  return str;  
		 }  
    public static String postData(String urlStr, String data, String contentType){  
        BufferedReader reader = null;  
        try {  
            URL url = new URL(urlStr);  
            URLConnection conn = url.openConnection();  
            conn.setDoOutput(true);  
            conn.setConnectTimeout(300000);  
            conn.setReadTimeout(300000);  
            if(contentType != null)  
                conn.setRequestProperty("content-type", contentType);  
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), DEFAULT_ENCODING);  
            if(data == null)  
                data = "";  
            writer.write(data);   
            writer.flush();  
            writer.close();    
  
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), DEFAULT_ENCODING));  
            StringBuilder sb = new StringBuilder();  
            String line = null;  
            while ((line = reader.readLine()) != null) {  
                sb.append(line);  
                //sb.append("\r\n");  
            }  
            return sb.toString();  
        } catch (Exception e) {  
            System.out.println(new Date().toString()+"**********请求微信错误!"+"Error connecting to " + urlStr + ": " + e.getMessage());
        } finally {  
            try {  
                if (reader != null)  
                    reader.close();  
            } catch (IOException e) {  
            }  
        }  
        return null;  
    }  
	
	
}
