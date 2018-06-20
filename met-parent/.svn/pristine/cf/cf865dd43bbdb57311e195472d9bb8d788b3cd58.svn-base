package com.example.demo.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Title: DateUtils.java Description: 日期工具类
 * 
 * @author jizhuang.wang
 * @created 2017年6月5日 下午5:18:51
 */
public class DateUtils {

	/** 年-月-日 时:分:秒 显示格式 */
	// 备注:如果使用大写HH标识使用24小时显示格式,如果使用小写hh就表示使用12小时制格式。
	public static String DATE_TO_STRING_DETAIAL_PATTERN = "yyyyMMddHHmmss";
	public static String DATE_TO_STRING_DEFAULT_PATTERN = "yyyyMMdd";

	/** 年-月-日 显示格式 */
	public static String DATE_TO_STRING_SHORT_PATTERN = "yyyy-MM-dd";
	/** 年月日 显示格式 */
	private static SimpleDateFormat simpleDateFormat;

	/**
	 * Date类型转为指定格式的String类型
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static String DateToString(Date source, String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(source);
	}

	/**
	 * 
	 * unix时间戳转为指定格式的String类型
	 * 
	 * 
	 * System.currentTimeMillis()获得的是是从1970年1月1日开始所经过的毫秒数
	 * unix时间戳:是从1970年1月1日（UTC/GMT的午夜）开始所经过的秒数,不考虑闰秒
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static String timeStampToString(long source, String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = new Date(source * 1000);
		return simpleDateFormat.format(date);
	}

	/**
	 * 将日期转换为时间戳(unix时间戳,单位秒)
	 * 
	 * @param date
	 * @return
	 */
	public static long dateToTimeStamp(Date date) {
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp.getTime() / 1000;

	}

	/**
	 * 
	 * 字符串转换为对应日期(可能会报错异常)
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static Date stringToDate(String source, String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse(source);
		} catch (Exception e) {
		}
		return date;
	}
	/**
	 * 
	 * 字符串转换为对应日期(可能会报错异常)
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static Date stringToDate(String source) {
		simpleDateFormat = new SimpleDateFormat(DATE_TO_STRING_DETAIAL_PATTERN);
		Date date = null;
		try {
			date = simpleDateFormat.parse(source);
		} catch (Exception e) {
		}
		return date;
	}
	/**
	 * 获得当前时间对应的指定格式
	 * 
	 * @param pattern
	 * @return
	 */
	public static String currentFormatDate(String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(new Date());

	}
	 
	/**
	 * 获得当前unix时间戳(单位秒)
	 * 
	 * @return 当前unix时间戳
	 */
	public static long currentTimeStamp() {
		return System.currentTimeMillis() / 1000;
	}

	  
	/**     
	 * @discription 获取今天（当前）日期
	 * @author jizhuang.wang       
	 * @created 2017年7月24日 下午1:38:19     
	 * @return     
	 */
	public static String getTodayData() {
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		date = calendar.getTime();  
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(date);
		return dateString;
	}

	  
	/**     
	 * @discription 获取昨天日期
	 * @author jizhuang.wang       
	 * @created 2017年7月24日 下午1:38:02     
	 * @return     
	 */
	@SuppressWarnings("static-access")
	public static String getYesterdayData() {
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, -1); 
		date = calendar.getTime();  
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(date);
		return dateString;
	}
	
	
	  
	    /**     
	     * @discription 把一个格式的时间字符串转化成另外一个格式
	     * @author gengyanlong       
	     * @created 2017年7月28日 下午6:05:18     
	     * @return     
	     */
	public static String  stringDateFormat(String typeOld,String typeNew,String dateString){
		
		SimpleDateFormat dateFormatold = new SimpleDateFormat(typeOld);
		SimpleDateFormat dateFormaNew = new SimpleDateFormat(typeNew);
		try {
			Date date = dateFormatold.parse(dateString);
			String dateNew = dateFormaNew.format(date);
			return dateNew;
		} catch (ParseException e) {
			e.printStackTrace();
			
			return null;
		}
		
		
	}
	
	@SuppressWarnings("unused")
	public static Long dateDiff(String startTime, String endTime,     
            String format, String str) {     
        // 按照传入的格式生成一个simpledateformate对象     
        SimpleDateFormat sd = new SimpleDateFormat(format);     
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数     
        long nh = 1000 * 60 * 60;// 一小时的毫秒数     
        long nm = 1000 * 60;// 一分钟的毫秒数     
        long ns = 1000;// 一秒钟的毫秒数     
        long diff;     
        long day = 0;     
        long hour = 0;     
        long min = 0;     
        long sec = 0;     
        // 获得两个时间的毫秒时间差异     
        try {     
            diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();     
            day = diff / nd;// 计算差多少天     
            hour = diff % nd / nh + day * 24;// 计算差多少小时     
            min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟     
            sec = diff % nd % nh % nm / ns;// 计算差多少秒     
            // 输出结果     
           //System.out.println("时间相差：" + day + "天" + (hour - day * 24) + "小时" + (min - day * 24 * 60) + "分钟" + sec + "秒。");     
           // System.out.println("hour=" + hour + ",min=" + min);     
            if (str.equalsIgnoreCase("h")) {     
                return hour;     
            } else {     
                return min+(hour*60);     
            }     
    
        } catch (ParseException e) {     
            // TODO Auto-generated catch block     
            e.printStackTrace();     
        }     
        if (str.equalsIgnoreCase("h")) {     
            return hour;     
        } else {     
            return min+(hour*60);     
        }     
    }  
	
	  
	/**     
	 * @discription 获取指定日期
	 * @author jizhuang.wang       
	 * @created 2017年12月1日 下午1:47:51     
	 * @param source 原始日期
	 * @param pattern 日期格式
	 * @param field field the calendar field.
	 * @param amount the amount of date or time to be added to the field.
	 * @return     
	 */
	public static String getDay(String source,String pattern,int field,int amount){
		 Calendar cal =Calendar.getInstance();
		 cal.setTime(DateUtils.stringToDate(source, pattern));
		 cal.add(field, amount);
		 SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		 return sdf.format(cal.getTime());
	}
	
	@SuppressWarnings("unused")
	public static Long dateDiffForMin(String startTime, String endTime,String format) {   
		  try {
        // 按照传入的格式生成一个simpledateformate对象     
        SimpleDateFormat sd = new SimpleDateFormat(format);     
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数     
        long nh = 1000 * 60 * 60;// 一小时的毫秒数     
        long nm = 1000 * 60;// 一分钟的毫秒数     
        long ns = 1000;// 一秒钟的毫秒数     
        long diff;     
        long day = 0;     
        long hour = 0;     
        long min = 0;     
		long sec = 0;     
        // 获得两个时间的毫秒时间差异     
          
				diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
				 day = diff / nd;// 计算差多少天     
		            hour = diff % nd / nh + day * 24;// 计算差多少小时     
		            min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟     
		            sec = diff % nd % nh % nm / ns;// 计算差多少秒     
		            // 输出结果     
//		           System.out.println("时间相差：" + day + "天" + (hour - day * 24) + "小时"    
//		                     + (min - day * 24 * 60) + "分钟" + sec + "秒。");
		           return day*1440+(hour - day * 24)*60+(min - day * 24 * 60); 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;     
           
		    
           
    } 
	public static void main(String[] args) {
		
		System.out.println(dateDiffForMin("201707150000","201707160021","yyyyMMddHHmm"));
	}

	 
	
	/**
	 * 功能描述：返回小
	 *
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar  calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    return calendar.get(Calendar.HOUR_OF_DAY);
	}
	 
	/**
	 * 功能描述：返回分
	 *
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    return calendar.get(Calendar.MINUTE);
	}

}
