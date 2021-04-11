package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestColored {

    @Test
    public void testSetColors1() throws ColorException {
        Colored[] coloredFigures = new Colored[3];
        coloredFigures[0] = new ColoredCircle(10, 20, 10, Color.RED);
        coloredFigures[1] = new ColoredRectangle(10, 20, 30, 40, Color.RED);
        coloredFigures[2] = new ColoredLine(10, 20, 30, 40, Color.RED);
        for (Colored colored : coloredFigures)
            colored.setColor(Color.GREEN);
        for (Colored colored : coloredFigures)
            assertEquals(Color.GREEN, colored.getColor());
    }

    @Test
    public void testSetColors2() throws ColorException {
        Colored[] coloredFigures = new Colored[3];
        coloredFigures[0] = new ColoredCircle(10, 20, 10, "RED");
        coloredFigures[1] = new ColoredRectangle(10, 20, 30, 40, "RED");
        coloredFigures[2] = new ColoredLine(10, 20, 30, 40, "RED");
        for (Colored colored : coloredFigures)
            colored.setColor("GREEN");
        for (Colored colored : coloredFigures)
            assertEquals(Color.GREEN, colored.getColor());
    }

}
