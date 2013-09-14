package com.udev.process;

import com.udev.factory.FigureCreator;
import com.udev.domain.Field;
import com.udev.domain.figures.Figure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;

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
        Random rand = new Random();
        FigureCreator creator;
        FigureActionManager manager = new FigureActionManager();
        Figure figure = null;
        while (field.isNotFull()) {
            if (field.isPossibleMoveFigure()) {
                try {
                    // TODO: Correct checking of the free space to create the figure.
                    // TODO: Fix reading of the input data.
                    // TODO: UI
                    // TODO: Counting of scores
                    // TODO: Removing of the line if it populated.
                    // TODO: JavaDocs
                    int ch;
                    while (true) {
                        ch = System.in.read();
                        if (ch == 49) {
                            manager.moveFigure(figure, field, FigureActionManager.Move.LEFT);
                        } else if (ch == 50) {
                            manager.moveFigure(figure, field, FigureActionManager.Move.RIGHT);
                        }
                        else {
                            manager.moveFigure(figure, field, FigureActionManager.Move.DOWN);
                            break;
                        }
                    }
                } catch (IOException e) {
                    logger.error("Error during reading the input data.");
                    break;
                }
            } else {
                creator = manager.getCreator(rand.nextInt(5));
                field.showData();
                figure = creator.createFigure();
                manager.addFigureToField(figure, field);
                field.setPossibleMoveFigure(true);
            }
            field.showData();
            field.verifyFreeSpace();
        }
        System.out.println("You've won :)");
    }
}
