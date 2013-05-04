package com.udev.field;

import com.udev.figures.Figure;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 04.05.13
 *         Time: 17:47
 */
public class Field {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;
    public static final int CREATE_FIGURE_LEFT_COORDINATE = 5;

    /**
     * Is set to <code>true</code> when there is enough space to create a new figure.
     */
    private boolean hasSpace = true;

    private int[][] data = new int[WIDTH][HEIGHT];

    public Field() {
        clear();
    }

    public void addFigureToField(Figure figure) {
        int[][] figureData = figure.getData();
        int figureWidth = figure.getWidth();
        int figureHeight = figure.getHeight();

        int dataI = CREATE_FIGURE_LEFT_COORDINATE;
        int dataJ = 0;
        for (int i = 0; i < figureWidth; i++) {
            for (int j = 0; j < figureHeight; j++) {
                data[dataI][dataJ] = figureData[i][j];
                dataJ++;
            }
            dataI++;
        }
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
