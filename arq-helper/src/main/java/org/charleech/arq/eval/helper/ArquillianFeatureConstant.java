package org.charleech.arq.eval.helper;

/**
 * <p>
 * This is an enumeration which represents the system feature constants.
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
public enum ArquillianFeatureConstant {

    /**
     * This is a constant which represents the Apache Maven configuration, the
     * testing pom.xml.
     *
     * @since 0.0.1
     */
    POM("pom.xml"),

    /**
     * This is a constant which represents the EJB configuration, the
     * ejb-jar.xml.
     *
     * @since 0.0.1
     */
    EJB_JAR("/ejb-jar.xml"),

    /**
     * This is a constant which represents the web configuration, the web.xml.
     *
     * @since 0.0.1
     */
    WEB("/web.xml"),

    /**
     * This is a constant which represents the enterprise configuration, the
     * application.xml.
     *
     * @since 0.0.1
     */
    APPLICATION("/application.xml"),

    /**
     * This is a constant which represents the Glassfish specific EJB
     * configuration, the ejb-jar.xml.
     *
     * @since 0.0.1
     */
    GF_EJB_JAR("/glassfish-ejb-jar.xml"),

    /**
     * This is a constant which represents the Glassfish specific web
     * configuration, the web.xml.
     *
     * @since 0.0.1
     */
    GF_WEB("/glassfish-web.xml"),

    /**
     * This is a constant which represents the Glassfish specific enterprise
     * configuration, the application.xml.
     *
     * @since 0.0.1
     */
    GF_APPLICATION("/glassfish-application.xml"),

    /**
     * This is a constant which represents the Glassfish log properties.
     *
     * @since 0.0.1
     */
    GF_LOG("/gf-log.properties"),

    /**
     * This is a constant which represents the CDI configuration, the beans.xml.
     *
     * @since 0.0.1
     */
    BEANS("/beans.xml"),

    /**
     * This is a constant which represents the bean validation, the
     * validation.xml.
     *
     * @since 0.0.1
     */
    VALIDATION("/validation.xml"),

    /**
     * This is a constant which represents the bean validation, the
     * validation.xml.
     *
     * @since 0.0.1
     */
    VALIDATION_MESSAGE("/ValidationMessages.properties"),

    /**
     * This is a constant which represents the logback configuration, the
     * logback-test.xml.
     *
     * @since 0.0.1
     */
    LOG_BACK_TEST("/logback-test.xml"),

    /**
     * This is a constant which represents the JPA configuration, the
     * persistence.xml.
     *
     * @since 0.0.1
     */
    PERSISTENCE("/persistence.xml"),

    /**
     * This is a constant which represents the Apache Maven exclusion dependency
     * list.
     *
     * @since 0.0.1
     */
    MAVEN_EXCLUSIONS("/default-maven-exclusions.xml"),

    /**
     * This is a constant which represents the Apache Maven additional exclusion
     * dependency list.
     *
     * @since 0.0.1
     */
    MAVEN_EXCLUSIONS_ADDITIONAL("/additional-maven-exclusions.xml");

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
    private ArquillianFeatureConstant(final String settingValue) {
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
