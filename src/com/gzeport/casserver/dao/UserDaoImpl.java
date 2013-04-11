package com.gzeport.casserver.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.gzeport.casserver.pojo.TBaseFuncmodel;
import com.gzeport.casserver.pojo.TBaseUser;


public class UserDaoImpl extends BaseDao implements IUserDao ,Serializable{

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(UserDaoImpl.class);
	private static final long serialVersionUID = 4032800539733619930L;
 
	public List<TBaseUser> userList(String username) {
		log.debug("finding Account instance by example");
		try {
			//String sql ="SELECT * FROM portal.T_BASE_USER  WHERE USER_CODE = ?" ;
			//List results = this.getJdbcTemplate().queryForList(sql, username);
			//Iterator it =results.iterator();
			//it.
			/*String 	loginsyssql  ="SELECT D.* FROM PORTAL.T_BASE_USER A "
					+""INNER JOIN PORTAL.T_USER_ROLE B ON A.USER_ID=B.USER_ID
					+""INNER JOIN PORTAL.T_ROLE_FUNCMODEL C ON B.ROLE_ID=C.ROLE_ID
					+""INNER JOIN PORTAL.T_BASE_FUNCMODEL D ON C.FUNC_ID=D.FUNC_ID
					+"INNER JOIN PORTAL.T_BASE_ROLE E ON B.ROLE_ID=E.ROLE_ID"
					+"WHERE A.USER_CODE=<USER_CODE> AND UP_FUNC_ID IS NULL
					";
			log.debug("find by sql successful, result size: "
					+ results.size());
			return results;*/
			return null;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
		
		 
	}
	 
	public List<TBaseFuncmodel> userModelList(String username) {
		return null;
	}
 
	public List<TBaseFuncmodel> userSysList(String username) {
		return null;
	}

	

}
