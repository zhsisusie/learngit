/**
 * Filename: TimeUtil.java
 * Project Name: kanion
 * @author: cyz	63954008(at)qq.com
 * @version: 1.0
 * @since: JDK 1.7.0_45
 * Copyright © 2014 CCNT. All Rights Reserved
 * Create at: 2014-10-12  下午10:29:28
 * Description:时间处理相关的通用方法。
 *
 * Modification History:
 * Date			Author		Version		Description
 * ------------------------------------------------------------------
 * 2014-10-12	cyz    		1.0			1.0 Version
 */
package com.kanion.www.util;

public class TimeUtil {

	//将时间字符串转换为小时
	public static double changeToHour(String timeString) {
		timeString = timeString.replace("小时", ",");
		timeString = timeString.replace("分钟", ",");
		String[] time = null;
		time = timeString.split(",");
		int hour=0,minute=0;
		for(int i=0;i<time.length;i++){
			if(0==i) hour += Integer.valueOf(time[i]);
			if(1==i) minute += Integer.valueOf(time[i]);
		}
		double result=ArithUtil.add(hour, ArithUtil.div(minute, 60.0));
		return result;
	}
	
	//将小时形式转换为“XX小时XX分钟”
	public static String minutesToString(double hours){
		//System.out.print("转换"+hours+"小时为字符串形式：");
		long longMinutes=(long)ArithUtil.round(ArithUtil.mul(hours, 60.0),0);
		long hour=longMinutes/60;
		long minute=longMinutes%60;
		String result=hour+"小时"+minute+"分钟";
		return result;
	}
	
	//时间除法
	public static String div(String timeString,double n){
		double hours=changeToHour(timeString);
		return minutesToString(ArithUtil.div(hours, n));
	}
}
