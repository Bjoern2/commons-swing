package com.googlecode.commons.swing.form;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.googlecode.commons.swing.layout.GridBagFactory;
import com.googlecode.commons.swing.layout.GridBagFactory.Fill;
import com.googlecode.commons.swing.util.SizeUtils;

public class FormFieldBox extends JComponent {

    private JLabel label;
    private Box center;
    private JLabel hint;
    
    public FormFieldBox(String labelText, Component component, String hintText) {
        this(labelText, Arrays.asList(component), hintText);
    }
    
    public FormFieldBox(String labelText, List<Component> components, String hintText) {
        this(labelText, (Collection<Component>)components, hintText);
    }
    
    public FormFieldBox(String labelText, Collection<Component> components, String hintText) {
        super();
        setLayout(new GridBagLayout());
        
        GridBagFactory factory = new GridBagFactory();
        
        
        label = new JLabel(labelText);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setVerticalAlignment(SwingConstants.TOP);
//        SizeUtils.setWidth(label, 150);
        SizeUtils.setAllWidths(label, 150);
        add(label, factory.setFill(Fill.BOTH).setInsetRight(5).create());
        
        factory.setInsetRight(0);
        
//        add(new Box(), factory.create());
        
        center = Box.createVerticalBox();
//        SizeUtils.setAllWidths(center, 200);
//        SizeUtils.setMinHeight(center, 20);
//        SizeUtils.setMinWidth(center, 150);
        add(center, factory.nextColumn().setFill(Fill.BOTH).create());
        
        hint = new JLabel(hintText);
        hint.setForeground(Color.GRAY);
        hint.setBackground(Color.RED);
        add(hint, factory.nextRow().setFill(Fill.BOTH).setInsetBottom(5).create());
        
        for (Component c : components) {
            SizeUtils.setAllWidths(c, 200);
            center.add(c);
        }
    }
    
    public void setLabelText(String text) {
        this.label.setText(text);
    }
    
    public String getLabelText() {
        return this.label.getText();
    }
    
    public Component[] getCenterComponents() {
        return center.getComponents();
    }
    
    public void addCenterComponent(Component c) {
        center.add(c);
    }
    
    public void setCenterComponent(Component c) {
        center.removeAll();
        center.add(c);
    }
    
    public void removeAllCenterComponents() {
        center.removeAll();
    }
    
}
