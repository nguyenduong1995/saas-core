/**
 * AppRealm.java
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.security;

import co.ipicorp.saas.core.service.AccountService;
import co.ipicorp.saas.core.service.UserService;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * AppRealm.
 * <<< Detail note.
 * @author hieumicro
 */
@SuppressWarnings("unused")
public abstract class AppRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    
    @Autowired
    private AccountService accountService;

    /*
     * @Autowired private SystemConfiguration systemConfiguration;
     */

    @Override
    public final boolean supports(AuthenticationToken token) {
        return true;
    }

    @Override
    protected final AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principle) {
        Set<String> roles = new HashSet<String>();
        Set<Permission> permissions = new HashSet<Permission>();

//        String loginName = (String) principle.getPrimaryPrincipal();
//        Account account = this.accountService.getByLoginName(loginName);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
//        if (account != null) {
//            User user = this.userService.getByAccountId(account.getId());
//            for (Role role : user.getRoles()) {
//                if (role.isActivated()) {
//                    roles.add(role.getRoleName());
//                    for (co.ipicorp.saas.core.model.Permission p : role.getPermissions()) {
//                        WildcardPermission wp = new WildcardPermission(p.getPermissionName());
//                        permissions.add(wp);
//                    }
//                }
//            }
//        }
        
        info.setRoles(roles);
        info.setObjectPermissions(permissions);

        return info;
    }

    // Pass by authentication
    @Override
    protected final AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        return new SimpleAuthenticationInfo(upToken.getUsername(), upToken.getPassword(), this.getRealmName());
    }

    @Override
    public final void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public final void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public final void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * clearAllCachedAuthorizationInfo.
     */
    public final void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * clearAllCachedAuthenticationInfo.
     */
    public final void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /** clear All Cache. */
    public final void clearAllCache() {
        this.clearAllCachedAuthenticationInfo();
        this.clearAllCachedAuthorizationInfo();
    }

    @Override
    public String getAuthorizationCacheName() {
        return getSaasAuthorizationCacheName();
    }
    
    public abstract String getSaasAuthorizationCacheName();
    public abstract String getRealmName();
}