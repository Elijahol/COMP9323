/*package com.vport.system.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import com.vport.system.bean.TimeTableWithWeek;
import com.vport.system.utils.DateUtil;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        
        Date date1 = new Date();
        Thread.sleep(1000);
        Date date2 = new Date();
        System.out.println(date1.getTime());
        
    }
    
    
    @Test
    public void test(){
        String pattern = "EEEE dd MMMM yyyy";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern,Locale.ENGLISH);
        String format = sdf.format(date);
        System.out.println(format);
    }
    //获取当前(上，下)周的日期范围如：...,-1上一周，0本周，1下一周...
    private static Map<String, TimeTableWithWeek> getWeekDays(int i) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd");
            // getTimeInterval(sdf);
    
            Calendar calendar1 = Calendar.getInstance();
            // 设置一个星期的第一天，一个星期的第一天是星期日
            calendar1.setFirstDayOfWeek(Calendar.SUNDAY);
            
            // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
            int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
            if (1 == dayOfWeek) {
                    calendar1.add(Calendar.DAY_OF_MONTH, -1);
            }
    
            // 获得当前日期是一个星期的第几天
            int day = calendar1.get(Calendar.DAY_OF_WEEK);
    
            //获取当前日期前（下）x周同星几的日期
            calendar1.add(Calendar.DATE, 7*i);
    
            calendar1.add(Calendar.DATE, calendar1.getFirstDayOfWeek() - day);
    
    
            
            String beginDate = sdf.format(calendar1.getTime());
            calendar1.add(Calendar.DATE, 6);
    
            String endDate = sdf.format(calendar1.getTime());
            Map<String, TimeTableWithWeek> map = new TreeMap<String,TimeTableWithWeek>();
            for (int j = Integer.parseInt(beginDate); j <= Integer.parseInt(endDate); j++) {
                Date dateByWeekday = DateUtil.getDateByWeekday(j);
                String strDate = DateUtil.dateToString(dateByWeekday);
                TimeTableWithWeek timeTableWithWeek = new TimeTableWithWeek();
                timeTableWithWeek.setTime(dateByWeekday);
                timeTableWithWeek.setVisualTime(strDate);
                if (j<10) {
                    map.put("0"+j, timeTableWithWeek);
                }else{
                    map.put(""+j, timeTableWithWeek);
                }
            }
            return map;
    }
    


}
*/