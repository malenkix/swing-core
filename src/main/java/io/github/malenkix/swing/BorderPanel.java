package io.github.malenkix.swing;

import java.awt.BorderLayout;
import java.awt.Component;

/**
 *
 * @author Maik
 */
public class BorderPanel extends Panel {

    public static final String NORTH = BorderLayout.NORTH;
    public static final String SOUTH = BorderLayout.SOUTH;
    public static final String EAST = BorderLayout.EAST;
    public static final String WEST = BorderLayout.WEST;
    public static final String CENTER = BorderLayout.CENTER;

    public BorderPanel(final int hgap, final int vgap) {
        super(new BorderLayout(hgap, vgap));
    }

    public void addTop(final Component component) {
        super.add(component, NORTH);
    }

    public void addLeft(final Component component) {
        super.add(component, WEST);
    }

    public void addCenter(final Component component) {
        super.add(component, CENTER);
    }

    public void addRight(final Component component) {
        super.add(component, EAST);
    }

    public void addBottom(final Component component) {
        super.add(component, SOUTH);
    }
}
