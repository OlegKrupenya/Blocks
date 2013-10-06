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

    /**
     * The field to paint.
     */
    private Field field;

    /**
     *
     * @return The field to paint.
     */
    public Field getField() {
        return field;
    }

    /**
     * Sets the field to paint.
     * @param field  The field to paint.
     */
    public void setField(Field field) {
        this.field = field;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D ga = (Graphics2D) g;
        ga.setPaint(Color.red);
        ga.drawRect(50, 50, 30 * 10, 30 * 20);
        paintHorizontalLines(ga);
        paintVerticalLines(ga);
        paintField(ga);
    }

    /**
     * Paints the content of the field.
     * @param ga Graphics2D
     */
    private void paintField(Graphics2D ga) {
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

    /**
     * Paints horizontal lines of the field.
     * @param ga  Graphics2D
     */
    private void paintHorizontalLines(Graphics2D ga) {
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

    /**
     * Paints vertical lines of the field.
     * @param ga  Graphics2D
     */
    private void paintVerticalLines(Graphics2D ga) {
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
