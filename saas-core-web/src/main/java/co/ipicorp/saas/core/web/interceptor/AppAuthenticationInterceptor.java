/**
 * AppAuthenticationInterceptor.java
 * @author     hieu.vo
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.interceptor;

import co.ipicorp.saas.core.web.util.Constants;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.aop.PermissionAnnotationHandler;
import org.apache.shiro.authz.aop.RoleAnnotationHandler;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grass.micro.apps.annotation.NoRequiredAuth;
import grass.micro.apps.component.SystemConfiguration;

/**
 * AppAuthenticationInterceptor.
 * <<< Detail note.
 * @author hieu.vo
 */
public class AppAuthenticationInterceptor extends HandlerInterceptorAdapter {
    
    private final Logger logger = Logger.getLogger(AppAuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod method = (HandlerMethod) handler;
        boolean swaggerEnable = SystemConfiguration.getInstance().getBoolean(Constants.APP_SWAGGER_ENABLE_KEY, true);
        if (swaggerEnable && method.getBeanType().getName().startsWith("springfox.documentation")) {
            logger.info("swagger enabled in system.properties. Bypass Swagger");
            return true;
        }
        
        boolean result = processAnnation(method, request, response);
        return result;
    }

    private boolean processAnnation(HandlerMethod method, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (method.getMethod().isAnnotationPresent(NoRequiredAuth.class)) {
            logger.info("This not required authentication request");
            return true;
        }
        
        // check @RequiresAuthentication
        RequiresAuthentication requireAuth = null;
        if (method.getMethod().isAnnotationPresent(RequiresAuthentication.class)) {
            requireAuth = method.getMethod().getAnnotation(RequiresAuthentication.class);
        }
        
        if (requireAuth != null && SecurityUtils.getSubject() != null) {
            if (!SecurityUtils.getSubject().isAuthenticated()) {
                this.sendError(request, response, HttpStatus.FORBIDDEN.value(), "FORBIDDEN");
                return false;
            }
        }
        
        RequiresPermissions requirePerms = null;
        if (method.getMethod().isAnnotationPresent(RequiresPermissions.class)) {
            requirePerms = method.getMethod().getAnnotation(RequiresPermissions.class);
        }
        
        // check @RequiresPermissions
        if (requirePerms != null) {
            PermissionAnnotationHandler annotaionHanlder = new PermissionAnnotationHandler();

            try {
                annotaionHanlder.assertAuthorized(requirePerms);
            } catch (Exception ex) {
                this.sendError(request, response, HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
                return false;
            }
        }

        // check @RequiresRoles
        RequiresRoles requireRole = null;
        if (method.getMethod().isAnnotationPresent(RequiresRoles.class)) {
            requireRole = method.getMethod().getAnnotation(RequiresRoles.class);
        }

        if (requireRole != null) {
            RoleAnnotationHandler annotaionHanlder = new RoleAnnotationHandler();

            try {
                annotaionHanlder.assertAuthorized(requireRole);
            } catch (Exception ex) {
                logger.warn(ex.getMessage());
                this.sendError(request, response, HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
                return false;
            }
        }
        
        // No annotation, reject
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return true;
        }
        
        this.sendError(request, response, 403, "Access denied");
        return false;
    }
    
    public void sendError(HttpServletRequest request, HttpServletResponse response, int errorCode, String message) {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(errorCode);
        JSONObject json = new JSONObject();
        try {
            json.put("timestamp", new Date().getTime());
            json.put("status", errorCode);
            json.put("message", message);
            response.getWriter().write(json.toString());
        } catch (Exception ex) {
            logger.warn(ex.getMessage());
        }
        
    }
}
