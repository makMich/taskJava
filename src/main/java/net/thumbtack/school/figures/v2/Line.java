package net.thumbtack.school.figures.v2;


import java.util.Objects;

public class Line extends Figure {

    private Point start = new Point();
    private Point end = new Point();

    public Line(int xLeft, int yTop, int xRight, int yBottom) {
        start.setX(xLeft);
        start.setY(yTop);
        end.setX(xRight);
        end.setY(yBottom);
    }

    public Line(Point startPoint, Point endPoint) {
        this(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
    }

    public Line(Point endPoint) {
        this(0, 0, endPoint.getX(), endPoint.getY());
    }

    public Line(int x, int y) {
        this(0, 0, x, y);
    }

    public Line() {
        this(0, 0, 1, 1);
    }

    private double getLength(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private int getLengthX() {
        return (end.getX() - start.getX());
    }

    private int getWidth() {
        return (end.getY() - start.getY());
    }

    public Point getStartPoint() {
        return start;
    }

    public Point getEndPoint() {
        return end;
    }

    public void setStartPoint(Point point) {
        this.start = point;
    }

    public void setEndPoint(Point point) {
        this.end = point;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
    }

    public void moveTo(int x, int y) {
        end.moveTo(x + getLengthX(), y + getWidth());
        start.moveTo(x, y);
    }


    public void moveRel(int dx, int dy) {
        start.moveRel(dx,dy);
        end.moveRel(dx, dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(start, line.start) &&
                Objects.equals(end, line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}