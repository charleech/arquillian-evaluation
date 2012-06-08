package test.org.charleech.arq.eval.eclipse;

/**
 * <p>
 * This is an interface which provides the feature for preparing the Eclipse IDE
 * for working with the Arquillian.
 * </p>
 * <p>
 * Since the Eclipse/JUnit does not integrated to the mavan-surefure-plugin,
 * then the system properties will not be existed.
 * </p>
 *
 * @author charlee.ch
 * @version 0.0.1
 * @since 0.0.1
 * @see <a href="https://github.com/charleech/arquillian-evaluation/issues/4">
GitHub Issue #4</a>
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
public interface EclipseWrappable {
    /**
     * Set the system properties
     */
    void setSystemProperties();
}
