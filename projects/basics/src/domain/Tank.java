package domain;

public class Tank {

    private int level;

    public Tank(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        if (level < 0)
            this.level = 0;

        this.level = level;
    }
}
