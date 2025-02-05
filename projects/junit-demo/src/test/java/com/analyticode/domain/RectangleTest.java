package com.analyticode.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    private Rectangle rect;

    @Test
    public void construct() {

        // Exception Testing
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle rect = new Rectangle(-1, 10);
        });
    }

    @Test
    public void calculateArea5_10() {
        Rectangle rect = new Rectangle(5, 10);
        assertEquals(50, rect.getArea());
    }

    @Test
    public void simpleNullCheck() {
        Rectangle rect = new Rectangle(5, 10);
        assertNotNull(rect);
    }

}
