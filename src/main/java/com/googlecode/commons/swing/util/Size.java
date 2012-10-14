package com.googlecode.commons.swing.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class Size {

    public enum Unit {
        PIXEL,
        PERCENT;
    }
    
    protected double value;
    protected Unit unit;
    
    public Size(double value, Unit unit) {
        super();
        this.value = value;
        this.unit = unit;
    }
    
    public Size(String size) {
        super();

        if (StringUtils.endsWithIgnoreCase(size, "%")) {
            unit = Unit.PERCENT;
        } else {
            unit = Unit.PIXEL;
        }
        
        size = size.toLowerCase();
        size = size.replace("%", "");
        size = size.replace("px", "");
        value = NumberUtils.toDouble(size);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    
    
    
    
}
