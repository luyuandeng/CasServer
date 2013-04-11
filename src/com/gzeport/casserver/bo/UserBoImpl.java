package com.gzeport.casserver.bo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gzeport.casserver.dao.IUserDao;
import com.gzeport.casserver.pojo.TBaseUser;

public class UserBoImpl  implements IUserBo{
    private IUserDao userDao;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    private  com.gzeport.portal.user.service.UserManager  userManager;
    
	public IUserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	 
	/**
	 * ��ȡ�û��� ����Ϣ
	 */
	public List<TBaseUser> userList(String userCode ) {
//		return this.userDao.userList(userName);
		logger.info("userCode="+userCode);
		List list=new ArrayList();
		list.add(this.userManager.findUserByUserCode(userCode));
		return list ;
	}
	
	public com.gzeport.portal.user.service.UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(
			com.gzeport.portal.user.service.UserManager userManager) {
		this.userManager = userManager;
	}

}
