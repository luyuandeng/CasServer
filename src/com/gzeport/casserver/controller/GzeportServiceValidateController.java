package com.gzeport.casserver.controller;

/*
 * Copyright 2007 The JA-SIG Collaborative. All rights reserved. See license
 * distributed with this file and available online at
 * http://www.ja-sig.org/products/cas/overview/license/
 */

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.jasig.cas.CentralAuthenticationService;
import org.jasig.cas.authentication.principal.Credentials;
import org.jasig.cas.authentication.principal.HttpBasedServiceCredentials;
import org.jasig.cas.authentication.principal.Principal;
import org.jasig.cas.authentication.principal.WebApplicationService;
import org.jasig.cas.services.UnauthorizedServiceException;
import org.jasig.cas.ticket.TicketException;
import org.jasig.cas.ticket.TicketValidationException;
import org.jasig.cas.ticket.proxy.ProxyHandler;
import org.jasig.cas.validation.Assertion;
import org.jasig.cas.validation.Cas20ProtocolValidationSpecification;
import org.jasig.cas.validation.ValidationSpecification;
import org.jasig.cas.web.support.ArgumentExtractor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.gzeport.casserver.util.StringHelp;
import com.gzeport.portal.to.Company;
import com.gzeport.portal.to.FuncModel;
import com.gzeport.portal.to.User;
import com.gzeport.portal.user.service.UserManager;

/**
 */
public class GzeportServiceValidateController extends AbstractController {

    /** View if Service Ticket Validation Fails. */
    private static final String DEFAULT_SERVICE_FAILURE_VIEW_NAME = "casServiceFailureView";

    /** View if Service Ticket Validation Succeeds. */
    private static final String DEFAULT_SERVICE_SUCCESS_VIEW_NAME = "casServiceSuccessView";

    /** Constant representing the PGTIOU in the model. */
    private static final String MODEL_PROXY_GRANTING_TICKET_IOU = "pgtIou";

    /** Constant representing the Assertion in the model. */
    private static final String MODEL_ASSERTION = "assertion";
    
    private static final String LONIN_USER = "loginuser";
    private static final String USER_COMPANY = "userCompany";
    private static final String USER_FUN_SYSMODEL = "userfunmodels";

    /** The CORE which we will delegate all requests to. */
    @NotNull
    private CentralAuthenticationService centralAuthenticationService;

    /** The validation protocol we want to use. */
    @NotNull
    private Class<?> validationSpecificationClass = Cas20ProtocolValidationSpecification.class;

    /** The proxy handler we want to use with the controller. */
    @NotNull
    private ProxyHandler proxyHandler;

    /** The view to redirect to on a successful validation. */
    @NotNull
    private String successView = DEFAULT_SERVICE_SUCCESS_VIEW_NAME;

    /** The view to redirect to on a validation failure. */
    @NotNull
    private String failureView = DEFAULT_SERVICE_FAILURE_VIEW_NAME;

    /** Extracts parameters from Request object. */
    @NotNull
    private ArgumentExtractor argumentExtractor;

    @NotNull
    private   UserManager userManager;
    public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
    
    private  SimpleDateFormat simpleDateFormat  =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
     * Overrideable method to determine which credentials to use to grant a
     * proxy granting ticket. Default is to use the pgtUrl.
     * 
     * @param request the HttpServletRequest object.
     * @return the credentials or null if there was an error or no credentials
     * provided.
     */
    protected Credentials getServiceCredentialsFromRequest(final HttpServletRequest request) {
        final String pgtUrl = request.getParameter("pgtUrl");
        if (StringUtils.hasText(pgtUrl)) {
            try {
                return new HttpBasedServiceCredentials(new URL(pgtUrl));
            } catch (final Exception e) {
                logger.error("Error constructing pgtUrl", e);
            }
        }

        return null;
    }

    protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) {
        binder.setRequiredFields("renew");
    }
    /**
     * @功能:通过注入的usermanger获取数据处理成客户端需要返回的权限数据 
     * @编码: luyd luyuandeng@gzeport.com
     * @时间: 2012-5-18下午02:22:56 
     * @文件: GzeportServiceValidateController.java
     */
    @SuppressWarnings("unchecked")
	protected final ModelAndView handleRequestInternal(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final WebApplicationService service = this.argumentExtractor.extractService(request);
        final String serviceTicketId = service != null ? service.getArtifactId() : null;

        if (service == null || serviceTicketId == null) {
            if (logger.isDebugEnabled()) {
                logger.debug(String.format("Could not process request; Service: %s, Service Ticket Id: %s", service, serviceTicketId));
            }
            return generateErrorView("INVALID_REQUEST", "INVALID_REQUEST", null);
        }

        try {
            final Credentials serviceCredentials = getServiceCredentialsFromRequest(request);
            String proxyGrantingTicketId = null;

            // XXX should be able to validate AND THEN use
            if (serviceCredentials != null) {
                try {
                    proxyGrantingTicketId = this.centralAuthenticationService
                        .delegateTicketGrantingTicket(serviceTicketId,
                            serviceCredentials);
                } catch (final TicketException e) {
                    logger.error("TicketException generating ticket for: "
                        + serviceCredentials, e);
                }
            }

            final Assertion assertion = this.centralAuthenticationService.validateServiceTicket(serviceTicketId, service);

            final ValidationSpecification validationSpecification = this.getCommandClass();
            final ServletRequestDataBinder binder = new ServletRequestDataBinder(validationSpecification, "validationSpecification");
            initBinder(request, binder);
            binder.bind(request);

            if (!validationSpecification.isSatisfiedBy(assertion)) {
                if (logger.isDebugEnabled()) {
                    logger.debug("ServiceTicket [" + serviceTicketId + "] does not satisfy validation specification.");
                }
                return generateErrorView("INVALID_TICKET", "INVALID_TICKET_SPEC", null);
            }
            
            onSuccessfulValidation(serviceTicketId, assertion);
            
            Principal principal = assertion.getChainedAuthentications().get(assertion.getChainedAuthentications().size()-1).getPrincipal();
            User user=  this.userManager.findUserByUserCode(principal.getId());
            List<FuncModel> list=  this.userManager.getFuncModelsList(null,String.valueOf(user.getUserId()));
          //  String userInfo=user.getUserCode()+"#"+user.getUserId()+"#"+user.getUserPwd();
         //   logger.info("++++____+++++"+userInfo);
            
            Map userMap = new HashMap();
            userMap.put("userId", StringHelp.trimNull(user.getUserId()!=null?user.getUserId().toString():""));
            userMap.put("userPwd", StringHelp.trimNull(user.getUserPwd()));
            userMap.put("userCode", StringHelp.trimNull(user.getUserCode()));
            userMap.put("userName", StringHelp.trimNull(user.getUserName()));
            userMap.put("isUse", StringHelp.trimNull(user.getIsUse()));
            userMap.put("customsCode", StringHelp.trimNull(user.getCustomsCode()));
            userMap.put("customsName", StringHelp.trimNull(user.getCustomsName()));
            userMap.put("company", StringHelp.trimNull(user.getCompany()!=null?user.getCompany().getCompanyId():""));
            userMap.put("userLoginType", StringHelp.trimNull(user.getUserLoginType()));
            userMap.put("createCompany",StringHelp.trimNull(user.getCreateCompany()));
            //userMap.put("userRoles", StringHelp.trimNull(user.getUserRoles().toString()));
            userMap.put("userSex", StringHelp.trimNull(user.getUserSex()));
            userMap.put("businessType", StringHelp.trimNull(user.getBusinessType()));
            userMap.put("createUser",StringHelp.trimNull(user.getCreateUser()));
            userMap.put("createTime", StringHelp.trimNull(user.getCreateTime()!=null?simpleDateFormat.format(user.getCreateTime()):null));
            userMap.put("workUnit", StringHelp.trimNull(user.getWorkUnit()));
            userMap.put("cardId", StringHelp.trimNull(user.getCardId()));
            userMap.put("cardType", StringHelp.trimNull(user.getCardType()));
            userMap.put("regRoleId", StringHelp.trimNull(user.getRegRoleId()));
            userMap.put("customsCodeExt", StringHelp.trimNull(user.getCustomsCodeExt()));
            userMap.put("userTel", StringHelp.trimNull(user.getUserTel()));
            userMap.put("userDpt", StringHelp.trimNull(user.getUserDpt()));
            userMap.put("userDuty", StringHelp.trimNull(user.getUserDuty()));
            userMap.put("birthday", StringHelp.trimNull(user.getBirthday()!=null?simpleDateFormat.format(user.getBirthday()):null));
            userMap.put("EMail", StringHelp.trimNull(user.getEMail()));
            userMap.put("certificate", StringHelp.trimNull(user.getCertificate()));
            userMap.put("clientsDesc", StringHelp.trimNull(user.getClientsDesc()));
            userMap.put("isModifyPwd", StringHelp.trimNull(user.getIsModifyPwd()));
            userMap.put("lastLoginTime",StringHelp.trimNull(user.getLastLoginTime()!=null?simpleDateFormat.format(user.getLastLoginTime()):null)); 
            userMap.put("attachmentid", StringHelp.trimNull(user.getAttachmentid()!=null?user.getAttachmentid().toString():"")); 
            userMap.put("modifyPwdTime", StringHelp.trimNull(user.getModifyPwdTime()!=null?simpleDateFormat.format(user.getModifyPwdTime()):null));
            userMap.put("newClients", StringHelp.trimNull(user.getNewClients()));
            userMap.put("newRoles", StringHelp.trimNull(user.getNewRoles()));
            userMap.put("roleCounts", StringHelp.trimNull(String.valueOf(user.getRoleCounts())));
            userMap.put("rolesDesc", StringHelp.trimNull(user.getRolesDesc()));
            
			
            
        Map companyMap = new HashMap();
           Company company = user.getCompany();
           if(company!=null){
        	     companyMap.put("brokerType", StringHelp.trimNull(company.getBrokerType()));
                 companyMap.put("coClass", StringHelp.trimNull(company.getCoClass()));
                 companyMap.put("companyId", StringHelp.trimNull(company.getCompanyId()));
                 companyMap.put("companyName", StringHelp.trimNull(company.getCompanyName()));
                 companyMap.put("companyState", StringHelp.trimNull(company.getCompanyState()));
                 companyMap.put("companyType",StringHelp.trimNull(company.getCompanyType()!=null?company.getCompanyType().getTypeId().toString()
             		   		  +"|"+company.getCompanyType().getTypeName():""));
                 companyMap.put("customsCode", StringHelp.trimNull(company.getCustomsCode()));
                 companyMap.put("customsName", StringHelp.trimNull(company.getCustomsName()));
                companyMap.put("english", StringHelp.trimNull(company.getEnglish()));
                 companyMap.put("engName", StringHelp.trimNull(company.getEngName()));
                 companyMap.put("eportCard", StringHelp.trimNull(company.getEportCard()));
                companyMap.put("orgCode", StringHelp.trimNull(company.getOrgCode()));
                 
           }
        
           Map funSysModel  = null;
           ArrayList modelList = new ArrayList();
           if(list!=null&&list.size()>0){
        	   for(FuncModel model :list){
            	   funSysModel=new HashMap();
            	   funSysModel.put("css",  StringHelp.trimNull(model.getCss()));
            	 //  funSysModel.put("disabled", StringHelp.trimNull(model.get));
// System.out.println("--type--"+model.getFuncSysType());
            	   funSysModel.put("funcCode", StringHelp.trimNull(model.getFuncCode()));
            	   funSysModel.put("funcId", StringHelp.trimNull(model.getFuncId()));
            	   funSysModel.put("funcIslast", StringHelp.trimNull(model.getFuncIslast()));
            	   funSysModel.put("funcIsmenu", StringHelp.trimNull(model.getFuncIsmenu()));
            	   funSysModel.put("funcmodel", StringHelp.trimNull(model.getFuncmodel()!=null?model.getFuncmodel().getFuncId():""));
            	   funSysModel.put("funcResume", StringHelp.trimNull(model.getFuncResume()));
            	   funSysModel.put("funcName", StringHelp.trimNull(model.getFuncName()));
            	   funSysModel.put("funcSysType", StringHelp.trimNull(model.getFuncSysType()));
            	   funSysModel.put("funcUrl", StringHelp.trimNull(model.getFuncUrl()));
            	   funSysModel.put("funcUseType", StringHelp.trimNull(model.getFuncUseType()));
            	   funSysModel.put("funcUseType0", StringHelp.trimNull(model.getFuncUseType0()));
            	   funSysModel.put("funcUseType1", StringHelp.trimNull(model.getFuncUseType1()));
            	   funSysModel.put("funcUseType2", StringHelp.trimNull(model.getFuncUseType2()));
            	   funSysModel.put("funcUseType34", StringHelp.trimNull(model.getFuncUseType34()));
            	   funSysModel.put("images", StringHelp.trimNull(model.getImages()));
            	   modelList.add(funSysModel);
               }
           }
        
               
            final ModelAndView success = new ModelAndView(this.successView);
            success.addObject(MODEL_ASSERTION, assertion);
/*            
logger.info("LOGIN_USER:::========"+userMap);
logger.info("LOGIN_COMPANY:::========"+companyMap);
logger.info("LOGIN_FUNMODELLIST:::========"+modelList);
*/
            success.addObject(LONIN_USER,userMap);
            success.addObject(USER_COMPANY,companyMap);
            success.addObject(USER_FUN_SYSMODEL,modelList);
            
            
            if (serviceCredentials != null && proxyGrantingTicketId != null) {
                final String proxyIou = this.proxyHandler.handle(serviceCredentials, proxyGrantingTicketId);
                success.addObject(MODEL_PROXY_GRANTING_TICKET_IOU, proxyIou);
            }

            if (logger.isDebugEnabled()) {
                logger.debug(String.format("Successfully validated service ticket: %s", serviceTicketId));
            }

            return success;
        } catch (final TicketValidationException e) {
            return generateErrorView(e.getCode(), e.getCode(), new Object[] {serviceTicketId, e.getOriginalService().getId(), service.getId()});
        } catch (final TicketException te) {
            return generateErrorView(te.getCode(), te.getCode(),
                new Object[] {serviceTicketId});
        } catch (final UnauthorizedServiceException e) {
            return generateErrorView(e.getMessage(), e.getMessage(), null);
        }
    }

    protected void onSuccessfulValidation(final String serviceTicketId, final Assertion assertion) {
        // template method with nothing to do.
    }

    private ModelAndView generateErrorView(final String code, final String description, final Object[] args) {
        final ModelAndView modelAndView = new ModelAndView(this.failureView);
        final String convertedDescription = getMessageSourceAccessor().getMessage(description, args, description);
        modelAndView.addObject("code", code);
        modelAndView.addObject("description", convertedDescription);

        return modelAndView;
    }

    private ValidationSpecification getCommandClass() {
        try {
            return (ValidationSpecification) this.validationSpecificationClass.newInstance();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * @param centralAuthenticationService The centralAuthenticationService to
     * set.
     */
    public final void setCentralAuthenticationService(final CentralAuthenticationService centralAuthenticationService) {
        this.centralAuthenticationService = centralAuthenticationService;
    }

    public final void setArgumentExtractor(final ArgumentExtractor argumentExtractor) {
        this.argumentExtractor = argumentExtractor;
    }

    /**
     * @param validationSpecificationClass The authenticationSpecificationClass
     * to set.
     */
    public final void setValidationSpecificationClass(final Class<?> validationSpecificationClass) {
        this.validationSpecificationClass = validationSpecificationClass;
    }

    /**
     * @param failureView The failureView to set.
     */
    public final void setFailureView(final String failureView) {
        this.failureView = failureView;
    }

    /**
     * @param successView The successView to set.
     */
    public final void setSuccessView(final String successView) {
        this.successView = successView;
    }

    /**
     * @param proxyHandler The proxyHandler to set.
     */
    public final void setProxyHandler(final ProxyHandler proxyHandler) {
        this.proxyHandler = proxyHandler;
    }
}
