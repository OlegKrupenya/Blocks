package com.udev.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 04.05.13
 *         Time: 17:47
 */
public class Field {

    private static final Logger logger = LoggerFactory.getLogger(Field.class);

    public static final int WIDTH = 20;
    public static final int HEIGHT = 10;
    public static final int CREATE_FIGURE_LEFT_COORDINATE = 4;

    /**
     * Is set to {@code true} when there is enough space to create a new figure.
     */
    private boolean hasSpace = true;

    /**
     * Is set to {@code true} when it is possible to move the figure.
     * When it is {@code false}, the new figure will be created.
     */
    private boolean canMoveTheFigure = false;

    private int[][] data = new int[WIDTH][HEIGHT];

    public Field() {
        clear();
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    /**
     * Indicates if it is possible to create a new figure.
     * When the field is full, the game is over.
     *
     * @return <code>true</code> if there is enough space to create a new figure.
     */
    public boolean isNotFull() {
        return hasSpace;
    }

    /**
     * @return {@code true} when it is possible to move the figure.
     */
    public boolean isCanMoveTheFigure() {
        return canMoveTheFigure;
    }

    /**
     * Logs the current state of the data
     */
    public void showFieldData() {
        logger.debug("\n\n The data:");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                sb.append(data[i][j] + " ");
            }
            sb.append("\n");
        }
        logger.debug("\n" + sb.toString());
    }

    /**
     * Clears the com.udev.field
     */
    private void clear() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                data[i][j] = 0;
            }
        }
    }
}
