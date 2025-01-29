package domain;

public class Rectangle {

    private int width;
    private int height;

    public Rectangle(int w, int h) {
        width = w;
        height = h;
    }

    public int getArea() {
        return width * height;
    }

}
