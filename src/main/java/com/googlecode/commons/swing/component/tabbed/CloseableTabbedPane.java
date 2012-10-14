package com.googlecode.commons.swing.component.tabbed;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTabbedPane;

public class CloseableTabbedPane extends JTabbedPane {

    @Override
    public void insertTab(String title, Icon icon, Component component, String tip, int index) {
        super.insertTab(title, icon, component, tip, index);
    }

}
