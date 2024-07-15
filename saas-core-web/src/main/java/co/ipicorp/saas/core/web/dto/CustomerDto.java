package co.ipicorp.saas.core.web.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import grass.micro.apps.model.dto.StatusTimestampDto;

/**
 * CustomerDto. <<< Detail note.
 * 
 * @author duyvk
 * @access public
 */
public class CustomerDto extends StatusTimestampDto implements Serializable {

    private static final long serialVersionUID = 7080250186030178126L;

    private AccountDto account;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "fullname")
    private String fullname;

    @JsonProperty(value = "shortname")
    private String shortname;

    @JsonProperty(value = "industry_id")
    private Integer industryId;

    @JsonProperty(value = "representative")
    private String representative;

    @JsonProperty(value = "representative_tel")
    private String representativeTel;

    @JsonProperty(value = "representative_email")
    private String representativeEmail;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "city_id")
    private Integer city;

    @JsonProperty(value = "district_id")
    private Integer districtId;

    @JsonProperty(value = "ward_id")
    private Integer wardId;

    @JsonProperty(value = "tel")
    private String telephone;

    @JsonProperty(value = "fax")
    private String fax;

    @JsonProperty(value = "website")
    private String website;

    @JsonProperty(value = "picture")
    private String picture;

    @JsonProperty(value = "customer_plan_id")
    private Integer customerPlanId;

    @JsonProperty(value = "organization")
    private Map<String, Object> organization;
    
    @JsonProperty(value = "customer_metadata")
    private List<Map<String, Object>> customerMetadata;

    /**
     * @return the account
     */
    public AccountDto getAccount() {
        return account;
    }

    /**
     * @param account
     *            the account to set
     */
    public void setAccount(AccountDto account) {
        this.account = account;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname
     *            the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the shortname
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * @param shortname
     *            the shortname to set
     */
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    /**
     * @return the industryId
     */
    public Integer getIndustryId() {
        return industryId;
    }

    /**
     * @param industryId
     *            the industryId to set
     */
    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    /**
     * @return the representative
     */
    public String getRepresentative() {
        return representative;
    }

    /**
     * @param representative
     *            the representative to set
     */
    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    /**
     * @return the representativeTel
     */
    public String getRepresentativeTel() {
        return representativeTel;
    }

    /**
     * @param representativeTel
     *            the representativeTel to set
     */
    public void setRepresentativeTel(String representativeTel) {
        this.representativeTel = representativeTel;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public Integer getCity() {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(Integer city) {
        this.city = city;
    }

    /**
     * @return the districtId
     */
    public Integer getDistrictId() {
        return districtId;
    }

    /**
     * @param districtId
     *            the districtId to set
     */
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    /**
     * @return the wardId
     */
    public Integer getWardId() {
        return wardId;
    }

    /**
     * @param wardId
     *            the wardId to set
     */
    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax
     *            the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website
     *            the website to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture
     *            the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return the customerPlanId
     */
    public Integer getCustomerPlanId() {
        return customerPlanId;
    }

    /**
     * @param customerPlanId
     *            the customerPlanId to set
     */
    public void setCustomerPlanId(Integer customerPlanId) {
        this.customerPlanId = customerPlanId;
    }

    /**
     * get value of <b>representativeEmail</b>.
     * 
     * @return the representativeEmail
     */
    public String getRepresentativeEmail() {
        return representativeEmail;
    }

    /**
     * Set value to <b>representativeEmail</b>.
     * 
     * @param representativeEmail
     *            the representativeEmail to set
     */
    public void setRepresentativeEmail(String representativeEmail) {
        this.representativeEmail = representativeEmail;
    }

    /**
     * get value of <b>organization</b>.
     * 
     * @return the organization
     */
    public Map<String, Object> getOrganization() {
        return organization;
    }

    /**
     * Set value to <b>organization</b>.
     * 
     * @param organization
     *            the organization to set
     */
    public void setOrganization(Map<String, Object> organization) {
        this.organization = organization;
    }

    /**
     * get value of <b>customerMetadata</b>.
     * 
     * @return the customerMetadata
     */
    public List<Map<String, Object>> getCustomerMetadata() {
		return customerMetadata;
	}

    /**
     * Set value to <b>customerMetadata</b>.
     * 
     * @param customerMetadata
     *            the customerMetadata to set
     */
	public void setCustomerMetadata(List<Map<String, Object>> customerMetadata) {
		this.customerMetadata = customerMetadata;
	}

	@Override
    public String toString() {
        return "CustomerDto [account=" + account + ", email=" + email + ", fullname=" + fullname + ", shortname=" + shortname + ", industryId=" + industryId
                + ", representative=" + representative + ", representativeTel=" + representativeTel + ", representativeEmail=" + representativeEmail
                + ", address=" + address + ", city=" + city + ", districtId=" + districtId + ", wardId=" + wardId + ", telephone=" + telephone + ", fax=" + fax
                + ", website=" + website + ", picture=" + picture + ", customerPlanId=" + customerPlanId + ", organization=" + organization + "]";
    }

}
