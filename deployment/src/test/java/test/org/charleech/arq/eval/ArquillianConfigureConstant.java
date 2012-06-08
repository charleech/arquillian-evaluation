package test.org.charleech.arq.eval;

/**
 * <p>
 * This is an enumeration which represents the Arquillian constants.
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
public enum ArquillianConfigureConstant {

    /**
     * This is a constant which represents the environment variable named
     * ARQUILLIAN_GF_ROOT.
     *
     * @since 0.0.1
     */
    ArquillianGfRoot("ARQUILLIAN_GF_ROOT"),

    /**
     * This is a constant which represents the Arquillian/Glassfish system
     * properties.
     *
     * @since 0.0.1
     */
    GfBindHttpPort("my.arquillian.glassfish.http.port"),

    /**
     * This is a constant which represents the Arquillian/Glassfish system
     * properties.
     *
     * @since 0.0.1
     */
    GfInstallRoot("my.arquillian.glassfish.root"),

    /**
     * This is a constant which represents the Arquillian/Glassfish system
     * properties.
     *
     * @since 0.0.1
     */
    GfInstanceRoot("my.arquillian.glassfish.instance"),

    /**
     * This is a constant which represents the Java system properties named
     * java.endorsed.dirs.
     */
    JavaEndorsedDirs("java.endorsed.dirs");

    /**
     * This is a variable which represents the enumeration value.
     *
     * @since 0.0.1
     */
    private String value;

    /**
     * This is a constructor which receives the value for construction.
     *
     * @param settingValue
     *            The setting value
     * @since 0.0.1
     */
    private ArquillianConfigureConstant(final String settingValue) {
        this.value = settingValue;
    }

    /**
     * Get the enumeration value.
     *
     * @return The enumeration value
     * @since 0.0.1
     */
    public String getValue() {
        return this.value;
    }
}
