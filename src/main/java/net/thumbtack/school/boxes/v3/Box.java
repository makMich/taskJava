package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.ClosedFigure;
import net.thumbtack.school.iface.v3.HasMetrics;


public class Box<T extends ClosedFigure> implements HasMetrics {
    private static final double EPS = 0.001;
    private T obj;

    public Box(T obj) {
        super();
        this.obj = obj;
    }

    public T getContent() {
        return obj;
    }

    public void setContent(T obj) {
        this.obj = obj;
    }

    @Override
    public double getArea() {
        return obj.getArea();
    }

    @Override
    public double getPerimeter() {
        return obj.getPerimeter();
    }

    @Override
    public boolean isInside(int x, int y) {
        return obj.isInside(x, y);
    }

    public boolean isAreaEqual(Box<? extends ClosedFigure> obj) {
        return Math.abs(this.obj.getArea() - obj.getArea()) < EPS;
    }

    public static boolean isAreaEqual(Box<? extends ClosedFigure> obj, Box<? extends ClosedFigure> obj1) {
        return obj.isAreaEqual(obj1);
    }

    public boolean isPerimeterEqual(Box<? extends ClosedFigure> obj) {
        return Math.abs(this.obj.getPerimeter() - obj.getPerimeter()) < EPS;
    }

    public static boolean isPerimeterEqual(Box<? extends ClosedFigure> obj, Box<? extends ClosedFigure> obj1) {
        return obj.isPerimeterEqual(obj1);
    }
}
