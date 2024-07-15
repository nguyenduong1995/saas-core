/**
 * District.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import grass.micro.apps.model.base.AbstractIdentifiedEntity;

/**
 * District. <<< Detail note.
 * 
 * @author hieumicro
 * @access public
 */
@Entity
@Table(name = "m_district")
public class District extends AbstractIdentifiedEntity implements Serializable {

    private static final long serialVersionUID = 8022846012202055692L;

    @Column(name = "code", nullable = false, length = 5)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "`type`", nullable = false, length = 30)
    private String type;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    /**
     * get value of <b>code</b>.
     * 
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Set value to <b>code</b>.
     * 
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * get value of <b>name</b>.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set value to <b>name</b>.
     * 
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get value of <b>type</b>.
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Set value to <b>type</b>.
     * 
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * get value of <b>city</b>.
     * 
     * @return the city
     */
    public City getCity() {
        return city;
    }

    /**
     * Set value to <b>city</b>.
     * 
     * @param city
     *            the city to set
     */
    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "District [code=" + code + ", name=" + name + ", type=" + type + ", city=" + city + "]";
    }

}
