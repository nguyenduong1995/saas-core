/**
 * ConsumerSecurityFilter.java
 * @author     duyvk
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.security;

/**
 * ConsumerSecurityFilter.
 * <<< Detail note.
 * @author hieumicro
 */
public class DefaultSecurityFilter extends AppSecurityFilter {
    
    private String sessionInfoKey;
    
    @Override
    public String getBypassUrlPattern() {
        String pattern = "^/monitoring$|";
        pattern +=  "^/errors$|^/error$|^/pub/.*$";
        return pattern;
    }

    @Override
    public String getSessionInfoKey() {
        return this.sessionInfoKey;
    }
    
    @Override
    public void setSessionInfoKey(String sessionInfoKey) {
        this.sessionInfoKey = sessionInfoKey;
    }

}
