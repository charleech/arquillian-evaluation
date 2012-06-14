package org.charleech.arq.eval.validation.seam;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.Validation;

import lombok.extern.slf4j.Slf4j;

import org.jboss.seam.validation.InjectingConstraintValidatorFactory;
import org.jboss.weld.manager.BeanManagerImpl;

/**
* JBoss, Home of Professional Open Source
*
* Copyright 2011, Red Hat, Inc., and individual contributors
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
/**
* A {@link ConstraintValidatorFactory} which enables CDI based dependency injection for the created {@link ConstraintValidator}
* s. Validator types must be valid CDI beans - in particular they must be defined in a bean deployment archive (BDA) - in order
* to make use of DI services.
*
* Please take a big not, this class has been copied by Charlee Ch. with
* purpose to debug the Seam Validation only.
*
* @author Gunnar Morling
* @see <a href="https://github.com/seam/validation">Seam Validation</a>
*/
@Slf4j
public class ExtendedInjectingConstraintValidatorFactory
     extends InjectingConstraintValidatorFactory {

   /**
    * The default constraint validator factory. The creation of validators
    * which are no compliant CDI bean (not contained in a BDA etc.) will be
    * delegated to this factory.
    */
   private final ConstraintValidatorFactory delegate;

    /**
     * This is a default constructor which will initiate the default
     * {@link ConstraintValidatorFactory} for delegating when the CDI bean is
     * not found or the customized constraint is not a CDI bean.
     */
   public ExtendedInjectingConstraintValidatorFactory() {
       ExtendedInjectingConstraintValidatorFactory.log.info(
          "This is a constructor");
       this.delegate =
               Validation.byDefaultProvider().configure()
                       .getDefaultConstraintValidatorFactory();
       ExtendedInjectingConstraintValidatorFactory.log.info(
          "The delegated is {}",
          this.delegate);
   }

   @Override
   @SuppressWarnings("unchecked")
   public <T extends ConstraintValidator<?, ?>>
          T getInstance(final Class<T> key) {
       T                    theValue    = null;
       BeanManager          beanManager = null;
       Set<Bean<?>>         beans       = null;
       Bean<?>              bean        = null;
       CreationalContext<?> ctx         = null;
       try {
           if (!this.isBeanManagerAvailable()) {
               throw new IllegalStateException(
                       "No bean manager is available. In order to use "
                     + "InjectingConstraintValidatorFactory, "
                     + "the javax.validation.Validator "
                     + "must either be retrieved via dependency injection or "
                     + "a bean manager must be available via JNDI.");
           }

           beanManager = this.getBeanManager();
           ExtendedInjectingConstraintValidatorFactory.log.trace(
              "The bean manager is {}",
              beanManager);

           ExtendedInjectingConstraintValidatorFactory.log.trace(
              beanManager.getClass().getName());

           final BeanManagerImpl x = (BeanManagerImpl) beanManager;


           ExtendedInjectingConstraintValidatorFactory.log.trace("" +
           		"The accessible beans are\r\n{}",
           		x.getAccessibleBeans());
           ExtendedInjectingConstraintValidatorFactory.log.trace(
               "The beans are\r\n{}",
               x.getBeans());

           beans = beanManager.getBeans(key);
           ExtendedInjectingConstraintValidatorFactory.log.trace(
              "The beans {} is looked up by using key as {}",
              beans,
              key);

           if (!beans.isEmpty()) {
               ExtendedInjectingConstraintValidatorFactory.log.info(
                  "It is a CDI bean.");
               // The given type is a CDI bean, so the container will deal with
               // injection etc.
               bean = beanManager.resolve(beans);
               ExtendedInjectingConstraintValidatorFactory.log.trace(
                  "The bean is {}",
                  bean);

               ctx  = beanManager.createCreationalContext(bean);
               ExtendedInjectingConstraintValidatorFactory.log.trace(
                  "The context is {}",
                  ctx);

               theValue = (T) beanManager.getReference(bean, key, ctx);
               ExtendedInjectingConstraintValidatorFactory.log.debug(
                  "The value is {}",
                  theValue);
           } else {
               ExtendedInjectingConstraintValidatorFactory.log.info(
                  "It is not a CDI bean.");
               // The given type is no CDI bean, so delegate the creation to
               // the default factory.
               theValue = this.delegate.getInstance(key);
               ExtendedInjectingConstraintValidatorFactory.log.debug(
                  "The value is {}", theValue);
           }

           return theValue;
       } finally {
           theValue    = null;
           beanManager = null;
           beans       = null;
           bean        = null;
           ctx         = null;
       }
   }
}
