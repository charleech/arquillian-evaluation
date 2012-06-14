package org.charleech.arq.eval.validation.custom;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import lombok.extern.slf4j.Slf4j;

import org.charleech.arq.eval.helper.AbstractMarker;
import org.charleech.arq.eval.validation.bean.Person;
/**
 * <p>
 * This is a concrete implementing class which provide the feature for
 * validating the person data bean as the customized constraint.
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
@Slf4j
public class PersonValidator
     extends AbstractMarker
  implements ConstraintValidator<PersonValid, Person> {

    /**
     * This is a variable which represents the {@link ValidationWrappable}.
     *
     * @since 0.0.1
     */
    @Inject
    @ValidationWrappable
    private ValidationWrapper wrapper;

    @Override
    public void initialize(final PersonValid constraintAnnotation) {
        PersonValidator.log.info(this.getMarker(),
                                 "The {} is initialized.",
                                 this.getClass().getName());
    }

    @Override
    public boolean isValid(final Person value,
                           final ConstraintValidatorContext context) {
        return !(this.wrapper.isNullOrEmpty(value.getId())) ||
                (this.wrapper.isNullOrEmpty(value.getName()));
    }

}
