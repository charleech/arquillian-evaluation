package org.charleech.arq.eval.helper.util;


/**
 * <p>
 * This is an interface which provides the feature for resetting the Java
 * utility logging framework (JUL).
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
public interface JulResettable {
    /**
     * Reset the Java utility logging framework (JUL).
     *
     * @param resettingProperties
     *            The resetting properties
     * @since 0.0.1
     */
    void reset(final String resettingProperties);

    /**
     * Reset the Java utility logging framework (JUL) by using the default
     * configuration.
     *
     * @since 0.0.1
     */
    void reset();
}
