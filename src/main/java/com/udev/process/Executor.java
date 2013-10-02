package com.udev.process;

import com.udev.events.KeyboardEventDispatcher;
import com.udev.events.KeyboardEventListener;
import com.udev.events.PaintEventDispatcher;
import com.udev.factory.FigureCreator;
import com.udev.domain.Field;
import com.udev.domain.figures.Figure;
import com.udev.ui.TetrisForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 04.05.13
 *         Time: 18:38
 */
public class Executor implements KeyboardEventListener {

    private static final Logger logger = LoggerFactory.getLogger(Executor.class);

    public void execute() {
        TetrisForm frame = new TetrisForm();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(30 * 10 + 100, 30 * 20 + 100);
        frame.setVisible(true);

        Field field = new Field();
        Random rand = new Random();
        FigureCreator creator;
        FigureActionManager manager = new FigureActionManager();
        Figure figure = null;

        PaintEventDispatcher dispatcher = new PaintEventDispatcher();
        dispatcher.addEventListener(frame);
        frame.getKeyboardEventDispatcher().addEventListener(this);

        while (field.isNotFull()) {
            if (field.isPossibleMoveFigure()) {
                try {
                    // TODO: Rotation.
                    // TODO: Fix reading of the input data.
                    // TODO: UI
                    // TODO: JavaDocs
                    // TODO: WIDTH and HEIGHT should be used instead of 10 and 20.
                    // TODO: Figure is moving through 2 cells
                    // TODO: Add a thread that will listen key handling
                    int ch;
                    while (true) {
                        ch = System.in.read();
                        if (ch == 49) {
                            manager.moveFigure(figure, field, FigureActionManager.Move.LEFT);
                        } else if (ch == 50) {
                            manager.moveFigure(figure, field, FigureActionManager.Move.RIGHT);
                        } else if (ch == 52) {
                            manager.moveFigure(figure, field, FigureActionManager.Move.FAST_DOWN);
                        } else if (ch == 53) {
                            manager.rotateFigure(figure, field);
                        } else {
                            manager.moveFigure(figure, field, FigureActionManager.Move.DOWN);
                            break;
                        }
                    }
                    field.checkScores();
                } catch (IOException e) {
                    logger.error("Error during reading the input data.");
                    break;
                }
            } else {
                creator = manager.getCreator(rand.nextInt(7));
                dispatcher.paintField(field);

                figure = creator.createFigure();
                boolean hasFreeSpace = manager.addFigureToField(figure, field);
                if (hasFreeSpace) {
                    field.setPossibleMoveFigure(true);
                } else {
                    field.setNotFull(hasFreeSpace);
                }
            }
            dispatcher.paintField(field);
        }
        System.out.println("Your score is: " + field.getScores());
    }

    public static void main(String[] args) {
        logger.debug("Starting the application...");
        Executor exec = new Executor();
        exec.execute();
    }

    @Override
    public void keyPressed(int keyCode) {
        JOptionPane.showMessageDialog(null, keyCode);
    }
}
