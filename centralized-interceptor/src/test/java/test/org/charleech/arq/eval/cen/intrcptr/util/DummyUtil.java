package test.org.charleech.arq.eval.cen.intrcptr.util;

import lombok.extern.slf4j.Slf4j;

import org.charleech.arq.eval.cen.intrcptr.CentralizedStereotype;

/**
 * <p>
 * This is a concrete implementing class which represents the dummy utility
 * which is a CDI managed bean.
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
@CentralizedStereotype
@Slf4j
public class DummyUtil {
    /**
     * This is the dummy utility method.
     *
     * @since 0.0.1
     */
    public void dummyUtil() {
        DummyUtil.log.info("This is dummy util");
        this.publicUtil();
    }

    /**
     * This is the dummy utility method. It is invoked directly by the
     * {@link #dummyUtil()}, the it is not a business method.
     *
     * @since 0.0.1
     */
    public void publicUtil() {
        DummyUtil.log.info("This is dummy util public method.");
        this.protectedUtil();
    }

    /**
     * This is the dummy utility method. It is invoked directly by the
     * {@link #publicUtil()}, the it is not a business method.
     *
     * @since 0.0.1
     */
    protected void protectedUtil() {
        DummyUtil.log.info("This is dummy util protected method.");
        this.privateUtil();
    }

    /**
     * This is the dummy utility method. It is invoked directly by the
     * {@link #protectedUtil()}, the it is not a business method.
     *
     * @since 0.0.1
     */
    private void privateUtil() {
        DummyUtil.log.info("This is dummy util private method.");
    }
}
