package co.ipicorp.saas.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import grass.micro.apps.model.base.StatusLockAuditableEntity;

/**
 * Customer. <<< Detail note.
 * 
 * @author hieumicro
 * @access public
 */
@Entity
@Table(name = "t_customer")
public class Customer extends StatusLockAuditableEntity {

    private static final long serialVersionUID = -908295375037534582L;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Account.class)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @Column(name = "email", nullable = true, length = 255)
    private String email;

    @Column(name = "fullname", nullable = false, length = 512)
    private String fullname;

    @Column(name = "shortname", nullable = false, length = 255)
    private String shortname;

    @Column(name = "industry_id", nullable = true)
    private Integer industryId;

    @Column(name = "representative", nullable = true, length = 255)
    private String representative;

    @Column(name = "representative_email", nullable = true, length = 255)
    private String representativeEmail;

    @Column(name = "representative_mobile", nullable = true, length = 20)
    private String representativeMobile;

    @Column(name = "position", nullable = true, length = 255)
    private String position;

    @Column(name = "address", nullable = true, length = 1024)
    private String address;

    @Column(name = "city_id", nullable = true)
    private Integer city;

    @Column(name = "district_id", nullable = true)
    private Integer districtId;

    @Column(name = "ward_id", nullable = true)
    private Integer wardId;

    @Column(name = "tel", nullable = true, length = 16)
    private String telephone;

    @Column(name = "fax", nullable = true, length = 16)
    private String fax;

    @Column(name = "website", nullable = true, length = 128)
    private String website;

    @Column(name = "picture") // 128KB
    private String picture;

    @Column(name = "customer_plan_id", nullable = true)
    private Integer customerPlanId;

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account
     *            the account to set
     */
    public void setAccount(Account account) {
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
     * get value of <b>representativeMobile</b>.
     * 
     * @return the representativeMobile
     */
    public String getRepresentativeMobile() {
        return representativeMobile;
    }

    /**
     * Set value to <b>representativeMobile</b>.
     * 
     * @param representativeMobile
     *            the representativeMobile to set
     */
    public void setRepresentativeMobile(String representativeMobile) {
        this.representativeMobile = representativeMobile;
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
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(String position) {
        this.position = position;
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

    @Override
    public String toString() {
        return "Customer [account=" + account + ", email=" + email + ", fullname=" + fullname + ", shortname=" + shortname + ", industryId=" + industryId
                + ", representative=" + representative + ", representativeEmail=" + representativeEmail + ", representativeMobile=" + representativeMobile
                + ", position=" + position + ", address=" + address + ", city=" + city + ", districtId=" + districtId + ", wardId=" + wardId + ", telephone="
                + telephone + ", fax=" + fax + ", website=" + website + ", picture=" + picture + ", customerPlanId=" + customerPlanId + "]";
    }

}
