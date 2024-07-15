/**
 * IndustryController.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.controller;

import co.ipicorp.saas.core.model.Industry;
import co.ipicorp.saas.core.service.IndustryService;
import co.ipicorp.saas.core.web.util.ControllerAction;

import com.sun.istack.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grass.micro.apps.annotation.Logged;
import grass.micro.apps.annotation.NoRequiredAuth;
import grass.micro.apps.web.component.ErrorsKeyConverter;
import grass.micro.apps.web.controller.GeneralController;
import grass.micro.apps.web.controller.support.AppControllerListingSupport;
import grass.micro.apps.web.controller.support.AppControllerSupport;

/**
 * IndustryController. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@RestController
@SuppressWarnings("unused")
public class IndustryController extends GeneralController {
	
    private static final Logger logger = Logger.getLogger(IndustryController.class);

	@Autowired
	private IndustryService industryService;

	@Autowired
	private ErrorsKeyConverter errorsProcessor;
	
	@GetMapping(value = ControllerAction.APP_PORTAL_INDUSTRY_ACTION)
	@NoRequiredAuth
	@Logged
	public ResponseEntity<?> listIndustries(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "level", required = false, defaultValue = "1") Integer level) {
		AppControllerSupport support = new AppControllerListingSupport() {
			@Override
			public List<? extends Serializable> getEntityList(HttpServletRequest request, HttpServletResponse response,
					Errors errors, ErrorsKeyConverter errorsProcessor) {
			    int lv = level;
			    if (level < 1 || level > 5) {
			        lv = 1;
			    }
				return IndustryController.this.industryService.getActivatedByLevel(lv);
			}

			@Override
			public String getAttributeName() {
				return "industries";
			}

			@Override
			public List<?> fetchEntitiesToDtos(List<? extends Serializable> entities) {
				List<Map<String, Object>> rs = new LinkedList<>();
				for (Object entity : entities) {
				    Industry industry = (Industry) entity;
				    Map<String, Object> map = new LinkedHashMap<String, Object>();
				    map.put("id", industry.getId());
				    map.put("name", industry.getName());
				    rs.add(map);
                }
				return rs;
			}
		};

		return support.doSupport(request, response, null, errorsProcessor);
	}
}
