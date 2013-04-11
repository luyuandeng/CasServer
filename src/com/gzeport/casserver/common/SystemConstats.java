/**
 * 
 */
package com.gzeport.casserver.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.CleanupFailureDataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.dao.IncorrectUpdateSemanticsDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.dao.UncategorizedDataAccessException;

/**
 * @author rr
 * 
 */
public class SystemConstats {

//    public static final String NO_OPERATOR = "noOpertaor";

//    public static final String LOGIN_OK = "UserLoginOk";
	
	
	public static final String PORTAL_SYSTEM_SCHEML="portal";
	

	
    public static final int[]  FUNCMODEL_CODERULE = new int[] { 3, 2, 2, 2,2 };// 功能模块编码规则

//    public static final String LONGIN_USERCODE_NOT_NULL = "���ɹ�";
    public static final String USER_FUNC_MODEL_RIGHT_="user_funcmodel_right_";
    //com.gzeport.logMessage
    
    public static final String COM_GZEPORT_LOGMESSAGE_CACHE="com.gzeport.logMessage";
    
    //***********************＝＝修改密码＝＝*****************************************
    public static final String PORTAL_CHGPWD_UPDATE_PASSWORD_OK = "portal.chgpwd.update.password.ok";
    public static final String PORTAL_CHGPWD_UPDATE_PASSWORD_FAILURE = "portal.chgpwd.update.password.failure";
    public static final String PORTAL_CHGPWD_UPDATE_PASSWORD_OLDPWD_NOTNULL = "portal.chgpwd.update.password.oldpwd.notnull";
    public static final String PORTAL_CHGPWD_UPDATE_PASSWORD_NOTNULL = "portal.chgpwd.update.password.notnull";
    public static final String PORTAL_CHGPWD_UPDATE_PASSWORD_OLDPWD_ERROR = "portal.chgpwd.update.password.oldpwd.error";
    //******************************************************************************    
    
    //***********************＝＝系统登录＝＝*****************************************
    public static final String PORTAL_LOGIN_USER_SUCCESS = "portal.login.user.success";
    public static final String PORTAL_LOGIN_ERROR_USER_NO_USERCODE = "portal.login.error.user.no.usercode";
    public static final String PORTAL_LOGIN_ERROR_USER_PASSWORD = "portal.login.error.user.password";
    public static final String PORTAL_LOGIN_ERROR_USER_NOEXIST = "portal.login.error.user.noexist";
    public static final String PORTAL_LOGIN_ERROR_USER_NO_RIGHT = "portal.login.error.user.no.right";    
    public static final String PORTAL_LOGIN_ERROR_USER_NO_MODIFY_PWD = "portal.login.error.user.no.modify.pwd";    
    public static final String PORTAL_LOGIN_ERROR_USER_LOCKED = "portal.login.error.user.locked";
    public static final String PORTAL_LOGIN_ERROR_USER_NOCOMPANY = "portal.login.error.user.nocompany";
    public static final String PORTAL_LOGIN_ERROR_USER_OTHER = "portal.login.error.user.other";
    public static final String PORTAL_LOGIN_ERROR_DB_CONNECT = "portal.login.error.db.connect";
    public static final String PORTAL_LOGIN_ERROR_IDENTIFYCODE_WRONG="portal.login.error.identifycode.wrong";
    
    public static final String PORTAL_LOGIN_ERROR_COMPANY_NO_USE = "portal.login.error.company.no.use";
    public static final String PORTAL_LOGIN_ERROR_COMPANY_BEFORE = "portal.login.error.company.before";
    public static final String PORTAL_LOGIN_ERROR_COMPANY_STOP = "portal.login.error.company.stop";
    
    public static final String PORTAL_LOGIN_FAILURE_NETCA_ERROR="portal.login.failure.netca.error";
   // public static final String PORTAL_LOGIN_FAILURE_NETCA_EMPTY="portal.login.failure.netca.empty";
    
    public static final String PORTAL_LOGIN_FAILURE_NETCA_NO_REGEIST="portal.login.failure.netca.no.regeist";
    
    //******************************************************************************  
    
    //***********************＝＝用户＝＝*********************************************
    public static final String  PORTAL_USER_SAVE = "portal.user.save";
    public static final String  PORTAL_USER_NOT_SAVE = "portal.user.no.save";
    public static final String  PORTAL_USER_ADD_OK = "portal.user.add.ok";
    public static final String  PORTAL_USER_ADD_FAILURE = "portal.user.add.failure";
    public static final String  PORTAL_USER_ADD_IS_EXIST = "portal.user.add.is.existed";   
    public static final String  PORTAL_USER_ADD_IS_USERNAME_EXIST = "portal.user.add.is.user.existed";
    public static final String  PORTAL_USER_UPDATE_OK = "portal.user.update.ok";
    public static final String  PORTAL_USER_UPDATE_FAILURE = "portal.user.update.failure";       
    public static final String  PORTAL_USER_DEL_OK = "portal.user.del.ok";
    public static final String  PORTAL_USER_DEL_FAILURE = "portal.user.del.failure";  
    
    public static final String  PORTAL_USER_DEL_FAILURE_IS_OTHER_SAVE = "portal.user.del.failure.is.other.save";  
    public static final String  PORTAL_USER_DEL_FAILURE_IS_OTHER_ROLE_SAVE = "portal.user.del.failure.is.other.role.save"; 
    
    //********************************************************************    
    
    //***********************＝＝角色＝＝*********************************************
    public static final String  PORTAL_ROLE_SAVE_OK = "portal.role.save.ok";
    public static final String  PORTAL_ROLE_SAVE_FAILURE = "portal.role.save.failure";
    public static final String  PORTAL_ROLE_ADD_OK = "portal.role.add.ok";
    public static final String  PORTAL_ROLE_ADD_FAILURE = "portal.role.add.failure";
    public static final String  PORTAL_ROLE_ADD_IS_EXIST = "portal.role.add.is.existed";   
    public static final String  PORTAL_ROLE_ADD_IS_ROLENAME_EXIST = "portal.role.add.is.rolename.existed";     
    public static final String  PORTAL_ROLE_UPDATE_OK = "portal.role.update.ok";
    public static final String  PORTAL_ROLE_UPDATE_FAILURE = "portal.role.update.failure";       
    public static final String  PORTAL_ROLE_DEL_OK = "portal.role.del.ok";
    public static final String  PORTAL_ROLE_DEL_FAILURE = "portal.role.del.failure";
    public static final String  PORTAL_ROLE_IS_ADMIN_PLEASE_DEL_OTHER = "portal.role.del.failure.is.admin.please.del.use";
    public static final String  PORTAL_ROLE_INHERIT_OK = "portal.role.inherit.ok";
    public static final String  PORTAL_ROLE_INHERIT_FAILURE = "portal.role.inherit.failure";
    public static final String  PORTAL_ROLE_UPDATE_FUNCMODEL_OK = "portal.role.update.funcmodel.ok";
    public static final String  PORTAL_ROLE_UPDATE_FUNCMODEL_FAILURE = "portal.role.update.funcmodel.failure"; 
    
 
    public static final String  PORTAL_CUSTOMSCODE_SAVE_OK = "portal.customsCode.save.ok";
    public static final String  PORTAL_CUSTOMSCODE_SAVE_FAILURE = "portal.customsCode.save.failure";
    public static final String  PORTAL_CUSTOMSCODE_ADD_OK = "portal.customsCode.add.ok";
    public static final String  PORTAL_CUSTOMSCODE_ADD_FAILURE = "portal.customsCode.add.failure";
    public static final String  PORTAL_CUSTOMSCODE_ADD_IS_EXIST = "portal.customsCode.add.is.existed";   
    public static final String  PORTAL_CUSTOMSCODE_ADD_IS_ROLENAME_EXIST = "portal.customsCode.add.is.rolename.existed";     
    public static final String  PORTAL_CUSTOMSCODE_UPDATE_OK = "portal.customsCode.update.ok";
    public static final String  PORTAL_CUSTOMSCODE_UPDATE_FAILURE = "portal.customsCode.update.failure";       
    public static final String  PORTAL_CUSTOMSCODE_DEL_OK = "portal.customsCode.del.ok";
    public static final String  PORTAL_CUSTOMSCODE_DEL_FAILURE = "portal.customsCode.del.failure";
 
    
  
    //********************************************************************
    
    
    
    //***********************＝＝网证通＝�?********************************************
    public static final String  PORTAL_USERCERT_ADD_OK = "portal.userCert.add.ok";
    public static final String  PORTAL_USERCERT_ADD_FAILURE = "portal.userCert.add.failure";
    public static final String  PORTAL_USERCERT_ADD_IS_EXIST = "portal.userCert.add.is.existed";   
    public static final String  PORTAL_USERCERT_UPDATE_OK = "portal.userCert.update.ok";
    public static final String  PORTAL_USERCERT_UPDATE_FAILURE = "portal.userCert.update.failure";       
    public static final String  PORTAL_USERCERT_DEL_OK = "portal.userCert.del.ok";
    public static final String  PORTAL_USERCERT_DEL_FAILURE = "portal.userCert.del.failure";
    public static final String  PORTAL_USERCERT_INHERIT_OK = "portal.userCert.inherit.ok";
    //********************************************************************
    
    
    
    //***********************＝＝单位＝＝*********************************************
    public static final String PORTAL_COMPANY_ADD_IS_EXIST = "portal.company.add.is.exist";
    public static final String PORTAL_COMPANY_ADD_OK = "portal.company.add.ok";
    public static final String PORTAL_COMPANY_ADD_FAILURE = "portal.company.add.failure";
    public static final String PORTAL_COMPANY_DEL_OK = "portal.company.del.ok";
    public static final String PORTAL_COMPANY_DEL_FAILURE = "portal.company.del.failure";
    
    public static final String PORTAL_COMPANY_NOT_DEL_SELF_COMPANY_FAILURE = "portal.company.not.del.self.company.failure";
    
    public static final String PORTAL_COMPANY_UPDATE_OK = "portal.company.update.ok";
    public static final String PORTAL_COMPANY_UPDATE_FAILURE = "portal.company.update.failure";
    public static final String PORTAL_COMPANY_ADD_HAS_CLIENTS = "portal.company.add.has.clients";
    public static final String PORTAL_COMPANY_ADD_HAS_ROLES = "portal.company.add.has.roles";    
    public static final String PORTAL_COMPANY_ADD_HAS_USERS = "portal.company.add.has.users";
    
    public static final String  PORTAL_COMPANY_UPDATE_RIGHT_OK = "portal.company.update.right.ok";
    public static final String  PORTAL_COMPANY_UPDATE_RIGHT_FAILURE = "portal.company.update.right.failure";
    //********************************************************************    

    //***********************＝＝客户＝＝*********************************************
    public static final String PORTAL_CLIENT_ADD_IS_EXIST = "portal.client.add.is.exist";
    public static final String PORTAL_CLIENT_ADD_OK = "portal.client.add.ok";
    public static final String PORTAL_CLIENT_ADD_FAILURE = "portal.client.add.failure";
    public static final String PORTAL_CLIENT_DEL_OK = "portal.client.del.ok";
    public static final String PORTAL_CLIENT_DEL_FAILURE = "portal.client.del.failure";
    public static final String PORTAL_CLIENT_UPDATE_OK = "portal.client.update.ok";
    public static final String PORTAL_CLIENT_UPDATE_FAILURE = "portal.client.update.failure";    
    //********************************************************************    
    
    
    
    
    
    //***********************＝配置＝�?********************************************
    public static final String PORTAL_MANIFEST_CONFIG_ADD_IS_EXIST = "portal.config.add.is.exist";//
    public static final String PORTAL_MANIFEST_CONFIG_ADD_NO_EXIST = "portal.config.add.no.exist";
    public static final String PORTAL_MANIFEST_CONFIG_ADD_OK = "portal.config.add.ok";
    public static final String PORTAL_MANIFEST_CONFIG_ADD_FAILURE = "portal.config.add.failure";
    public static final String PORTAL_MANIFEST_CONFIG_DEL_OK = "portal.config.del.ok";
    public static final String PORTAL_MANIFEST_CONFIG_DEL_FAILURE = "portal.config.del.failure";
    public static final String PORTAL_MANIFEST_CONFIG_UPDATE_OK = "portal.config.update.ok";
    public static final String PORTAL_MANIFEST_CONFIG_UPDATE_FAILURE = "portal.config.update.failure"; 
    
    

    //***********************＝＝模块＝＝*********************************************
    public static final String PORTAL_FUNCMODEL_ADD_IS_EXIST = "portal.funcmodel.add.is.exist";
    public static final String PORTAL_FUNCMODEL_ADD_OK = "portal.funcmodel.add.ok";
    public static final String PORTAL_FUNCMODEL_ADD_FAILURE = "portal.funcmodel.add.failure";
    public static final String PORTAL_FUNCMODEL_ADD_SUPER_RIGHT_OK = "portal.funcmodel.add.super.right.ok";
    public static final String PORTAL_FUNCMODEL_ADD_SUPER_RIGHT_FAILURE = "portal.funcmodel.add.super.right.failure";    
    public static final String PORTAL_FUNCMODEL_DEL_OK = "portal.funcmodel.del.ok";
    public static final String PORTAL_FUNCMODEL_DEL_FAILURE = "portal.funcmodel.del.failure";
    public static final String PORTAL_FUNCMODEL_UPDATE_OK = "portal.funcmodel.update.ok";
    public static final String PORTAL_FUNCMODEL_UPDATE_FAILURE = "portal.funcmodel.update.failure";    
    //********************************************************************   
    
    //***********************＝＝查询＝＝*********************************************
	public static final String PORTAL_SEARCH_SAVE_SUCCESS="portal.search.save.success";
	public static final String PORTAL_SEARCH_SAVE_FAILURE="portal.search.save.failure";    
    public static final String PORTAL_SEARCH_SAVE_IS_EXIST = "portal.search.save.is.exist";
    public static final String PORTAL_SEARCH_DEL_OK = "portal.search.del.ok";
    public static final String PORTAL_SEARCH_DEL_FAILURE = "portal.search.del.failure";
    //********************************************************************   
    
    // edi 
	public static final String EDI_CLIENTTYPE_ADD_SUCCESS="edi.clientType.add.success";
	public static final String EDI_CLIENTTYPE_ADD_FAILURE="edi.clientType.add.failure";
	public static final String EDI_CLIENTTYPE_REMOVE_SUCCESS="edi.clientType.remove.success";
	public static final String EDI_CLIENTTYPE_REMOVE_FAILURE="edi.clientType.remove.failure";
	public static final String EDI_CLIENTTYPE_UPDATE_SUCCESS="edi.clientType.update.success";
	public static final String EDI_CLIENTTYPE_UPDATE_FAILURE="edi.clientType.update.failure";
	
	public static final String CONIFGINFO_COMPANY_PARAMETYPE="0";
	public static final String CONIFGINFO_USER_PARAMETYPE="1";
	
	public static List dmVarList() {
		List list = new ArrayList();
		list.add("rowId");
		list.add("action");
		list.add("img");
		list.add("key");
		return list;
	}
		public static String successMsg(String contextPath) {
    	return "<IMG align=absmiddle src=" + contextPath + "/images/portal/actionSucc.gif><IMG align=absmiddle src=" + contextPath + "/images/portal/space.gif><font color=blue>";
    }
    
    public static String failureMsg(String contextPath) {
    	return "<IMG align=absmiddle src=" + contextPath + "/images/portal/actionFail.gif><IMG align=absmiddle src=" + contextPath + "/images/portal/space.gif><font color=red>";
    }
    
    public static String searchMsg(String contextPath) {
    	return "<IMG align=absmiddle src=" + contextPath + "/images/portal/actionSeek.gif><IMG align=absmiddle src=" + contextPath + "/images/portal/space.gif>";
    }        

    public static String errorIco(String contextPath) {
    	return "<img src='" + contextPath + "/images/portal/error_icon.gif'>";
    }
    
    public static String successIco(String contextPath) {
    	return "<img src='" + contextPath + "/images/portal/tickico.gif'>";
    }    
    
    public static String myException(RuntimeException ex) {
		if (ex instanceof DataIntegrityViolationException) { 
            return "完整性约束异�? " + ex.getCause().getMessage();
		}  

		if (ex instanceof DataRetrievalFailureException) { 
            return "数据获取异常: " + ex.getCause().getMessage();
		} 
		
		if (ex instanceof IncorrectUpdateSemanticsDataAccessException) { 
            return "更新出错异常: " + ex.getCause().getMessage();
		}    		
		
		if (ex instanceof DeadlockLoserDataAccessException) { 
			return "死锁访问异常: " + ex.getCause().getMessage();
    	}
    
    	if (ex instanceof CleanupFailureDataAccessException) { 
    		return "清除失败异常: " + ex.getCause().getMessage();
    	}

    	if (ex instanceof DataAccessResourceFailureException) { 
    			return "资源访问异常: " + ex.getCause().getMessage();
    	}    			

    	if (ex instanceof InvalidDataAccessApiUsageException) { 
    			return "无效数据访问API使用异常: " + ex.getCause().getMessage();
    	}    			

    	if (ex instanceof InvalidDataAccessResourceUsageException) { 
    			return "无效数据访问资源使用异常: " + ex.getCause().getMessage();
    	}    			

    	if (ex instanceof OptimisticLockingFailureException) { 
    			return "乐观锁失败异�? " + ex.getCause().getMessage();
    	}    			

    	if (ex instanceof TypeMismatchDataAccessException) { 
    			return "类型匹配失败异常: " + ex.getCause().getMessage();
    	}    			

    	if (ex instanceof UncategorizedDataAccessException) { 
    			return "其他原因异常: " + ex.getCause().getMessage();
    	}
		return ex.getCause().getMessage();    			    	
    }
}
