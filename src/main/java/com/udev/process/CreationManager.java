package com.udev.process;

import com.udev.factory.*;

/**
 * Created with IntelliJ IDEA.
 * User: taipan
 * Date: 06.10.13
 * Time: 14:59
 * To change this template use File | Settings | File Templates.
 */
public class CreationManager {
    /**
     * Creator that creates cubes.
     */
    private FigureCreator cubeCreator = new CubeCreator();

    /**
     * Creator that creates {@link com.udev.domain.figures.LFigure}
     */
    private FigureCreator lFigureCreator = new LFigureCreator();

    /**
     * Creator that creates {@link com.udev.domain.figures.ReverseLFigure}
     */
    private FigureCreator reverseLFigureCreator = new ReverseLFigureCreator();

    /**
     * Creator that creates {@link com.udev.domain.figures.SFigure}
     */
    private FigureCreator sFigureCreator = new SFigureCreator();

    /**
     * Creator that creates {@link com.udev.domain.figures.TFigure}
     */
    private FigureCreator tFigureCreator = new TFigureCreator();

    /**
     * Creator that creates sticks.
     */
    private FigureCreator stickCreator = new StickCreator();

    /**
     * Creator that creates {@link com.udev.domain.figures.ZFigure}
     */
    private FigureCreator zFigureCreator = new ZFigureCreator();

    /**
     * Returns creator by index.
     * 0 - {@link CubeCreator},
     * 1 - {@link LFigureCreator}
     * TODO: Add others creators to this JavaDoc
     *
     * @param index Index to get creator.
     * @return Creator of the figure.
     */
    protected FigureCreator getCreator(int index) {
        FigureCreator creator;
        switch (index) {
            case 0: {
                creator = cubeCreator;
                break;
            }
            case 1: {
                creator = lFigureCreator;
                break;
            }
            case 2: {
                creator = reverseLFigureCreator;
                break;
            }
            case 3: {
                creator = tFigureCreator;
                break;
            }
            case 4: {
                creator = zFigureCreator;
                break;
            }
            case 5: {
                creator = sFigureCreator;
                break;
            }
            default: {
                creator = stickCreator;
            }
        }
        return creator;
    }
}
