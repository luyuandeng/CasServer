package com.gzeport.casserver.action;


import java.io.ByteArrayInputStream;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import net.netca.jce.SimplePKCS7SignedData;
import net.netca.secuInter.CertInfo;
import net.netca.util.encoders.Base64;

import org.jasig.cas.CentralAuthenticationService;
import org.jasig.cas.authentication.principal.Credentials;
import org.jasig.cas.ticket.TicketException;
import org.jasig.cas.web.bind.CredentialsBinder;
import org.jasig.cas.web.support.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.webflow.execution.RequestContext;

import com.gzeport.casserver.Md5PwdEncoder;
import com.gzeport.casserver.authentication.NewUsernamePasswordCredentials;
import com.gzeport.logistics.common.util.StopWatchUtils;
import com.gzeport.logistics.common.util.StringHelp;
import com.gzeport.portal.authorization.AuthorizationHelp;
import com.gzeport.portal.common.CommonConstatsHelp;
import com.gzeport.portal.common.Message;
import com.gzeport.portal.netca.service.UserCertManager;
import com.gzeport.portal.to.User;
import com.gzeport.portal.to.UserCert;
import com.gzeport.portal.user.service.UserManager;

public class BaseUserCheckAction  {

    private CredentialsBinder credentialsBinder;
   private  int errorTimes =0;
    @NotNull
    private   UserManager userManager;
    
	private UserCertManager  userCertManager;
 //   GzeportPersonAttributeDao  gzeportPersonAttributeDao

	@NotNull
    private CentralAuthenticationService centralAuthenticationService;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public final void doBind(final RequestContext context, final Credentials credentials) throws Exception {
        final HttpServletRequest request = WebUtils.getHttpServletRequest(context);

        if (this.credentialsBinder != null && this.credentialsBinder.supports(credentials.getClass())) {
            this.credentialsBinder.bind(request, credentials);
        }
    }
    /**
     * @author: luyd luyuandeng@gzeport.com
     * @Time: 2012-5-4上午11:10:21
     * @Description: 检查用户登录合法性 保存用户信息到session 
     * @throws
     */
    public final String check(final RequestContext context, final NewUsernamePasswordCredentials credentials, final MessageContext messageContext) throws Exception {
    	    StopWatchUtils sw;
	        sw = new StopWatchUtils(getClass().getName());
			sw.start(true);
			sw.setStartTime(System.currentTimeMillis());
    	 	String loginType = null;
	        String userName = "";
	        String companyState="4";
	        String companyType=CommonConstatsHelp.SYSTEM_OTHER_COMPANY_TYPE;
	        
    	   HttpServletRequest request = WebUtils.getHttpServletRequest(context);
	       HttpSession session  = WebUtils.getHttpServletRequest(context).getSession();
	       
	       String snmm =StringHelp.trimNull(request.getParameter("certThumbPrint"));
	      
	       if(!"".equals(snmm)){
	    	   return this.certUserCheck(context, credentials, messageContext); 
	       }
	  //     gzeportPersonAttributeDao.set();
	       if (!"".equals(StringHelp.trimNull(String.valueOf(credentials.getUsername())))) {
	         //  User user=this.userManager.getUserInfo(request);
	    	   Md5PwdEncoder md5PwdEncoder = new Md5PwdEncoder();
	    	   String entryPwd = md5PwdEncoder.encode(StringHelp.trimNull(String.valueOf(credentials.getPassword())));
	    	   User user=	this.userManager.findUserByUserCode(credentials.getUsername());
	           companyType=StringHelp.trimNull(String.valueOf(user.getCompany().getCompanyType().getTypeId()),CommonConstatsHelp.SYSTEM_OTHER_COMPANY_TYPE);
	            
	           if (user != null) {
	               // AuthorizationHelp.removeUserRightCache(String.valueOf(user.getUserId()));
	                String password = user.getUserPwd();
	                if (!entryPwd.equals(password)) { 
	                	// 密码有误
	                	//System.out.println(context.getFlowScope().getInteger("errorTimes"));
	                	context.getFlowScope().put("login_failed_num_to_show_validation_code",context.getFlowScope().getInteger("errorTimes")==null?1:context.getFlowScope().getInteger("login_failed_num_to_show_validation_code")+1 );
	                	//超过输入错误密码次数3锁定帐户
	                	/*if(context.getFlowScope().getInteger("errorTimes")>3){
		                	 user.setIsUse("1");
		                	  this.userManager.updateObject(user);
		                  }*/
	                	//密码有误
	                    messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_PASSWORD_ERROR").defaultText("INVALID_USER_PASSWORD_ERROR").build());
	                    return "error";
	                }
	                
	                
	                String isUse = user.getIsUse();
	                if ("0".equals(isUse)) {
	                    // 用户未起用;0 表没起用, 1表起用                   
//	                    request.getSession().invalidate();
	                    request.setAttribute("userId", String.valueOf(user.getUserId()));
	                    request.setAttribute("userCode", user.getUserCode());
	                    request.setAttribute("customsCode", user.getCustomsCode());
	                    request.setAttribute("companyId", String.valueOf(user.getCompany().getCompanyId()));
	                    request.setAttribute("companyName", user.getCompany().getCompanyName());
	                 	//用户未起用
	                    messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_UNUSE").defaultText("INVALID_USER_UNUSE").build());
	                    return "error";
	                }
	                if (user.getCompany()==null) {
//	                    request.getSession().invalidate();
	                    // 用户未关联单位
	                	messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_UNCONNCOMPANY").defaultText("INVALID_USER_UNCONNCOMPANY").build());
	                    return "error";
	                }else{
	                	 companyState=StringHelp.trimNull(String.valueOf(user.getCompany().getCompanyState()));
	                	if(CommonConstatsHelp.COMPANY_STATE_NO_USE.equals(companyState) ){
	                		//单位禁用
	                		messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_COMPANY_UNUSE").defaultText("INVALID_USER_COMPANY_UNUSE").build());
		                    return "error";
	                	}
	                	 
	                	if( CommonConstatsHelp.COMPANY_STATE_STOP.equals(companyState)){
//	                		request.getSession().invalidate();
	                		//欠费
	                		messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_COMPANY_NOPLAY_OFF").defaultText("INVALID_USER_COMPANY_NOPLAY_OFF").build());
	                		return "error";
	                	}
	                	if(CommonConstatsHelp.COMPANY_STATE_BEFORE.equals(companyState) ){

//	                		request.getSession().invalidate();
	                		  //单位登记开发期
	                		messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_COMPANY_STATE_BEFORE").defaultText("INVALID_USER_COMPANY_STATE_BEFORE").build());
	                		return "error";
	                	}
	                }
	                
	            	     
	                
	            	//String func= "";
	         		// func= AuthorizationHelp.getFuncModelCodeStr(String.valueOf(user.getUserId()),this.userManager);

		/*		    List	funModelist =this.userManager.getFuncModelsList( null,String.valueOf(user.getUserId()));
			      	List	funSyslist = new ArrayList();
				     if(funModelist.size()>0){
				    	 for(int i=0;i<funModelist.size();i++){
					    	   FuncModel funcModel=(FuncModel)funModelist.get(i);
					    	  // logger.info("funcName="+funcModel.getFuncName()+"_____"+funcModel.getFuncmodel().getFuncId());
					    	   if(funcModel.getFuncmodel().getFuncId()==null){
					    		   funSyslist.add(funcModel);
					    	   }
					     }
				    	 if(funSyslist!=null&&funSyslist.size()>0){
					    	 for(int j =0;j<funSyslist.size();j++){
					    		 FuncModel func=(FuncModel)funSyslist.get(j);
					    		 logger.info("SYS::"+func.getFuncName());
					    	 }
					     }
				    	 request.getSession(true).setAttribute("LOGIN_USER_MODULE",funModelist );
				    	 request.getSession(true).setAttribute("LOGIN_USER_SYSTEM",funSyslist );
				     } else {
				    	//没有权限
		                    messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_NOAUTHORITY").defaultText("INVALID_USER_NOAUTHORITY").build());
		                    return "error";
				     }*/
	        		String validPwd="0";//0未到期 ,1到期
	        		Date currentDate =new Date();
	        		Calendar calendar = Calendar.getInstance();
	        		  calendar.add(Calendar.MONTH, -3);    //得到前3个月的时间
	        		  long time2=calendar.getTimeInMillis();
	      
	        		  if(user.getModifyPwdTime()!=null){
	        			  long lastLoginTime=user.getModifyPwdTime().getTime();
	        			  long p= (lastLoginTime -time2);
	        			 if(p>0){
	        				 validPwd="0" ;
	        			 }
	        		 
	        		  }else{
	        			  validPwd="0" ; 
	        		  }
	        		request.getSession(true).setAttribute("validPwd",validPwd);
	        	
	         		if(request.getSession().getAttribute("LOGIN_USER")==null){
	         			request.getSession(true).setAttribute("LOGIN_USER",user );
	         		}
	                
	                if ("0".equals(user.getIsModifyPwd())) {
	                	
	                }
	            	sw.setEndTime(System.currentTimeMillis());
	        		sw.stop();
	        		sw=null;

	        		 //更新用户登录时间
	        		 Date loginTime=new Date(System.currentTimeMillis());
	        		 user.setLastLoginTime(loginTime);
	        		 this.userManager.updateUser(user);
//	        		 this.centralAuthenticationService.g
	        		 return "success";
	            }else{    
	                // 没有此用户
	             //   request.getSession().removeAttribute("userId");
//	                request.getSession().invalidate();
	                messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_NOT_FOUND").defaultText("INVALID_USER_NOT_FOUND").build());
	                return "error";
	            }
	        } else {
	        	messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_NOT_FOUND").defaultText("INVALID_USER_NOT_FOUND").build());
	            return "error";
	        }
    }

    public String certUserCheck(final RequestContext context, final NewUsernamePasswordCredentials credentials, 
    		final MessageContext messageContext)throws Exception {
    	Message message = null; 
    	
    	HttpServletRequest request = WebUtils.getHttpServletRequest(context);
	    HttpSession session  = WebUtils.getHttpServletRequest(context).getSession();
    	String  loginModel=  StringHelp.trimNull(request.getParameter("loginModel"),"CNGZEPORT");
    	if(!"".equals(StringHelp.trimNull(request.getParameter("systemView")))){
    	//	sucessView=StringHelp.trimNull(request.getParameter("systemView"));
    	}
    	User userInfo = null;
    	//网证通方式
      if("gdnetCat".equals(StringHelp.trimNull(loginModel))){
        	request.getSession().removeAttribute("certThumb");
        	String argStr=  request.getParameter("randomStr");
        	String argSign=  request.getParameter("procContent");
            String sn="1000000060241";
        	  sn=  request.getParameter("certThumbPrint");
        	  
        	UserCert userCert = this.userCertManager.getUserCert(sn);
			if (userCert == null) {
				 messageContext.addMessage(new MessageBuilder().error().code("INVAILD_USER_CERT_ERROR").defaultText("INVAILD_USER_CERT_ERROR").build());
	             return "error";			
			}
			request.getSession().setAttribute("certThumb",userCert.getCertThumbPrint());
			
			String userId = String.valueOf(userCert.getUserKey());
			if (userId == null && "".equals(userId)) {
				messageContext.addMessage(new MessageBuilder().error().code("INVAILD_USER_CERT_ERROR").defaultText("INVAILD_USER_CERT_ERROR").build());
	             return "error";	
			}
			userInfo = this.userManager.getUser(userId);
        }	
    	
    if("netCat".equals(StringHelp.trimNull(loginModel))){
    	request.getSession().removeAttribute("certThumb");
    	String argStr=  request.getParameter("randomStr");
    	String argSign=  request.getParameter("procContent");
        SimplePKCS7SignedData sd=new SimplePKCS7SignedData(new ByteArrayInputStream(Base64.decode(new String(argSign))));//装载SimplePKCS7SignedData对象进行验证
        X509Certificate certs[]=null;
        String sn =null;

        try {
			// 进行验证信息
			if (sd.verify()) {
				byte b[] = sd.getContent();
				String signData = new String(b, "UTF-16LE");
				if (signData.equals(argStr)) {
					certs = sd.getSignCertificates();
					CertInfo certInfo = new CertInfo();
					certInfo.setCert(certs[0]);
					/*
					 * 此处在证书查询校验服务器搭建完成后，需将certs[0]进行Base64编码后提交到证书查询校验服务器进行查询校验。
					 * Base64编码代码如： byte cc[] = certs[0].getEncoded();
					 * BASE64Encoder baseE = new BASE64Encoder(); String
					 * s_certBeChk = baseE.encode(cc)
					 * 回复“OK”后，则继续。
					 * 以下为：根据获取到的证书微缩图certInfo.getThumbprint()，到数据库中查询具体登录的用户帐户。
					 */
					sn = certInfo.getThumbprint();
					UserCert userCert = this.userCertManager.getUserCert(sn);
					if (userCert == null) {
					messageContext.addMessage(new MessageBuilder().error().code("INVAILD_USER_CERT_ERROR").defaultText("INVAILD_USER_CERT_ERROR").build());
			             return "error";
					}
					request.getSession().setAttribute("certThumb",
							userCert.getCertThumbPrint());
					String userId = String.valueOf(userCert.getUserKey());
					if (userId == null && "".equals(userId)) {
						messageContext.addMessage(new MessageBuilder().error().code("INVAILD_USER_CERT_ERROR").defaultText("INVAILD_USER_CERT_ERROR").build());
			             return "error";
					}
					userInfo = this.userManager.getUser(userId);

				} else {
				}
			}
			} catch (Exception e) {
			}
    	}
    
    
    	if("CNGZEPORT".equals(StringHelp.trimNull(loginModel))){
    		 String sn =StringHelp.trimNull(request.getParameter("certThumbPrint"));
    		 List userInf =StringHelp.getAllStringBySplit(new StringBuffer(sn), "||") ;
    		 String caCode="";
    		 for(int i=0;i<userInf.size();i++){
//    			 System.out.println("userinfo=="+userInf.get(i));
    			 if(i==5){
    			 caCode=String.valueOf(userInf.get(i));
    			 }
    		 }
//    		 System.out.println("caCode==="+caCode);
    			if ("".equals(caCode)) {
    				messageContext.addMessage(new MessageBuilder().error().code("INVAILD_USER_CERT_ERROR").defaultText("INVAILD_USER_CERT_ERROR").build());
		             return "error";
				
				}
    			UserCert userCert = this.userCertManager.getUserCert(StringHelp.trimNull(caCode));
//    			System.out.println("userCert_action="+userCert);
				if (userCert == null) {
					messageContext.addMessage(new MessageBuilder().error().code("INVAILD_USER_CERT_ERROR").defaultText("INVAILD_USER_CERT_ERROR").build());
		             return "error";
					
				}
				request.getSession().setAttribute("certThumb",userCert.getCertThumbPrint());
				String userId = String.valueOf(userCert.getUserKey());
				
				if (userId == null && "".equals(userId)) {
					messageContext.addMessage(new MessageBuilder().error().code("INVAILD_USER_CERT_ERROR").defaultText("INVAILD_USER_CERT_ERROR").build());
		             return "error";
				
				}
				userInfo = this.userManager.getUser(userId);
    	}
			
        String loginType = null;
        String userName = "";
        String ediClientType = null;
        String companyState="4";	     
        if(userInfo==null){
        	 messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_NOT_FOUND").defaultText("INVALID_USER_NOT_FOUND").build());
             return "error";
        }
        request.getSession().setAttribute("userId",String.valueOf(userInfo.getUserId())); 
             
        if (!"".equals(StringHelp.trimNull(userInfo.getUserCode()))) {
        User user=	this.userManager.findUserByUserCode(userInfo.getUserCode());
        if (userInfo != null) {
        	 AuthorizationHelp.removeUserRightCache(String.valueOf(user.getUserId()));
             loginType = user.getUserLoginType();// (总系统管理员，一般单位管理员,普通用户)
             ediClientType = user.getUserDpt();
             userName = user.getUserName();
             credentials.setYzm("userCertLogin");
             credentials.setUsername(user.getUserCode());
            // AuthorizationHelp.removeUserRightCache(String.valueOf(user.getUserId()));
             String password = user.getUserPwd();
        
             
             String isUse = user.getIsUse();
             if ("0".equals(isUse)) {
                 // 用户未起用;0 表没起用, 1表起用                   
//                 request.getSession().invalidate();
                 request.setAttribute("userId", String.valueOf(user.getUserId()));
                 request.setAttribute("userCode", user.getUserCode());
                 request.setAttribute("customsCode", user.getCustomsCode());
                 request.setAttribute("companyId", String.valueOf(user.getCompany().getCompanyId()));
                 request.setAttribute("companyName", user.getCompany().getCompanyName());
              	//用户未起用
                 messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_UNUSE").defaultText("INVALID_USER_UNUSE").build());
                 return "error";
             }
             if (user.getCompany()==null) {
//                 request.getSession().invalidate();
                 // 用户未关联单位
             	messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_UNCONNCOMPANY").defaultText("INVALID_USER_UNCONNCOMPANY").build());
                 return "error";
             }else{
             	 companyState=StringHelp.trimNull(String.valueOf(user.getCompany().getCompanyState()));
             	if(CommonConstatsHelp.COMPANY_STATE_NO_USE.equals(companyState) ){
             		//单位禁用
             		messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_COMPANY_UNUSE").defaultText("INVALID_USER_COMPANY_UNUSE").build());
	                    return "error";
             	}
             	 
             	if( CommonConstatsHelp.COMPANY_STATE_STOP.equals(companyState)){
             		//欠费
             		messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_COMPANY_NOPLAY_OFF").defaultText("INVALID_USER_COMPANY_NOPLAY_OFF").build());
             		return "error";
             	}
             	if(CommonConstatsHelp.COMPANY_STATE_BEFORE.equals(companyState) ){
             		  //单位登记开发期
             		messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_COMPANY_STATE_BEFORE").defaultText("INVALID_USER_COMPANY_STATE_BEFORE").build());
             		return "error";
             	}
             }
             
     		String validPwd="0";//0未到期 ,1到期
     		Date currentDate =new Date();
     		Calendar calendar = Calendar.getInstance();
     		  calendar.add(Calendar.MONTH, -3);    //得到前3个月的时间
     		  long time2=calendar.getTimeInMillis();
   
     		  if(user.getModifyPwdTime()!=null){
     			  long lastLoginTime=user.getModifyPwdTime().getTime();
     			  long p= (lastLoginTime -time2);
     			 if(p>0){
     				 validPwd="0" ;
     			 }
     		 
     		  }else{
     			  validPwd="0" ; 
     		  }
     		request.getSession(true).setAttribute("validPwd",validPwd);
     	
      		if(request.getSession().getAttribute("LOGIN_USER")==null){
      			request.getSession(true).setAttribute("LOGIN_USER",user );
      		}
             
             if ("0".equals(user.getIsModifyPwd())) {
             	
             }
         	//sw.setEndTime(System.currentTimeMillis());
     		//sw.stop();
     		//sw=null;

     		 //更新用户登录时间
     		 Date loginTime=new Date(System.currentTimeMillis());
     		 user.setLastLoginTime(loginTime);
     		 this.userManager.updateUser(user);
     		 return "success";
         }else{    
             // 没有此用户
             messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_NOT_FOUND").defaultText("INVALID_USER_NOT_FOUND").build());
             return "error";
         }
       }else {
       	messageContext.addMessage(new MessageBuilder().error().code("INVALID_USER_NOT_FOUND").defaultText("INVALID_USER_NOT_FOUND").build());
        return "error";
       }
    }

    private void populateErrorsInstance(final TicketException e, final MessageContext messageContext) {

        try {
            messageContext.addMessage(new MessageBuilder().error().code(e.getCode()).defaultText(e.getCode()).build());
        } catch (final Exception fe) {
            logger.error(fe.getMessage(), fe);
        }
    }


    public final void setCentralAuthenticationService(final CentralAuthenticationService centralAuthenticationService) {
        this.centralAuthenticationService = centralAuthenticationService;
    }

    public final void setCredentialsBinder(final CredentialsBinder credentialsBinder) {
        this.credentialsBinder = credentialsBinder;
    }
    
    public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public void setUserCertManager(UserCertManager userCertManager) {
		this.userCertManager = userCertManager;
	}
}

