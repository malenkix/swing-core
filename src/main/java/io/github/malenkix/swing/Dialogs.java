package io.github.malenkix.swing;

import java.awt.Color;
import java.io.File;
import java.util.Locale;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Maik
 */
public final class Dialogs {

    public static final int OPEN_DIALOG = JFileChooser.OPEN_DIALOG;
    public static final int SAVE_DIALOG = JFileChooser.SAVE_DIALOG;

    private static final FileFilter PDF_FILTER = createFilterByExtension("pdf");

    private Dialogs() {
        //
    }

    public static File chooseFile(final JFrame frame, final File root, final int type, final FileFilter fileFilter) {
        final JFileChooser chooser = new JFileChooser(root);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(fileFilter);
        chooser.setFileHidingEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        chooser.setDialogType(type);
        final int option = chooser.showDialog(frame, null);
        return option == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFile().getAbsoluteFile() : null;
    }

    public static File choosePdfFile(final JFrame frame, final File root, final int type) {
        return chooseFile(frame, root, type, PDF_FILTER);
    }

    public static File chooseFile(final JFrame frame, final File root, final int type, final String extension) {
        return chooseFile(frame, root, type, createFilterByExtension(extension));
    }

    private static FileFilter createFilterByExtension(final String extension) {
        return new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f != null && (f.isDirectory() || (f.isFile() && f.getName().endsWith("." + extension)));
            }

            @Override
            public String getDescription() {
                return "*." + extension;
            }
        };
    }

    public static Color chooseColor(final JFrame frame, final Color defaultColor) {
        return JColorChooser.showDialog(frame, null, defaultColor);
    }

    public static void setDefaultLocale(final Locale locale) {
        JFileChooser.setDefaultLocale(locale);
        JColorChooser.setDefaultLocale(locale);
        JOptionPane.setDefaultLocale(locale);
    }
}
