package com.udev.domain.figures;

import com.udev.domain.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 04.05.13
 *         Time: 17:46
 */
public class Cube implements Figure {
    public static final int CUBE_HEIGHT = 2;
    private static final byte CONTENT = 1;
    private int leftBorder;
    private int height;
    private int width;
    private List<Cell> data;

    public Cube() {
        init();
    }


    @Override
    public List<Cell> getCells() {
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
        this.data = new ArrayList<>(4);
        clear();
    }

    private void clear() {
        for (int i = 0; i < CUBE_HEIGHT; i++) {
            for (int j = 0; j < CUBE_HEIGHT; j++) {
                Cell cell = new Cell();
                cell.setData(CONTENT);
                cell.setI(i);
                cell.setJ(j + this.leftBorder);
                data.add(cell);
            }
        }
    }
}