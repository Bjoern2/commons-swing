/**
 * Copyright 2012 Björn Schmitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.commons.swing.form;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.googlecode.commons.swing.layout.GridBagFactory;
import com.googlecode.commons.swing.layout.GridBagFactory.Anchor;
import com.googlecode.commons.swing.layout.GridBagFactory.Fill;
import com.googlecode.commons.swing.util.SizeUtils;

public class FormPanel extends JPanel {

    private static final long serialVersionUID = -6584224287899377530L;

    protected final GridBagFactory gridBagFactory = new GridBagFactory();
    protected int labelWidth = 100;
    protected int fieldWidth = 300;

    public FormPanel() {
        super();
        setBackground(Color.WHITE);
        init();
    }

    protected void init() {
        setLayout(new GridBagLayout());

        gridBagFactory.setFill(Fill.HORIZONTAL);
        gridBagFactory.setInsets(new Insets(2, 2, 2, 2));
        gridBagFactory.setAnchor(Anchor.NORTHWEST);
    }

    public void addField(String label, Component c) {
        JLabel dummy = new JLabel();
        SizeUtils.setAllWidths(dummy, 20);
        addField(label, c, dummy);
    }

    public void addField(String label, Component c, Component notifier) {
        JLabel lbl = new JLabel(label);
        SizeUtils.setAllWidths(lbl, labelWidth);
        add(lbl, gridBagFactory.resetColumn().create());

        SizeUtils.setAllWidths(c, fieldWidth);
        add(c, gridBagFactory.nextColumn().create());

        add(notifier, gridBagFactory.nextColumn().create());

        gridBagFactory.nextRow();
    }

    public void addDummyOnEnd() {
        JLabel lbl = new JLabel();
        add(lbl, gridBagFactory.resetColumn().setColWeight(1.0).setRowWeight(1.0).setColSpanToColCount().create());
    }

}
