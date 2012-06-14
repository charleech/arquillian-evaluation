package test.org.charleech.arq.eval.validation;

/**
 * <p>
 * This is an enumeration which represents the deploying mode.
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
public enum DeployingMode {
    /**
     * This is a constant which represents the normal seam validation
     * configuration deployment.
     *
     * @since 0.0.1
     */
    NORMAL,

    /**
     * This is a constant which represents the extended seam validation
     * configuration deployment.
     *
     * @since 0.0.1
     */
    EXTENDED,

    /**
     * This is a constant which represents the customized seam validation
     * configuration deployment.
     *
     * @since 0.0.1
     */
    CUSTOMIZED,
}
