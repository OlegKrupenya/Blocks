package com.udev.process;

import com.udev.domain.figures.Cell;
import com.udev.factory.CubeCreator;
import com.udev.factory.FigureCreator;
import com.udev.domain.Field;
import com.udev.domain.figures.Figure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: oleg.krupenya
 * Date: 7/23/13
 * Time: 7:41 PM
 */
public class FigureActionManager {

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
            if (!(cell.getI() != Field.HEIGHT - 1 && (data[cell.getI() + 1][cell.getJ()].getData() == Field.ZERO
                    || figure.contains(data[cell.getI() + 1][cell.getJ()])))) {
                canMove = false;
                break;
            }
        }
        field.setPossibleMoveFigure(canMove);
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
                moveFigureDownDownwards(figure, field);
                break;
            }
        }
    }

    /**
     * Move the figure downwards.
     *
     * @param figure The figure to move.
     * @param field  The field.
     */
    private void moveFigureDownDownwards(Figure figure, Field field) {
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
//                int index = cell.getI();
//                cell.setI(index + 1);
                cell = data[cell.getI() + 1][cell.getJ()];
                alreadyMovedCells.add(data[cell.getI()][cell.getJ()]);
            }
        }
    }
}
