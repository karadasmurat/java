//change v1
package classes.abstracts;

import interfaces.Flyable;

public abstract class Bird implements Flyable {

}

class Swan extends Bird {

    @Override
    public void fly() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fly'");
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

}
