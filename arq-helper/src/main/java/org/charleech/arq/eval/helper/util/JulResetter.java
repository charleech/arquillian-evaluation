package org.charleech.arq.eval.helper.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.LogManager;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.charleech.arq.eval.helper.AbstractMarker;
import org.charleech.arq.eval.helper.ArquillianConstant;
import org.charleech.arq.eval.helper.ArquillianFeatureConstant;

/**
 * <p>
 * This is a concrete implementing class which provides the feature described
 * at {@link JulResettable}.
 * </p>
 *
 * @author charlee.ch
 * @version 0.0.1
 * @since 0.0.1
 * @see AbstractMarker
 * @see JulResettable
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
public final class JulResetter extends AbstractMarker implements JulResettable {

    /**
     * This is a default JUL configuration.
     *
     * @since 0.0.1
     */
    private static final String CONFIGURE;

    /**
     * <p>
     * This is a self instance which represents and implements the singleton
     * pattern.
     * </p>
     *
     * @since 0.0.1
     */
    @Getter(value = AccessLevel.PUBLIC)
    private static final JulResettable INSTANCE;

    static {
        INSTANCE  = new JulResetter();
        CONFIGURE = ArquillianConstant.ROOT_CONFIGURE.getValue()
                  + ArquillianConstant.ROOT_CONFIGURE_GF.getValue()
                  + ArquillianFeatureConstant.GF_LOG.getValue();
    }

    /**
     * <p>
     * This is a default constructor.
     * </p>
     * <p>
     * It is a private accessor with purpose to prevent to be instantiated by
     * other with purpose to ensure the singleton pattern.
     * </p>
     *
     * @since 0.0.1
     */
    private JulResetter() {
        super();
    }

    @Override
    public void reset() {
        this.reset(JulResetter.CONFIGURE);
    }

    @Override
    public void reset(final String resettingProperties) {
        LogManager manager = null;
        File       log     = null;
        try {
            JulResetter.log.info("The resetting properties is {}",
                                 resettingProperties);
            log = new File(resettingProperties);

            manager = LogManager.getLogManager();
            manager.readConfiguration(new FileInputStream(log));

        } catch (final Exception e) {
            JulResetter.log.error(
               this.getMarker(),
               "Cannot set customized glassfish logging. ",
               e);
        } finally {
            manager = null;
            log     = null;
        }
    }

}
