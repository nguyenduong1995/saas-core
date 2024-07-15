/**
 * CustomerRegistrationDto.java
 * @copyright  2021 Duong NT
 * @author     ntduong
 */
package co.ipicorp.saas.core.web.dto;

import java.io.Serializable;

import grass.micro.apps.model.dto.StatusTimestampDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.ipicorp.saas.core.model.CustomerType;

/**
 * CustomerRegistrationDto. <<< Detail note.
 * 
 * @author hieuvh
 * @access public
 */
public class CustomerRegistrationDto extends StatusTimestampDto implements Serializable {
	
	private static final long serialVersionUID = 8790670347840876565L;

	@JsonProperty("customer_type")
	private CustomerType customerType;
	
	@JsonProperty("fullname")
    private String fullname;
    
    @JsonProperty("telephone")
    private String telephone;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("company_id")
    private Integer companyId;
    
    @JsonProperty("company_name")
    private String companyName;
    
    @JsonProperty("company_fullname")
    private String companyFullname;
    
    @JsonProperty("city_id_of_company")
    private Integer cityId;
    
    @JsonProperty("city_name_of_company")
    private String cityName;
    
    @JsonProperty("company_address")
    private String companyAddress;
    
    @JsonProperty("company_website")
    private String companyWebsite;
    
    @JsonProperty("department_id")
    private Integer departmentId;
    
    @JsonProperty("department_name")
    private String departmentName;
    
    @JsonProperty("department_shortname")
    private String departmentShortName;
    
    @JsonProperty("other_company_name")
    private String otherCompanyName;
    
    @JsonProperty("ip_address")
    private String ipAddress;

    @JsonProperty("position")
    private String position;
    
    @JsonProperty("project")
    private String project;
    
    /**
     * get value of <b>fullname</b>.
     * 
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Set value to <b>fullname</b>.
     * 
     * @param fullname
     *            the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * get value of <b>telephone</b>.
     * 
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Set value to <b>telephone</b>.
     * 
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    /**
     * get value of <b>email</b>.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value to <b>email</b>.
     * 
     * @param the email to set
     *            
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * get value of <b>companyId</b>.
     * 
     * @return the companyId
     */
    public Integer getCompanyId() {
        return companyId;
    }
    
    /**
     * Set value to <b>companyId</b>.
     * 
     * @param the companyId to set
     *            
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
    
    /**
     * get value of <b>companyName</b>.
     * 
     * @return the companyName
     */
    public String getCompanyName() {
		return companyName;
	}

    /**
     * Set value to <b>companyName</b>.
     * 
     * @param the companyName to set
     *            
     */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
     * get value of <b>companyFullname</b>.
     * 
     * @return the companyFullname
     */
	public String getCompanyFullname() {
		return companyFullname;
	}

	/**
     * Set value to <b>companyFullname</b>.
     * 
     * @param the companyFullname to set
     *            
     */
	public void setCompanyFullname(String companyFullname) {
		this.companyFullname = companyFullname;
	}

	/**
     * get value of <b>departmentId</b>.
     * 
     * @return the departmentId
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * Set value to <b>departmentId</b>.
     * 
     * @param departmentId
     *            the departmentId to set
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * get value of <b>departmentName</b>.
     * 
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Set value to <b>departmentName</b>.
     * 
     * @param departmentName
     *            the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

	/**
     * get value of <b>otherCompanyName</b>.
     * 
     * @return the otherCompanyName
     */
    public String getOtherCompanyName() {
        return otherCompanyName;
    }

    /**
     * Set value to <b>otherCompanyName</b>.
     * 
     * @param otherCompanyName
     *            the otherCompanyName to set
     */
    public void setOtherCompanyName(String companyName) {
        this.otherCompanyName = companyName;
    }
    
    /**
     * get value of <b>customerType</b>.
     * @return the customerType
     */
    public CustomerType getCustomerType() {
        return customerType;
    }

    /**
     * Set value to <b>customerType</b>.
     * @param customerType the customerType to set
     */
    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
    
    /**
     * get value of <b>ipAddress</b>.
     * @return the ipAddress
     */
    public String getIpAddress() {
		return ipAddress;
	}
    
    /**
     * Set value to <b>ipAddress</b>.
     * @param ipAddress the ipAddress to set
     */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
     * get value of <b>position</b>.
     * @return the position
     */
	public String getPosition() {
		return position;
	}

	/**
     * Set value to <b>position</b>.
     * @param position the position to set
     */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
     * get value of <b>project</b>.
     * @return the project
     */
	public String getProject() {
		return project;
	}

	/**
     * Set value to <b>project</b>.
     * @param project the project to set
     */
	public void setProject(String project) {
		this.project = project;
	}

	/**
     * get value of <b>cityId</b>.
     * @return the cityId
     */
	public Integer getCityId() {
		return cityId;
	}

	/**
     * Set value to <b>cityId</b>.
     * @param cityId the cityId to set
     */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
     * get value of <b>cityName</b>.
     * @return the cityName
     */
	public String getCityName() {
		return cityName;
	}

	/**
     * Set value to <b>cityName</b>.
     * @param cityName the cityName to set
     */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
     * get value of <b>companyAddress</b>.
     * @return the companyAddress
     */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
     * Set value to <b>companyAddress</b>.
     * @param companyAddress the companyAddress to set
     */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
    * get value of <b>companyWebsite</b>.
    * @return the companyWebsite
    */
	public String getCompanyWebsite() {
		return companyWebsite;
	}
    
    /**
     * Set value to <b>companyWebsite</b>.
     * @param companyWebsite the companyWebsite to set
     */
	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	/**
    * get value of <b>departmentShortName</b>.
    * @return the departmentShortName
    */
	public String getDepartmentShortName() {
		return departmentShortName;
	}

	/**
     * Set value to <b>departmentShortName</b>.
     * @param departmentShortName the departmentShortName to set
     */
	public void setDepartmentShortName(String departmentShortName) {
		this.departmentShortName = departmentShortName;
	}

	@Override
    public String toString() {
        return "CustomerRegistrationDto [customerType=" + customerType + ", fullname=" + fullname + ", telephone=" + telephone + ", cityId= " + cityId
        		+ ", email=" + email + ", companyId=" + companyId + "," + ", companyName=" + companyName + ", companyFullname=" + companyFullname
        		+ ", cityName=" + cityName + ", companyAddress=" + companyAddress + "," + ", companyWebsite=" + companyWebsite 
        		+ ", departmentId=" + departmentId + "," + ", departmentName=" + departmentName + ", departmentShortName= " + departmentShortName
                + ", otherCompanyName=" + otherCompanyName + ", ipAddress=" + ipAddress + ", position=" + position + ", project=" + project + "]";
    }

}
