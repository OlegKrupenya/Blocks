package com.udev.figures;

import com.udev.field.Field;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 04.05.13
 *         Time: 17:46
 */
public class Cube implements Figure {
    public static final int CUBE_HEIGHT = 2;
    private int[][] data;
    private int leftBorder;
    private int height;
    private int width;


    @Override
    public int[][] getData() {
        return this.data;
    }

    @Override
    public int getLeftBorder() {
        return this.leftBorder;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setData(int[][] data) {
        this.data = data;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    private void init() {
        this.height = CUBE_HEIGHT;
        this.width = CUBE_HEIGHT;
        this.leftBorder = Field.CREATE_FIGURE_LEFT_COORDINATE;
        this.data = new int[CUBE_HEIGHT][CUBE_HEIGHT];
        clear();
    }

    private void clear() {
        for (int i = 0; i < CUBE_HEIGHT; i++) {
            for (int j = 0; j < CUBE_HEIGHT; j++) {
                data[i][j] = 1;
            }
        }
    }
}