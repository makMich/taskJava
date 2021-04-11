package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBoxes {
    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testRectangleBox() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        Rectangle rect = new Rectangle(topLeft, bottomRight);
        Box<Rectangle> rectBox = new Box<>(rect);
        assertAll(
                () -> assertEquals(10, rectBox.getContent().getTopLeft().getX()),
                () -> assertEquals(20, rectBox.getContent().getTopLeft().getY()),
                () -> assertEquals(30, rectBox.getContent().getBottomRight().getX()),
                () -> assertEquals(40, rectBox.getContent().getBottomRight().getY()),
                () -> assertEquals(rectBox.getContent().getLength(), 20),
                () -> assertEquals(rectBox.getContent().getWidth(), 20),
                () -> assertEquals(400, rectBox.getArea(), DOUBLE_EPS)
        );
    }

    @Test
    public void testCircleBox() {
        Point center = new Point(10, 20);
        Circle circle = new Circle(center, 10);
        Box<Circle> circleBox = new Box<>(circle);
        assertAll(
                () -> assertEquals(10, circleBox.getContent().getCenter().getX()),
                () -> assertEquals(20, circleBox.getContent().getCenter().getY()),
                () -> assertEquals(10, circleBox.getContent().getRadius()),
                () -> assertEquals(Math.PI * 10 * 10, circleBox.getArea(), DOUBLE_EPS)
        );
    }

    @Test
    public void testColoredRectangleBox() throws ColorException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        ColoredRectangle rect = new ColoredRectangle(topLeft, bottomRight, Color.BLUE);
        Box<ColoredRectangle> rectBox = new Box<>(rect);
        assertAll(
                () -> assertEquals(10, rectBox.getContent().getTopLeft().getX()),
                () -> assertEquals(20, rectBox.getContent().getTopLeft().getY()),
                () -> assertEquals(30, rectBox.getContent().getBottomRight().getX()),
                () -> assertEquals(40, rectBox.getContent().getBottomRight().getY()),
                () -> assertEquals(rectBox.getContent().getLength(), 20),
                () -> assertEquals(rectBox.getContent().getWidth(), 20),
                () -> assertEquals(Color.BLUE, rectBox.getContent().getColor()),
                () -> assertEquals(400, rectBox.getArea(), DOUBLE_EPS)
        );
    }

    @Test
    public void testColoredCircleBox() throws ColorException {
        Point center = new Point(10, 20);
        ColoredCircle coloredCircle = new ColoredCircle(center, 10, Color.GREEN);
        Box<ColoredCircle> coloredCircleBox = new Box<>(coloredCircle);
        assertAll(
                () -> assertEquals(10, coloredCircleBox.getContent().getCenter().getX()),
                () -> assertEquals(20, coloredCircleBox.getContent().getCenter().getY()),
                () -> assertEquals(10, coloredCircleBox.getContent().getRadius()),
                () -> assertEquals(Color.GREEN, coloredCircle.getColor())
        );
    }


    @Test
    public void testMetricsBox() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        Rectangle rect = new Rectangle(topLeft, bottomRight);
        Box<Rectangle> rectBox = new Box<>(rect);
        assertEquals(400, rectBox.getArea(), DOUBLE_EPS);
        assertEquals(80, rectBox.getPerimeter(), DOUBLE_EPS);
    }

    @Test
    public void testMetricsEqualBox1() throws ColorException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 60);
        Rectangle rect = new Rectangle(topLeft, bottomRight);
        Box<Rectangle> rectBox = new Box<>(rect);
        ColoredRectangle coloredRectangle = new ColoredRectangle(topLeft, bottomRight, Color.BLUE);
        Box<ColoredRectangle> coloredRectangleBox = new Box<>(coloredRectangle);
        assertTrue(coloredRectangleBox.isAreaEqual(rectBox));
        assertTrue(coloredRectangleBox.isPerimeterEqual(rectBox));
    }

    @Test
    public void testMetricsEqualBox2() {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 60);
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1);
        Box<Rectangle> rectBox1 = new Box<>(rect1);
        Point topLeft2 = new Point(10, 20);
        Point bottomRight2 = new Point(20, 100);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2);
        Box<Rectangle> rectBox2 = new Box<>(rect2);
        assertTrue(rectBox2.isAreaEqual(rectBox1));
        assertFalse(rectBox2.isPerimeterEqual(rectBox1));
        assertTrue(Box.isAreaEqual(rectBox2, rectBox1));
        assertFalse(Box.isPerimeterEqual(rectBox2, rectBox1));
    }

    @Test
    public void testRectangleArrayBox() {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 60);
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1);
        Point topLeft2 = new Point(20, 10);
        Point bottomRight2 = new Point(60, 30);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2);
        Rectangle[] rectangles1 = new Rectangle[]{rect1, rect2};
        ArrayBox<Rectangle> rectArrayBox1 = new ArrayBox<>(rectangles1);
        Rectangle[] rectangles2 = new Rectangle[]{rect2, rect1};
        ArrayBox<Rectangle> rectArrayBox2 = new ArrayBox<>(rectangles2);
        assertTrue(rectArrayBox1.isSameSize(rectArrayBox2));
    }

    @Test
    public void testRectangleCircleArrayBoxes() {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 60);
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1);
        Point topLeft2 = new Point(20, 10);
        Point bottomRight2 = new Point(60, 30);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2);
        Rectangle[] rectangles = new Rectangle[]{rect1, rect2};
        ArrayBox<Rectangle> rectArrayBox = new ArrayBox<>(rectangles);
        Point center = new Point(10, 20);
        Circle circle = new Circle(center, 10);
        Circle[] circles = new Circle[]{circle};
        ArrayBox<Circle> circleArrayBox = new ArrayBox<>(circles);
        assertFalse(rectArrayBox.isSameSize(circleArrayBox));
    }

    @Test
    public void testMixedFiguresArrayBoxes() {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 60);
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1);
        Point center = new Point(10, 20);
        Circle circle = new Circle(center, 10);
        ClosedFigure[] figures1 = new ClosedFigure[]{rect1, circle};
        ArrayBox<ClosedFigure> figureArrayBox1 = new ArrayBox<>(figures1);
        Point topLeft2 = new Point(20, 10);
        Point bottomRight2 = new Point(60, 30);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2);
        ClosedFigure[] figures2 = new ClosedFigure[]{rect2};
        ArrayBox<ClosedFigure> figureArrayBox2 = new ArrayBox<>(figures2);
        assertFalse(figureArrayBox1.isSameSize(figureArrayBox2));
    }

    @Test
    public void testPairBox1() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 60);
        Rectangle rect = new Rectangle(topLeft, bottomRight);
        Point center = new Point(10, 20);
        Circle circle = new Circle(center, 10);
        PairBox<Rectangle, Circle> pairBox1 = new PairBox<>(rect, circle);
        PairBox<Circle, Rectangle> pairBox2 = new PairBox<>(circle, rect);
        assertTrue(pairBox1.isAreaEqual(pairBox2));
        assertTrue(pairBox1.isPerimeterEqual(pairBox2));
        assertTrue(PairBox.isAreaEqual(pairBox1, pairBox2));
        assertTrue(PairBox.isPerimeterEqual(pairBox1, pairBox2));
    }

    @Test
    public void testPairBox2() throws ColorException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 60);
        Rectangle rect = new Rectangle(topLeft, bottomRight);
        ColoredRectangle coloredRectangle = new ColoredRectangle(topLeft, bottomRight, Color.BLUE);
        PairBox<Rectangle, ColoredRectangle> pairBox1 = new PairBox<>(rect, coloredRectangle);
        PairBox<ColoredRectangle, Rectangle> pairBox2 = new PairBox<>(coloredRectangle, rect);
        assertTrue(pairBox1.isAreaEqual(pairBox2));
        assertTrue(pairBox1.isPerimeterEqual(pairBox2));
        assertTrue(PairBox.isAreaEqual(pairBox1, pairBox2));
        assertTrue(PairBox.isPerimeterEqual(pairBox1, pairBox2));
    }

    @Test
    public void testRectangleNamedBox() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        Rectangle rect = new Rectangle(topLeft, bottomRight);
        NamedBox<Rectangle> rectBox = new NamedBox<>(rect, "Very good rect");
        assertAll(
                () -> assertEquals(10, rectBox.getContent().getTopLeft().getX()),
                () -> assertEquals(20, rectBox.getContent().getTopLeft().getY()),
                () -> assertEquals(30, rectBox.getContent().getBottomRight().getX()),
                () -> assertEquals(40, rectBox.getContent().getBottomRight().getY()),
                () -> assertEquals(rectBox.getContent().getLength(), 20),
                () -> assertEquals(rectBox.getContent().getWidth(), 20),
                () -> assertEquals(400, rectBox.getArea(), DOUBLE_EPS),
                () -> assertEquals("Very good rect", rectBox.getName())
        );
    }

    @Test
    public void testAreaNamedBox() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        Rectangle rect = new Rectangle(topLeft, bottomRight);
        NamedBox<Rectangle> rectBox = new NamedBox<>(rect, "Very good rect");
        assertEquals(400, rectBox.getArea(), DOUBLE_EPS);
        assertEquals("Very good rect", rectBox.getName());
    }


/*
    @Test
	public void testMustNotBeCompiled() {
		Box<String> stringBox = new Box<>("My String");
		Box<Figure> figureBox = new Box<>(new Line());
	}
*/



}
