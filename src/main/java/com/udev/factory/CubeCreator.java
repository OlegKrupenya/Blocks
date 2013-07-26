package com.udev.factory;

import com.udev.domain.figures.Cube;
import com.udev.domain.figures.Figure;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 04.05.13
 *         Time: 19:29
 */
public class CubeCreator implements FigureCreator {
    @Override
    public Figure createFigure() {
        return new Cube();
    }
}
