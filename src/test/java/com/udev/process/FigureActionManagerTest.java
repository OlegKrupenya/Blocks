package com.udev.process;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 28.07.13
 *         Time: 22:19
 */
public class FigureActionManagerTest {

    private FigureActionManager manager;

    @Before
    public void setUp() {
        this.manager = new FigureActionManager();
    }

    @After
    public void tearDown() {
        this.manager = null;
    }

    @Test
    public void addFigureToFieldTest_hp() {
        Assert.assertNotNull(this.manager.getCreator(0));
    }
}
