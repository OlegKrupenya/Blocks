package com.udev.domain.figures;

import com.udev.domain.Cell;
import com.udev.domain.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * User: oleg.krupenya
 * Date: 9/9/13
 * Time: 11:39 AM
 */
public class Stick implements Figure {

    private static final int STICK_WIDTH = 1;
    private static final int STICK_HEIGHT = 4;

    private int height;
    private int width;
    private int leftBorder;
    private RotationState rotationState;

    private List<Cell> cells;

    public Stick() {
        init();
    }

    /**
     * @return The internal representation of the figure.
     *         It consist of the list of cells that have data and position
     *         of the cell on the field.
     */
    @Override
    public List<Cell> getCells() {
        return this.cells;
    }

    /**
     * Allows to set the internal representation of the figure.
     *
     * @param cells The internal representation of the figure.
     *              It consist of the list of cells that have data and position
     *              of the cell on the field.
     */
    @Override
    public void setCells(List<Cell> cells) {
         this.cells = cells;
    }

    @Override
    public int getLeftBorder() {
        return this.leftBorder;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public RotationState getRotationState() {
        return rotationState;
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
    public void clear() {
        for (int i = 0; i < STICK_HEIGHT; i++) {
            for (int j = 0; j < STICK_WIDTH; j++) {
                Cell cell = new Cell();
                cell.setData(Field.ONE);
                cell.setI(i);
                cell.setJ(j + this.leftBorder);
                cells.add(cell);
            }
        }
    }

    private void init() {
        this.height = STICK_HEIGHT;
        this.width = STICK_WIDTH;
        this.leftBorder = Field.CREATE_FIGURE_LEFT_COORDINATE;
        this.cells = new ArrayList<>(4);
        clear();
    }
}
