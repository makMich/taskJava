package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPentagon {

    private static final double DOUBLE_EPS = 1E-6;
    @Test
    public void testPentagon() {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(20, 10);
        Point point3 = new Point(40, 20);
        Point point4 = new Point(50, 50);
        Point point5 = new Point(30, 60);
        Pentagon pentagon = new Pentagon(point1, point2, point3, point4, point5);
        assertAll(
                () -> assertEquals(10, pentagon.getPoint1().getX()),
                () -> assertEquals(20, pentagon.getPoint1().getY()),
                () -> assertEquals(20, pentagon.getPoint2().getX()),
                () -> assertEquals(10, pentagon.getPoint2().getY()),
                () -> assertEquals(40, pentagon.getPoint3().getX()),
                () -> assertEquals(20, pentagon.getPoint3().getY()),
                () -> assertEquals(50, pentagon.getPoint4().getX()),
                () -> assertEquals(50, pentagon.getPoint4().getY()),
                () -> assertEquals(30, pentagon.getPoint5().getX()),
                () -> assertEquals(60, pentagon.getPoint5().getY()),
                () -> assertEquals(1100, pentagon.getArea()),
                () -> assertEquals(135.207631, pentagon.getPerimeter(), DOUBLE_EPS)
        );
    }

    @Test
    public void testMovePentagon() {
        Pentagon pentagon = new Pentagon(new Point(10, 20), new Point(20, 10), new Point(40, 20),
                new Point(50, 50), new Point(30, 60));
        pentagon.moveRel(25, 45);
        assertAll(
                () -> assertEquals(35, pentagon.getPoint1().getX()),
                () -> assertEquals(65, pentagon.getPoint1().getY()),
                () -> assertEquals(45, pentagon.getPoint2().getX()),
                () -> assertEquals(55, pentagon.getPoint2().getY()),
                () -> assertEquals(65, pentagon.getPoint3().getX()),
                () -> assertEquals(65, pentagon.getPoint3().getY()),
                () -> assertEquals(75, pentagon.getPoint4().getX()),
                () -> assertEquals(95, pentagon.getPoint4().getY()),
                () -> assertEquals(55, pentagon.getPoint5().getX()),
                () -> assertEquals(105, pentagon.getPoint5().getY())
        );
        pentagon.moveTo(10, 20);
        assertAll(
                () -> assertEquals(10, pentagon.getPoint1().getX()),
                () -> assertEquals(20, pentagon.getPoint1().getY()),
                () -> assertEquals(20, pentagon.getPoint2().getX()),
                () -> assertEquals(10, pentagon.getPoint2().getY()),
                () -> assertEquals(40, pentagon.getPoint3().getX()),
                () -> assertEquals(20, pentagon.getPoint3().getY()),
                () -> assertEquals(50, pentagon.getPoint4().getX()),
                () -> assertEquals(50, pentagon.getPoint4().getY()),
                () -> assertEquals(30, pentagon.getPoint5().getX()),
                () -> assertEquals(60, pentagon.getPoint5().getY())
        );
        pentagon.moveTo(new Point(100, 200));
        assertAll(
                () -> assertEquals(100, pentagon.getPoint1().getX()),
                () -> assertEquals(200, pentagon.getPoint1().getY()),
                () -> assertEquals(110, pentagon.getPoint2().getX()),
                () -> assertEquals(190, pentagon.getPoint2().getY()),
                () -> assertEquals(130, pentagon.getPoint3().getX()),
                () -> assertEquals(200, pentagon.getPoint3().getY()),
                () -> assertEquals(140, pentagon.getPoint4().getX()),
                () -> assertEquals(230, pentagon.getPoint4().getY()),
                () -> assertEquals(120, pentagon.getPoint5().getX()),
                () -> assertEquals(240, pentagon.getPoint5().getY())
        );
    }

    @Test
    public void testIsPointInsidePentagon1() {
        Pentagon pentagon = new Pentagon(new Point(10, 20), new Point(20, 10), new Point(40, 20),
                new Point(50, 50), new Point(30, 60));
        assertAll(
                () -> assertFalse(pentagon.isInside(10, 20)),
                () -> assertFalse(pentagon.isInside(0, 0)),
                () -> assertFalse(pentagon.isInside(100, 200)),
                () -> assertTrue(pentagon.isInside(15, 25)),
                () -> assertTrue(pentagon.isInside(45, 45)),
                () -> assertTrue(pentagon.isInside(40, 30))
        );
    }

    @Test
    public void testIsPointInsidePentagon2() {
        Pentagon pentagon = new Pentagon(new Point(10, 20), new Point(20, 10), new Point(40, 20),
                new Point(50, 50), new Point(30, 60));
        assertAll(
                () -> assertFalse(pentagon.isInside(new Point(10, 20))),
                () -> assertFalse(pentagon.isInside(new Point(0, 0))),
                () -> assertFalse(pentagon.isInside(new Point(100, 200))),
                () -> assertTrue(pentagon.isInside(new Point(15, 25))),
                () -> assertTrue(pentagon.isInside(new Point(45, 45))),
                () -> assertTrue(pentagon.isInside(new Point(40, 30)))
        );
    }

    @Test
    public void testResizePentagon() {
        Pentagon pentagon = new Pentagon(new Point(10, 20), new Point(20, 10), new Point(40, 20),
                new Point(50, 50), new Point(30, 60));
        pentagon.resize(3);
        assertAll(
                () -> assertEquals(10, pentagon.getPoint1().getX()),
                () -> assertEquals(20, pentagon.getPoint1().getY()),
                () -> assertEquals(40, pentagon.getPoint2().getX()),
                () -> assertEquals(-10, pentagon.getPoint2().getY()),
                () -> assertEquals(100, pentagon.getPoint3().getX()),
                () -> assertEquals(20, pentagon.getPoint3().getY()),
                () -> assertEquals(140, pentagon.getPoint4().getX()),
                () -> assertEquals(110, pentagon.getPoint4().getY()),
                () -> assertEquals(80, pentagon.getPoint5().getX()),
                () -> assertEquals(140, pentagon.getPoint5().getY())
        );
    }
}
