package com.googlecode.commons.swing.component.datetime;

import java.text.DateFormatSymbols;
import java.util.Locale;

import javax.swing.AbstractSpinnerModel;
import javax.swing.SpinnerModel;

import org.apache.commons.lang3.Validate;

public class SpinnerMonthModel extends AbstractSpinnerModel implements SpinnerModel {

    
    protected Locale locale = Locale.getDefault();
    protected DateFormatSymbols dfs = new DateFormatSymbols(locale);
    protected int month = 0;
    
    @Override
    public Object getValue() {
        return dfs.getMonths()[month];
    }
    
    public int getIntValue() {
        return month;
    }

    @Override
    public void setValue(Object value) {
        Validate.isInstanceOf(Number.class, value);
        Number num = (Number)value;
        Validate.inclusiveBetween(0, 11, num.intValue());
        month = num.intValue();
        fireStateChanged();
    }

    @Override
    public Object getNextValue() {
        if (month < 11) {
            month++;
        }
        fireStateChanged();
        return dfs.getMonths()[month];
    }

    @Override
    public Object getPreviousValue() {
        if (month > 0) {
            month--;
        }
        fireStateChanged();
        return dfs.getMonths()[month];
    }

}
