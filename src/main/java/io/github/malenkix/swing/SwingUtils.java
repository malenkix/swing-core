package io.github.malenkix.swing;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Maik
 */
public final class SwingUtils {

    private SwingUtils() {
    }

    public static void boot(final Class<? extends JFrame> frameClass, final float scale) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            throw new RuntimeException(ex);
        }
        SwingUtilities.invokeLater(() -> {
            try {

                final JFrame frame = frameClass.newInstance();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                final Toolkit toolkit = frame.getToolkit();
                final Dimension screen = toolkit.getScreenSize();

                frame.setSize((int) (screen.width * scale), (int) (screen.height * scale));
                frame.setLocationRelativeTo(null);

                frame.setVisible(true);
            } catch (InstantiationException | IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
