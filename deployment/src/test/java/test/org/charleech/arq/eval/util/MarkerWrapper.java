package test.org.charleech.arq.eval.util;

import lombok.AccessLevel;
import lombok.Getter;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * <p>
 * This is a concrete implementing class which provides the feature described
 * at {@link MarkerWrappable}.
 * </p>
 *
 * @author charlee.ch
 * @version 0.0.1
 * @since 0.0.1
 * @see MarkerWrappable
 */
public class MarkerWrapper implements MarkerWrappable {


    /**
     * This is a constant which represents the the Weld-SE subclass postfix.
     *
     * @since 0.0.1
     */
    private static final String WELD_POSTFIX;

    /**
     * This is a constant which represents the the Weld-SE subclass infix.
     *
     * @since 0.0.1
     */
    private static final String WELD_INFIX;

    /**
     * <p>
     * This is a self instance which represents and implements the singleton
     * pattern.
     * </p>
     *
     * @since 0.0.1
     */
    @Getter(value = AccessLevel.PUBLIC)
    private static final MarkerWrappable INSTANCE;

    static {
        WELD_POSTFIX = "WeldSubclass";
        WELD_INFIX   = "Proxy";
        INSTANCE     = new MarkerWrapper();
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
    private MarkerWrapper() {

    }

    @Override
    public Marker getMarker(final Class<?> clazz) {
        String name   = null;
        Marker marker = null;
        try {
            name   = this.getTargetClass(clazz).
                        getPackage().
                           getName();
            marker = this.getMarker(name);
            return marker;
        } finally {
            marker = null;
            name   = null;
        }
    }

    @Override
    public Marker getMarker(final String markerName) {
        return MarkerFactory.getMarker(markerName);
    }

    /**
     * Get the target class.
     *
     * @param determined
     *            The determining class
     * @return The target class
     * @since 0.0.1
     */
    private Class<?> getTargetClass(final Class<?> determined) {
        Class<?> clazz = null;
        try {
            clazz = determined;
            if (this.isWeldSubClass(clazz)) {
                clazz = clazz.getSuperclass();
            }
            return clazz;
        } finally {
            clazz = null;
        }
    }

    /**
     * Determine if it is a Weld subclass or not. Normally, it occurs only when
     * using the Weld-SE.
     *
     * @param clazz
     *            The determining class
     * @return The determined result
     * @since 0.0.1
     */
    protected boolean isWeldSubClass(final Class<?> clazz) {
        boolean result = false;
        String  name   = null;

        name = clazz.getName();

        result =
           (name.indexOf(MarkerWrapper.WELD_INFIX) != -1)
        && (name.indexOf(MarkerWrapper.WELD_POSTFIX) != -1);

        return result;
    }

}
