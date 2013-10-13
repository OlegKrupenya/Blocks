package com.udev.process;

import com.udev.domain.Cell;
import com.udev.domain.Field;
import com.udev.domain.figures.Figure;
import com.udev.domain.figures.RotationState;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: taipan
 * Date: 13.10.13
 */
public class ReverseLFigureRotationManager implements RotationManager {

    @Override
    public void rotate(Figure figure, Field field) {
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        RotationState state = figure.getRotationState();
        if (state == RotationState.HORIZONTAL && isPossibleToRotateVertically(figure, field)) {
            Cell firstCell = cells.get(0);
            data[firstCell.getI()][firstCell.getJ()] = new Cell(firstCell.getI(), firstCell.getJ(), Field.ZERO);
            data[firstCell.getI() - 1][firstCell.getJ() + 2] = new Cell(firstCell.getI() - 1, firstCell.getJ() + 2,
                    Field.ONE);
            firstCell.setI(firstCell.getI() - 1);
            firstCell.setJ(firstCell.getJ() + 2);

            Cell secondCell = cells.get(1);
            data[secondCell.getI()][secondCell.getJ()] = new Cell(secondCell.getI(), secondCell.getJ(), Field.ZERO);
            data[secondCell.getI() - 1][secondCell.getJ() + 2] = new Cell(secondCell.getI() - 1, secondCell.getJ() + 2,
                    Field.ONE);
            secondCell.setI(secondCell.getI() - 1);
            secondCell.setJ(secondCell.getJ() + 2);
            figure.setRotationState(RotationState.VERTICAL);
        } else if (state == RotationState.VERTICAL && isPossibleToRotateBackHorizontally(figure, field)) {
            Cell thirdCell = cells.get(2);
            data[thirdCell.getI()][thirdCell.getJ()] = new Cell(thirdCell.getI(), thirdCell.getJ(), Field.ZERO);
            data[thirdCell.getI() - 2][thirdCell.getJ() - 1] = new Cell(thirdCell.getI() - 2, thirdCell.getJ() - 1,
                    Field.ONE);
            thirdCell.setI(thirdCell.getI() - 2);
            thirdCell.setJ(thirdCell.getJ() - 1);

            Cell fourthCell = cells.get(3);
            data[fourthCell.getI()][fourthCell.getJ()] = new Cell(fourthCell.getI(), fourthCell.getJ(), Field.ZERO);
            data[fourthCell.getI() - 2][fourthCell.getJ() - 1] = new Cell(fourthCell.getI() - 2, fourthCell.getJ() - 1,
                    Field.ONE);
            fourthCell.setI(fourthCell.getI() - 2);
            fourthCell.setJ(fourthCell.getJ() - 1);
            figure.setRotationState(RotationState.BACK_HORIZONTAL);
        } else if (state == RotationState.BACK_HORIZONTAL && isPossibleToRotateBackVertically(figure, field)) {
            Cell firstCell = cells.get(0);
            data[firstCell.getI()][firstCell.getJ()] = new Cell(firstCell.getI(), firstCell.getJ(), Field.ZERO);
            data[firstCell.getI() + 1][firstCell.getJ() - 2] = new Cell(firstCell.getI() + 1, firstCell.getJ() - 2,
                    Field.ONE);
            firstCell.setI(firstCell.getI() + 1);
            firstCell.setJ(firstCell.getJ() - 2);

            Cell secondCell = cells.get(1);
            data[secondCell.getI()][secondCell.getJ()] = new Cell(secondCell.getI(), secondCell.getJ(), Field.ZERO);
            data[secondCell.getI() + 1][secondCell.getJ() - 2] = new Cell(secondCell.getI() + 1, secondCell.getJ() - 2,
                    Field.ONE);
            secondCell.setI(secondCell.getI() + 1);
            secondCell.setJ(secondCell.getJ() - 2);
            figure.setRotationState(RotationState.BACK_VERTICAL);
        }  else if (state == RotationState.BACK_VERTICAL && isPossibleToRotateHorizontally(figure, field)) {
            Cell thirdCell = cells.get(2);
            data[thirdCell.getI()][thirdCell.getJ()] = new Cell(thirdCell.getI(), thirdCell.getJ(), Field.ZERO);
            data[thirdCell.getI() + 2][thirdCell.getJ() + 1] = new Cell(thirdCell.getI() + 2, thirdCell.getJ() + 1,
                    Field.ONE);
            thirdCell.setI(thirdCell.getI() + 2);
            thirdCell.setJ(thirdCell.getJ() + 1);

            Cell fourthCell = cells.get(3);
            data[fourthCell.getI()][fourthCell.getJ()] = new Cell(fourthCell.getI(), fourthCell.getJ(), Field.ZERO);
            data[fourthCell.getI() + 2][fourthCell.getJ() + 1] = new Cell(fourthCell.getI() + 2, fourthCell.getJ() + 1,
                    Field.ONE);
            fourthCell.setI(fourthCell.getI() + 2);
            fourthCell.setJ(fourthCell.getJ() + 1);
            figure.setRotationState(RotationState.HORIZONTAL);
        }
    }
    private boolean isPossibleToRotateBackHorizontally(Figure figure, Field field) {
        boolean canRotate = true;
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        Cell firstCell = cells.get(0);
        if (firstCell.getJ() - 2 < 0 || data[firstCell.getI()][firstCell.getJ() - 1].getData() == Field.ONE
                || data[firstCell.getI()][firstCell.getJ() - 2].getData() == Field.ONE) {
            canRotate = false;
        }
        return canRotate;
    }

    private boolean isPossibleToRotateBackVertically(Figure figure, Field field) {
        boolean canRotate = true;
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        Cell fourthCell = cells.get(3);
        if (fourthCell.getI() + 2 > 19 || data[fourthCell.getI() + 1][fourthCell.getJ() - 1].getData() == Field.ONE
                || data[fourthCell.getI() + 2][fourthCell.getJ() - 1].getData() == Field.ONE) {
            canRotate = false;
        }
        return canRotate;
    }

    private boolean isPossibleToRotateHorizontally(Figure figure, Field field) {
        boolean canRotate = true;
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        Cell secondCell = cells.get(1);
        if (secondCell.getJ() + 2 > 9 || data[secondCell.getI()][secondCell.getJ() + 1].getData() == Field.ONE
                || data[secondCell.getI()][secondCell.getJ() + 2].getData() == Field.ONE) {
            canRotate = false;
        }
        return canRotate;
    }

    private boolean isPossibleToRotateVertically(Figure figure, Field field) {
        boolean canRotate = true;
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        Cell fourthCell = cells.get(3);
        if (data[fourthCell.getI() - 1][fourthCell.getJ()].getData() == Field.ONE
                || data[fourthCell.getI() - 2][fourthCell.getJ()].getData() == Field.ONE) {
            canRotate = false;
        }
        return canRotate;
    }
}
