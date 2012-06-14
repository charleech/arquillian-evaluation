package org.charleech.arq.eval.helper;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

import org.charleech.arq.eval.helper.eclipse.EclipseWrapper;
import org.charleech.arq.eval.helper.util.JulResetter;
import org.charleech.arq.eval.helper.util.MarkerWrapper;
import org.junit.BeforeClass;
import org.slf4j.Marker;

/**
 * <p>
 * This is a base class which provides the feature for preparing the JUnit
 * test suite.
 * </p>
 *
 * @author charlee.ch
 * @version 0.0.1
 * @since 0.0.1
 * @see <a rel="license"
 *      href="http://creativecommons.org/licenses/by-nc-sa/3.0/"><img
 *      alt="Creative Commons License" style="border-width:0"
 *      src="http://i.creativecommons.org/l/by-nc-sa/3.0/88x31.png" /></a><br />
 *      <span xmlns:dct="http://purl.org/dc/terms/"
 *      property="dct:title">Charlee@GitHub</span> by <a
 *      xmlns:cc="http://creativecommons.org/ns#"
 *      href="https://github.com/charleech" property="cc:attributionName"
 *      rel="cc:attributionURL">Charlee Chitsuk</a> is licensed under a <a
 *      rel="license"
 *      href="http://creativecommons.org/licenses/by-nc-sa/3.0/">Creative
 *      Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License</a>.
 */
@Slf4j
public class AbstractTestSuite {

    private static final String DEFAULT_ARCHIVE_FOLDER;

    static {
        DEFAULT_ARCHIVE_FOLDER = "target/arquillian";
    }

    /**
     * This is a before class configuration. The following will be performed.
     * <ul>
     * <li>
     * The Java Util Logging (JUL) will be reset.
     * </li>
     * <li>
     * The required system properties will be set if it is not existed.
     * </li>
     * </ul>
     *
     * @since 0.0.1
     */
    @BeforeClass
    public static void setupBeforeClass() {
        JulResetter.getINSTANCE().reset();
        EclipseWrapper.getINSTANCE().setSystemProperties();
    }

    /**
     * Delete all file from the default archive folder. The sub-folder is
     * excluded.
     *
     * @param archiveFolder
     *            The deleting file folder name
     * @since 0.0.1
     */
    public static void clearCreatedArquillianArchives() {
        AbstractTestSuite.clearCreatedArquillianArchives(
           AbstractTestSuite.DEFAULT_ARCHIVE_FOLDER);
    }

    /**
     * Delete all file from the specified archive folder. The sub-folder is
     * excluded.
     *
     * @param archiveFolder
     *            The deleting file folder name
     * @since 0.0.1
     */
    public static void clearCreatedArquillianArchives(
                          final String archiveFolder) {
        File   folder = null;
        File[] files  = null;
        try {
            folder = new File(archiveFolder);

            if (!folder.exists()) {
                AbstractTestSuite.log.warn(
                   AbstractTestSuite.getMarker(),
                   "The folder {} is not existed.",
                   archiveFolder);
                return;
            }
            if (!folder.isDirectory()) {
                AbstractTestSuite.log.warn(
                   AbstractTestSuite.getMarker(),
                   "The {} is not a folder.",
                   archiveFolder);
                return;
            }

            files = folder.listFiles();
            for (final File file : files) {
                AbstractTestSuite.log.info(
                   AbstractTestSuite.getMarker(),
                   "The {} will be deleted",
                   file.toString());
                file.delete();
            }
        } finally {
            folder = null;
            files  = null;
        }
    }

    /**
     * Get the {@link Marker} for this class.
     *
     * @return The {@link Marker} for this class.
     */
    private static Marker getMarker() {
        return MarkerWrapper.getINSTANCE().getMarker(AbstractTestSuite.class);
    }

}
