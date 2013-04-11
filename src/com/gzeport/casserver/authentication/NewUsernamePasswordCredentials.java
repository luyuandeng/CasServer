package com.gzeport.casserver.authentication;

/*
 * Copyright 2007 The JA-SIG Collaborative. All rights reserved. See license
 * distributed with this file and available online at
 * http://www.ja-sig.org/products/cas/overview/license/
 */


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;

/**
 * UsernamePasswordCredentials respresents the username and password that a user
 * may provide in order to prove the authenticity of who they say they are.
 * 
 * @author Scott Battaglia
 * @version $Revision: 1.2 $ $Date: 2007/01/22 20:35:26 $
 * @since 3.0
 * <p>
 * This is a published and supported CAS Server 3 API.
 * </p>
 */
public class NewUsernamePasswordCredentials extends UsernamePasswordCredentials {
    /** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -4140155037135619123L;
	
//	@NotNull
    @Size(min=1,message = "required.yzm")
    private String yzm;

	public String getYzm() {
		return yzm;
	}

	public void setYzm(String yzm) {
		this.yzm = yzm;
	}


}

