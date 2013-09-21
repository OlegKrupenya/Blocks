package com.udev.domain.figures;

import com.udev.domain.Cell;

import java.util.List;

/**
 * The Figure contains the list of Cells.
 * The Cell consists of its coordinates on the field and the data: 1(not empty) or 0 (empty)
 *
 * @author taipan
 *         Date: 04.05.13
 *         Time: 17:42
 */
public interface Figure {

    /**
     * @return The internal representation of the figure.
     *         It consist of the list of cells that have data and position
     *         of the cell on the field.
     */
    public List<Cell> getCells();

    /**
     * Allows to set the internal representation of the figure.
     *
     * @param cells The internal representation of the figure.
     *              It consist of the list of cells that have data and position
     *              of the cell on the field.
     */
    public void setCells(List<Cell> cells);

    public int getLeftBorder();

    public int getWidth();

    public int getHeight();

    public void setWidth(int width);

    public void setHeight(int height);

    public boolean contains(Cell cell);

    public void clear();

    public void setRotationState(RotationState rotationState);

    public RotationState getRotationState();
}
