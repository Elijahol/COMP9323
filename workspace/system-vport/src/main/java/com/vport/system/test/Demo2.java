/*package com.vport.system.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
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
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import com.vport.system.bean.TimeTableWithWeek;
import com.vport.system.utils.DateUtil;

@SuppressWarnings("all")
public class Demo2 {
    private static class ValueComparator implements Comparator<Map.Entry<String,Integer>>{

        @Override
        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
            // TODO Auto-generated method stub
            return o2.getValue() - o1.getValue();
        }

        
        
    }
    *//**
     * Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, dayofMonth - i);
        return calendar.getTime();
     *//*
    public static void main(String[] args) throws InterruptedException, ParseException, IOException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm EEEE",Locale.ENGLISH);
        System.out.println(sdf.format(date));
        
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