package com.udev.process;

import com.udev.domain.figures.Cell;
import com.udev.factory.CubeCreator;
import com.udev.factory.FigureCreator;
import com.udev.domain.Field;
import com.udev.domain.figures.Figure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: oleg.krupenya
 * Date: 7/23/13
 * Time: 7:41 PM
 */
public class FigureActionManager {

    private static final Logger logger = LoggerFactory.getLogger(FigureActionManager.class);

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

    public FigureCreator getCreator(int index) {
        FigureCreator creator = null;
        if (index == 0) {
            creator = new CubeCreator();
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
     * Returns {@code true} if it is possible to move the figure downwards.
     *
     * @param figure The figure to move
     * @param field  The field
     * @return {@code true} if it is possible to move the figure downwards.
     */
    public boolean isPossibleToMoveTheFigureDownwards(Figure figure, Field field) {
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
    public boolean isPossibleToMoveTheFigureLeft(Figure figure, Field field) {
        boolean canMove = true;
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        for (Cell cell : cells) {
            if (!(cell.getJ() != 0) && (data[cell.getI()][cell.getJ() - 1].getData() == Field.ZERO
                    || figure.contains(data[cell.getI()][cell.getJ() - 1]))) {
                canMove = false;
                break;
            }
        }
        return canMove;
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
        }
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
            for (Iterator<Cell> iterator = cells.iterator(); iterator.hasNext(); ) {
                Cell cell = iterator.next();
                if (!alreadyMovedCells.contains(cell)) {
                    data[cell.getI()][cell.getJ()].setData(Field.ZERO);
                }
                data[cell.getI() + 1][cell.getJ()].setData(Field.ONE);
                alreadyMovedCells.add(data[cell.getI()+1][cell.getJ()]);
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
            for (Iterator<Cell> iterator = cells.iterator(); iterator.hasNext(); ) {
                Cell cell = iterator.next();
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
}
