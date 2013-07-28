package com.udev.domain;

import com.udev.domain.figures.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 04.05.13
 *         Time: 17:47
 */
public class Field {

    /** Left coordinate of the figure when it is added on the field. */
    public static final int CREATE_FIGURE_LEFT_COORDINATE = 4;

    /** Height of the field. */
    public static final int HEIGHT = 10;

    /** Width of the field. */
    public static final int WIDTH = 20;

    /** Initial value of the field is 0 (empty). */
    private static final byte INIT_VALUE = 0;

    /** Logger. **/
    private static final Logger logger = LoggerFactory.getLogger(Field.class);

    /** Is set to {@code true} when there is enough space to create a new figure. */
    private boolean hasSpace = true;

    /**
     * Is set to {@code true} when it is possible to move the figure.
     * When it is {@code false}, the new figure will be created.
     */
    private boolean possibleMoveFigure = false;

    /** Data of the field. */
    private Cell[][] cells = new Cell[WIDTH][HEIGHT];


    /**
     * Constructor.
     */
    public Field() {
        init();
    }

    /**
     *
     * @return
     */
    public Cell[][] getCells() {
        return cells;
    }

    /**
     *
     * @param cells
     */
    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    /**
     * @return {@code true} when it is possible to move the figure.
     */
    public boolean isPossibleMoveFigure() {
        return possibleMoveFigure;
    }

    /**
     * Indicates if it is possible to create a new figure.
     * When the field is full, the game is over.
     *
     * @return <code>true</code> if there is enough space to create a new figure.
     */
    public boolean isNotFull() {
        return hasSpace;
    }

    /**
     * Logs the current state of the data
     */
    public void showData() {
        logger.debug("\n\n The data:");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                sb.append(cells[i][j].getData() + " ");
            }
            sb.append("\n");
        }
        logger.debug("\n" + sb.toString());
    }

    /**
     * Clears the com.udev.field
     */
    private void clear() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Cell cell =  cells[i][j];
                cell.setI(i);
                cell.setJ(j);
                cell.setData(INIT_VALUE);
            }
        }
    }

    /**
     * Initialize the cells
     */
    private void init() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Cell cell =  new Cell();
                cell.setI(i);
                cell.setJ(j);
                cell.setData(INIT_VALUE);
                cells[i][j] = cell;
            }
        }
    }
}
