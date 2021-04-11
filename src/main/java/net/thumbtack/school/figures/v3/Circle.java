package net.thumbtack.school.figures.v3;

import java.util.Objects;

public class Circle extends ClosedFigure {
    private int radius;
    private Point center = new Point();

    public Circle(int xCenter, int yCenter, int radius) {
        center.setX(xCenter);
        center.setY(yCenter);
        this.radius = radius;
    }

    public Circle(Point center, int radius) {
        this(center.getX(), center.getY(), radius);
    }

    public Circle(int radius) {
        this(0, 0, radius);
    }

    public Circle() {
        this(0, 0, 1);
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }


    public void resize(int ratio) {
        radius *= ratio;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }


    public boolean isInside(int x, int y) {
        return (((x - center.getX()) * (x - center.getX()) + (y - center.getY()) * (y - center.getY())) <= (radius * radius));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius &&
                center.equals(circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, center);
    }

}