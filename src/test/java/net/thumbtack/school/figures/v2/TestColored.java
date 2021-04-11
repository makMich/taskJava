package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.Colored;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestColored {
    @Test
    public void testSetColors() {
        Colored[] coloredFigures = new Colored[3];
        coloredFigures[0] = new ColoredCircle(10, 20, 10, 1);
        coloredFigures[1] = new ColoredRectangle(10, 20, 30, 40, 1);
        coloredFigures[2] = new ColoredLine(10, 20, 30, 40, 1);
        for (Colored colored : coloredFigures)
            colored.setColor(2);
        for (Colored colored : coloredFigures)
            assertEquals(2, colored.getColor());


    }


}
