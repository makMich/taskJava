package net.thumbtack.school.iface.v3;

import net.thumbtack.school.figures.v3.Point;

public interface HasMetrics {
    double getArea();

    double getPerimeter();
    default boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }
    boolean isInside(int x, int y);

}
