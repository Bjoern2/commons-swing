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
import java.util.List;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DateUtils;

import com.googlecode.commons.swing.resources.DefaultIcons;
import com.googlecode.commons.swing.util.DateUtils2;
import com.googlecode.commons.swing.util.SizeUtils;

public class MiniDateCalendar extends JPanel {

	private static final long serialVersionUID = -4119475468102494329L;

	private Locale locale = Locale.getDefault();
    
    private JPanel panNorth;
    private JButton btnPrev;
    private JLabel lblMonth;
    private JButton btnNext;

    private JPanel panCenter;
    private int weekDayStart = Calendar.SUNDAY;
    private final List<Integer> orderedWeekdays = new ArrayList<Integer>();
    private List<String> weekdays = new ArrayList<String>();
    private List<DayButton> days = new ArrayList<DayButton>();

    private Date value = new Date();

    public MiniDateCalendar() {
        this(Locale.getDefault());
    }
    
    public MiniDateCalendar(Locale locale) {
        super();
        this.locale = Validate.notNull(locale);
        weekDayStart = Calendar.getInstance(locale).getFirstDayOfWeek();
        init();
    }
    
    private void init() {
        final DateFormatSymbols dfs = new DateFormatSymbols(locale);
        CollectionUtils.addAll(this.weekdays, dfs.getShortWeekdays());
        
        for (int i = 0; i < 7; i++) {
			orderedWeekdays.add(((i + weekDayStart - 1) % 7) + 1 );
        }
    	
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



        for (int col = 0; col < 7; col++) {
            JLabel lblDay = new JLabel(weekdays.get(orderedWeekdays.get(col)));
            lblDay.setHorizontalAlignment(SwingConstants.CENTER);
            panCenter.add(lblDay);
        }

        ButtonGroup grp = new ButtonGroup();
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
            	final int day = orderedWeekdays.get(col);
                final DayButton btn = createDayButton(day, weekdays.get(day));
                btn.setMargin(new Insets(0, 0, 0, 0));
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

        final NumberFormat nfDay = new DecimalFormat("00");
        final SimpleDateFormat formatMonth = new SimpleDateFormat("MM.yyyy");
        lblMonth.setText(formatMonth.format(getValue()));

        for (DayButton btn : days) {
            btn.setText("");
            btn.setEnabled(false);
            btn.setValue(null);
            btn.setSelected(false);
        }
        
        int startWeekday = DateUtils2.getWeekNumber(startOfMonth);
        for (int i = 0; i < daysOfMonth; i++) {
            DayButton btn = days.get(i + orderedWeekdays.indexOf(startWeekday));
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

    protected DayButton createDayButton(int weekNumber, String weekdayName) {
    	DayButton btn = new DayButton();
    	return btn;
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
