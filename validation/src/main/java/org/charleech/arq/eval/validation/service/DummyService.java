package org.charleech.arq.eval.validation.service;

import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import lombok.extern.slf4j.Slf4j;

import org.charleech.arq.eval.helper.AbstractMarker;
import org.charleech.arq.eval.validation.bean.Person;

/**
 * <p>
 * This is a concrete implementing class which provides the feature described
 * at {@link DummyServiceable}.
 * </p>
 *
 * @author charlee.ch
 * @version 0.0.1
 * @see DummyServiceable
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
@Stateless
@WebService(
   endpointInterface =
                   "org.charleech.arq.eval.validation.service.DummyServiceable",
   serviceName       = "engine/ejb/DummyService",
   portName          = "DummyPort"
)
@Slf4j
public class DummyService extends AbstractMarker implements DummyServiceable {

    /**
     * This is variable which represents the {@link Validator}.
     *
     * @since 0.0.1
     */
    @Inject
    private Validator validator;

    public static final EntityManagerFactory EMF;

    static {
        EMF = Persistence.createEntityManagerFactory("mydb");
    }

    @Override
    public String greet(final Person person) {
        String                           result     = null;
        Set<ConstraintViolation<Person>> violations = null;
        Person                           data       = null;
        EntityManager                    em         = null;
        try {
            violations = this.validator.validate(person);

            if (violations.size() > 0) {
                this.printViolations(violations);
                result = "ERROR";
            } else {
                result = "Hello " + person.getName();
            }

            em = DummyService.EMF.createEntityManager();

            em.persist(person);

            data = em.find(Person.class, person.getId());

            if (data == null) {
                DummyService.log.warn(this.getMarker(),
                                      "Cannot find by using id as {}",
                                      person.getId());
            } else {
                DummyService.log.info(this.getMarker(),
                                      "The found data is {}",
                                      data);
            }

            return result;
        } finally {
            result = null;
            data   = null;
            if (violations != null) {
                violations.clear();
                violations = null;
            }
            if ((em != null) && (em.isOpen())) {
                em.close();
                em = null;
            }
        }
    }

    /**
     * Print the {@link ConstraintViolation}.
     *
     * @param constraintViolations
     *            The printing {@link ConstraintViolation}
     * @since 0.0.1
     */
    private void printViolations( final Set<ConstraintViolation<Person>>
                                        constraintViolations) {
        DummyService.log.info(this.getMarker(),
                "The violations size is {}.", constraintViolations.size());

        for (final ConstraintViolation<Person> violation : constraintViolations) {
            DummyService.log.info(
                    this.getMarker(),
                    "The message is {}",
                    violation.getMessage());
            DummyService.log.info(
                    this.getMarker(),
                    "The message template is {}",
                    violation.getMessageTemplate());
            DummyService.log.info(
                    this.getMarker(),
                    "The property path is {}",
                    violation.getPropertyPath());

        }
    }
}
