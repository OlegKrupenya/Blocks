package com.udev.factory;

import com.udev.domain.figures.Figure;
import com.udev.domain.figures.JFigure;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 14.09.13
 *         Time: 23:46
 */
public class ReverseLFigureCreator implements FigureCreator {
    @Override
    public Figure createFigure() {
        return new JFigure();
    }
}
