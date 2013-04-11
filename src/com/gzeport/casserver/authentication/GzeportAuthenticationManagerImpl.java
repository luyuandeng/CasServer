package com.gzeport.casserver.authentication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jasig.cas.authentication.AbstractAuthenticationManager;
 
import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.AuthenticationHandler;
import org.jasig.cas.authentication.handler.BadCredentialsAuthenticationException;
import org.jasig.cas.authentication.handler.UnsupportedCredentialsException;
import org.jasig.cas.authentication.principal.Credentials;
import org.jasig.cas.authentication.principal.CredentialsToPrincipalResolver;
import org.jasig.cas.authentication.principal.Principal;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.perf4j.LoggingStopWatch;

import com.gzeport.casserver.pojo.UserCasInfo;
import com.gzeport.portal.to.User;
import com.gzeport.portal.user.service.UserManager;

public class GzeportAuthenticationManagerImpl extends AbstractAuthenticationManager {

    /** An array of authentication handlers. */
    @NotNull
    @Size(min=1)
    private List<AuthenticationHandler> authenticationHandlers;

    /** An array of CredentialsToPrincipalResolvers. */
    @NotNull
    @Size(min=1)
    private List<CredentialsToPrincipalResolver> credentialsToPrincipalResolvers;
    
    @NotNull
    private  UserManager userManager;

    @Override
    protected Pair<AuthenticationHandler, Principal> authenticateAndObtainPrincipal(final Credentials credentials) throws AuthenticationException {
        boolean foundSupported = false;
        boolean authenticated = false;
        AuthenticationHandler authenticatedClass = null;
        
        for (final AuthenticationHandler authenticationHandler : this.authenticationHandlers) {
            if (authenticationHandler.supports(credentials)) {
                foundSupported = true;

                boolean auth = false;
                final LoggingStopWatch stopWatch = new LoggingStopWatch(authenticationHandler.getClass().getSimpleName());

                try {
                    auth = authenticationHandler.authenticate(credentials);
                } finally {
                    stopWatch.stop();
                }

                if (!auth) {
                    if (log.isInfoEnabled()) {
                        log.info("AuthenticationHandler: "
                                + authenticationHandler.getClass().getName()
                                + " failed to authenticate the user which provided the following credentials: "
                                + credentials.toString());
                    }
                } else {
                    if (log.isInfoEnabled()) {
                        log.info("AuthenticationHandler: "
                                + authenticationHandler.getClass().getName()
                                + " successfully authenticated the user which provided the following credentials: "
                                + credentials.toString());
                    }
                    authenticatedClass = authenticationHandler;
                    authenticated = true;
                    break;
                }
            }
        }

        if (!authenticated) {
            if (foundSupported) {
                throw BadCredentialsAuthenticationException.ERROR;
            }

            throw UnsupportedCredentialsException.ERROR;
        }

        foundSupported = false;

        for (final CredentialsToPrincipalResolver credentialsToPrincipalResolver : this.credentialsToPrincipalResolvers) {
            if (credentialsToPrincipalResolver.supports(credentials)) {
            //	log.info("ToPrincipalResolver====="+credentialsToPrincipalResolver.getClass());
                final Principal principal =  credentialsToPrincipalResolver.resolvePrincipal(credentials);
             String userCode=   principal.getId();
        //     log.info("serrr!!!!!!!!!!userCode="+userCode);
              User user=  this.userManager.findUserByUserCode(userCode);
              List list=  this.userManager.getFuncModelsList(String.valueOf(user.getUserId()));
              String userInfo=user.getUserCode()+"#"+user.getUserId()+"#"+user.getUserPwd();
              
              UserCasInfo userCasInfo=new UserCasInfo();
              userCasInfo.setUserInfo(userInfo);
              userCasInfo.setCompanyInfo(user.getCompany().getCompanyId()+"#"+user.getCompany().getCompanyName());
         
              userCasInfo.setSystemFuncModel(list);
           //   List list2=new ArrayList(userCasInfo);
              Map map=new HashMap();
              map.put(userCode, userCasInfo);
              final Principal principal2=    new SimplePrincipal(userCode, map);
           //     log.info("Resolved principal " + principal2);
                foundSupported = true;
                if (principal != null) {
                    return new Pair<AuthenticationHandler,Principal>(authenticatedClass, principal2);
                }
            }
        }

        if (foundSupported) {
            if (log.isDebugEnabled()) {
                log.debug("CredentialsToPrincipalResolver found but no principal returned.");
            }

            throw BadCredentialsAuthenticationException.ERROR;
        }

        log.error("CredentialsToPrincipalResolver not found for " + credentials.getClass().getName());
        throw UnsupportedCredentialsException.ERROR;
    }

    /**
     * @param authenticationHandlers The authenticationHandlers to set.
     */
    public void setAuthenticationHandlers(
        final List<AuthenticationHandler> authenticationHandlers) {
        this.authenticationHandlers = authenticationHandlers;
    }

    /**
     * @param credentialsToPrincipalResolvers The
     * credentialsToPrincipalResolvers to set.
     */
    public void setCredentialsToPrincipalResolvers(
        final List<CredentialsToPrincipalResolver> credentialsToPrincipalResolvers) {
        this.credentialsToPrincipalResolvers = credentialsToPrincipalResolvers;
    }

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
    
}
