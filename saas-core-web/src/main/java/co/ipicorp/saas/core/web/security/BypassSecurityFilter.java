/**
 * ConsumerSecurityFilter.java
 * @author     duyvk
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ConsumerSecurityFilter.
 * <<< Detail note.
 * @author hieumicro
 */
public class BypassSecurityFilter extends DefaultSecurityFilter {
    
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        super.isAccessAllowed(request, response, mappedValue);
        return true;
    }
    
}
