package com.udev.process;

import com.udev.factory.CureCreator;
import com.udev.factory.FigureCreator;
import com.udev.field.Field;
import com.udev.figures.Figure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 04.05.13
 *         Time: 18:38
 */
public class Executor {

    private static final Logger logger = LoggerFactory.getLogger(Executor.class);

    public static void main(String[] args) {

        logger.debug("Starting the application...");

        Field field = new Field();
        FigureCreator creator = null;
        while (field.isNotFull()) {
            creator = getCreator(0);
            Figure figure = creator.createFigure();
            field.addFigureToField(figure);
        }
    }

    private static FigureCreator getCreator(int index) {
        FigureCreator creator = null;
        if (index == 0) {
            creator = new CureCreator();
        }
        return creator;
    }
}
