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
/**
 * This is a data tool that provides some method to calculate
 * and format the time
 * @author Siyu Wang
 *
 */
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
    * calculate delta-T
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
    * get the timestamp
    * @param date
    * @return
    */
    public static Long getTime(Date date){
    return date.getTime();
    }
    /**
    * calculate the diff between two times
    * @param startDate
    * @param endDate
    * @param calType 
    * @return
    */
    public static int calDiffs(Date startDate, Date endDate, int calType){
    Long start = DateUtil.getTime(startDate);
    Long end = DateUtil.getTime(endDate);
    int diff = (int) ((end - start)/calType);
    return diff;
    }
    
    /**
    * Format the time with the specific pattern
    * @param date
    * @param pattern
    * @return
    */
    public static String getDateText(Date date, String pattern){
    SimpleDateFormat sdf = getSimpleDateFormat(pattern);
    return sdf.format(date);
    }
    /**
    * Calculate and get the past time in a specific format 
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

    public static String showTimeText(Date date){
    return DateUtil.timeDiffText(date, new Date());
    }
    
    /**
     * find the day of the week according to the date
     */
    public static long getWhitchDay(Date today){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        //1=Sunday,2=Monday...7=Saturday
        return calendar.get(Calendar.DAY_OF_WEEK)-1;
    }
    
    public static String getWeekDay(Date today){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        //1=Sunday,2=Monday...7=Saturday
        Integer k = (calendar.get(Calendar.DAY_OF_WEEK)-1);
        return dayOfWeek.get(k.longValue());
    }
   
    public static boolean isDateEqualToday(Date day1, Date day2){
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(day1);
        calendar2.setTime(day2);
        return calendar.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) 
                && calendar.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
    }
    
    public static Date daysBetweenWeeks(Date baseDate, int days) {
        Calendar c = Calendar.getInstance();
        if (baseDate != null)
            c.setTime(baseDate);
 
        c.add(Calendar.DAY_OF_MONTH, days);
        return c.getTime();
    }

    /**
     * Calculate the age according to the birthday
     * @param birthday
     * @return
     */
    public static Integer getAgeByBirth(Date birthday) {
        Integer age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {
           return 0;
        }
    }
   
    public static String dateToString(Date date) {
 
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
            return sdf.format(date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return date.toString();
    }
    

    public static Date stringToDate(String dateString) {
 
        try {
            return TIME_FORMAT.parse(dateString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
   
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
    
    /**
     * Calculate the days of the current week i==0
     * Calculate the days of the last week i==-1
     * Calculate the days of the next week i==1
     * @param i
     * @return
     */
    public static Map<String, Object> getWeekDays(int i) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd");
    
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setFirstDayOfWeek(Calendar.SUNDAY);
            
            int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK);
            /*if (1 == dayOfWeek) {
                    calendar1.add(Calendar.DAY_OF_MONTH, -1);
            }*/
    
            
            int day = calendar1.get(Calendar.DAY_OF_WEEK);
    
            
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
