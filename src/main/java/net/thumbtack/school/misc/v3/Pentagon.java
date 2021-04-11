package net.thumbtack.school.misc.v3;

import net.thumbtack.school.figures.v3.ClosedFigure;
import net.thumbtack.school.figures.v3.Point;

import java.util.Objects;

public class Pentagon extends ClosedFigure {

    private Point point1 = new Point();
    private Point point2 = new Point();
    private Point point3 = new Point();
    private Point point4 = new Point();
    private Point point5 = new Point();

    public Pentagon(int oneX, int oneY, int twoX, int twoY, int threeX, int threeY,
                    int fourX, int fourY, int fiveX, int fiveY) {
        point1.setX(oneX);
        point1.setY(oneY);
        point2.setX(twoX);
        point2.setY(twoY);
        point3.setX(threeX);
        point3.setY(threeY);
        point4.setX(fourX);
        point4.setY(fourY);
        point5.setX(fiveX);
        point5.setY(fiveY);
    }

    public Pentagon(Point point1, Point point2, Point point3, Point point4, Point point5) {
        this(point1.getX(), point1.getY(), point2.getX(), point2.getY(), point3.getX(), point3.getY(),
                point4.getX(), point4.getY(), point5.getX(), point5.getY());
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

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }

    public Point getPoint5() {
        return point5;
    }

    public void setPoint5(Point point5) {
        this.point5 = point5;
    }

    public double getLength(Point point1, Point point2) {
       return Math.abs(Math.sqrt(Math.pow((point2.getX() - point1.getX()), 2) + Math.pow((point2.getY() - point1.getY()), 2)));
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs(point1.getX() * point2.getY() + point2.getX() * point3.getY() + point3.getX() *
                point4.getY() + point4.getX() * point5.getY() + point5.getX() * point1.getY() - point2.getX() *
                point1.getY() - point3.getX() * point2.getY() - point4.getX() * point3.getY() - point5.getX() *
                point4.getY() - point1.getX() * point5.getY());
    }

    @Override
    public double getPerimeter() {
        return getLength(point1, point2) + getLength(point2, point3) + getLength(point3, point4) +
                getLength(point4, point5) + getLength(point5, point1);
    }

    @Override
    public boolean isInside(int x, int y) {
        return Math.signum((point1.getX() - x) * (point2.getY() - point1.getY()) - (point2.getX() - point1.getX()) *
                (point1.getY() - y)) ==
                Math.signum((point2.getX() - x) * (point3.getY() - point2.getY()) - (point3.getX() - point2.getX()) *
                        (point2.getY() - y)) &&
                Math.signum((point1.getX() - x) * (point2.getY() - point1.getY()) - (point2.getX() - point1.getX()) *
                        (point1.getY() - y)) ==
                Math.signum((point3.getX() - x) * (point4.getY() - point3.getY()) - (point4.getX() - point3.getX()) *
                                (point3.getY() - y)) &&
                Math.signum((point1.getX() - x) * (point2.getY() - point1.getY()) - (point2.getX() - point1.getX()) *
                        (point1.getY() - y)) ==
                Math.signum((point4.getX() - x) * (point5.getY() - point4.getY()) - (point5.getX() - point4.getX()) *
                                (point4.getY() - y)) &&
                Math.signum((point1.getX() - x) * (point2.getY() - point1.getY()) - (point2.getX() - point1.getX()) *
                        (point1.getY() - y)) ==
                Math.signum((point5.getX() - x) * (point1.getY() - point5.getY()) - (point1.getX() - point5.getX()) *
                                (point5.getY() - y));
    }

    @Override
    public void moveTo(int x, int y) {
        point2.moveTo((x - point1.getX()) + point2.getX(), (y - point1.getY()) + point2.getY());
        point3.moveTo((x - point1.getX()) + point3.getX(), (y - point1.getY()) + point3.getY());
        point4.moveTo((x - point1.getX()) + point4.getX(), (y - point1.getY()) + point4.getY());
        point5.moveTo((x - point1.getX()) + point5.getX(), (y - point1.getY()) + point5.getY());
        point1.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        point1.moveRel(dx, dy);
        point2.moveRel(dx, dy);
        point3.moveRel(dx, dy);
        point4.moveRel(dx, dy);
        point5.moveRel(dx, dy);
    }

    @Override
    public void resize(int ratio) {
        point2.setX((point2.getX() - point1.getX()) * ratio + point1.getX());
        point2.setY((point2.getY() - point1.getY()) * ratio + point1.getY());
        point3.setX((point3.getX() - point1.getX()) * ratio + point1.getX());
        point3.setY((point3.getY() - point1.getY()) * ratio + point1.getY());
        point4.setX((point4.getX() - point1.getX()) * ratio + point1.getY());
        point4.setY((point4.getY() - point1.getY()) * ratio + point1.getY());
        point5.setX((point5.getX() - point1.getX()) * ratio + point1.getY());
        point5.setY((point5.getY() - point1.getY()) * ratio + point1.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pentagon pentagon = (Pentagon) o;
        return Objects.equals(point1, pentagon.point1) &&
                Objects.equals(point2, pentagon.point2) &&
                Objects.equals(point3, pentagon.point3) &&
                Objects.equals(point4, pentagon.point4) &&
                Objects.equals(point5, pentagon.point5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2, point3, point4, point5);
    }
}
