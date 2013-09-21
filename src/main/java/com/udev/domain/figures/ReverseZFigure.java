package com.udev.domain.figures;

import com.udev.domain.Cell;
import com.udev.domain.Field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 15.09.13
 *         Time: 0:33
 */
public class ReverseZFigure implements Figure {
    private int height;
    private int width;
    private int leftBorder;
    private List<Cell> cells;
    private RotationState rotationState;

    /**
     * Constructor.
     */
    public ReverseZFigure() {
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
        return leftBorder;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
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
        cells.addAll(Arrays.asList(
                new Cell(1, this.leftBorder, Field.ONE),
                new Cell(1, this.leftBorder + 1, Field.ONE),
                new Cell(0, this.leftBorder + 1, Field.ONE),
                new Cell(0, this.leftBorder + 2, Field.ONE)
        ));
    }

    private void init() {
        this.height = 2;
        this.width = 3;
        this.leftBorder = Field.CREATE_FIGURE_LEFT_COORDINATE;
        this.cells = new ArrayList<>(4);
        clear();
    }
}
