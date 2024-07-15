/**
 * Setting.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     thanh
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import grass.micro.apps.model.base.StatusLockAuditableEntity;
import grass.micro.apps.model.util.JsonToMapConverter;

/**
 * Setting.
 * <<< Detail note.
 * @author nt.duong
 * @access public
 */
@Entity
@Table(name = "m_setting")
public class Setting extends StatusLockAuditableEntity implements Serializable {

    private static final long serialVersionUID = 6792159178465950057L;
    
    @Column(name = "`key`", nullable = false, length = 64)
    private String key;
    
    @Column(name = "`value`", nullable = false)
    @Convert(converter = JsonToMapConverter.class)
    private LinkedHashMap<String, String> value;
    
    public Setting() {
    }

    /**
     * @param key
     * @param value
     */
    public Setting(String key, LinkedHashMap<String, String> value) {
        super();
        this.key = key;
        this.value = value;
    }

    /**
     * get value of <b>key</b>.
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Set value to <b>key</b>.
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * get value of <b>value</b>.
     * @return the value
     */
    public LinkedHashMap<String, String> getValue() {
        return value;
    }

    /**
     * Set value to <b>value</b>.
     * @param value the value to set
     */
    public void setValue(LinkedHashMap<String, String> value) {
        this.value = value;
    }

}
