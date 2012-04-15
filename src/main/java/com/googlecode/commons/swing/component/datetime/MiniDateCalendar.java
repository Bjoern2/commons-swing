package com.googlecode.commons.swing.component.datetime;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.googlecode.commons.swing.resources.DefaultIcons;
import com.googlecode.commons.swing.util.DateUtils2;
import com.googlecode.commons.swing.util.SizeUtils;

public class MiniDateCalendar extends JPanel {

    private Locale locale = Locale.getDefault();
    
    private JPanel panNorth;
    private JButton btnPrev;
    private JLabel lblMonth;
    private JButton btnNext;

    private JPanel panCenter;
    private Set<String> weekdays = new HashSet<String>();
    private List<DayButton> days = new ArrayList<DayButton>();

    private Date value = new Date();
    private Date selectedMonth = (Date)value.clone();

    public MiniDateCalendar() {
        super();
        init();
    }
    
    private void init() {
        setLayout(new BorderLayout());
        SizeUtils.setAllWidths(this, 150);
        SizeUtils.setAllHeights(this, 180);
        
        panNorth = new JPanel(new BorderLayout());
        add(panNorth, BorderLayout.NORTH);
        
        btnPrev = new JButton();
        SizeUtils.setAllWidths(btnPrev, 18);
        SizeUtils.setAllHeights(btnPrev, 18);
        btnPrev.setIcon(DefaultIcons.resultset_previous());
        btnPrev.setMargin(new Insets(0, 0, 0, 0));
        btnPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickPrev();
            }
        });
        panNorth.add(btnPrev, BorderLayout.WEST);
        
        lblMonth = new JLabel();
        SizeUtils.setMinHeight(lblMonth, 0);
        SizeUtils.setPreferredHeight(lblMonth, 0);
        lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
        panNorth.add(lblMonth, BorderLayout.CENTER);
        
        btnNext = new JButton();
        btnNext.setIcon(DefaultIcons.resultset_next());
        SizeUtils.setAllWidths(btnNext, 18);
        SizeUtils.setAllHeights(btnNext, 18);
        btnNext.setMargin(new Insets(0, 0, 0, 0));
        btnNext.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickNext();
            }
        });
        panNorth.add(btnNext, BorderLayout.EAST);

        panCenter = new JPanel();
        panCenter.setLayout(new GridLayout(7, 7));
        add(panCenter, BorderLayout.CENTER);

        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        String[] weekdays = dfs.getShortWeekdays();
        CollectionUtils.addAll(this.weekdays, weekdays);

        for (int col = 1; col <= 7; col++) {
            JLabel lblDay = new JLabel(weekdays[col]);
            lblDay.setHorizontalAlignment(SwingConstants.CENTER);
            panCenter.add(lblDay);
        }

        ButtonGroup grp = new ButtonGroup();
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                final DayButton btn = new DayButton();
                btn.setMargin(new Insets(0, 0, 0, 0));
                btn.weekdayName = weekdays[col];
                btn.weekdayNumber = col;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        onClickDay(btn.value);
                    }
                });
                days.add(btn);
                grp.add(btn);
                panCenter.add(btn);
            }
        }
        
        refresh();

    }
    
    protected void onClickDay(Date day) {
        value = day;
        fireActionListener();
    }
    
    protected void onClickNext() {
        value = DateUtils.addMonths(value, 1);
        refresh();
    }
    
    protected void onClickPrev() {
        value = DateUtils.addMonths(value, -1);
        refresh();
    }

    public void refresh() {
        final Date value = getValue();
        final Date startOfMonth = DateUtils2.getStartOfMonth(value);
        final Date endOfMonth = DateUtils2.getEndOfMonth(value);
        final long daysOfMonth = DateUtils.getFragmentInDays(endOfMonth, Calendar.MONTH);
        final long actualDay = DateUtils.getFragmentInDays(value, Calendar.MONTH);

        final NumberFormat nfDay = new DecimalFormat("00");
        final SimpleDateFormat formatMonth = new SimpleDateFormat("MM.yyyy");
        lblMonth.setText(formatMonth.format(getValue()));

//        Date i = (Date)startOfMonth.clone();
//        for (DayButton btn : days) {
//            if (DateUtils2.getWeekNumber(i))
//        }
        
        
        for (DayButton btn : days) {
            btn.setText("");
            btn.setEnabled(false);
//            btn.setBorder(new LineBorder());
            btn.value = null;
            btn.setSelected(false);
        }
        
        int startWeekday = DateUtils2.getWeekNumber(startOfMonth);
        for (int i = 0; i < daysOfMonth; i++) {
            DayButton btn = days.get(i + startWeekday - 1);
            btn.setText(nfDay.format(i + 1));
            btn.value = DateUtils.setDays(startOfMonth, i + 1);
            btn.setEnabled(true);
            if (DateUtils.isSameDay(btn.value, this.value)) {
            	btn.setSelected(true);
            }
        }

    }

    public Date getValue() {
        if (value == null) {
            value = new Date();
        }
        return value;
    }
    
    public void setValue(Date value) {
    	this.value = value;
    	refresh();
    }

    
    public class DayButton extends JToggleButton {

        private static final long serialVersionUID = -6099662047444463605L;
        
        protected int weekdayNumber;
        protected String weekdayName;
        protected Date value;
        
    }
    
    public void addActionListener(ActionListener l) {
        listenerList.add(ActionListener.class, l);
    }
    
    public void removeActionListener(ActionListener l) {
        listenerList.remove(ActionListener.class, l);
    }
    
    protected void fireActionListener() {
        ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
        for (ActionListener l : listeners) {
            l.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
        }
    }

}
