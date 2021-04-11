package net.thumbtack.school.iface.v3;

import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.colors.v3.Color;

public interface Colored {
    void setColor(Color color) throws ColorException;
    void setColor (String colorString) throws ColorException;

    Color getColor();

}
