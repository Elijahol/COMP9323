package com.vport.system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.omg.PortableServer.ServantActivator;

public class DateUtil {
    
    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final int DAYS_OF_ONE_WEEK = 7;
    private static Map<Long, String> dayOfWeek;
    static{
        dayOfWeek= new HashMap<Long,String>();
        dayOfWeek.put(1L, "Monday");
        dayOfWeek.put(2L, "Tuesday");
        dayOfWeek.put(3L, "Wednesday");
        dayOfWeek.put(4L, "Thursday");
        dayOfWeek.put(5L, "Friday");
        dayOfWeek.put(6L, "Saturday");
        dayOfWeek.put(0L, "Sunday");
    }
    
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
     * 查找当前日期是一周中的第几天，星期几
     */
    public static String getWeekDay(Date today){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        //1=Sunday,2=Monday...7=Saturday
        Integer k = (calendar.get(Calendar.DAY_OF_WEEK)-1);
        return dayOfWeek.get(k.longValue());
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
    /**
     * 计算距离baseDate 若干天的 日期
     * days=2 表示2天后
     * days=-1 一天前
     *
     * @param baseDate 日期 null 表示当前日期
     * @param days     日期
     * @return
     */
    public static Date daysBetweenWeeks(Date baseDate, int days) {
        Calendar c = Calendar.getInstance();
        if (baseDate != null)
            c.setTime(baseDate);
 
        c.add(Calendar.DAY_OF_MONTH, days);
        return c.getTime();
    }

    
    public static Integer getAgeByBirth(Date birthday) {
        Integer age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
           return 0;
        }
    }
    /**
     * 日期转字符串
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
 
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
            return sdf.format(date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return date.toString();
    }
    

    /**
     * 字符串转换为日期类型
     *
     * @param dateString
     * @return
     */
    public static Date stringToDate(String dateString) {
 
        try {
            return TIME_FORMAT.parse(dateString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static Date getFutureDate(Integer dayOfWeek){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int day = calendar.get(Calendar.DAY_OF_WEEK)-1;
        if (dayOfWeek < day) {
            dayOfWeek += DAYS_OF_ONE_WEEK;
        }
        calendar.add(Calendar.DATE, dayOfWeek - day);
        return calendar.getTime();
    }

    
}
