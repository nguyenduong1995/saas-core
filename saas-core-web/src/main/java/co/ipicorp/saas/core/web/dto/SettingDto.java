/**
 * SettingDto.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     nt.duong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.dto;

import java.io.Serializable;

/**
 * SettingDto.
 * <<< Detail note.
 * @author nt.duong
 * @access public
 */
public class SettingDto implements Serializable {

    private static final long serialVersionUID = -3278011272091586126L;
    
    private Integer id;
    
    private String key;
    
    private String appName;
    
    private String logo;
    
    private String icon;
    
    private String avatarLandingPage;
    
    private String emailStaff;
    
    private String emailRetailer;
    
    public SettingDto() {
    }

    /**
     * get value of <b>id</b>.
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set value to <b>id</b>.
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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

    public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getAvatarLandingPage() {
		return avatarLandingPage;
	}

	public void setAvatarLandingPage(String avatarLandingPage) {
		this.avatarLandingPage = avatarLandingPage;
	}

    /**
     * get value of <b>emailStaff</b>.
     * @return the emailStaff
     */
    public String getEmailStaff() {
        return emailStaff;
    }

    /**
     * Set value to <b>emailStaff</b>.
     * @param emailStaff the emailStaff to set
     */
    public void setEmailStaff(String emailStaff) {
        this.emailStaff = emailStaff;
    }

    public String getEmailRetailer() {
		return emailRetailer;
	}

	public void setEmailRetailer(String emailRetailer) {
		this.emailRetailer = emailRetailer;
	}

	@Override
    public String toString() {
        return "SettingDto [id=" + id + ", key=" + key + ", appName=" + appName + ", logo=" + logo + ", icon=" + icon + ", avatarLandingPage="
                + avatarLandingPage + ", emailStaff=" + emailStaff + ", emailRetailer=" + emailRetailer + "]";
    }
}
