package com.googlecode.commons.swing.util;

import java.awt.Component;
import java.awt.Container;
import java.util.Collection;

public class ContainerUtils {

    public static void addAll(Container parent, Collection<Component> children) {
        for (Component child : children) {
            parent.add(child);
        }
    }
    
    public static void addAll(Container parent, Collection<Component> children, Object containt) {
        for (Component child : children) {
            parent.add(child, containt);
        }
    }
    
}
