/**
 * ApiWebSessionManager.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.security;

import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import grass.micro.apps.util.SystemUtils;
import io.jsonwebtoken.Claims;

/**
 * ApiWebSessionManager. <<< Detail note.
 * 
 * @author hieumicro
 * @access public
 */
public class ApiWebSessionManager extends DefaultWebSessionManager {

    @Override
    public Serializable getSessionId(SessionKey key) {
        Serializable rs = super.getSessionId(key);
        if (rs == null) {
            if (WebUtils.isWeb(key)) {
                ServletRequest request = WebUtils.getRequest(key);
                if (request != null) {
                    rs = (Serializable) getBearerSessionId(request);
                }
            }
        }

        return rs;
    }

    /**
     * @param request
     * @return
     */
    private Serializable getBearerSessionId(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authorization = request.getHeader("Authorization");
        String token = null;
        if (authorization != null && authorization.startsWith("Bearer")) {
            String[] arr = authorization.split("\\s+");
            if (arr.length == 2) {
                token = arr[1];
            }
        }
        
        if (token != null && !token.isEmpty()) {
            Claims claims = SystemUtils.getInstance().decodeJWT(token);

            if (claims == null) {
                return null;
            }
            
            String encodedData = (String) claims.get("data");
            if (encodedData != null && !encodedData.isEmpty()) {
                JSONObject obj = SystemUtils.getInstance().decodeToJSONObject(encodedData);
                if (obj != null && obj.has("sessionId")) {
                    try {
                        return obj.getString("sessionId");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return null;
    }

}
