package com.gzeport.casserver.authentication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jasig.cas.authentication.principal.AbstractPersonDirectoryCredentialsToPrincipalResolver;
import org.jasig.cas.authentication.principal.Credentials;
import org.jasig.cas.authentication.principal.Principal;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentialsToPrincipalResolver;
import org.jasig.services.persondir.IPersonAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GzeportAbstractPersonDirectoryCredentialsToPrincipalResolver    extends
    AbstractPersonDirectoryCredentialsToPrincipalResolver {

    protected String extractPrincipalId(final Credentials credentials) {
        final UsernamePasswordCredentials usernamePasswordCredentials = (UsernamePasswordCredentials) credentials;
        return usernamePasswordCredentials.getUsername();
    }

    /**
     * Return true if Credentials are UsernamePasswordCredentials, false
     * otherwise.
     */
    public boolean supports(final Credentials credentials) {
        return credentials != null
            && UsernamePasswordCredentials.class.isAssignableFrom(credentials
                .getClass());
    }
}
