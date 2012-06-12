package org.charleech.arq.eval.helper.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.charleech.arq.eval.helper.AbstractMarker;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.jboss.shrinkwrap.resolver.api.maven.filter.ExclusionsFilter;

/**
 * <p>
 * This is a concrete implementing class which provides the feature described
 * at {@link FeatureWrappable}.
 * </p>
 *
 * @author charlee.ch
 * @version 0.0.1
 * @since 0.0.1
 * @see AbstractMarker
 * @see FeatureWrappable
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
public final class FeatureWrapper extends AbstractMarker
                               implements FeatureWrappable {

    /**
     * <p>
     * This is a self instance which represents and implements the singleton
     * pattern.
     * </p>
     *
     * @since 0.0.1
     */
    @Getter(value = AccessLevel.PUBLIC)
    private static final FeatureWrappable INSTANCE;

    static {
        INSTANCE = new FeatureWrapper();
    }

    /**
     * <p>
     * This is a default constructor.
     * </p>
     * <p>
     * It is a private accessor with purpose to prevent to be instantiated by
     * other with purpose to ensure the singleton pattern.
     * </p>
     *
     * @since 0.0.1
     */
    private FeatureWrapper() {

    }

    @Override
    public File asFile(final String resource) {
        File file = null;
        try {

            FeatureWrapper.
               log.
                  debug(this.getMarker(),
                        "The loading file name is {}",
                        resource);

            file = new File(resource);
            if (!file.exists()) {
                FeatureWrapper.
                   log.
                      warn(this.getMarker(),
                           "The specified resoure {} is not existed.",
                           resource);
                file = null;
            }
            return file;
        } finally {
            file = null;
        }
    }

    @Override
    public File[] getExclusionFromResource(final String pom,
                                           final String exclusions,
                                           final String additional) {
        File[]           dependencies = null;
        ExclusionsFilter filter       = null;
        try {
            filter       = this.getFilter(exclusions, additional);
            dependencies = DependencyResolvers.
                              use(MavenDependencyResolver.class).
                              loadEffectivePom(pom).
                              importAnyDependencies(filter).
                              resolveAsFiles();
            return dependencies;
        } finally {
            dependencies = null;
        }
    }

    /**
     * Get the {@link ExclusionsFilter} by using the specified resources.
     *
     * @param exclusions
     *            The default exclusion list file
     * @param additional
     *            The additional exclusion list file
     * @return The {@link ExclusionsFilter}
     * @since 0.0.1
     */
    private ExclusionsFilter getFilter(final String exclusions,
                                       final String additional) {
        List<String> dependencies = null;
        try {
            dependencies = this.getExclusions(exclusions);
            dependencies.addAll(this.getExclusions(additional));
            return new ExclusionsFilter(dependencies.toArray(new String[0]));
        } finally {
            dependencies = null;
        }
    }

    /**
     * Read the dependencies from specified resource.
     *
     * @param source
     *            The reading resource
     * @return The list of dependencies
     * @since 0.0.1
     */
    private List<String> getExclusions(final String source) {
        Properties                      props         = null;
        Iterator<Entry<Object, Object>> values        = null;
        Entry<Object, Object>           value         = null;
        List<String>                    exclusionList = null;
        String                          message       = null;
        try {
            message       = "Cannot load the exclusion file {}.";
            props         = new Properties();
            exclusionList = Collections.
                               synchronizedList(
                                  new ArrayList<String>());
            props.loadFromXML(new FileInputStream(this.asFile(source)));
            values = props.entrySet().iterator();
            while (values.hasNext()) {
                value = values.next();
                exclusionList.add(value.getValue().toString().trim());
            }

            props.clear();

            return exclusionList;

        } catch (final InvalidPropertiesFormatException e) {
            FeatureWrapper.log.warn(this.getMarker(), "", e);
            FeatureWrapper.log.warn(this.getMarker(), message, source);
            return exclusionList;
        } catch (final IOException e) {
            FeatureWrapper.log.warn(this.getMarker(), "", e);
            FeatureWrapper.log.warn(this.getMarker(), message, source);
            return exclusionList;
        } finally {
            props         = null;
            values        = null;
            value         = null;
            exclusionList = null;
            message       = null;
        }
    }

}
