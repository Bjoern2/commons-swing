package com.googlecode.commons.swing.layout.util;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class ColoratorKeyListener implements KeyListener {

    private Colorator colorator = new Colorator();
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F9) {
            if (e.getComponent() instanceof Container) {
                Container con = (Container)e.getComponent();
                colorator.colorateBackground(con);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}
