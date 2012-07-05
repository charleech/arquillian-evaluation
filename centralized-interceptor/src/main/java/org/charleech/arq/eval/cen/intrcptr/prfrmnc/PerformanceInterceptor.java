package org.charleech.arq.eval.cen.intrcptr.prfrmnc;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import lombok.extern.slf4j.Slf4j;

import org.charleech.arq.eval.helper.AbstractMarker;

/**
 * <p>
 * This is a concrete implementing class which provides the feature for
 * capturing the process time for each process. as a CDI interceptor.
 * </p>
 *
 * @author charlee.ch
 * @version 0.0.1
 * @since 0.0.1
 * @see AbstractMarker
 * @see PerformanceInterceptable
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
@PerformanceInterceptable
@Interceptor
@Slf4j
public class PerformanceInterceptor extends AbstractMarker {
    /**
     * This is a callback method for performing as the business method
     * interception.
     *
     * @param context
     *            The {@link InvocationContext}
     * @return The processed result object.
     * @throws Exception
     *             If there is any error.
     * @since 0.0.1
     */
    @AroundInvoke
    public Object perform(final InvocationContext context) throws Exception {
        Object result = null;
        long   start  = -1L;
        try {
            start  = System.nanoTime();
            result = context.proceed();
            PerformanceInterceptor.log.info(
               this.getMarker(),
               "The elapses time is {} nanosec.",
               System.nanoTime() - start);
            return result;
        } finally {
            result = null;
        }
    }

}
