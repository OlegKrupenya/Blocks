package com.udev.domain.figures;

import com.udev.domain.Cell;

import java.util.List;

/**
 * User: oleg.krupenya
 * Date: 9/9/13
 * Time: 11:39 AM
 */
public class Stick implements Figure {

    private List<Cell> cells;

    /**
     * @return The internal representation of the figure.
     *         It consist of the list of cells that have data and position
     *         of the cell on the field.
     */
    @Override
    public List<Cell> getCells() {
        return null;
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

    }

    @Override
    public int getLeftBorder() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public boolean contains(Cell cell) {
        return false;
    }

    @Override
    public void clear() {

    }
}
