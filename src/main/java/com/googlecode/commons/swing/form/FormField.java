package com.googlecode.commons.swing.form;

import java.awt.Component;

public interface FormField {

    void setLabelText(String text);
    String getLabelText();
    
    void setHintText(String text);
    String getHintText();
    
    void setErrorText(String text);
    String getErrorText();
    
    void setComponent(Component c);
    Component getComponent();
    
}
