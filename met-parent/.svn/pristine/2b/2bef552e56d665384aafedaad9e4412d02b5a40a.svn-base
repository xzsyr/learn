/**
 * 
 */
package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @Project MeWeb
* @Copyright © 2008-2014 SPRO Technology Consulting Limited. All rights reserved.
* @fileName com.mw.framework.util.SerialNumberUtils.java
* @Version 1.0.0
* @author Allan Ai
* @time 2014-7-22
*
*/
public class SerialNumberUtils {
	
	/** 
     * 获取现在时间 
     * @return返回字符串格式yyyyMMddHHmmss 
     */  
      public static String getStringDate() {  
             Date currentTime = new Date();  
             SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
             String dateString = formatter.format(currentTime);  
             System.out.println("TIME:::"+dateString);  
             return dateString;  
          }  
      /** 
       * 由年月日时分秒+3位随机数 
       * 生成流水号 
       * @return 
       */  
      public static String Getnum(){  
          String t = getStringDate();  
          int x=(int)(Math.random()*900)+100;  
          String serial = t + x;  
          return serial;  
      }  
        
      //主方法测试  
    public static void main(String[] args) {  
        String m= Getnum();  
        System.out.println(m);  
    } 
}
