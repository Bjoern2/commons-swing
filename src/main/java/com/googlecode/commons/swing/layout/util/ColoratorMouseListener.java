package com.googlecode.commons.swing.layout.util;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColoratorMouseListener implements MouseListener {

    private Colorator colorator = new Colorator();
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.isControlDown()) {
            if (e.getComponent() instanceof Container) {
                Container con = (Container)e.getComponent();
                colorator.colorateBackground(con);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
