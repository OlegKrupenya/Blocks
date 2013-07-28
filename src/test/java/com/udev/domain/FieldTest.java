package com.udev.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 28.07.13
 *         Time: 22:22
 */
public class FieldTest {

    private Field field;

    @Before
    public void setUp() {
        this.field = new Field();
    }

    @After
    public void tearDown() {
        this.field = null;
    }

    @Test
    public void initTest_hp() {
        assertFalse(this.field.isPossibleMoveFigure());
        assertTrue(this.field.isNotFull());
    }
}
