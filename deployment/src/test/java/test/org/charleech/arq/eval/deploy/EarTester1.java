package test.org.charleech.arq.eval.deploy;

import javax.ejb.EJB;
import javax.inject.Inject;

import junit.framework.Assert;

import org.charleech.arq.eval.deploy.DummyServiceable;
import org.charleech.arq.eval.deploy.DummyWrapper;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <p>
 * This is a concrete implementing class which provides the feature for testing
 * the deploying the {@link EnterpriseArchive} to the Arquillian.
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
@RunWith(Arquillian.class)
public class EarTester1 {

    /**
     * Create the deploying archive for Arquillian.
     *
     * @return The deploying archive for Arquillian.
     * @since 0.0.1
     */
    @Deployment
    public static EnterpriseArchive deploy() {
        return ArchivePreparation.getINSTANCE().getDeploying(
                  String.valueOf(System.currentTimeMillis()));
    }

    /**
     * This is a variable which represents the EJB which is deployed by the
     * Arquillian for testing the EJB injection.
     *
     * @since 0.0.1
     */
    @EJB
    private DummyServiceable dummyService;

    /**
     * This is a variable which represent the {@link DummyWrapper} for testing
     * the CDI injection.
     *
     * @since 0.0.1
     */
    @Inject
    private DummyWrapper wrapper;

    /**
     * This is a success test case for ensuring that the Arquillian deploy
     * the archive successfully.
     *
     * @since 0.0.1
     */
    @Test
    public void whenEnsureDeployment() {
        String name   = "Charlee";
        String result = null;
        try {
            Assert.assertNotNull("The dummy wraper is null.",
                    this.wrapper);

            this.wrapper.dummy();

            Assert.assertNotNull("The dummy service is null.",
                                 this.dummyService);


            result = this.dummyService.greet(name);
            Assert.assertEquals("The result is unexpected.",
                                "Hello ".concat(name),
                                result);
        } finally {
            name   = null;
            result = null;
        }
    }

}
