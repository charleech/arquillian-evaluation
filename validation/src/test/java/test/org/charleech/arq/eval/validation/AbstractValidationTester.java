package test.org.charleech.arq.eval.validation;

import javax.ejb.EJB;

import junit.framework.Assert;
import lombok.extern.slf4j.Slf4j;

import org.charleech.arq.eval.helper.AbstractMarker;
import org.charleech.arq.eval.validation.bean.Person;
import org.charleech.arq.eval.validation.service.DummyServiceable;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
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
 * @see AbstractMarker
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
@Slf4j
public abstract class AbstractValidationTester extends AbstractMarker {

    /**
     * This is a variable which represents the EJB which is deployed by the
     * Arquillian for testing.
     *
     * @since 0.0.1
     */
    @EJB
    private DummyServiceable dummyService;

    /**
     * This is a success test case for ensuring that the Arquillian deploy
     * the archive successfully.
     *
     * @since 0.0.1
     */
    @Test
    public void whenEnsureDeployment() {
        Person person = null;
        String result = null;
        try {
            Assert.assertNotNull("The dummy service is null.",
                                 this.dummyService);
            person = new Person();
            person.setId("001");
            person.setName("Charlee");

            result = this.dummyService.greet(person);

            AbstractValidationTester.log.info(
               this.getMarker(),
               "The result is {}",
               result);

            Assert.assertEquals("The result is unexpected.",
                                "Hello ".concat(person.getName()),
                                result);
        } finally {
            person = null;
            result = null;
        }
    }
}
