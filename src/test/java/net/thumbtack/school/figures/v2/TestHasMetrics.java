package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.HasMetrics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHasMetrics {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testCompareArea1() {
        HasMetrics rect1 = new Rectangle(0, 0, 10, 10);
        HasMetrics rect2 = new Rectangle(10, 10, 20, 20);
        assertEquals(rect1.getArea(), rect2.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testCompareArea2() {
        HasMetrics rect1 = new Rectangle(0, 0, 10, 10);
        HasMetrics rect2 = new ColoredRectangle(0, 0, 10, 10, 1);
        assertEquals(rect1.getArea(), rect2.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testComparePerimeter1() {
        HasMetrics rect1 = new Rectangle(0, 0, 10, 10);
        HasMetrics rect2 = new Rectangle(10, 10, 20, 20);
        assertEquals(rect1.getPerimeter(), rect2.getPerimeter(), DOUBLE_EPS);
    }

    @Test
    public void testComparePerimeter2() {
        HasMetrics rect1 = new Rectangle(0, 0, 10, 10);
        HasMetrics rect2 = new ColoredRectangle(0, 0, 10, 10, 1);
        assertEquals(rect1.getPerimeter(), rect2.getPerimeter(), DOUBLE_EPS);
    }
}
