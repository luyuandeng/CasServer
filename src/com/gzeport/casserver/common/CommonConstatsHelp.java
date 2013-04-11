
 package com.gzeport.casserver.common;
 
public class  CommonConstatsHelp {
	
   public static final String GZEPORT_COMPANY_CODE="GZEPORT";//电子口岸公司代码
   public static final String COMMON_COMPANY_CODE="***";//默认公司代码
   public static final String COMMON_COMPANY_NAME="默认公司(权限有限)";//默认公司代码
   public static final String MAIN_COMPANY_CODE="GZEPORT";//GZEPORT(电子口岸公司)--;5100(广州海关�?
   
   public static final String ROLE_LEVEL_MAIN_ADMIN="0";//电子口岸总管理员权限,�?��系统只有�?��这样的角�?
   public static final String ROLE_LEVEL_MAIN_NORMAL="1";//可被2级继�?
   public static final String ROLE_LEVEL_COMPANY_ADMIN="2";//下属单位管理员权�?�?��单位只有�?��这样的角�?
   public static final String ROLE_LEVEL_COMPANY_ENABLE_INHERIT="3";//可被4级继�?
   public static final String ROLE_LEVEL_COMPANY_NOENABLE_INHERIT="4";//不能被继承，可继�?�?
//	public static final String GZEPORT_COMPANY_ID="GZEPORT";
   
	public static final String SYSTEM_MANAGER_COMPANY_TYPE="999";
	public static final String SYSTEM_OTHER_COMPANY_TYPE="11";
   
   
   public static final String USER_LOGIN_TYPE_MAIN_ADMIN="0"; //核心管理单位的用户级别分 管理员和普�?用户
   public static final String USER_LOGIN_TYPE_MAIN_NORMAL="1";
   public static final String USER_LOGIN_TYPE_COMPANY_ADMIN="2";//�?��单位�?��情况下只有一�?
   public static final String USER_LOGIN_TYPE_COMPANY_NORMAL="3";
   
   public static final String ROLE_AUTHORAZTION_OPERATOR_TYPE_VIEW="1";
   public static final String ROLE_AUTHORAZTION_OPERATOR_TYPE_AUTHORAZ="0";
   
   
   public static final String SYSTEM_TYPE_CODE_USERMANAGER="0";//用户管理系统
   public static final String SYSTEM_TYPE_CODE_EDI="1"; //edi 系统
   public static final String SYSTEM_TYPE_CODE_BARGE="2";//驳船快线
   
   public  static final String ROLE_USE_ENABLE="1";
   public  static final String ROLE_USE_UNENABLE="0";//不可�?
   
   public static final String SYSTEM_USER_SEX_MAN="1";//�?
   public static final String SYSTEM_USER_SEX_WENMAN="0";//�?
   public static final String  COMPANY_STATE_NO_USE="0";//禁用
   public static final String  COMPANY_STATE_BEFORE="1";//登记�?���?
   public static final String  COMPANY_STATE_TRY_USE="2";//试用
   public static final String  COMPANY_STATE_AFTER="3";//正式使用
   
   public static final String  COMPANY_STATE_STOP="4";//停用
   
   public static final String  COMPANY_STATE_NO_SIGN="9";//未签约状�?
   
   public static final String SYSTEM_ROLE_COMMMON_USER="430";//为用户管理公共角色id,如有变动请改
   public static final int SYSTEM_COMMON_RECORDS_PAGE=10;//每页记录�?
   
   public static final String SYSTEM_DIR_NAME="SYSTEM_DIR_NAME";//系统目录名称
   public static final String FILE_CONFG_BEAN_NAME="FILE_CONFG_BEAN_NAME";//文件配置Bean
   
   public static final String FILE_REAL_PATH="FILE_REAL_PATH";//文件绝对路径
   
   
   public static final String  USER_NO_NULL="0";//数据为空
   public static final String  USER_OR_PWD_ERROR="1";//用户不存在或密码错误
   public static final String  USER_NO_USE="2";                                              //用户没启�?
   
   public static final String  USER_NO_CONTA_COMPANY="3";
   public static final String  USER_NO_RIGHT="6";//用户没权�?
}


 