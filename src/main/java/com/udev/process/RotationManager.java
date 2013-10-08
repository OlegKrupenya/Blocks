package com.udev.process;

import com.udev.domain.Field;
import com.udev.domain.figures.Figure;

/**
 * User: oleg.krupenya
 * Date: 10/8/13
 * Time: 7:54 PM
 */
public interface RotationManager {
    /**
     * Rotates the figure.
     * @param figure The figure to rotate.
     * @param field  The Field.
     */
    public void rotate(Figure figure, Field field);
}
