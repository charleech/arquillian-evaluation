package test.org.charleech.arq.eval.validation;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.junit.runner.RunWith;

/**
 * <p>
 * This is a concrete implementing class which provides the feature for testing
 * the JBoss Seam Validation with the JBoss Arquillian.
 * </p>
 *
 * @author charlee.ch
 * @version 0.0.1
 * @since 0.0.1
 * @see ValidationCustomizedTester
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
@RunWith(Arquillian.class)
public class ValidationCustomizedTester extends AbstractValidationTester {

    /**
     * Create the deploying archive for Arquillian.
     *
     * @return The deploying archive for Arquillian.
     * @since 0.0.1
     */
    @Deployment(name="customized")
    public static EnterpriseArchive deploy() {
        return ArchivePreparation.getINSTANCE().getDeployingCustomized();
    }
}
