package com.udev.process;

import com.udev.domain.Field;
import com.udev.domain.figures.Cell;
import com.udev.domain.figures.Cube;
import com.udev.domain.figures.Figure;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 28.07.13
 *         Time: 22:19
 */
public class FigureActionManagerTest {

    private static final byte ONE = 1;
    private static final byte ZERO = 0;
    private FigureActionManager manager;
    private Field field = new Field();

    @Before
    public void setUp() {
        this.manager = new FigureActionManager();
    }

    @After
    public void tearDown() {
        this.manager = null;
        this.field.clear();
    }

    @Test
    public void addFigureToFieldTest_hp() {
        assertNotNull(this.manager.getCreator(0));
    }

    @Test
    public void moveDownwardsTest_figureIsCreated_move() {
        // given
        Figure cube = new Cube();
        this.manager.addFigureToField(cube, field);

        Cell first = new Cell();
        first.setData(ONE);
        first.setI(1);
        first.setJ(4);
        Cell second = new Cell();
        second.setData(ONE);
        second.setI(1);
        second.setJ(5);
        Cell third = new Cell();
        third.setData(ONE);
        third.setI(2);
        third.setJ(4);
        Cell fourth = new Cell();
        fourth.setData(ONE);
        fourth.setI(2);
        fourth.setJ(5);
        List<Cell> expected = new ArrayList<>(4);
        expected.add(first);
        expected.add(second);
        expected.add(third);
        expected.add(fourth);

        // do
        this.manager.moveFigure(cube, field, FigureActionManager.Move.DOWN);

        // verify
        List<Cell> figureData = cube.getCells();
        assertNotNull(figureData);
        assertEquals(4, figureData.size());
        assertTrue(figureData.containsAll(expected));

        int size = 0;
        for (int i = 0; i < Field.WIDTH; i++) {
            for (int j = 0; j < Field.HEIGHT; j++) {
                Cell cell =  this.field.getCells()[i][j];
                if (expected.contains(cell)) {
                    size++;
                }
                else {
                    assertFalse(cell.getData() == ONE);
                    assertFalse(cell.getI() == 1 && cell.getJ() == 4);
                    assertFalse(cell.getI() == 1 && cell.getJ() == 5);
                    assertFalse(cell.getI() == 2 && cell.getJ() == 4);
                    assertFalse(cell.getI() == 2 && cell.getJ() == 5);
                }
            }
        }
        Cell[][] data = this.field.getCells();
        assertTrue(data[0][4].getData() == ZERO);
        assertTrue(data[0][5].getData() == ZERO);
        assertTrue(this.field.isNotFull());
        assertTrue(this.field.isPossibleMoveFigure());
    }

    @Test
    public void moveDownwardsTest_figureIsInMiddle_move() {
        // given
        Figure cube = new Cube();

        // initial
        Cell firstBefore = new Cell();
        firstBefore.setData(ONE);
        firstBefore.setI(7);
        firstBefore.setJ(4);
        Cell secondBefore = new Cell();
        secondBefore.setData(ONE);
        secondBefore.setI(7);
        secondBefore.setJ(5);
        Cell thirdBefore = new Cell();
        thirdBefore.setData(ONE);
        thirdBefore.setI(8);
        thirdBefore.setJ(4);
        Cell fourthBefore = new Cell();
        fourthBefore.setData(ONE);
        fourthBefore.setI(8);
        fourthBefore.setJ(5);
        List<Cell> initial = new ArrayList<>(4);
        initial.add(firstBefore);
        initial.add(secondBefore);
        initial.add(thirdBefore);
        initial.add(fourthBefore);
        cube.setCells(initial);
        Cell [][] cells = field.getCells();
        cells[7][4] = firstBefore;
        cells[7][5] = secondBefore;
        cells[8][4] = thirdBefore;
        cells[8][5] = fourthBefore;


        Cell first = new Cell();
        first.setData(ONE);
        first.setI(8);
        first.setJ(4);
        Cell second = new Cell();
        second.setData(ONE);
        second.setI(8);
        second.setJ(5);
        Cell third = new Cell();
        third.setData(ONE);
        third.setI(9);
        third.setJ(4);
        Cell fourth = new Cell();
        fourth.setData(ONE);
        fourth.setI(9);
        fourth.setJ(5);
        List<Cell> expected = new ArrayList<>(4);
        expected.add(first);
        expected.add(second);
        expected.add(third);
        expected.add(fourth);

        // do
        this.manager.moveFigure(cube, field, FigureActionManager.Move.DOWN);

        // verify
        List<Cell> figureData = cube.getCells();
        assertNotNull(figureData);
        assertEquals(4, figureData.size());
        assertTrue(figureData.containsAll(expected));

        int size = 0;
        for (int i = 0; i < Field.WIDTH; i++) {
            for (int j = 0; j < Field.HEIGHT; j++) {
                Cell cell =  this.field.getCells()[i][j];
                if (expected.contains(cell)) {
                    size++;
                }
                else {
                    assertFalse(cell.getData() == ONE);
                    assertFalse(cell.getI() == 8 && cell.getJ() == 4);
                    assertFalse(cell.getI() == 8 && cell.getJ() == 5);
                    assertFalse(cell.getI() == 9 && cell.getJ() == 4);
                    assertFalse(cell.getI() == 9 && cell.getJ() == 5);
                }
            }
        }
        Cell[][] data = this.field.getCells();
        assertTrue(data[7][4].getData() == ZERO);
        assertTrue(data[7][5].getData() == ZERO);
        assertTrue(this.field.isNotFull());
        assertTrue(this.field.isPossibleMoveFigure());
    }

    @Test
    public void moveDownwardsTest_figureIsAtMiddle_cannotMove() {
        // given
        Figure cube = new Cube();

        // initial
        Cell firstBefore = new Cell();
        firstBefore.setData(ONE);
        firstBefore.setI(7);
        firstBefore.setJ(4);
        Cell secondBefore = new Cell();
        secondBefore.setData(ONE);
        secondBefore.setI(7);
        secondBefore.setJ(5);
        Cell thirdBefore = new Cell();
        thirdBefore.setData(ONE);
        thirdBefore.setI(8);
        thirdBefore.setJ(4);
        Cell fourthBefore = new Cell();
        fourthBefore.setData(ONE);
        fourthBefore.setI(8);
        fourthBefore.setJ(5);
        List<Cell> initial = new ArrayList<>(4);
        initial.add(firstBefore);
        initial.add(secondBefore);
        initial.add(thirdBefore);
        initial.add(fourthBefore);
        cube.setCells(initial);
        Cell [][] cells = field.getCells();
        cells[7][4] = firstBefore;
        cells[7][5] = secondBefore;
        cells[8][4] = thirdBefore;
        cells[8][5] = fourthBefore;

        for (int i = 8; i < Field.WIDTH; i++) {
            for (int j = 0; j < Field.HEIGHT; j++) {
                Cell cell =  this.field.getCells()[i][j];
                cell.setData(ONE);
                cell.setI(i);
                cell.setJ(j);
            }
        }

        // do
        this.manager.moveFigure(cube, field, FigureActionManager.Move.DOWN);

        // verify
        List<Cell> figureData = cube.getCells();
        assertNotNull(figureData);
        assertEquals(4, figureData.size());
        assertFalse(figureData.containsAll(initial));

        Cell[][] afterData = this.field.getCells();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < Field.HEIGHT; j++) {
                Cell cell =  this.field.getCells()[i][j];
                assertEquals(ZERO, cell.getData());
            }
        }
        for (int i = 8; i < Field.HEIGHT; i++) {
            for (int j = 0; j < Field.HEIGHT; j++) {
                Cell cell =  this.field.getCells()[i][j];
                assertEquals(ONE, cell.getData());
            }
        }
        assertFalse(this.field.isNotFull());
        assertFalse(this.field.isPossibleMoveFigure());
    }

    @Test
    public void moveDownwardsTest_figureIsAtBottom_cannotMove() {
        // given
        Figure cube = new Cube();

        // initial
        Cell firstBefore = new Cell();
        firstBefore.setData(ONE);
        firstBefore.setI(7);
        firstBefore.setJ(4);
        Cell secondBefore = new Cell();
        secondBefore.setData(ONE);
        secondBefore.setI(7);
        secondBefore.setJ(5);
        Cell thirdBefore = new Cell();
        thirdBefore.setData(ONE);
        thirdBefore.setI(8);
        thirdBefore.setJ(4);
        Cell fourthBefore = new Cell();
        fourthBefore.setData(ONE);
        fourthBefore.setI(8);
        fourthBefore.setJ(5);
        List<Cell> initial = new ArrayList<>(4);
        initial.add(firstBefore);
        initial.add(secondBefore);
        initial.add(thirdBefore);
        initial.add(fourthBefore);
        cube.setCells(initial);
        Cell [][] cells = field.getCells();
        cells[18][4] = firstBefore;
        cells[18][5] = secondBefore;
        cells[19][4] = thirdBefore;
        cells[19][5] = fourthBefore;

        // do
        this.manager.moveFigure(cube, field, FigureActionManager.Move.DOWN);

        assertFalse(this.field.isNotFull());
        assertFalse(this.field.isPossibleMoveFigure());
    }
}
