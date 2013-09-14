package com.udev.factory;

import com.udev.domain.figures.Figure;
import com.udev.domain.figures.TFigure;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 14.09.13
 *         Time: 23:54
 */
public class TFigureCreator implements FigureCreator {
    @Override
    public Figure createFigure() {
        return new TFigure();
    }
}
