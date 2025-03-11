package domain;

public class Rectangle extends Shape2D {

    private double width;
    private double height;

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

}
