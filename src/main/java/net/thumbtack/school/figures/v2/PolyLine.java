package net.thumbtack.school.figures.v2;

import java.util.Arrays;
import java.util.Objects;

public class PolyLine extends Figure {

    Point[] points;
    double Length = 0;

    public PolyLine(Point[] points) {
        this.points = Arrays.copyOf(points, points.length);

    }

    private double length(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private double length(Point point1, Point point2) {
        return length(point1.getX(), point2.getX(), point1.getY(), point2.getY());
    }

    public Point[] getPoints() {
        return points;
    }

    public double getLength() {
        for (int i = 1; i < points.length; i++) {
            Length += length(points[i - 1], points[i]);
        }
        return Length;
    }

    public void setPoints(Point[] points) {
       this.points = Arrays.copyOf(points, points.length);
    }

    public void moveTo(int x, int y) {
        int dx, dy;
        dx = x - points[0].getX();
        dy = y - points[0].getY();
        for (Point point : points) {
            point.moveTo(point.getX() + dx, point.getY() + dy);
        }
    }


    public void moveRel(int dx, int dy) {
        for (Point point : points) {
            point.moveRel(dx, dy);
        }
    }

    public Rectangle getBoundingRectangle() {
        Rectangle rectangle = new Rectangle();
        int maxX = points[0].getX(),
                maxY = points[0].getY(),
                minX = points[0].getX(),
                minY = points[0].getY();
        for(Point point : points) {
            if (point.getX() > maxX) {
                maxX = point.getX();
            }
            if (point.getX() < minX) {
                minX = point.getX();
            }
            if (point.getY() > maxY) {
                maxY = point.getY();
            }
            if (point.getY() < minY) {
                minY = point.getY();
            }
        }
        rectangle.getTopLeft().setX(minX);
        rectangle.getTopLeft().setY(minY);
        rectangle.getBottomRight().setX(maxX);
        rectangle.getBottomRight().setY(maxY);
        return rectangle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolyLine polyLine = (PolyLine) o;
        return Double.compare(polyLine.Length, Length) == 0 &&
                Arrays.equals(points, polyLine.points);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(Length);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }
}
