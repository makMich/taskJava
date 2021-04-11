package net.thumbtack.school.figures.v2;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.iface.v2.Colored;

import java.util.Objects;

public class ColoredLine extends Line implements Colored {
    private int color;

    public ColoredLine(int xLeft, int yTop, int xRight, int yBottom, int color) {
        super(xLeft, yTop, xRight, yBottom);
        this.color = color;
    }

    public ColoredLine(Point startPoint, Point endPoint, int color) {
        this(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY(), color);
    }

    public ColoredLine(Point endPoint, int color) {
        this(0, 0, endPoint.getX(), endPoint.getY(), color);
    }

    public ColoredLine(int x, int y, int color) {
        this(0, 0, x, y, color);
    }

    public ColoredLine(int color) {
        this(0, 0, 1, 1, color);
    }

    public ColoredLine() {
        this(0, 0, 1, 1, 1);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredLine that = (ColoredLine) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}

