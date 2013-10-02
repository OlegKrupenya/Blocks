package com.udev.ui;

import com.udev.domain.Field;
import com.udev.events.PaintEventDispatcher;
import com.udev.events.PaintEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * User: oleg.krupenya
 * Date: 9/25/13
 * Time: 10:14 PM
 */
public class TetrisForm extends JFrame implements PaintEventListener {

    private TetrisPanel panel;

    /**
     * Constructs a new frame that is initially invisible.
     * <p/>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @throws java.awt.HeadlessException if GraphicsEnvironment.isHeadless()
     *                                    returns true.
     * @see java.awt.GraphicsEnvironment#isHeadless
     * @see java.awt.Component#setSize
     * @see java.awt.Component#setVisible
     * @see javax.swing.JComponent#getDefaultLocale
     */
    public TetrisForm() throws HeadlessException {
        this.panel = new TetrisPanel();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.add(this.panel);
    }

    @Override
    public void paintField(Field field) {
        this.panel.setField(field);
        this.panel.repaint();
        field.showData();
    }
}
