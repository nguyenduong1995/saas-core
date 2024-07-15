/**
 * SessionExpirationHandler.java
 * @author     duyvk
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.security;

import co.ipicorp.saas.core.web.util.Constants;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import grass.micro.apps.component.SystemConfiguration;
import grass.micro.apps.web.component.SessionPool;


/**
 * SessionExpirationHandler.
 * <<< Session expiration handler.
 * @author duyvk
 * @access public
 */
public class SessionExpirationHandler extends SessionListenerAdapter {

    @Autowired
    private SessionPool<?> pool;

    @Override
    public void onStop(Session session) {
        this.removeLoginUser(session);
        super.onStop(session);
    }

    private void removeLoginUser(Session session) {
        String usernameKey = SystemConfiguration.getInstance().getProperty(Constants.APP_SESSIONPOOL_USERNAME_KEY);
        String tokenKey = SystemConfiguration.getInstance().getProperty(Constants.APP_SESSIONPOOL_TOKEN_KEY);
        String username = (String) session.getAttribute(usernameKey);
        String token = (String) session.getAttribute(tokenKey);
        if (username != null) {
            pool.dropSession(username, token);
        }
    }

    @Override
    public void onExpiration(Session session) {
        this.removeLoginUser(session);
        super.onExpiration(session);
    }

    @Override
    public void onStart(Session session) {
        super.onStart(session);
    }
    
}