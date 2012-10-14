package com.googlecode.commons.swing.component.datetime;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class DateSpinner extends JSpinner {

    private static final long serialVersionUID = 7743669607171898565L;

    public DateSpinner() {
        super(new SpinnerDateModel());
    }
    
}
