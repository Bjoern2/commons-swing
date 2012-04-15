package com.googlecode.commons.swing.util;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public final class DateUtils2 {

    public static Date getStartOfMonth(Date month) {
        if (month == null) {
            return null;
        }
        Date start = (Date)month.clone();
        start = DateUtils.truncate(start, Calendar.MONTH);
        return start;
    }
    
    public static Date getEndOfMonth(Date month) {
        if (month == null) {
            return null;
        }
        Date end = (Date)month.clone();
        end = DateUtils.truncate(end, Calendar.MONTH);
        end = DateUtils.addMonths(end, 1);
        end = DateUtils.addMilliseconds(end, -1);
        return end;
    }
    
    public static String getShortWeekday(Date d) {
        return DateFormatUtils.format(d, "EEE");
    }
    
    public static int getWeekNumber(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal.get(Calendar.DAY_OF_WEEK);
    }
    
}
