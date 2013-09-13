package com.udev.factory;

import com.udev.domain.figures.Figure;
import com.udev.domain.figures.Stick;

/**
 * User: oleg.krupenya
 * Date: 9/13/13
 * Time: 8:01 PM
 */
public class StickCreator implements FigureCreator {
    @Override
    public Figure createFigure() {
        return new Stick();
    }
}
