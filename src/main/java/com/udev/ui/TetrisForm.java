package com.udev.ui;

import com.udev.domain.Field;
import com.udev.process.Executor;

import javax.swing.*;
import java.awt.*;

/**
 * User: oleg.krupenya
 * Date: 9/25/13
 * Time: 10:14 PM
 */
public class TetrisForm extends JFrame {

    private Executor executor;

    public void paint(Graphics g) {
        Graphics2D ga = (Graphics2D) g;
        ga.setPaint(Color.red);
        ga.drawRect(50, 50, 30 * 10, 30 * 20);
        drawLines(ga);
    }


    private void drawLines(Graphics2D ga) {
        int x1 = 50;
        int y1 = 50;
        int x2 = 50;
        int y2 = 50 + 30 * 20;
        for (int i = 0; i <= 10; i++) {
            ga.setPaint(Color.gray);
            ga.drawLine(x1, y1, x2, y2);
            x1 = x1 + 30;
            x2 = x2 + 30;
        }
    }

    public static void main(String args[]) {
        TetrisForm frame = new TetrisForm();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(30 * 10 + 100, 30 * 20 + 100);
        frame.setVisible(true);
    }
}
