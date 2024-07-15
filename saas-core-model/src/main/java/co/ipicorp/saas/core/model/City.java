/**
 * City.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import grass.micro.apps.model.base.AbstractIdentifiedEntity;

/**
 * City. <<< Detail note.
 * 
 * @author hieumicro
 * @access public
 */
@Entity
@Table(name = "m_city")
public class City extends AbstractIdentifiedEntity implements Serializable {

    private static final long serialVersionUID = 8022846012202055692L;

    @Column(name = "code", nullable = false, unique = true, length = 5)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "`type`", nullable = false, length = 30)
    private String type;
    
    @Column(name = "`region_id`", nullable = false)
    private Integer regionId;

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
     * get value of <b>regionId</b>.
     * @return the regionId
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * Set value to <b>regionId</b>.
     * @param regionId the regionId to set
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "City [code=" + code + ", name=" + name + ", type=" + type + ", regionId=" + regionId + "]";
    }

}
