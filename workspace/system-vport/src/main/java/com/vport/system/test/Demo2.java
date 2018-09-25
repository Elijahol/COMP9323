/*package com.vport.system.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import com.vport.system.bean.TimeTableWithWeek;
import com.vport.system.utils.DateUtil;

public class Demo2 {
    private static class ValueComparator implements Comparator<Map.Entry<String,Integer>>{

        @Override
        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
            // TODO Auto-generated method stub
            return o2.getValue() - o1.getValue();
        }

        
        
    }
    public static void main(String[] args) throws InterruptedException, ParseException {
       SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
       String hour = "15:00";
       String hour2 = "9:00";
       Date date = sdf.parse(hour);
       Date date2 = sdf.parse(hour2);
       System.out.println(date);
       System.out.println(date2);
       System.out.println(date2.compareTo(date));
        
    }
    
    
    @Test
    public void test(){
        String pattern = "EEEE dd MMMM yyyy";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern,Locale.ENGLISH);
        String format = sdf.format(date);
        System.out.println(format);
    }
    
    


}
*/