package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.ClosedFigure;
import net.thumbtack.school.figures.v2.Point;

import java.util.Objects;

public class Triangle extends ClosedFigure {

    private Point point1 = new Point();
    private Point point2= new Point();
    private Point point3= new Point();

    public Triangle(int oneX, int oneY, int twoX, int twoY, int threeX, int threeY) {
        point1.setX(oneX);
        point1.setY(oneY);
        point2.setX(twoX);
        point2.setY(twoY);
        point3.setX(threeX);
        point3.setY(threeY);
    }

    public Triangle(Point point1, Point point2, Point point3) {
        this(point1.getX(), point1.getY(), point2.getX(), point2.getY(), point3.getX(), point3.getY());
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }


    public double getLength(Point point1, Point point2) {
        return Math.sqrt((point2.getX() - point1.getX()) * (point2.getX() - point1.getX()) +
                (point2.getY() - point1.getY()) * (point2.getY() - point1.getY()));
    }

    @Override
    public double getArea() {
        return Math.abs(0.5 * ((point2.getX() - point1.getX()) * (point3.getY() - point1.getY())
                - (point3.getX() - point1.getX()) * (point2.getY() - point1.getY())));
    }

    @Override
    public double getPerimeter() {
        return getLength(point1, point2) + getLength(point2, point3) + getLength(point3, point1);
    }

    @Override
    public boolean isInside(int x, int y) {
        return Math.signum((point1.getX() - x) * (point2.getY() - point1.getY()) - (point2.getX() - point1.getX()) *
                (point1.getY() - y)) == Math.signum((point2.getX() - x) * (point3.getY() - point2.getY()) -
                (point3.getX() - point2.getX()) * (point2.getY() - y)) && Math.signum((point1.getX() - x) *
                (point2.getY() - point1.getY()) - (point2.getX() - point1.getX()) * (point1.getY() - y)) ==
                Math.signum((point3.getX() - x) * (point1.getY() - point3.getY()) -
                        (point1.getX() - point3.getX()) * (point3.getY() - y));
    }

    @Override
    public void moveTo(int x, int y) {
        point2.moveTo((x - point1.getX()) + point2.getX(), (y - point1.getY()) + point2.getY());
        point3.moveTo((x - point1.getX()) + point3.getX(), (y - point1.getY()) + point3.getY());
        point1.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        point1.moveRel(dx, dy);
        point2.moveRel(dx, dy);
        point3.moveRel(dx, dy);
    }

    @Override
    public void resize(int ratio) {
        point2.setX((point2.getX() - point1.getX()) + point1.getX());
        point2.setY((point2.getY() - point1.getY()) + point1.getY());
        point3.setX((point3.getX() - point1.getX()) + point1.getX());
        point3.setY((point3.getY() - point1.getY()) + point1.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(point1, triangle.point1) &&
                Objects.equals(point2, triangle.point2) &&
                Objects.equals(point3, triangle.point3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2, point3);
    }
}
