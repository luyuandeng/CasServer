package com.gzeport.casserver.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.gzeport.casserver.bo.IUserBo;
import com.gzeport.casserver.pojo.TBaseUser;

public class UserController {
	
	private String jsp;
	private IUserBo userBo;
	
	public IUserBo getUserBo() {
		return userBo;
	}

	public void setUserBo(IUserBo userBo) {
		this.userBo = userBo;
	}


	
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse rsp) throws Exception {
		String uname=req.getParameter("uname");
		String upass=req.getParameter("upass");
		TBaseUser baseUser=new TBaseUser();
		baseUser.setUserName(uname);
		List<TBaseUser> accountList=userBo.userList(uname);
		if(accountList.size()>0){
			TBaseUser acccountEntity=accountList.get(0);
			return new ModelAndView(jsp,"account" , acccountEntity);
			//return new ModelAndView(jsp,"result","index");
		}
		return new ModelAndView(jsp,"account" ,null);
		//return new ModelAndView(jsp,"result","error");
	}

}
