package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.ClosedFigure;

public class NamedBox<T extends ClosedFigure> extends Box<T> {
    private String name;

    public NamedBox(T closedFigure, String name) {
        super(closedFigure);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
