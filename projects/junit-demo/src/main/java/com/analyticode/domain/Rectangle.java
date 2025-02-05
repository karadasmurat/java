package com.analyticode.domain;

public class Rectangle {

    private int width;
    private int height;

    public Rectangle(int w, int h) {
        if (w <= 0 || h <= 0)
            throw new IllegalArgumentException("Dimensions should be greater than zero.");
        width = w;
        height = h;
    }

    public int getArea() {
        return width * height;
    }

}
