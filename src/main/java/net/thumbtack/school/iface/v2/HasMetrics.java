package net.thumbtack.school.iface.v2;

import net.thumbtack.school.figures.v2.Point;

public interface HasMetrics {
    double getArea();

    double getPerimeter();
    default boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }
    boolean isInside(int x, int y);

}
