package com.udev.ui;

import javax.swing.*;
import java.awt.*;

/**
 * User: oleg.krupenya
 * Date: 9/25/13
 * Time: 10:14 PM
 */
public class TetrisForm extends JFrame {

    public void paint(Graphics g) {
        Graphics2D ga = (Graphics2D) g;
        ga.setPaint(Color.red);
        ga.drawRect(50, 50, 30 * 10, 30 * 20);
    }

    public static void main(String args[]) {
        TetrisForm frame = new TetrisForm();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(30 * 10 + 100, 30 * 20 + 100);
        frame.setVisible(true);
    }
}
