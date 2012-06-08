package test.org.charleech.arq.eval.util;

import java.io.File;

/**
 * <p>
 * This is an interface which provides the feature for loading the resource
 * as a file for helping adding the featured resources.
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
public interface FeatureWrappable {
    /**
     * Get the specified resource from the specified root folder.
     *
     * @param resource
     *            The resource
     * @return The resource as {@link File}
     * @since 0.0.1
     */
    File asFile(final String resource);

    /**
     * Get the exclusion dependency list from the resource.
     *
     * @param pom
     *            The testing Apache Maven POM
     * @param exclusions
     *            The default exclusion list file
     * @param additional
     *            The additional exclusion list file
     * @return The exclusion dependency list
     * @since 0.0.1
     */
    File[] getExclusionFromResource(final String pom,
                                    final String exclusions,
                                    final String additional);
}
