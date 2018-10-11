package com.vport.system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.omg.PortableServer.ServantActivator;

import com.vport.system.bean.TimeTableWithWeek;

public class DateUtil {
    
    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final int DAYS_OF_ONE_WEEK = 7;
    public static final String YMD = "yyyyMMdd";
    public static final String YMD_YEAR = "yyyy";
    public static final String YMD_BREAK = "yyyy-MM-dd";
    public static final String YMDHMS = "yyyyMMddHHmmss";
    public static final String YMDHMS_BREAK = "yyyy-MM-dd HH:mm:ss";
    public static final String YMDHMS_BREAK_HALF = "yyyy-MM-dd HH:mm";

    /**
    * 计算时间差
    */
    public static final int CAL_MINUTES = 1000 * 60;
    public static final int CAL_HOURS = 1000 * 60 * 60;
    public static final int CAL_DAYS = 1000 * 60 * 60 * 24;
    public static Map<Long, String> dayOfWeek;
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
    private static SimpleDateFormat getSimpleDateFormat(String pattern){
        return new SimpleDateFormat(pattern);
    }
    /**
    * 获取时间戳
    * @param date
    * @return
    */
    public static Long getTime(Date date){
    return date.getTime();
    }
    /**
    * 计算时间差
    * @param startDate
    * @param endDate
    * @param calType 计算类型,按分钟、小时、天数计算
    * @return
    */
    public static int calDiffs(Date startDate, Date endDate, int calType){
    Long start = DateUtil.getTime(startDate);
    Long end = DateUtil.getTime(endDate);
    int diff = (int) ((end - start)/calType);
    return diff;
    }
    
    /**
    * 获取日期格式化后的值
    * 
    * @param date
    * @param pattern
    * @return
    */
    public static String getDateText(Date date, String pattern){
    SimpleDateFormat sdf = getSimpleDateFormat(pattern);
    return sdf.format(date);
    }
    /**
    * 计算时间差值以某种约定形式显示
    * 
    * @param startDate
    * @param endDate
    * @return
    */
    public static String timeDiffText(Date startDate, Date endDate){
    int calDiffs = DateUtil.calDiffs(startDate, endDate, DateUtil.CAL_MINUTES);
    if(calDiffs == 0){
    return "just now";
    }
    if(calDiffs < 60){
    return calDiffs + " mins ago";
    }
    calDiffs = DateUtil.calDiffs(startDate, endDate, DateUtil.CAL_HOURS);
    if(calDiffs < 24){
        if(calDiffs > 2)
            return calDiffs + " hours ago";
        else
            return calDiffs + " hour ago";
    }
    if(calDiffs < 48){
    return "yesterday";
    }
    return DateUtil.getDateText(startDate, DateUtil.YMDHMS_BREAK_HALF);
    }

    /**
    * 显示某种约定后的时间值,类似微信朋友圈发布说说显示的时间那种
    * 
    * @param date
    * @return
    */
    public static String showTimeText(Date date){
    return DateUtil.timeDiffText(date, new Date());
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
    public static Date getDateByMonthDay(Integer dayofMonth,Integer lastMonthMaxDay){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, dayofMonth - i - lastMonthMaxDay);
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
            int lastMothday = calendar1.getActualMaximum(Calendar.DAY_OF_MONTH);
            calendar1.add(Calendar.DATE, 6);
            int nowMonthDay = calendar1.getActualMaximum(Calendar.DAY_OF_MONTH);
            int tar = Integer.parseInt(beginDate);
            
            
            String endDate = sdf.format(calendar1.getTime());
            List<Integer> days = new ArrayList<>();
            System.out.println("beginDate: " + beginDate);
            System.out.println("endDate: " + endDate);
            int index = 0;
            int tarIndex = -1;
            while(tar != Integer.parseInt(endDate)){
                if (tar > lastMothday) {
                    tar = 1;
                    tarIndex = index-1;
                }
                days.add(tar);
                tar ++;
                index ++;
                
            }
            days.add(tar);
            Map<String, Object> map = new TreeMap<String,Object>();
            for(int k = 0; k < days.size();k++){
                Date dateByWeekday = null;
                if (tarIndex >=0 && k<=tarIndex) {
                    dateByWeekday  = DateUtil.getDateByMonthDay(days.get(k),lastMothday);
                }else{
                    dateByWeekday = DateUtil.getDateByMonthDay(days.get(k),0);
                }
                TimeTableWithWeek timeTableWithWeek = new TimeTableWithWeek();
                timeTableWithWeek.setTime(dateByWeekday);
                if (days.get(k)<10) {
                    map.put("0"+days.get(k), timeTableWithWeek);
                }else{
                    map.put(""+days.get(k), timeTableWithWeek);
                }
            }
           /* for (Integer eachDay : days) {
                Date dateByWeekday = DateUtil.getDateByMonthDay(eachDay);
                TimeTableWithWeek timeTableWithWeek = new TimeTableWithWeek();
                timeTableWithWeek.setTime(dateByWeekday);
                if (eachDay<10) {
                    map.put("0"+eachDay, timeTableWithWeek);
                }else{
                    map.put(""+eachDay, timeTableWithWeek);
                }
            }*/
            return map;
    }
    
    public static String getDayOfMonth(Date time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        return calendar.get(Calendar.DAY_OF_MONTH) >= 10 ? calendar.get(Calendar.DAY_OF_MONTH)+"":"0"+calendar.get(Calendar.DAY_OF_MONTH);
    }
    
}
