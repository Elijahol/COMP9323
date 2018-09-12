package com.vport.system.bean;
/**
 * 存储一天中的课程信息
 * @author Administrator
 *
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TimeTableWithWeek {
    private final String FORMAT = "EEEE dd MMMM yyyy";
    private String visualTime;
    private Date time;
    private List<TimeTable> timeTables = new ArrayList<>();
    public String getVisualTime() {
        return visualTime;
    }
    public void setVisualTime(String visualTime) {
        this.visualTime = visualTime;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT,Locale.ENGLISH);
        this.visualTime = sdf.format(time);
        this.time = time;
    }
    public List<TimeTable> getTimeTables() {
        return timeTables;
    }
    public void setTimeTables(List<TimeTable> timeTables) {
        this.timeTables = timeTables;
    }
    @Override
    public String toString() {
        return "TimeTableWithWeek [visualTime=" + visualTime + ", time=" + time + ", timeTables=" + timeTables
                + "]";
    }
    
    
}
