package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Rectangle {
    private Point pointLeftTop = new Point();
    private Point pointRightBottom = new Point();

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        pointLeftTop.setX(xLeft);
        pointLeftTop.setY(yTop);
        pointRightBottom.setX(xRight);
        pointRightBottom.setY(yBottom);
    }

    public Rectangle(Point leftTop, Point rightBottom) {
        this(leftTop.getX(), leftTop.getY(), rightBottom.getX(), rightBottom.getY());
    }

    public Rectangle(int length, int width) {
        this(0, -width, length, 0);
    }

    public Rectangle() {
        this(0, -1, 1, 0);
    }

    public Point getTopLeft() {
        return pointLeftTop;
    }

    public Point getBottomRight() {
        return pointRightBottom;
    }

    public void setTopLeft(Point topLeft) {
        pointLeftTop = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        pointRightBottom = bottomRight;
    }

    public int getLength() {
        return pointRightBottom.getX() - pointLeftTop.getX();
    }

    public int getWidth() {
        return pointRightBottom.getY() - pointLeftTop.getY();
    }

    public void moveRel(int dx, int dy) {
        pointLeftTop.moveRel(dx, dy);
        pointRightBottom.moveRel(dx, dy);
    }

    public void moveTo(int x, int y) {
        pointRightBottom.moveTo(x + getLength(), y + getWidth());
        pointLeftTop.moveTo(x, y);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void resize(int ratio) {
        pointRightBottom.setX(getLength() * ratio + pointLeftTop.getX());
        pointRightBottom.setY(getWidth() * ratio + pointLeftTop.getY());
    }

    public double getArea() {
        return getWidth() * getLength();
    }

    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    public boolean isInside(int x, int y) {
        return (pointLeftTop.getX() <= x && pointRightBottom.getX() >= x && pointLeftTop.getY() <= y
                && pointRightBottom.getY() >= y);
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Rectangle rectangle) {
        return (((((pointLeftTop.getX() >= rectangle.getTopLeft().getX()
                && pointLeftTop.getX() <= rectangle.getBottomRight().getX())
                || (pointRightBottom.getX() >= rectangle.getTopLeft().getX()
                && pointRightBottom.getX() <= rectangle.getBottomRight().getX()))
                && ((pointLeftTop.getY() >= rectangle.getTopLeft().getY()
                && pointLeftTop.getY() <= rectangle.getBottomRight().getY())
                || (pointRightBottom.getY() >= rectangle.getTopLeft().getY()
                && pointRightBottom.getY() <= rectangle.getBottomRight().getY())))
                || (((rectangle.getTopLeft().getX() >= pointLeftTop.getX()
                && rectangle.getTopLeft().getX() <= pointRightBottom.getX())
                || (rectangle.getBottomRight().getX() >= pointLeftTop.getX()
                && rectangle.getBottomRight().getX() <= pointRightBottom.getX()))
                && ((rectangle.getTopLeft().getY() >= pointLeftTop.getY()
                && rectangle.getTopLeft().getY() <= pointRightBottom.getY())
                || (rectangle.getBottomRight().getY() >= pointLeftTop.getY()
                && rectangle.getBottomRight().getY() <= pointRightBottom.getY()))))
                || ((((pointLeftTop.getX() >= rectangle.getTopLeft().getX()
                && pointLeftTop.getX() <= rectangle.getBottomRight().getX())
                || (pointRightBottom.getX() >= rectangle.getTopLeft().getX()
                && pointRightBottom.getX() <= rectangle.getBottomRight().getX()))
                && ((rectangle.getTopLeft().getY() >= pointLeftTop.getY()
                && rectangle.getTopLeft().getY() <= pointRightBottom.getY())
                || (rectangle.getBottomRight().getY() >= pointLeftTop.getY()
                && rectangle.getBottomRight().getY() <= pointRightBottom.getY())))
                || (((rectangle.getTopLeft().getX() >= pointLeftTop.getX()
                && rectangle.getTopLeft().getX() <= pointRightBottom.getX())
                || (rectangle.getBottomRight().getX() >= pointLeftTop.getX()
                && rectangle.getBottomRight().getX() <= pointRightBottom.getX()))
                && ((pointLeftTop.getY() >= rectangle.getTopLeft().getY()
                && pointLeftTop.getY() <= rectangle.getBottomRight().getY())
                || (pointRightBottom.getY() >= rectangle.getTopLeft().getY()
                && pointRightBottom.getY() <= rectangle.getBottomRight().getY())))));
    }

    public boolean isInside(Rectangle rectangle) {
        return (rectangle.pointLeftTop.getX() >= pointLeftTop.getX()
                && rectangle.pointRightBottom.getX() <= pointRightBottom.getX())
                && (rectangle.pointLeftTop.getY() >= pointLeftTop.getY()
                && rectangle.pointRightBottom.getY() <= pointRightBottom.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(pointLeftTop, rectangle.pointLeftTop) &&
                Objects.equals(pointRightBottom, rectangle.pointRightBottom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointLeftTop, pointRightBottom);
    }
}
