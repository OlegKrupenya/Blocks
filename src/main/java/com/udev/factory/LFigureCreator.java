package com.udev.factory;

import com.udev.domain.figures.Figure;
import com.udev.domain.figures.LFigure;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 14.09.13
 *         Time: 20:29
 */
public class LFigureCreator implements FigureCreator {
    @Override
    public Figure createFigure() {
        return new LFigure();
    }
}
