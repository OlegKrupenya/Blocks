package com.udev.process;

import com.udev.domain.Cell;
import com.udev.factory.*;
import com.udev.domain.Field;
import com.udev.domain.figures.Figure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * User: oleg.krupenya
 * Date: 7/23/13
 * Time: 7:41 PM
 */
public class FigureActionManager {

    private static final Logger logger = LoggerFactory.getLogger(FigureActionManager.class);

    /**
     * Creator that creates cubes.
     */
    private FigureCreator cubeCreator = new CubeCreator();

    /**
     * Creator that creates {@link com.udev.domain.figures.LFigure}
     */
    private FigureCreator lFigureCreator = new LFigureCreator();

    /**
     * Creator that creates {@link com.udev.domain.figures.ReverseLFigure}
     */
    private FigureCreator reverseLFigureCreator = new ReverseLFigureCreator();

    /**
     * Creator that creates {@link com.udev.domain.figures.TFigure}
     */
    private FigureCreator tFigureCreator = new TFigureCreator();

    /**
     * Creator that creates sticks.
     */
    private FigureCreator stickCreator = new StickCreator();

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
        FigureCreator creator;
        switch (index) {
            case 0: {
                creator = cubeCreator;
                break;
            }
            case 1: {
                creator = lFigureCreator;
                break;
            }
            case 2: {
                creator = reverseLFigureCreator;
                break;
            }
            case 3: {
                creator = tFigureCreator;
                break;
            }
            default: {
                creator = stickCreator;
            }
        }
        return creator;
    }

    public void addFigureToField(Figure figure, Field field) {
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        for (Cell cell : cells) {
            int i = cell.getI();
            int j = cell.getJ();
            data[i][j] = cell;
        }
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
                moveFigureDownwards(figure, field);
                break;
            }
            case LEFT: {
                moveFigureLeft(figure, field);
                break;
            }
            case RIGHT: {
                moveFigureRight(figure, field);
                break;
            }
        }
    }

    /**
     * Returns {@code true} if it is possible to move the figure downwards.
     *
     * @param figure The figure to move
     * @param field  The field
     * @return {@code true} if it is possible to move the figure downwards.
     */
    private boolean isPossibleToMoveTheFigureDownwards(Figure figure, Field field) {
        boolean canMove = true;
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        for (Cell cell : cells) {
            // TODO: HEIGHT should be here!!!!
            if (!(cell.getI() != 19 && (data[cell.getI() + 1][cell.getJ()].getData() == Field.ZERO
                    || figure.contains(data[cell.getI() + 1][cell.getJ()])))) {
                canMove = false;
                break;
            }
        }
        field.setPossibleMoveFigure(canMove);
        return canMove;
    }

    /**
     * Returns {@code true} if it is possible to move the figure left.
     *
     * @param figure The figure to move
     * @param field  The field
     * @return {@code true} if it is possible to move the figure left.
     */
    private boolean isPossibleToMoveTheFigureLeft(Figure figure, Field field) {
        boolean canMove = true;
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        for (Cell cell : cells) {
            if (!(cell.getJ() > 0 && (data[cell.getI()][cell.getJ() - 1].getData() == Field.ZERO
                    || figure.contains(data[cell.getI()][cell.getJ() - 1])))) {
                canMove = false;
                break;
            }
        }
        return canMove;
    }

    /**
     * Returns {@code true} if it is possible to move the figure left.
     *
     * @param figure The figure to move
     * @param field  The field
     * @return {@code true} if it is possible to move the figure left.
     */
    private boolean isPossibleToMoveTheFigureRight(Figure figure, Field field) {
        boolean canMove = true;
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        for (Cell cell : cells) {
            if (!(cell.getJ() < 9 && (data[cell.getI()][cell.getJ() + 1].getData() == Field.ZERO
                    || figure.contains(data[cell.getI()][cell.getJ() + 1])))) {
                canMove = false;
                break;
            }
        }
        return canMove;
    }

    /**
     * Moves the figure downwards.
     *
     * @param figure The figure to move.
     * @param field  The field.
     */
    private void moveFigureDownwards(Figure figure, Field field) {
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        List<Cell> alreadyMovedCells = new ArrayList<>(figure.getCells().size());
        if (isPossibleToMoveTheFigureDownwards(figure, field)) {
            for (Cell cell : cells) {
                if (!alreadyMovedCells.contains(cell)) {
                    data[cell.getI()][cell.getJ()].setData(Field.ZERO);
                }
                data[cell.getI() + 1][cell.getJ()].setData(Field.ONE);
                alreadyMovedCells.add(data[cell.getI() + 1][cell.getJ()]);
            }
            figure.setCells(alreadyMovedCells);
            logger.debug("The figure has been moved downwards:\n" + figure + "\n");
        }
    }

    /**
     * Moves the figure left.
     *
     * @param figure The figure to move.
     * @param field  The field.
     */
    private void moveFigureLeft(Figure figure, Field field) {
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        List<Cell> alreadyMovedCells = new ArrayList<>(figure.getCells().size());
        if (isPossibleToMoveTheFigureLeft(figure, field)) {
            for (Cell cell : cells) {
                if (!alreadyMovedCells.contains(cell)) {
                    data[cell.getI()][cell.getJ()].setData(Field.ZERO);
                }
                data[cell.getI()][cell.getJ() - 1].setData(Field.ONE);
                alreadyMovedCells.add(data[cell.getI()][cell.getJ() - 1]);
            }
            figure.setCells(alreadyMovedCells);
            logger.debug("The figure has been moved left:\n" + figure + "\n");
        }
    }

    /**
     * Moves the figure right.
     *
     * @param figure The figure to move.
     * @param field  The field.
     */
    private void moveFigureRight(Figure figure, Field field) {
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        List<Cell> alreadyMovedCells = new ArrayList<>(figure.getCells().size());
        if (isPossibleToMoveTheFigureRight(figure, field)) {
            for (Cell cell : cells) {
                if (!alreadyMovedCells.contains(cell)) {
                    data[cell.getI()][cell.getJ()].setData(Field.ZERO);
                }
                data[cell.getI()][cell.getJ() + 1].setData(Field.ONE);
                alreadyMovedCells.add(data[cell.getI()][cell.getJ() + 1]);
            }
            figure.setCells(alreadyMovedCells);
            logger.debug("The figure has been moved left:\n" + figure + "\n");
        }
    }
}
