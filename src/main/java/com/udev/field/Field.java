package com.udev.field;

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

    private int[][] data = new int[WIDTH][HEIGHT];

    public Field() {
        clear();
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
