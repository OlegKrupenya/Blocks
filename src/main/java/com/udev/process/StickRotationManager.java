package com.udev.process;

import com.udev.domain.Cell;
import com.udev.domain.Field;
import com.udev.domain.figures.Figure;
import com.udev.domain.figures.RotationState;
import com.udev.domain.figures.Stick;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 21.09.13
 *         Time: 19:57
 */
public class StickRotationManager implements RotationManager {

    private class VerticalComparator implements Comparator<Cell> {

        @Override
        public int compare(Cell o1, Cell o2) {
            return o1.getJ() > o2.getJ() ? 1 : o1.getJ() == o2.getJ() ? 0 : -1;
        }
    }

    private class HorizontalComparator implements Comparator<Cell> {

        @Override
        public int compare(Cell o1, Cell o2) {
            return o1.getI() > o2.getI() ? 1 : o1.getI() == o2.getI() ? 0 : -1;
        }
    }

    /**
     * Rotates the figure.
     *
     * @param figure The figure to rotate.
     * @param field  The Field.
     */
    public void rotate(Figure figure, Field field) {
        if (figure instanceof Stick) {
            rotateStick(figure, field);
        }
    }

    private void rotateStick(Figure figure, Field field) {
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        RotationState state = figure.getRotationState();
        if (state == RotationState.HORIZONTAL && isPossibleToRotateStickVertically(figure, field)) {
            Cell first = cells.get(0);
            data[first.getI()][first.getJ()] = new Cell(first.getI(), first.getJ(), Field.ZERO);
            data[first.getI() - 1][first.getJ() + 1] = new Cell(first.getI() - 1, first.getJ() + 1, Field.ONE);
            first.setI(first.getI() - 1);
            first.setJ(first.getJ() + 1);

            Cell third = cells.get(2);
            data[third.getI()][third.getJ()] = new Cell(third.getI(), third.getJ(), Field.ZERO);
            data[third.getI() + 1][third.getJ() - 1] = new Cell(third.getI() + 1, third.getJ() - 1, Field.ONE);
            third.setI(third.getI() + 1);
            third.setJ(third.getJ() - 1);

            Cell fourth = cells.get(3);
            data[fourth.getI()][fourth.getJ()] = new Cell(fourth.getI(), fourth.getJ(), Field.ZERO);
            data[fourth.getI() + 2][fourth.getJ() - 2] = new Cell(fourth.getI() + 2, fourth.getJ() - 2, Field.ONE);
            fourth.setI(fourth.getI() + 2);
            fourth.setJ(fourth.getJ() - 2);

            figure.setRotationState(RotationState.VERTICAL);
        } else if (state == RotationState.VERTICAL && isPossibleToRotateStickHorizontally(figure, field)) {
            Cell first = cells.get(0);
            data[first.getI()][first.getJ()] = new Cell(first.getI(), first.getJ(), Field.ZERO);
            data[first.getI() + 1][first.getJ() - 1] = new Cell(first.getI() + 1, first.getJ() - 1, Field.ONE);
            first.setI(first.getI() + 1);
            first.setJ(first.getJ() - 1);

            Cell third = cells.get(2);
            data[third.getI()][third.getJ()] = new Cell(third.getI(), third.getJ(), Field.ZERO);
            data[third.getI() - 1][third.getJ() + 1] = new Cell(third.getI() - 1, third.getJ() + 1, Field.ONE);
            third.setI(third.getI() - 1);
            third.setJ(third.getJ() + 1);

            Cell fourth = cells.get(3);
            data[fourth.getI()][fourth.getJ()] = new Cell(fourth.getI(), fourth.getJ(), Field.ZERO);
            data[fourth.getI() - 2][fourth.getJ() + 2] = new Cell(fourth.getI() - 2, fourth.getJ() + 2, Field.ONE);
            fourth.setI(fourth.getI() - 2);
            fourth.setJ(fourth.getJ() + 2);

            figure.setRotationState(RotationState.HORIZONTAL);
        }
    }

    private boolean isPossibleToRotateStickHorizontally(Figure figure, Field field) {
        boolean canRotate = true;
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        Collections.sort(cells, new VerticalComparator());

        Cell first = cells.get(0);
        if (first.getJ() == 0 || data[first.getI()][first.getJ() - 1].getData() == Field.ONE) {
            canRotate = false;
        }

        Cell third = cells.get(2);
        if (third.getJ() >= 8 || data[first.getI()][first.getJ() + 1].getData() == Field.ONE) {
            canRotate = false;
        }

        Cell fourth = cells.get(3);
        if (fourth.getJ() >= 8 || data[first.getI()][first.getJ() + 2].getData() == Field.ONE) {
            canRotate = false;
        }
        return canRotate;
    }

    private boolean isPossibleToRotateStickVertically(Figure figure, Field field) {
        boolean canRotate = true;
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();
        Collections.sort(cells, new HorizontalComparator());

        Cell third = cells.get(2);
        if (third.getI() >= 18 || data[third.getI() + 1][third.getJ()].getData() == Field.ONE) {
            canRotate = false;
        }

        Cell fourth = cells.get(3);
        if (fourth.getI() >= 18 || data[fourth.getI() + 2][fourth.getJ()].getData() == Field.ONE) {
            canRotate = false;
        }

        return canRotate;
    }
}
