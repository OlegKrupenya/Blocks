package com.udev.figures;

/**
 * Created with IntelliJ IDEA.
 *
 * @author taipan
 *         Date: 04.05.13
 *         Time: 17:42
 */
public interface Figure {
    public int[][] getData();
    public int getLeftBorder();
    public int getWidth();
    public int getHeight();
    public void setWidth(int width);
    public void setHeight(int height);
    public void setData(int[][] data);
}
