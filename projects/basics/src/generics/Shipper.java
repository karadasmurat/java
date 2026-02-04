package generics;

import domain.Package;

// T is a placeholder for a specific type of Package
public interface Shipper<T extends Package> {
    void ship(T p);
}

class BoxShipper implements Shipper<Package.Box> {
    @Override
    public void ship(Package.Box box) {
        // No 'instanceof' needed! The compiler guarantees 'box' is a Box.
        System.out.println("Weight: " + box.getWeight());
    }
}

class EnvelopeShipper implements Shipper<Package.Envelope> {
    @Override
    public void ship(Package.Envelope env) {
        System.out.println("Padded: " + env.isPadded());
    }
}
