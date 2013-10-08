package com.udev.factory;

import com.udev.domain.figures.Figure;
import com.udev.domain.figures.SFigure;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 15.09.13
 *         Time: 0:35
 */
public class SFigureCreator implements FigureCreator {
    @Override
    public Figure createFigure() {
        return new SFigure();
    }
}
