/**
 * Copyright 2012 Björn Schmitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
    
    public static int getDaysOfMonth(Date date) {
        Date endOfMonth = getEndOfMonth(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(endOfMonth);
        return cal.get(Calendar.DAY_OF_MONTH);
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
