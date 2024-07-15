/**
 * AppSecurityFilter.java
 * @author     duyvk
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.security;

import co.ipicorp.saas.core.web.util.Constants;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grass.micro.apps.component.SystemConfiguration;
import grass.micro.apps.web.component.SessionPool;
import grass.micro.apps.web.security.SessionInfo;
import grass.micro.apps.web.util.RequestUtils;

/**
 * AppSecurityFilter.
 * <<< Detail note.
 * @author hieumicro
 */
public abstract class AppSecurityFilter extends AccessControlFilter {

    @Autowired
    private SessionPool<?> pool;

    public AppSecurityFilter() {
        super();
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        String pattern = this.getBypassUrlPattern();
        if (isLoginRequest(request, response) 
                || this.getPathWithinApplication(request).matches(pattern)) {
            return true;
        }
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        boolean result = false;
        
        SessionInfo sessionInfo = RequestUtils.getInstance().getSessionInfo(httpRequest, this.getSessionInfoKey());
        // authenticated --> check token is right (no login from other browser). If token is not right, force logout
        if (sessionInfo != null && SecurityUtils.getSubject().isAuthenticated()) {
            result = this.checkDuplicateLogin(httpRequest, sessionInfo);
        } else if (sessionInfo != null) { // Not authenticated - check manually login by SessionInfo
            result = this.loginManually(sessionInfo);
        }
        
        return result;
    }

    private boolean checkDuplicateLogin(HttpServletRequest httpRequest, SessionInfo sessionInfo) {
        SessionInfo existedSession = pool.getSession(sessionInfo.getUsername());
        if (existedSession != null) {
            if (!sessionInfo.getToken().equals(existedSession.getToken())) {
                SecurityUtils.getSubject().logout();
                return false;
            }
        }

        return true;
    }

    /**
     * Login manually from {@link SessionInfo}.
     * @param sessionInfo {@link SessionInfo} instance
     */
    private boolean loginManually(SessionInfo sessionInfo) {
        UsernamePasswordToken token = new UsernamePasswordToken(sessionInfo.getUsername(),
                "dummybecausewebypassauthenticate");
        
        try {
            SecurityUtils.getSubject().login(token); // BYPASS Login
        } catch (Exception ex) {
            // do nothing
        }

        if (SecurityUtils.getSubject().isAuthenticated()) {
            String usernameKey = SystemConfiguration.getInstance().getProperty(Constants.APP_SESSIONPOOL_USERNAME_KEY);
            String tokenKey = SystemConfiguration.getInstance().getProperty(Constants.APP_SESSIONPOOL_TOKEN_KEY);
            
            SecurityUtils.getSubject().getSession(true).setAttribute(usernameKey, sessionInfo.getUsername());
            SecurityUtils.getSubject().getSession(true).setAttribute(tokenKey, sessionInfo.getToken());
            return true;
        }
        
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        this.onLoginFail(request, response);
        return false;
    }

    /*
     * Login failure process - redriect to login page
     */
    private void onLoginFail(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);
        JSONObject json = new JSONObject();
        try {
            json.put("timestamp", new Date().getTime());
            json.put("status", 403);
            json.put("message", "Access denied");
        } catch (JSONException ex) {
            // do nothing
        }
        
        res.getWriter().write(json.toString());
    }
    
    /**
     * Get List of URL need to Bypass authentication.
     * @return Regular expression String.
     */
    public abstract String getBypassUrlPattern();

    /**
     * Get name of {@link SessionInfo} Key.
     * @return String
     */
    public abstract String getSessionInfoKey();
    
    /**
     * Set name of {@link SessionInfo} Key.
     * @param sessionInfoKey String
     */
    public abstract void setSessionInfoKey(String sessionInfoKey);
}
