package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.ClosedFigure;
import net.thumbtack.school.figures.v3.Point;
import net.thumbtack.school.iface.v3.HasMetrics;

public class PairBox<T extends ClosedFigure, V extends ClosedFigure> implements HasMetrics {
    private T obj;
    private V obj1;
    public static final double EPS = 0.001;

    public PairBox(T obj, V obj1) {
        this.obj = obj;
        this.obj1 = obj1;
    }

    public T getContentFirst() {
        return obj;
    }

    public void setContentFirst(T obj) {
        this.obj = obj;
    }

    public V getContentSecond() {
        return obj1;
    }

    public void setContentSecond(V obj1) {
        this.obj1 = obj1;
    }

    @Override
    public double getArea() {
        return obj.getArea() + obj1.getArea();
    }

    @Override
    public double getPerimeter() {
        return obj.getPerimeter() + obj1.getPerimeter();
    }

    public boolean isAreaEqual(PairBox<? extends ClosedFigure, ? extends ClosedFigure> pairBox) {
        return Math.abs(this.getPerimeter() - pairBox.getPerimeter()) < EPS;
    }

    public boolean isPerimeterEqual(PairBox<? extends ClosedFigure, ? extends ClosedFigure> pairBox) {
        return Math.abs(this.getPerimeter() - pairBox.getPerimeter()) < EPS;
    }

    public static boolean isAreaEqual(PairBox<? extends ClosedFigure, ? extends ClosedFigure> pairBox,
                                      PairBox<? extends ClosedFigure, ? extends ClosedFigure> pairBox1) {
        return pairBox.isAreaEqual(pairBox1);
    }

    public static boolean isPerimeterEqual(PairBox<? extends ClosedFigure, ? extends ClosedFigure> pairBox,
                                           PairBox<? extends ClosedFigure, ? extends ClosedFigure> pairBox1) {
        return pairBox.isPerimeterEqual(pairBox1);
    }

    @Override
    public boolean isInside(Point point) {
        return obj.isInside(point.getX(), point.getY()) && obj1.isInside(point.getX(), point.getY());
    }

    @Override
    public boolean isInside(int x, int y) {
        return obj.isInside(x, y) && obj1.isInside(x, y);
    }
}
