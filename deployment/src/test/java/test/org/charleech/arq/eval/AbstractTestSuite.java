package test.org.charleech.arq.eval;

import org.junit.BeforeClass;

import test.org.charleech.arq.eval.eclipse.EclipseWrapper;
import test.org.charleech.arq.eval.util.JulResetter;

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
public class AbstractTestSuite {
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
    public static void before() {
        JulResetter.getINSTANCE().reset();
        EclipseWrapper.getINSTANCE().setSystemProperties();
    }
}
