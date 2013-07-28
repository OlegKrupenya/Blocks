package com.udev.process;

import com.udev.domain.figures.Cell;
import com.udev.factory.CubeCreator;
import com.udev.factory.FigureCreator;
import com.udev.domain.Field;
import com.udev.domain.figures.Figure;

import java.util.List;

/**
 * User: oleg.krupenya
 * Date: 7/23/13
 * Time: 7:41 PM
 */
public class FigureActionManager {

    public FigureCreator getCreator(int index) {
        FigureCreator creator = null;
        if (index == 0) {
            creator = new CubeCreator();
        }
        return creator;
    }

    public void addFigureToField(Figure figure, Field field) {
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        for (Cell cell : cells) {
            int i = cell.getI();
            int j = cell.getJ();
            data[i][j] = cell;
        }
    }

    public void moveFigure(Figure figure, Field field) {
    }
}
