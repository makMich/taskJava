package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class ColoredLine extends Line implements Colored {
    private Color color;

    public ColoredLine(int xLeft, int yTop, int xRight, int yBottom, Color color) throws ColorException {
        super(xLeft, yTop, xRight, yBottom);
        setColor(color);
    }

    public ColoredLine(int xLeft, int yTop, int xRight, int yBottom, String color) throws ColorException {
        this(xLeft, yTop, xRight, yBottom, Color.colorFromString(color));
    }

    public ColoredLine(Point startPoint, Point endPoint, Color color) throws ColorException {
        this(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY(), color);
    }

    public ColoredLine(Point startPoint, Point endPoint, String color) throws ColorException {
        this(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY(), Color.colorFromString(color));
    }

    public ColoredLine(Point endPoint, Color color) throws ColorException {
        this(0, 0, endPoint.getX(), endPoint.getY(), color);
    }

    public ColoredLine(Point endPoint, String color) throws ColorException {
        this(0, 0, endPoint.getX(), endPoint.getY(), Color.colorFromString(color));
    }

    public ColoredLine(int x, int y, Color color) throws ColorException {
        this(0, 0, x, y, color);
    }

    public ColoredLine(int x, int y, String color) throws ColorException {
        this(0, 0, x, y, Color.colorFromString(color));
    }

    public ColoredLine(Color color) throws ColorException {
        this(0, 0, 1, 1, color);
    }

    public ColoredLine(String color) throws ColorException {
        this(0, 0, 1, 1, Color.colorFromString(color));
    }

    public ColoredLine() throws ColorException {
        this(0, 0, 1, 1, Color.RED);
    }

    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public void setColor(String colorString) throws ColorException {
        this.color = Color.colorFromString(colorString);
    }

    public Color getColor() {
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

