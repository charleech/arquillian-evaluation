package test.org.charleech.arq.eval.deploy;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.org.charleech.arq.eval.util.JulResetter;

/**
 * <p>
 * This is a concrete implementing class which provides the feature as a Junit
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
@RunWith(Suite.class)
@SuiteClasses({
    EarTester1.class,
    EarTester1.class,
    EarTester1.class
})
public class EarTestSuite {
    /**
     * This is a before class configuration. The Java Util Logging (JUL) will be
     * reset.
     *
     * @since 0.0.1
     */
    @BeforeClass
    public static void before() {
        JulResetter.getINSTANCE().reset();
    }
}
