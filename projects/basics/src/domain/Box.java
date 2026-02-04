package domain;

class Box {
    int value;

    public Box(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box(value=" + value + ")";
    }
}
