package io.github.malenkix.swing;

import java.awt.Color;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Maik
 */
public final class Borders {

    private Borders() {
        //
    }

    public static EmptyBorder empty(final int top, final int left, final int bottom, final int right) {
        return new EmptyBorder(top, left, bottom, right);
    }

    public static EmptyBorder empty(final int topBottom, final int leftRight) {
        return Borders.empty(topBottom, leftRight, topBottom, leftRight);
    }

    public static EmptyBorder empty(final int inset) {
        return Borders.empty(inset, inset);
    }

    public static LineBorder line(final Color color, final int thickness) {
        return new LineBorder(color, thickness);
    }

    public static LineBorder line(final Color color) {
        return line(color, 1);
    }

    public static LineBorder lineGray() {
        return line(Color.GRAY);
    }

    public static Border dashed(final Color color, final int thickness) {
        return BorderFactory.createDashedBorder(color, thickness, 1f, 1f, false);
    }

    public static Border dashed(final Color color) {
        return dashed(color, 1);
    }

    public static MatteBorder matte(final int top, final int left, final int bottom, final int right, final Color color) {
        return new MatteBorder(top, left, bottom, right, color);
    }

    public static MatteBorder matteGray(final int top, final int left, final int bottom, final int right) {
        return matte(top, left, bottom, right, Color.GRAY);
    }

    public static CompoundBorder compound(final Border firstBorder, final Border secondBorder, final Border... borders) {
        if (borders == null || borders.length == 0) {
            return new CompoundBorder(firstBorder, secondBorder);
        }
        return new CompoundBorder(firstBorder, compound(secondBorder, borders[0], Arrays.copyOfRange(borders, 1, borders.length)));
    }
}
