package com.googlecode.commons.swing.component.datetime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.JPopupMenu;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class JDateTimeField extends JFormattedTextField {

    private static final long serialVersionUID = 1787915955297704574L;

//    private JButton arrowButton;
    
    private JPopupMenu popup;
    private MiniDateCalendar calendar;

    public JDateTimeField() {
        super(new SimpleDateFormat("dd.MM.yyyy"));
//
//        setLayout(new MyLayoutManager());
//        arrowButton = new BasicArrowButton(BasicArrowButton.SOUTH, UIManager.getColor("ComboBox.buttonBackground"), UIManager.getColor("ComboBox.buttonShadow"), UIManager.getColor("ComboBox.buttonDarkShadow"), UIManager.getColor("ComboBox.buttonHighlight"));
//        arrowButton.setName("ComboBox.arrowButton");
//        add(arrowButton);
        
        popup = new JPopupMenu();
        popup.setFocusable(false);
        calendar = new MiniDateCalendar();
        calendar.setFocusable(false);
        calendar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//popup.setVisible(false);
				JDateTimeField.this.setValue(calendar.getValue());
			}
		});
        popup.add(calendar);
        
        addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				onFocus();
			}
		});
        addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
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
		popup.show(JDateTimeField.this, 0, 18);
		JDateTimeField.this.requestFocus();
    }

	@Override
	public void commitEdit() throws ParseException {
		// TODO Auto-generated method stub
		super.commitEdit();
		
		if (isValid()) {
			calendar.setValue((Date)getValue());
		}
	}


}
