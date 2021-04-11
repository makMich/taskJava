package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.Point;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestColoredTriangle {
    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void TestColoredTriangle1() throws ColorException {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30, 10);
        Point point3 = new Point(20, 30);
        ColoredTriangle coloredTriangle = new ColoredTriangle(point1, point2, point3, Color.RED);
        assertAll(
                () -> assertEquals(10, coloredTriangle.getPoint1().getX()),
                () -> assertEquals(20, coloredTriangle.getPoint1().getY()),
                () -> assertEquals(30, coloredTriangle.getPoint2().getX()),
                () -> assertEquals(10, coloredTriangle.getPoint2().getY()),
                () -> assertEquals(20, coloredTriangle.getPoint3().getX()),
                () -> assertEquals(30, coloredTriangle.getPoint3().getY()),
                () -> assertEquals(150, coloredTriangle.getArea()),
                () -> assertEquals(58.863495, coloredTriangle.getPerimeter(), DOUBLE_EPS),
                () -> assertEquals(Color.RED, coloredTriangle.getColor())
        );
        coloredTriangle.setColor(Color.RED);
        assertEquals(Color.RED, coloredTriangle.getColor());
        coloredTriangle.setColor("BLUE");
        assertEquals(Color.BLUE, coloredTriangle.getColor());
    }

    @Test
    public void TestColoredTriangle2() throws ColorException {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30, 10);
        Point point3 = new Point(20, 30);
        ColoredTriangle coloredTriangle = new ColoredTriangle(point1, point2, point3, "GREEN");
        assertAll(
                () -> assertEquals(10, coloredTriangle.getPoint1().getX()),
                () -> assertEquals(20, coloredTriangle.getPoint1().getY()),
                () -> assertEquals(30, coloredTriangle.getPoint2().getX()),
                () -> assertEquals(10, coloredTriangle.getPoint2().getY()),
                () -> assertEquals(20, coloredTriangle.getPoint3().getX()),
                () -> assertEquals(30, coloredTriangle.getPoint3().getY()),
                () -> assertEquals(150, coloredTriangle.getArea()),
                () -> assertEquals(58.863495, coloredTriangle.getPerimeter(), DOUBLE_EPS),
                () -> assertEquals(Color.GREEN, coloredTriangle.getColor())
        );
        coloredTriangle.setColor(Color.RED);
        assertEquals(Color.RED, coloredTriangle.getColor());
        coloredTriangle.setColor("BLUE");
        assertEquals(Color.BLUE, coloredTriangle.getColor());
    }

    @Test
    public void TestColoredTriangle3() throws ColorException {
        ColoredTriangle coloredTriangle = new ColoredTriangle(10, 20, 30, 10, 20, 30, Color.RED);
        assertAll(
                () -> assertEquals(10, coloredTriangle.getPoint1().getX()),
                () -> assertEquals(20, coloredTriangle.getPoint1().getY()),
                () -> assertEquals(30, coloredTriangle.getPoint2().getX()),
                () -> assertEquals(10, coloredTriangle.getPoint2().getY()),
                () -> assertEquals(20, coloredTriangle.getPoint3().getX()),
                () -> assertEquals(30, coloredTriangle.getPoint3().getY()),
                () -> assertEquals(150, coloredTriangle.getArea()),
                () -> assertEquals(58.863495, coloredTriangle.getPerimeter(), DOUBLE_EPS),
                () -> assertEquals(Color.RED, coloredTriangle.getColor())
        );
        coloredTriangle.setColor(Color.GREEN);
        assertEquals(Color.GREEN, coloredTriangle.getColor());
        coloredTriangle.setColor("BLUE");
        assertEquals(Color.BLUE, coloredTriangle.getColor());
        assertThrows(ColorException.class, () -> coloredTriangle.setColor((String) null));
    }

    @Test
    public void TestColoredTriangle4() throws ColorException {
        ColoredTriangle coloredTriangle = new ColoredTriangle(10, 20, 30, 10, 20, 30, "BLUE");
        assertAll(
                () -> assertEquals(10, coloredTriangle.getPoint1().getX()),
                () -> assertEquals(20, coloredTriangle.getPoint1().getY()),
                () -> assertEquals(30, coloredTriangle.getPoint2().getX()),
                () -> assertEquals(10, coloredTriangle.getPoint2().getY()),
                () -> assertEquals(20, coloredTriangle.getPoint3().getX()),
                () -> assertEquals(30, coloredTriangle.getPoint3().getY()),
                () -> assertEquals(150, coloredTriangle.getArea()),
                () -> assertEquals(58.863495, coloredTriangle.getPerimeter(), DOUBLE_EPS),
                () -> assertEquals(Color.BLUE, coloredTriangle.getColor())
        );
        coloredTriangle.setColor(Color.GREEN);
        assertEquals(Color.GREEN, coloredTriangle.getColor());
        coloredTriangle.setColor("RED");
        assertEquals(Color.RED, coloredTriangle.getColor());
        assertThrows(ColorException.class, () -> coloredTriangle.setColor((Color) null));
    }


    @Test
    public void testMoveColoredTriangle() throws ColorException {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30, 10);
        Point point3 = new Point(20, 30);
        ColoredTriangle coloredTriangle = new  ColoredTriangle(point1, point2, point3, Color.GREEN);
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
    public void testIsPointInsideColoredTriangle() throws ColorException {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30, 10);
        Point point3 = new Point(20, 30);
        ColoredTriangle coloredTriangle = new  ColoredTriangle(point1, point2, point3, Color.GREEN);
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
