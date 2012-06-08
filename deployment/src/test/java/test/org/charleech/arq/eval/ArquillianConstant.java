package test.org.charleech.arq.eval;

/**
 * <p>
 * This is an enumeration which represents the system constants.
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
public enum ArquillianConstant {

    /**
     * This is a constant which represents the separator.
     *
     * @since 0.0.1
     */
    SEPARATOR("/"),

    /**
     * This is a constant which represents to the project root.
     *
     * @since 0.0.1
     */
    ROOT_PROJECT(""),

    /**
     * This is a constant which represents the root configuration folder.
     *
     * @since 0.0.1
     */
    ROOT_CONFIGURE("src/test/resources/arquillian"),

    /**
     * This is a constant which represents the root JavaEE configuration folder.
     *
     * @since 0.0.1
     */
    ROOT_CONFIGURE_JAVAEE("/javaee"),

    /**
     * This is a constant which represents the root Glassfish specific
     * configuration folder.
     *
     * @since 0.0.1
     */
    ROOT_CONFIGURE_GF("/gf"),

    /**
     * This is a constant which represents the deploying Java archive name.
     *
     * @since 0.0.1
     */
    JAVA_ARCHIVE_NAME("my-app.ear"),


    /**
     * This is a constant which represents the deploying EJB archive name.
     *
     * @since 0.0.1
     */
    EJB_ARCHIVE_NAME("my-app-ejb.jar"),

    /**
     * This is a constant which represents the deploying web archive name.
     *
     * @since 0.0.1
     */
    WEB_ARCHIVE_NAME("my-app-web.war"),

    /**
     * This is a constant which represents the deploying enterprise archive
     * name.
     *
     * @since 0.0.1
     */
    EAR_ARCHIVE_NAME("my-app-ear.ear"),

    /**
     * This is a constant which represents the web resource path as
     * WEB-INF/classes/META-INF.
     *
     * @since 0.0.1
     */
    WEB_INF_CLASSES_META_INF("/META-INF");

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
    private ArquillianConstant(final String settingValue) {
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
