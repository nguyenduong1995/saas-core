package co.ipicorp.saas.core.model;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import grass.micro.apps.model.base.StatusLockAuditableEntity;
import grass.micro.apps.model.util.JsonToMapConverter;

/**
 * CustomerRegistration. <<< Detail note.
 * 
 * @author nt.duong
 * @access public
 */
@Entity
@Table(name = "t_customer_registration")
public class CustomerRegistration extends StatusLockAuditableEntity {

	private static final long serialVersionUID = 1630401156014459116L;

	@Column(name = "fullname", nullable = false, length = 255)
    private String fullname;

    @Column(name = "email", nullable = false, length = 255)
    private String email;
    
    @Column(name = "industry_id", nullable = false, length = 11)
	private Integer industryId;
    
    @Column(name = "address", nullable = true, length = 1024)
	private String address;

	@Column(name = "city_id", nullable = true)
	private Integer city;

	@Column(name = "district_id", nullable = true)
	private Integer districtId;

	@Column(name = "ward_id", nullable = true)
	private Integer wardId;
    
    @Column(name = "website", nullable = true, length = 255)
    private String website;
    
    @Column(name = "representative", nullable = true, length = 255)
    private String representative;
    
    @Column(name = "representative_email", nullable = true, length = 255)
    private String representativeEmail;

    @Column(name = "representative_mobile", nullable = false, length = 16)
    private String representativeMobile;
    
    @Column(name = "extra", nullable = true)
    @Convert(converter = JsonToMapConverter.class)
    private LinkedHashMap<String, Object> extra;

    /**
     * get value of <b>fullname</b>.
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Set value to <b>fullname</b>.
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * get value of <b>email</b>.
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value to <b>email</b>.
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get value of <b>industryId</b>.
     * @return the industryId
     */
    public Integer getIndustryId() {
        return industryId;
    }

    /**
     * Set value to <b>industryId</b>.
     * @param industryId the industryId to set
     */
    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    /**
     * get value of <b>address</b>.
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set value to <b>address</b>.
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get value of <b>city</b>.
     * @return the city
     */
    public Integer getCity() {
        return city;
    }

    /**
     * Set value to <b>city</b>.
     * @param city the city to set
     */
    public void setCity(Integer city) {
        this.city = city;
    }

    /**
     * get value of <b>districtId</b>.
     * @return the districtId
     */
    public Integer getDistrictId() {
        return districtId;
    }

    /**
     * Set value to <b>districtId</b>.
     * @param districtId the districtId to set
     */
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    /**
     * get value of <b>wardId</b>.
     * @return the wardId
     */
    public Integer getWardId() {
        return wardId;
    }

    /**
     * Set value to <b>wardId</b>.
     * @param wardId the wardId to set
     */
    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    /**
     * get value of <b>website</b>.
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Set value to <b>website</b>.
     * @param website the website to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * get value of <b>representative</b>.
     * @return the representative
     */
    public String getRepresentative() {
        return representative;
    }

    /**
     * Set value to <b>representative</b>.
     * @param representative the representative to set
     */
    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    /**
     * get value of <b>representativeEmail</b>.
     * @return the representativeEmail
     */
    public String getRepresentativeEmail() {
        return representativeEmail;
    }

    /**
     * Set value to <b>representativeEmail</b>.
     * @param representativeEmail the representativeEmail to set
     */
    public void setRepresentativeEmail(String representativeEmail) {
        this.representativeEmail = representativeEmail;
    }

    /**
     * get value of <b>representativeMobile</b>.
     * @return the representativeMobile
     */
    public String getRepresentativeMobile() {
        return representativeMobile;
    }

    /**
     * Set value to <b>representativeMobile</b>.
     * @param representativeMobile the representativeMobile to set
     */
    public void setRepresentativeMobile(String representativeMobile) {
        this.representativeMobile = representativeMobile;
    }

    /**
     * get value of <b>extra</b>.
     * @return the extra
     */
    public LinkedHashMap<String, Object> getExtra() {
        return extra;
    }

    /**
     * Set value to <b>extra</b>.
     * @param extra the extra to set
     */
    public void setExtra(LinkedHashMap<String, Object> extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "CustomerRegistration [fullname=" + fullname + ", email=" + email + ", industryId=" + industryId + ", address=" + address + ", city=" + city
                + ", districtId=" + districtId + ", wardId=" + wardId + ", website=" + website + ", representative=" + representative + ", representativeEmail="
                + representativeEmail + ", representativeMobile=" + representativeMobile + ", extra=" + extra + "]";
    }
    
}
