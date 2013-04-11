package com.gzeport.casserver.bo;

import java.util.List;

import com.gzeport.casserver.pojo.TBaseUser;

public interface IUserBo {
	public List<TBaseUser> userList(String  username);
}
