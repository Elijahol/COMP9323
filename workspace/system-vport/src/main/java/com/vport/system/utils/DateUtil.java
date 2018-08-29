package com.vport.system.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    
    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
    public static final int DAYS_OF_ONE_WEEK = 7;
    
    /**
     * 查找当前日期是一周中的第几天，星期几
     */
    public static long getWhitchDay(Date today){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        //1=Sunday,2=Monday...7=Saturday
        return calendar.get(Calendar.DAY_OF_WEEK)-1;
    }
    /**
     * 判断日期是否相等 年月日相等就相等
     * @param args
     */
    public static boolean isDateEqualToday(Date day1, Date day2){
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(day1);
        calendar2.setTime(day2);
        return calendar.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) 
                && calendar.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
    }
    

    
}
