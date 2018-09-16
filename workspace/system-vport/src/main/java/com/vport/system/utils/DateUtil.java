package com.vport.system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.omg.PortableServer.ServantActivator;

import com.vport.system.bean.TimeTableWithWeek;

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
    
    /**
     * 得到本周某天对应的date
     * @param dayOfWeek
     * @return
     */
    public static Date getDateByWeekday(Integer dayOfWeek){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int day = calendar.get(Calendar.DAY_OF_WEEK)-1;
        /*if (dayOfWeek < day) {
            dayOfWeek += DAYS_OF_ONE_WEEK;
        }*/
        calendar.add(Calendar.DATE, dayOfWeek - day);
        return calendar.getTime();
    }
    public static Date getDateByMonthDay(Integer dayofMonth){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, dayofMonth - i);
        return calendar.getTime();
    }
  //获取当前(上，下)周的日期范围如：...,-1上一周，0本周，1下一周...
    public static Map<String, Object> getWeekDays(int i) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd");
            // getTimeInterval(sdf);
    
            Calendar calendar1 = Calendar.getInstance();
            // 设置一个星期的第一天，一个星期的第一天是星期日
            calendar1.setFirstDayOfWeek(Calendar.SUNDAY);
            
            // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
            int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
            /*if (1 == dayOfWeek) {
                    calendar1.add(Calendar.DAY_OF_MONTH, -1);
            }*/
    
            // 获得当前日期是一个星期的第几天
            int day = calendar1.get(Calendar.DAY_OF_WEEK);
    
            //获取当前日期前（下）x周同星几的日期
            calendar1.add(Calendar.DATE, 7*i);
    
            calendar1.add(Calendar.DATE, calendar1.getFirstDayOfWeek() - day);
    
    
            
            String beginDate = sdf.format(calendar1.getTime());
            calendar1.add(Calendar.DATE, 6);
    
            String endDate = sdf.format(calendar1.getTime());
            Map<String, Object> map = new TreeMap<String,Object>();
            for (int j = Integer.parseInt(beginDate); j <= Integer.parseInt(endDate); j++) {
                Date dateByWeekday = DateUtil.getDateByMonthDay(j);
                TimeTableWithWeek timeTableWithWeek = new TimeTableWithWeek();
                timeTableWithWeek.setTime(dateByWeekday);
                if (j<10) {
                    map.put("0"+j, timeTableWithWeek);
                }else{
                    map.put(""+j, timeTableWithWeek);
                }
            }
            return map;
    }
    
    public static String getDayOfMonth(Date time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        return calendar.get(Calendar.DAY_OF_MONTH)+"";
    }
    
}
