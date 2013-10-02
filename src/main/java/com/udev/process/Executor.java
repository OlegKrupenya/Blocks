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

    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(Executor.class);

    /**
     * Creator of the figures.
     */
    private FigureCreator creator;

    /**
     * Dispatcher that notifies the form that data need to be repainted.
     */
    private PaintEventDispatcher dispatcher = new PaintEventDispatcher();

    /**
     * The field that contains data.
     */
    private Field field = new Field();

    /**
     * The current figure.
     */
    private Figure figure = null;

    /**
     * Manager of action with the figure.
     */
    private FigureActionManager manager = new FigureActionManager();

    /**
     *  Generates different type of figures.
     */
    private Random rand = new Random();

    // TODO: Rotation.
    // TODO: Fix reading of the input data.
    // TODO: JavaDocs
    // TODO: WIDTH and HEIGHT should be used instead of 10 and 20.
    // TODO: Figure is moving through 2 cells
    // TODO: Add multithreading:
    /*
        Queue will hold tasks (movement or rotation) and execute them.
        One thread will listen key handling and add tasks to the queue.
        The second one will add a task to move the figure down by the timer.
     */

    public void execute() {
        TetrisForm frame = new TetrisForm();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(30 * 10 + 100, 30 * 20 + 100);
        frame.setVisible(true);

        dispatcher.addEventListener(frame);
        frame.getKeyboardEventDispatcher().addEventListener(this);

        creator = manager.getCreator(rand.nextInt(7));
        dispatcher.paintField(field);

        figure = creator.createFigure();
        boolean hasFreeSpace = manager.addFigureToField(figure, field);
        if (hasFreeSpace) {
            field.setPossibleMoveFigure(true);
        } else {
            field.setNotFull(hasFreeSpace);
        }
        dispatcher.paintField(field);
    }

    public static void main(String[] args) {
        logger.debug("Starting the application...");
        Executor exec = new Executor();
        exec.execute();
    }

    @Override
    public void keyPressed(int keyCode) {
        if (field.isNotFull()) {
            if (field.isPossibleMoveFigure()) {
                if (keyCode == 37) {
                    manager.moveFigure(figure, field, FigureActionManager.Move.LEFT);
                } else if (keyCode == 39) {
                    manager.moveFigure(figure, field, FigureActionManager.Move.RIGHT);
                } else if (keyCode == 32) {
                    manager.moveFigure(figure, field, FigureActionManager.Move.FAST_DOWN);
                } else if (keyCode == 38) {
                    manager.rotateFigure(figure, field);
                } else {
                    manager.moveFigure(figure, field, FigureActionManager.Move.DOWN);
                }
                field.checkScores();
                dispatcher.paintField(field);
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
        } else {
            JOptionPane.showMessageDialog(null, "Your score is: " + field.getScores());
        }
    }
}
