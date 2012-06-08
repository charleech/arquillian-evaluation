package org.charleech.arq.eval.deploy;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * <p>
 * This is a concrete implementing class which provides the feature described
 * at {@link DummyServiceable}.
 * </p>
 *
 * @author charlee.ch
 * @version 0.0.1
 * @see DummyServiceable
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
   endpointInterface = "org.charleech.arq.eval.deploy.DummyServiceable",
   serviceName       = "engine/ejb/DummyService",
   portName          = "DummyPort"
)
public final class DummyService implements DummyServiceable {

    @Override
    public String greet(final String name) {
        String result = null;

        result = "Hello " + name;
        return result;
    }
}
