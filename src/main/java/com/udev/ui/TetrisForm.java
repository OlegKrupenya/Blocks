package com.udev.ui;

import com.udev.domain.Cell;
import com.udev.domain.Field;
import com.udev.events.EventDispatcher;
import com.udev.events.PaintEventListener;

import javax.swing.*;
import java.awt.*;

/**
 * User: oleg.krupenya
 * Date: 9/25/13
 * Time: 10:14 PM
 */
public class TetrisForm extends JFrame implements PaintEventListener {

    private EventDispatcher dispatcher;
    private Field field;

    public EventDispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(EventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void paint(Graphics g) {
        Graphics2D ga = (Graphics2D) g;
        ga.setPaint(Color.red);
        ga.drawRect(50, 50, 30 * 10, 30 * 20);
        drawHorizontalLines(ga);
        drawVerticalLines(ga);
        drawField(ga);
    }

    @Override
    public void paintField(Field field) {
        this.field = field;
        removeAll();
        repaint();
        field.showData();
    }

    private void drawField(Graphics2D ga) {
        int x = 50;
        int y = 50;
        int width = 30;
        int height = 30;

        if (field != null) {
            Cell[][] data = field.getCells();
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 10; j++) {
                    if (data[i][j].getData() == Field.ONE) {
                        ga.fillRect(x + 30 * data[i][j].getJ(), y + 30 * data[i][j].getI(), width, height);
                    }
                }
            }
        }
    }

    private void drawHorizontalLines(Graphics2D ga) {
        int x1 = 50;
        int y1 = 50;
        int x2 = 50 + 30 * 10;
        int y2 = 50;
        for (int i = 0; i <= 20; i++) {
            ga.setPaint(Color.gray);
            ga.drawLine(x1, y1, x2, y2);
            y1 = y1 + 30;
            y2 = y2 + 30;
        }
    }


    private void drawVerticalLines(Graphics2D ga) {
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
}
