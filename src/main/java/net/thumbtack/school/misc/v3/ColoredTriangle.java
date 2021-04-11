package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.figures.v3.Point;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class ColoredTriangle extends Triangle implements Colored {

    private Color color;

    public ColoredTriangle(Point point1, Point point2, Point point3, Color color) throws ColorException{
        this(point1.getX(), point1.getY(), point2.getX(), point2.getY(), point3.getX(), point3.getY(), color);
    }

    public ColoredTriangle(Point point1, Point point2, Point point3, String color) throws ColorException {
        this(point1.getX(), point1.getY(), point2.getX(), point2.getY(), point3.getX(), point3.getY(), Color.colorFromString(color));
    }

    public ColoredTriangle(int oneX, int oneY, int twoX, int twoY, int threeX, int threeY, Color color)  throws ColorException{
        super(oneX, oneY, twoX, twoY, threeX, threeY);
        setColor(color);
    }

    public ColoredTriangle(int oneX, int oneY, int twoX, int twoY, int threeX, int threeY, String color) throws ColorException {
        this(oneX, oneY, twoX, twoY, threeX, threeY, Color.colorFromString(color));
    }

    @Override
    public void setColor(Color color)  throws ColorException{
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public void setColor(String colorString) throws ColorException {
        this.color = Color.colorFromString(colorString);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColoredTriangle that = (ColoredTriangle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
