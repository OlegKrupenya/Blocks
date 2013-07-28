package com.udev.domain.figures;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 28.07.13
 *         Time: 22:38
 */
public class CubeTest {

    private Figure cube;

    @Before
    public void setUp() {
        this.cube = new Cube();
    }

    @After
    public void tearDown() {
        this.cube = null;
    }

    @Test
    public void initTest_hp() {
        assertEquals(2, cube.getHeight());
        assertEquals(2, cube.getWidth());
        assertEquals(4, cube.getLeftBorder());
    }
}
