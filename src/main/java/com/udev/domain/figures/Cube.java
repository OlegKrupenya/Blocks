package com.udev.domain.figures;

import com.udev.domain.Cell;
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
    private int leftBorder;
    private int height;
    private int width;
    private List<Cell> cells;
    private RotationState rotationState;

    public Cube() {
        init();
    }


    @Override
    public List<Cell> getCells() {
        return this.cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
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
    public RotationState getRotationState() {
        return rotationState;
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

    @Override
    public void setRotationState(RotationState rotationState) {
        this.rotationState = rotationState;
    }

    @Override
    public boolean contains(Cell obj) {
        for (Cell cell : this.getCells()) {
            if (cell.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return cells.toString();
    }

    private void init() {
        this.height = CUBE_HEIGHT;
        this.width = CUBE_HEIGHT;
        this.leftBorder = Field.CREATE_FIGURE_LEFT_COORDINATE;
        this.cells = new ArrayList<>(4);
        clear();
    }

    public void clear() {
        for (int i = 0; i < CUBE_HEIGHT; i++) {
            for (int j = 0; j < CUBE_HEIGHT; j++) {
                Cell cell = new Cell();
                cell.setData(Field.ONE);
                cell.setI(i);
                cell.setJ(j + this.leftBorder);
                cells.add(cell);
            }
        }
    }
}