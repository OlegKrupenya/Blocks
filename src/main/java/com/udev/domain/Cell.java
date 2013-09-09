package com.udev.domain;

/**
 * The Cell consists of its coordinates on the field and the data: 1(not empty) or 0 (empty)
 * <p/>
 * @author taipan
 */
public class Cell {
    /**
     * Left index in the field.
     */
    private int i;

    /**
     * Upper index in the field.
     */
    private int j;

    /**
     * 1 - not empty, 0 - empty.
     */
    private byte data;

    /**
     * Constructor.
     */
    public Cell() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (data != cell.data) return false;
        if (i != cell.i) return false;
        if (j != cell.j) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        result = 31 * result + (int) data;
        return result;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "i=" + i +
                ", j=" + j +
                ", data=" + data +
                '}';
    }

    /**
     * @return  Left index in the field.
     */
    public int getI() {
        return i;
    }

    /**
     * Sets the left index in the field.
     * @param i Left index in the field.
     */
    public void setI(int i) {
        this.i = i;
    }

    /**
     *
     * @return Upper index in the field.
     */
    public int getJ() {
        return j;
    }

    /**
     * Sets the upper index in the field.
     * @param j Upper index in the field.
     */
    public void setJ(int j) {
        this.j = j;
    }

    /**
     *
     * @return 1 - not empty, 0 - empty.
     */
    public byte getData() {
        return data;
    }

    /**
     * Sets the data. 1 - not empty, 0 - empty.
     * @param data The data to set.
     */
    public void setData(byte data) {
        if (data != 0 && data != 1) {
            throw new IllegalArgumentException("The data can be either 0 or 1.");
        }
        this.data = data;
    }

}
