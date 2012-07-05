package test.org.charleech.arq.eval.cen.intrcptr.service;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <p>
 * This is an interface which described the feature for greeting.
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
@Remote
@WebService
public interface DummyServiceable {
    /**
     * Greet to the specified name.
     *
     * @param name The greeting name.
     *
     * @return The greet message.
     * @since 0.0.1
     */
    @WebMethod
    String greet(@WebParam(name = "name") final String name);
}
