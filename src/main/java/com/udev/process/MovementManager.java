package com.udev.process;

import com.udev.domain.Cell;
import com.udev.domain.Field;
import com.udev.domain.figures.Figure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 21.09.13
 *         Time: 20:02
 */
public class MovementManager {

    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(MovementManager.class);

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
    protected void moveFigureDownwards(Figure figure, Field field) {
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
     * Drops the figure.
     * @param figure The figure to move.
     * @param field The field.
     */
    protected void moveFigureFastDownwards(Figure figure, Field field) {
        while (isPossibleToMoveTheFigureDownwards(figure, field)) {
            moveFigureDownwards(figure, field);
        }
    }

    /**
     * Moves the figure left.
     *
     * @param figure The figure to move.
     * @param field  The field.
     */
    protected void moveFigureLeft(Figure figure, Field field) {
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
    protected void moveFigureRight(Figure figure, Field field) {
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
}
