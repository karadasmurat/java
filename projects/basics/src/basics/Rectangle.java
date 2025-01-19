package basics;

public class Rectangle {

    private int width;
    private int height;

    public Rectangle(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int getArea() {
        return this.width * this.height;
    }

}
