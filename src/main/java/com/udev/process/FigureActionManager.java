package com.udev.process;

import com.udev.domain.Cell;
import com.udev.domain.Field;
import com.udev.domain.figures.*;
import com.udev.factory.CubeCreator;
import com.udev.factory.FigureCreator;
import com.udev.factory.LFigureCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * User: oleg.krupenya
 * Date: 7/23/13
 * Time: 7:41 PM
 */
public class FigureActionManager {

    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(FigureActionManager.class);


    /**
     * Creation manager.
     */
    private CreationManager creationManager = new CreationManager();

    /**
     * Rotation of the {@link LFigure}.
     */
    private RotationManager lFigureRotationManager = new LFigureRotationManager();

    /**
     * Movement manager.
     */
    private MovementManager movementManager = new MovementManager();

    /**
     * Rotation manager of the {@link com.udev.domain.figures.JFigure}.
     */
    private RotationManager reverseLFigureRotationManager = new JFigureRotationManager();

    /**
     * Rotation of the {@link Stick}.
     */
    private RotationManager stickRotationManager = new StickRotationManager();

    /**
     * Rotation of the {@link SFigure}.
     */
    private RotationManager sFigureRotationManager = new SFigureRotationManager();

    /**
     * Rotation of the {@link TFigure}
     */
    private RotationManager tFigureRotationManager = new TFigureRotationManager();

    /**
     * Rotation of the {@link ZFigure}.
     */
    private RotationManager zFigureRotationManager = new ZFigureRotationManager();

    /**
     * Determines direction to move a figure
     */
    public enum Move {
        /**
         * The user has pressed the key Left.
         */
        LEFT,
        /**
         * The user has pressed the key Right.
         */
        RIGHT,
        /**
         * Usual movement downwards by timer.
         */
        DOWN,
        /**
         * Speeds up the movement downwards, the user pressed key down.*
         */
        FAST_DOWN
    }

    /**
     * Returns creator by index.
     * 0 - {@link CubeCreator},
     * 1 - {@link LFigureCreator}
     * TODO: Add others creators to this JavaDoc
     *
     * @param index Index to get creator.
     * @return Creator of the figure.
     */
    public FigureCreator getCreator(int index) {
        return creationManager.getCreator(index);
    }

    public boolean addFigureToField(Figure figure, Field field) {
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        for (Cell cell : cells) {
            int i = cell.getI();
            int j = cell.getJ();
            if (data[i][j].getData() == Field.ONE) {
                return false;
            }
            data[i][j] = cell;
        }
        return true;
    }

    /**
     * Move the figure in required direction.
     *
     * @param figure    The figure to move
     * @param field     The field
     * @param direction The direction to move.
     */
    public void moveFigure(Figure figure, Field field, Move direction) {
        switch (direction) {
            case DOWN: {
                movementManager.moveFigureDownwards(figure, field);
                break;
            }
            case LEFT: {
                movementManager.moveFigureLeft(figure, field);
                break;
            }
            case RIGHT: {
                movementManager.moveFigureRight(figure, field);
                break;
            }
            case FAST_DOWN: {
                movementManager.moveFigureFastDownwards(figure, field);
                break;
            }
        }
    }

    /**
     * Rotates the figure
     *
     * @param figure The figure to rotate.
     * @param field  The field.
     */
    public void rotateFigure(Figure figure, Field field) {
        if (figure instanceof Stick) {
            this.stickRotationManager.rotate(figure, field);
        } else if (figure instanceof SFigure) {
            this.sFigureRotationManager.rotate(figure, field);
        } else if (figure instanceof ZFigure) {
            this.zFigureRotationManager.rotate(figure, field);
        } else if (figure instanceof TFigure) {
            this.tFigureRotationManager.rotate(figure, field);
        } else if (figure instanceof LFigure) {
            this.lFigureRotationManager.rotate(figure, field);
        } else if (figure instanceof JFigure) {
            this.reverseLFigureRotationManager.rotate(figure, field);
        }
    }


}
