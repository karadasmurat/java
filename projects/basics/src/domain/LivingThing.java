package domain;

import java.time.LocalDate;

/**
 * Abstract base class for all living things.
 */
public abstract class LivingThing {

    private String name;
    private LocalDate birthDate;
    private boolean isAlive;

    public LivingThing(String name) {
        this.name = name;
    }

    public abstract LivingThing reproduce();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "LivingThing(" + name + ")";
    }

}
