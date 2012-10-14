package com.googlecode.commons.swing.component.link;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;

import javax.swing.JButton;

public class HyperLink extends JButton {

    private static final long serialVersionUID = -6795489495494326758L;

    public HyperLink() {
        this("");
    }
    
    public HyperLink(String text) {
        super();
        setBorderPainted(false);
        setContentAreaFilled(false);
        setMargin(new Insets(0, 0, 0, 0));
        setForeground(Color.BLUE);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
}
