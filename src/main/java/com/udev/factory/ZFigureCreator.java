package com.udev.factory;

import com.udev.domain.figures.Figure;
import com.udev.domain.figures.ZFigure;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 15.09.13
 *         Time: 0:27
 */
public class ZFigureCreator implements FigureCreator {
    @Override
    public Figure createFigure() {
        return new ZFigure();
    }
}
