package com.gzeport.casserver.dao;

import java.util.List;

import com.gzeport.casserver.pojo.TBaseFuncmodel;
import com.gzeport.casserver.pojo.TBaseUser;


public interface IUserDao {

	public List<TBaseUser> userList(String username );
	public List<TBaseFuncmodel> userSysList(String username );
	public List<TBaseFuncmodel> userModelList(String username );
	
}
