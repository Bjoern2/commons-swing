package com.googlecode.commons.swing.component.datetime;

import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SpinnerNumberModel;

import org.apache.commons.lang3.time.DateUtils;

import com.googlecode.commons.swing.util.DateUtils2;

public class DateMultiSpinner extends JComponent {

    private static final long serialVersionUID = -1182369340447643945L;

    private JSpinner day;
    private SpinnerNumberModel dayModel;
    private JSpinner month;
    private SpinnerMonthModel monthModel;
    private JSpinner year;
    private SpinnerNumberModel yearModel;
    
    public DateMultiSpinner() {
        super();
        init();
    }
    
    protected void init() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        dayModel = new SpinnerNumberModel(1, 1, 31, 1);
        day = new JSpinner(dayModel);
        add(day);
        
        monthModel = new SpinnerMonthModel();
        month = new JSpinner(monthModel);
        month.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                monthOrYearChanged();
            }
        });
        add(month);
        
        yearModel = new SpinnerNumberModel(1970, null, null, 1);
        year = new JSpinner(yearModel);
        year.setEditor(new NumberEditor(year, "0000"));
        year.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                monthOrYearChanged();
            }
        });
        add(year);
        
        setValue(new Date());
    }
    
    public void setValue(Date value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(value);
        
        int daysOfMonth = DateUtils2.getDaysOfMonth(value);
        dayModel.setMaximum(daysOfMonth);
        
        dayModel.setValue(cal.get(Calendar.DATE));
        monthModel.setValue(cal.get(Calendar.MONTH));
        yearModel.setValue(cal.get(Calendar.YEAR));
    }
    
    public Date getValue() {
        Date value = new Date();
        value = DateUtils.setYears(value, (Integer)yearModel.getValue());
        value = DateUtils.setMonths(value, monthModel.getIntValue());
        value = DateUtils.setDays(value, (Integer)dayModel.getValue());
        value = DateUtils.setHours(value, 0);
        value = DateUtils.setMinutes(value, 0);
        value = DateUtils.setSeconds(value, 0);
        value = DateUtils.setMilliseconds(value, 0);
        return value;
        
    }
    
    protected void monthOrYearChanged() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, (Integer)yearModel.getValue());
        cal.set(Calendar.MONTH, monthModel.getIntValue());
        final int daysInMonth = DateUtils2.getDaysOfMonth(cal.getTime());
        final int days = (Integer)dayModel.getValue();
        dayModel.setMaximum(daysInMonth);
        if (daysInMonth < days) {
            dayModel.setValue(daysInMonth);
        }

    }

}
