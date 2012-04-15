package com.googlecode.commons.swing.component.datetime;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicArrowButton;

public class JDateTimeField extends JFormattedTextField {

    private static final long serialVersionUID = 1787915955297704574L;

    private JButton arrowButton;

    public JDateTimeField() {
        super(new SimpleDateFormat("dd.MM.yyyy"));

        setLayout(new MyLayoutManager());
        arrowButton = new BasicArrowButton(BasicArrowButton.SOUTH, UIManager.getColor("ComboBox.buttonBackground"), UIManager.getColor("ComboBox.buttonShadow"), UIManager.getColor("ComboBox.buttonDarkShadow"), UIManager.getColor("ComboBox.buttonHighlight"));
        arrowButton.setName("ComboBox.arrowButton");
        add(arrowButton);

    }

    protected class MyLayoutManager implements LayoutManager {
        // This layout manager handles the 'standard' layout of combo boxes.
        // It puts the arrow button to the right and the editor to the left.
        // If there is no editor it still keeps the arrow button to the right.
        public void addLayoutComponent(String name, Component comp) {
        }

        public void removeLayoutComponent(Component comp) {
        }

        public Dimension preferredLayoutSize(Container parent) {
            return parent.getPreferredSize();
        }

        public Dimension minimumLayoutSize(Container parent) {
            return parent.getMinimumSize();
        }

        public void layoutContainer(Container parent) {
            boolean squareButton = true;
            
            JDateTimeField cb = (JDateTimeField) parent;
            int width = cb.getWidth();
            int height = cb.getHeight();

            Insets insets = getInsets();
            int buttonHeight = height - (insets.top + insets.bottom);
            int buttonWidth = buttonHeight;
            if (arrowButton != null) {
                Insets arrowInsets = arrowButton.getInsets();
                buttonWidth = squareButton ? buttonHeight : arrowButton.getPreferredSize().width + arrowInsets.left + arrowInsets.right;
            }
            Rectangle cvb;

            if (arrowButton != null) {
                if (cb.getComponentOrientation().isLeftToRight()) {
                    arrowButton.setBounds(width - (insets.right + buttonWidth), insets.top, buttonWidth, buttonHeight);
                } else {
                    arrowButton.setBounds(insets.left, insets.top, buttonWidth, buttonHeight);
                }
            }
//            if (editor != null) {
//                cvb = rectangleForCurrentValue();
//                editor.setBounds(cvb);
//            }
        }
    }

}
