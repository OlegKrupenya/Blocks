package com.udev.process;

import com.udev.factory.CubeCreator;
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
            field.showFieldData();
            Figure figure = creator.createFigure();
            field.addFigureToField(figure);
            field.showFieldData();
        }
    }

    private static FigureCreator getCreator(int index) {
        FigureCreator creator = null;
        if (index == 0) {
            creator = new CubeCreator();
        }
        return creator;
    }
}
