package org.charleech.arq.eval.validation.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.charleech.arq.eval.validation.custom.PersonValid;
/**
 * <p>
 * This is a concrete implementing class which provides the feature as a Person
 * data bean.
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
@Data
@EqualsAndHashCode(
        callSuper       = false,
        doNotUseGetters = true,
        of              = { "id" }
)
@ToString(
        callSuper         = true,
        includeFieldNames = true,
        doNotUseGetters   = false
)
@Entity
@Table(
        name = "Person"
        )
@PersonValid
public class Person implements Serializable {

    /**
     * This is a default serial version UID.
     *
     * @since 0.0.1
     */
    private static final long serialVersionUID = 1L;

    /**
     * This is a variable which represents the id.
     *
     * @since 0.0.1
     */
    @Id
    @Column(
            name     = "ID",
            nullable = false,
            length   = 36
    )
    private String id;

    /**
     * This is a variable which represents the name.
     *
     * @since 0.0.1
     */
    @Column(
            name     = "NAME",
            nullable = false,
            length   = 255
    )
    private String name;
}
