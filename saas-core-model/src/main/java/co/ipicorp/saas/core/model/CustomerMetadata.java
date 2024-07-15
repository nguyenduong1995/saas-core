/**
 * CustomerMetadata.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import co.ipicorp.saas.core.model.util.CustomerMetakeyTypeConverter;

import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import grass.micro.apps.model.base.AbstractLockAuditableEntity;
import grass.micro.apps.model.util.JsonToMapConverter;

/**
 * CustomerMetadata. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "td_customer_metadata")
public class CustomerMetadata extends AbstractLockAuditableEntity implements Serializable {

	private static final long serialVersionUID = -8659575560778442695L;

	@Column(name = "customer_id", nullable = false, length = 11)
    private Integer customerId;
	
	@Convert(converter = CustomerMetakeyTypeConverter.class)
	@Column(name = "meta_key_type", nullable = false)
    private CustomerMetakeyType metaKeyType;
	
	@Column(name = "meta_key", nullable = false, length = 64)
    private String metaKey;
	
	@Column(name = "text_content", nullable = true, length = 1024)
    private String textContent;
	
	@Column(name = "meta_content", nullable = false)
	@Convert(converter = JsonToMapConverter.class)
    private LinkedHashMap<String, Object> metaContent;
	
	@Column(name = "jwt_secret_salt", nullable = true, length = 128)
    private String jwtSecretSalt;
	
	@Column(name = "jwt_content", nullable = true)
    private String jwtContent;

	/**
     * @return the customerId
     */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param name the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
     * @return the metaKey
     */
	public String getMetaKey() {
		return metaKey;
	}

	/**
	 * @param name the metaKey to set
	 */
	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}

	/**
     * @return the metaContent
     */
	public LinkedHashMap<String, Object> getMetaContent() {
		return metaContent;
	}

	/**
	 * @param name the metaContent to set
	 */
	public void setMetaContent(LinkedHashMap<String, Object> metaContent) {
		this.metaContent = metaContent;
	}

	/**
     * @return the jwtSecretSalt
     */
	public String getJwtSecretSalt() {
		return jwtSecretSalt;
	}

	/**
	 * @param name the jwtSecretSalt to set
	 */
	public void setJwtSecretSalt(String jwtSecretSalt) {
		this.jwtSecretSalt = jwtSecretSalt;
	}

	/**
     * @return the jwtContent
     */
	public String getJwtContent() {
		return jwtContent;
	}

	/**
	 * @param name the jwtContent to set
	 */
	public void setJwtContent(String jwtContent) {
		this.jwtContent = jwtContent;
	}
	
	/**
     * get value of <b>metaKeyType</b>.
     * @return the metaKeyType
     */
    public CustomerMetakeyType getMetaKeyType() {
        return metaKeyType;
    }

    /**
     * Set value to <b>metaKeyType</b>.
     * @param metaKeyType the metaKeyType to set
     */
    public void setMetaKeyType(CustomerMetakeyType metaKeyType) {
        this.metaKeyType = metaKeyType;
    }

    /**
     * get value of <b>textContent</b>.
     * @return the textContent
     */
    public String getTextContent() {
        return textContent;
    }

    /**
     * Set value to <b>textContent</b>.
     * @param textContent the textContent to set
     */
    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String toString() {
        return "CustomerMetadata [customerId=" + customerId + ", metaKeyType=" + metaKeyType + ", metaKey=" + metaKey + ", textContent=" + textContent
                + ", metaContent=" + metaContent + ", jwtSecretSalt=" + jwtSecretSalt + ", jwtContent=" + jwtContent + "]";
    }
	
}
