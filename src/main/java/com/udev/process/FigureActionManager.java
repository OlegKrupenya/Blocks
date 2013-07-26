package com.udev.process;

import com.udev.factory.CubeCreator;
import com.udev.factory.FigureCreator;
import com.udev.domain.Field;
import com.udev.domain.figures.Figure;

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
        int[][] figureData = figure.getData();
        int[][] data = figure.getData();
        int figureWidth = figure.getWidth();
        int figureHeight = figure.getHeight();

        int dataI = 0;
        int dataJ = Field.CREATE_FIGURE_LEFT_COORDINATE;
        for (int i = 0; i < figureWidth; i++) {
            for (int j = 0; j < figureHeight; j++) {
                data[dataI][dataJ] = figureData[i][j];
                dataJ++;
            }
            dataJ = Field.CREATE_FIGURE_LEFT_COORDINATE;
            dataI++;
        }
    }

    public void moveFigure(Figure figure, Field field) {
    }
}
