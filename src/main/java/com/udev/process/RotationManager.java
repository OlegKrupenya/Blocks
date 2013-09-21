package com.udev.process;

import com.udev.domain.Cell;
import com.udev.domain.Field;
import com.udev.domain.figures.Figure;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 21.09.13
 *         Time: 19:57
 */
public class RotationManager {

    /**
     * Rotates the figure.
     * @param figure The figure to rotate.
     * @param field  The Field.
     */
    public void rotate(Figure figure, Field field) {

    }

    private void rotateStick(Figure figure, Field field) {

    }

    private boolean isPossibleToRotateStick(Figure figure, Field field) {
        boolean canRotate = true;
        Cell[][] data = field.getCells();
        List<Cell> cells = figure.getCells();

        return canRotate;
    }

}
