/**
 * AddressListController.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.controller;

import co.ipicorp.saas.core.model.City;
import co.ipicorp.saas.core.model.District;
import co.ipicorp.saas.core.model.Region;
import co.ipicorp.saas.core.model.Ward;
import co.ipicorp.saas.core.service.CityService;
import co.ipicorp.saas.core.service.DistrictService;
import co.ipicorp.saas.core.service.RegionService;
import co.ipicorp.saas.core.service.WardService;
import co.ipicorp.saas.core.web.dto.CityDto;
import co.ipicorp.saas.core.web.util.ControllerAction;
import co.ipicorp.saas.core.web.util.DtoFetchingUtils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grass.micro.apps.annotation.NoRequiredAuth;
import grass.micro.apps.web.component.ErrorsKeyConverter;
import grass.micro.apps.web.controller.GeneralController;
import grass.micro.apps.web.controller.support.AppControllerListingSupport;
import grass.micro.apps.web.controller.support.AppControllerSupport;
import grass.micro.apps.web.util.RequestUtils;

/**
 * AddressListController. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@RestController
@SuppressWarnings("unchecked")
public class AddressListController extends GeneralController {
	
	private static Logger logger = Logger.getLogger(AddressListController.class);
	
    @Autowired
    private ErrorsKeyConverter errorsProcessor;

    @Autowired
    private RegionService regionService;
    
    @Autowired
    private CityService cityService;
    
    @Autowired
    private DistrictService districtService;
    
    @Autowired
    private WardService wardService;

    @GetMapping(value = ControllerAction.APP_REGION_ACTION)
    @ResponseBody
    @NoRequiredAuth
    public ResponseEntity<?> listRegions(HttpServletRequest request, HttpServletResponse response) {
        AppControllerSupport support = new AppControllerSupport() {
            
            @Override
            public void process(HttpServletRequest request, HttpServletResponse response, Errors errors,
                    ErrorsKeyConverter errorsProcessor) {
                List<Region> regions = null;
                try {
                    regions = regionService.getAll();
                } catch (Exception ex) {
                    logger.error(ex.getMessage(), ex);
                    getRpcResponse().error("1000", ex.getMessage());
                }
                
                if (regions == null) {
                    regions = new ArrayList<>();
                }
                
                getRpcResponse().addAttribute("regions", regions);
            }
        };

        return support.doSupport(request, response, RequestUtils.getInstance().getBindingResult(), errorsProcessor);
    }
    
    @GetMapping(value = ControllerAction.APP_REGION_DETAIL_ACTION)
    @ResponseBody
    @NoRequiredAuth
    public ResponseEntity<?> getRegion(HttpServletRequest request, HttpServletResponse response, 
            @PathVariable("id") int id) {
        AppControllerSupport support = new AppControllerSupport() {
            
            @Override
            public void process(HttpServletRequest request, HttpServletResponse response, Errors errors,
                    ErrorsKeyConverter errorsProcessor) {
                Region region = null;
                try {
                    region = regionService.get(id);
                } catch (Exception ex) {
                    logger.error(ex.getMessage(), ex);
                    getRpcResponse().error("1000", ex.getMessage());
                }
                
                if (region == null) {
                    errors.reject("404", "Not found");
                } else {
                    getRpcResponse().addAttribute("region", region);
                }
            }
        };

        return support.doSupport(request, response, RequestUtils.getInstance().getBindingResult(), errorsProcessor);
    }

    @GetMapping(value = ControllerAction.APP_REGION_DETAIL_ACTION + ControllerAction.APP_CITY_ACTION)
    @ResponseBody
    @NoRequiredAuth
    public ResponseEntity<?> getCitiesByRegion(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int regionId) {
        AppControllerSupport support = new AppControllerSupport() {
            
            @Override
            public void process(HttpServletRequest request, HttpServletResponse response, Errors errors,
                    ErrorsKeyConverter errorsProcessor) {
                List<City> cities = null;
                try {
                    cities = cityService.getByRegionId(regionId);
                } catch (Exception ex) {
                    logger.error(ex.getMessage(), ex);
                    getRpcResponse().error("1000", ex.getMessage());
                }
                
                if (cities == null) {
                    cities = new ArrayList<>();
                }
                
                List<CityDto> cityDtos = DtoFetchingUtils.fetchCities(cities);
                getRpcResponse().addAttribute("cities", cityDtos);
                
            }
        };

        return support.doSupport(request, response, RequestUtils.getInstance().getBindingResult(), errorsProcessor);
    }
    
    @GetMapping(value = ControllerAction.APP_CITY_ACTION)
    @ResponseBody
    @NoRequiredAuth
    public ResponseEntity<?> listCities(HttpServletRequest request, HttpServletResponse response) {
        AppControllerSupport support = new AppControllerSupport() {
        	
        	@Override
			public void process(HttpServletRequest request, HttpServletResponse response, Errors errors,
					ErrorsKeyConverter errorsProcessor) {
        		List<City> cities = null;
				try {
					cities = cityService.getAll();
				} catch (Exception ex) {
					logger.error(ex.getMessage(), ex);
					getRpcResponse().error("1000", ex.getMessage());
				}
				
				if (cities == null) {
					cities = new ArrayList<>();
				}
				
				List<CityDto> cityDtos = DtoFetchingUtils.fetchCities(cities);
				getRpcResponse().addAttribute("cities", cityDtos);
				
			}
        };

        return support.doSupport(request, response, RequestUtils.getInstance().getBindingResult(), errorsProcessor);
    }    
        
    @GetMapping(value = ControllerAction.APP_CITY_DETAIL_ACTION)
    @ResponseBody
    @NoRequiredAuth
    public ResponseEntity<?> getCity(HttpServletRequest request, HttpServletResponse response, 
            @PathVariable("id") int id) {
        AppControllerSupport support = new AppControllerSupport() {
            
            @Override
            public void process(HttpServletRequest request, HttpServletResponse response, Errors errors,
                    ErrorsKeyConverter errorsProcessor) {
                City city = null;
                try {
                    city = cityService.get(id);
                } catch (Exception ex) {
                    logger.error(ex.getMessage(), ex);
                    getRpcResponse().error("1000", ex.getMessage());
                }
                
                if (city == null) {
                    errors.reject("404", "Not found");
                } else {
                    getRpcResponse().addAttribute("city", DtoFetchingUtils.fetchCity(city));
                }
            }
        };

        return support.doSupport(request, response, RequestUtils.getInstance().getBindingResult(), errorsProcessor);
    }

    @GetMapping(value = ControllerAction.APP_DISTRICT_ACTION)
    @ResponseBody
    @NoRequiredAuth
    public ResponseEntity<?> listDistricts(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam("cityId") int cityId) {
        AppControllerSupport support = new AppControllerListingSupport() {

            @Override
            public List<? extends Serializable> getEntityList(HttpServletRequest request, HttpServletResponse response, Errors errors,
                    ErrorsKeyConverter errorsProcessor) {
                return districtService.getByCityId(cityId);
            }

            @Override
            public String getAttributeName() {
                return "districts";
            }

            @Override
            public List<?> fetchEntitiesToDtos(List<? extends Serializable> entities) {
                return DtoFetchingUtils.fetchDistricts((List<District>) entities);
            }
        };

        return support.doSupport(request, response, RequestUtils.getInstance().getBindingResult(), errorsProcessor);
    }
    
    @GetMapping(value = ControllerAction.APP_WARD_ACTION)
    @ResponseBody
    @NoRequiredAuth
    public ResponseEntity<?> listWards(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("districtId") Integer districtId) {
        AppControllerSupport support = new AppControllerListingSupport() {

            @Override
            public List<? extends Serializable> getEntityList(HttpServletRequest request, HttpServletResponse response, Errors errors,
                    ErrorsKeyConverter errorsProcessor) {
                return wardService.getByDistrictId(districtId);
            }

            @Override
            public String getAttributeName() {
                return "wards";
            }

            @Override
            public List<?> fetchEntitiesToDtos(List<? extends Serializable> entities) {
                return DtoFetchingUtils.fetchWards((List<Ward>) entities);
            }
        };

        return support.doSupport(request, response, RequestUtils.getInstance().getBindingResult(), errorsProcessor);
    }
    
}
