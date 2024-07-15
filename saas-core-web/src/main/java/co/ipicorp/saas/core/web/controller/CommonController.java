/**
 * CommonController.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.controller;

import co.ipicorp.saas.core.model.Company;
import co.ipicorp.saas.core.service.CompanyService;
import co.ipicorp.saas.core.web.dto.CompanyDto;
import co.ipicorp.saas.core.web.util.ControllerAction;
import co.ipicorp.saas.core.web.util.DtoFetchingUtils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grass.micro.apps.annotation.GetBody;
import grass.micro.apps.annotation.Logged;
import grass.micro.apps.web.dto.RpcResponse;
import grass.micro.apps.web.form.validator.LimittedForm;

/**
 * CommonController.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
@RestController
public class CommonController {
    private Logger logger = Logger.getLogger(CommonController.class);
    
    @Autowired
    private CompanyService companyService;

    @GetMapping(value = ControllerAction.APP_COMPANY_ACTION)
    @Logged
    public ResponseEntity<?> listCompany(HttpServletRequest request, HttpServletResponse response,
            @GetBody LimittedForm form, BindingResult errors) {
        RpcResponse rs = new RpcResponse(ControllerAction.APP_COMPANY_ACTION);
        HttpStatus status = HttpStatus.OK;
        List<Company> companies = null;
        try {
            companies = this.companyService.getAllActivated();
        } catch (Exception ex) {
            logger.warn(ex.getMessage(), ex);
        }

        if (companies == null) {
            companies = new ArrayList<>();
        }

        List<CompanyDto> dtos = DtoFetchingUtils.fetchCompanies(companies);
        rs.addAttribute("companies", dtos);

        return new ResponseEntity<>(rs, status);
    }
    
}
