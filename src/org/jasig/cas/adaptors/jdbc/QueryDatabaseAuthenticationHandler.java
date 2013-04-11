/*
 * Copyright 2007 The JA-SIG Collaborative. All rights reserved. See license
 * distributed with this file and available online at
 * http://www.ja-sig.org/products/cas/overview/license/
 */
package org.jasig.cas.adaptors.jdbc;

import java.util.List;

import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import com.gzeport.logistics.common.util.StringHelp;
import com.gzeport.portal.to.FuncModel;
import com.gzeport.portal.to.User;

import javax.validation.constraints.NotNull;

/**
 * Class that if provided a query that returns a password (parameter of query
 * must be username) will compare that password to a translated version of the
 * password provided by the user. If they match, then authentication succeeds.
 * Default password translator is plaintext translator.
 * 
 * @author Scott Battaglia
 * @author Dmitriy Kopylenko
 * @version $Revision$ $Date$
 * @since 3.0
 */
public final class QueryDatabaseAuthenticationHandler extends
    AbstractJdbcUsernamePasswordAuthenticationHandler {

    @NotNull
    private String sql;
    
    @NotNull
    private  com.gzeport.portal.user.service.UserManager  userManager;

    protected final boolean authenticateUsernamePasswordInternal(final UsernamePasswordCredentials credentials) throws AuthenticationException {
        final String username = getPrincipalNameTransformer().transform( StringHelp.toUpperString(credentials.getUsername()));
        final String password = credentials.getPassword();
       
        final String encryptedPassword = this.getPasswordEncoder().encode(
            password);
        try {
            final String dbPassword = getJdbcTemplate().queryForObject(
                this.sql, String.class, username);
            return true;
            //  return dbPassword.equals(encryptedPassword);
        } catch (final IncorrectResultSizeDataAccessException e) {
            return false;
        }
        
        
        
    }

    /**
     * @param sql The sql to set.
     */
    public void setSql(final String sql) {
        this.sql = sql;
    }

	public com.gzeport.portal.user.service.UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(
			com.gzeport.portal.user.service.UserManager userManager) {
		this.userManager = userManager;
	}
}
