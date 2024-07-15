/**
 * DtoFetchingUtils.java
 * @copyright  Copyright © 2020 Micro App
 * @author     hieumicro
 * @package    co.ipicorp.saas.ms.identity.util
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import co.ipicorp.saas.core.model.Account;
import co.ipicorp.saas.core.model.City;
import co.ipicorp.saas.core.model.Company;
import co.ipicorp.saas.core.model.Customer;
import co.ipicorp.saas.core.model.District;
import co.ipicorp.saas.core.model.Ward;
import co.ipicorp.saas.core.web.dto.AccountDto;
import co.ipicorp.saas.core.web.dto.CityDto;
import co.ipicorp.saas.core.web.dto.CompanyDto;
import co.ipicorp.saas.core.web.dto.CustomerDto;
import co.ipicorp.saas.core.web.dto.DistrictDto;
import co.ipicorp.saas.core.web.dto.WardDto;

import grass.micro.apps.util.SystemUtils;
import grass.micro.apps.web.util.CommonFetchingUtils;

/**
 * DtoFetchingUtils. <<< Detail note.
 * 
 * @author hieumicro
 * @access public
 */
public class DtoFetchingUtils {

    private DtoFetchingUtils() {
    }

    /**
     * Fetch one Account.
     * 
     * @param account
     * @return
     */
    public static AccountDto fetchAccount(Account account) {
        AccountDto result = new AccountDto();
        CommonFetchingUtils.fetchStatusTimestamp(result, account);
        result.setId(account.getId());
        result.setEmail(account.getEmail());
        result.setLoginName(account.getLoginName());
        result.setAccountType(account.getAccountType());
        return result;
    }

    /**
     * Fetch List of Company to List of CompanyDto.
     * 
     * @param roles
     *            list of {@link Company}
     * @return list of {@link CompanyDto}
     */
    public static List<CompanyDto> fetchCompanies(List<Company> companies) {
        if (companies == null) {
            return new ArrayList<>();
        }

        List<CompanyDto> result = new LinkedList<>();
        for (Company company : companies) {
            result.add(fetchCompany(company));
        }

        return result;
    }

    /**
     * Fetch Company to CompanyDto.
     * 
     * @param role
     *            {@link Company}
     * @return {@link CompanyDto}
     */
    private static CompanyDto fetchCompany(Company company) {
        CompanyDto result = new CompanyDto();
        CommonFetchingUtils.fetchStatusTimestamp(result, company);
        result.setShortName(company.getShortName());
        result.setFullname(company.getFullname());
        result.setAddress(company.getAddress());
        result.setFax(company.getFax());
        result.setTax(company.getTax());
        result.setTelephone(company.getTelephone());
        result.setWebsite(company.getWebsite());
        DistrictDto district = fetchDistrict(company.getDistrict());
        result.setDistrict(district);
        result.setCity(district.getCity());
        district.setCity(null);
        return result;
    }

    /**
     * @param entities
     * @return
     */
    public static List<CityDto> fetchCities(List<City> cities) {
        if (cities == null) {
            return new ArrayList<>();
        }

        List<CityDto> result = new LinkedList<>();
        for (City city : cities) {
            result.add(fetchCity(city));
        }

        return result;
    }

    /**
     * @param city
     * @return
     */
    public static CityDto fetchCity(City city) {
        CityDto result = new CityDto();
        String props = "id,code,name,type,regionId";
        SystemUtils.getInstance().copyProperties(city, result, props.split(","));
        return result;
    }

    /**
     * Fetch List of District to List of DistrictDto.
     * 
     * @param roles
     *            list of {@link District}
     * @return list of {@link DistrictDto}
     */
    public static List<DistrictDto> fetchDistricts(List<District> districts) {
        if (districts == null) {
            return new ArrayList<>();
        }

        List<DistrictDto> result = new LinkedList<>();
        for (District district : districts) {
            result.add(fetchDistrict(district));
        }

        return result;
    }

    /**
     * Fetch District to DistrictDto.
     * 
     * @param role
     *            {@link District}
     * @return {@link DistrictDto}
     */
    public static DistrictDto fetchDistrict(District district) {
        DistrictDto result = new DistrictDto();
        String props = "id,code,name,type";
        SystemUtils.getInstance().copyProperties(district, result, props.split(","));
        result.setCity(fetchCity(district.getCity()));
        return result;
    }

    /**
     * Fetch List of Ward to List of WardDto.
     * 
     * @param roles
     *            list of {@link Ward}
     * @return list of {@link WardDto}
     */
    public static List<WardDto> fetchWards(List<Ward> wards) {
        if (wards == null) {
            return new ArrayList<>();
        }

        List<WardDto> result = new LinkedList<>();
        for (Ward ward : wards) {
            result.add(fetchWard(ward));
        }

        return result;
    }

    /**
     * Fetch Ward to WardDto.
     * 
     * @param role
     *            {@link Ward}
     * @return {@link WardDto}
     */
    public static WardDto fetchWard(Ward ward) {
        WardDto result = new WardDto();
        String props = "id,code,name,type";
        SystemUtils.getInstance().copyProperties(ward, result, props.split(","));
        result.setDistrict(fetchDistrict(ward.getDistrict()));
        return result;
    }

    public static List<CustomerDto> fetchCustomers(List<Customer> customers) {
        if (customers == null) {
            return new ArrayList<>();
        }

        List<CustomerDto> result = new LinkedList<>();
        for (Customer customer : customers) {
            result.add(fetchCustomer(customer, false));
        }

        return result;
    }
    
    public static CustomerDto fetchCustomer(Customer customer, boolean fetchDetail) {
        CustomerDto result = new CustomerDto();
        CommonFetchingUtils.fetchStatusTimestamp(result, customer);
        String props = "email,fullname,shortname,industryId,representative,representativeEmail,address,city,districtId,wardId,telephone,"
        				+ "fax,website,picture,customerPlanId";
        SystemUtils.getInstance().copyProperties(customer, result, props.split(","));
        result.setRepresentativeTel(customer.getRepresentativeMobile());
        if (fetchDetail) {
            if (customer.getAccount() != null) {
                result.setAccount(fetchAccount(customer.getAccount()));
            }
        }

        return result;
    }

}
