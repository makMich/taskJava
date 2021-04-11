package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestColoredTriangle {
    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void TestColoredTriangle1() {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30, 10);
        Point point3 = new Point(20, 30);
        ColoredTriangle coloredTriangle = new ColoredTriangle(point1, point2, point3, 1);
        assertAll(
                () -> assertEquals(10, coloredTriangle.getPoint1().getX()),
                () -> assertEquals(20, coloredTriangle.getPoint1().getY()),
                () -> assertEquals(30, coloredTriangle.getPoint2().getX()),
                () -> assertEquals(10, coloredTriangle.getPoint2().getY()),
                () -> assertEquals(20, coloredTriangle.getPoint3().getX()),
                () -> assertEquals(30, coloredTriangle.getPoint3().getY()),
                () -> assertEquals(150, coloredTriangle.getArea()),
                () -> assertEquals(58.863495, coloredTriangle.getPerimeter(), DOUBLE_EPS),
                () -> assertEquals(1, coloredTriangle.getColor())
        );
    }

    @Test
    public void TestColoredTriangle2() {
        ColoredTriangle coloredTriangle = new ColoredTriangle(10, 20, 30, 10, 20, 30, 1);
        assertAll(
                () -> assertEquals(10, coloredTriangle.getPoint1().getX()),
                () -> assertEquals(20, coloredTriangle.getPoint1().getY()),
                () -> assertEquals(30, coloredTriangle.getPoint2().getX()),
                () -> assertEquals(10, coloredTriangle.getPoint2().getY()),
                () -> assertEquals(20, coloredTriangle.getPoint3().getX()),
                () -> assertEquals(30, coloredTriangle.getPoint3().getY()),
                () -> assertEquals(150, coloredTriangle.getArea()),
                () -> assertEquals(58.863495, coloredTriangle.getPerimeter(), DOUBLE_EPS),
                () -> assertEquals(1, coloredTriangle.getColor())
        );
    }


    @Test
    public void testMoveColoredTriangle() {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30, 10);
        Point point3 = new Point(20, 30);
        ColoredTriangle coloredTriangle = new ColoredTriangle(point1, point2, point3, 2);
        coloredTriangle.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, coloredTriangle.getPoint1().getX()),
                () -> assertEquals(70, coloredTriangle.getPoint1().getY()),
                () -> assertEquals(130, coloredTriangle.getPoint2().getX()),
                () -> assertEquals(60, coloredTriangle.getPoint2().getY()),
                () -> assertEquals(120, coloredTriangle.getPoint3().getX()),
                () -> assertEquals(80, coloredTriangle.getPoint3().getY())
        );

        coloredTriangle.moveTo(50, 20);
        assertAll(
                () -> assertEquals(50, coloredTriangle.getPoint1().getX()),
                () -> assertEquals(20, coloredTriangle.getPoint1().getY()),
                () -> assertEquals(70, coloredTriangle.getPoint2().getX()),
                () -> assertEquals(10, coloredTriangle.getPoint2().getY()),
                () -> assertEquals(60, coloredTriangle.getPoint3().getX()),
                () -> assertEquals(30, coloredTriangle.getPoint3().getY())
        );

        coloredTriangle.moveTo(new Point(1110, 1070));
        assertAll(
                () -> assertEquals(1110, coloredTriangle.getPoint1().getX()),
                () -> assertEquals(1070, coloredTriangle.getPoint1().getY()),
                () -> assertEquals(1130, coloredTriangle.getPoint2().getX()),
                () -> assertEquals(1060, coloredTriangle.getPoint2().getY()),
                () -> assertEquals(1120, coloredTriangle.getPoint3().getX()),
                () -> assertEquals(1080, coloredTriangle.getPoint3().getY())
        );
    }

    @Test
    public void testIsPointInsideColoredTriangle() {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30, 10);
        Point point3 = new Point(20, 30);
        ColoredTriangle coloredTriangle = new ColoredTriangle(point1, point2, point3, 1);
        assertAll(
                () -> assertTrue(coloredTriangle.isInside(new Point(20, 25))),
                () -> assertTrue(coloredTriangle.isInside(new Point(20, 20))),
                () -> assertTrue(coloredTriangle.isInside(new Point(15, 20))),
                () -> assertFalse(coloredTriangle.isInside(new Point(30, 30))),
                () -> assertFalse(coloredTriangle.isInside(new Point(0, 0))),
                () -> assertFalse(coloredTriangle.isInside(new Point(100, -100)))
        );
    }


}
