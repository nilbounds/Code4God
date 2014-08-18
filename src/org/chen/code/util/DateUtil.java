package org.chen.code.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 工具类，处理日期相关
 * @author 中普
 * @version 1.3
 * @see Calendar
 *
 */
public class DateUtil {

	/**
	 * 根据当前时间获取问题的ID
	 * @return 问题的ID
	 * @throws ParseException 
	 */
	public static int getProblemId() throws ParseException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
        long from = df.parse(CodeConstans.START_DATE).getTime();
		
		long to = df.parse(year+"-"+month+"-"+day).getTime();
		
		int sub = (int) ((to - from) / (1000 * 60 * 60 * 24));
		
		return sub + CodeConstans.START_ID;
	}
}
