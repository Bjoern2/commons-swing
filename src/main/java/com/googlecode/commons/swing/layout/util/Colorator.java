package com.googlecode.commons.swing.layout.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colorator {

    private List<Color> colors;
    
    public Colorator() {
        colors = new ArrayList<Color>();
        colors.add(Color.BLUE);
        colors.add(Color.CYAN);
        colors.add(Color.GREEN);
        colors.add(Color.MAGENTA);
        colors.add(Color.ORANGE);
        colors.add(Color.PINK);
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
    }
    
    public void colorateBackground(Container c) {
        if (c != null) {
            c.setBackground(nextColor());
            for (Component child : c.getComponents()) {
                if (child instanceof Container) {
                    Container c2 = (Container)child;
                    colorateBackground(c2);
                }
            }
        }
    }
    
    protected Color nextColor() {
        Random r = new Random();
        int index = r.nextInt(colors.size() - 1);
        return colors.get(index);
    }
    
}
