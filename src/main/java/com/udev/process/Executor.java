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
        FigureActionManager manager = new FigureActionManager();
        while (field.isNotFull()) {
            Figure figure = null;
            if (field.isCanMoveTheFigure()) {
                creator = manager.getCreator(0);
                field.showFieldData();
                figure = creator.createFigure();
                manager.addFigureToField(figure, field);
                field.showFieldData();
            }  else {
                manager.moveFigure(figure, field);
            }
        }
        System.out.println("You've won :)");
    }


}
