package com.googlecode.commons.swing.component.datetime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JPopupMenu;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class JDateTimeField extends JFormattedTextField {

    private static final long serialVersionUID = 1787915955297704574L;

    private JPopupMenu popup;
    private MiniDateCalendar calendar;

    public JDateTimeField() {
        super(new SimpleDateFormat("dd.MM.yyyy"));
        
        popup = new JPopupMenu();
        popup.setFocusable(false);
        calendar = new MiniDateCalendar();
        calendar.setFocusable(false);
        calendar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDateTimeField.this.setValue(calendar.getValue());
			}
		});
        popup.add(calendar);
        
        addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				onFocus();
			}
		});
        addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					popup.setVisible(false);
				} else {
					onFocus();
				}
			}
		});
        
        addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				onFocus();				
			}
		});

    }
    
    protected void onFocus() {
    	if (this.isShowing()) {
			popup.show(JDateTimeField.this, 0, 18);
			JDateTimeField.this.requestFocus();
    	}
    }

	@Override
	public void commitEdit() throws ParseException {
		super.commitEdit();
		
		if (isValid()) {
			calendar.setValue((Date)getValue());
		}
	}


}
