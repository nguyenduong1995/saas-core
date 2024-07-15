/**
 * CityDto.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.dto;

/**
 * CityDto. <<< Detail note.
 * 
 * @author hieumicro
 * @access public
 */
public class CityDto {
    private Integer id;

    private String code;

    private String name;

    private String type;
    
    private Integer regionId;

    /**
     * get value of <b>id</b>.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set value to <b>id</b>.
     * 
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
        return "CityDto [id=" + id + ", code=" + code + ", name=" + name + ", type=" + type + ", regionId=" + regionId + "]";
    }

}
