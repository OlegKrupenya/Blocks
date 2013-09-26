package com.udev.ui;

import com.udev.domain.Cell;
import com.udev.domain.Field;

import javax.swing.*;
import java.awt.*;

/**
 * User: oleg.krupenya
 * Date: 9/26/13
 * Time: 1:50 PM
 */
public class TetrisPanel extends JPanel {

    private Field field;


    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D ga = (Graphics2D) g;
        ga.setPaint(Color.red);
        ga.drawRect(50, 50, 30 * 10, 30 * 20);
        drawHorizontalLines(ga);
        drawVerticalLines(ga);
        drawField(ga);
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
