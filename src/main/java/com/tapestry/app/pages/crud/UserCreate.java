package com.tapestry.app.pages.crud;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.tapestry.app.entities.User;
import com.tapestry.app.services.MisDAO;

public class UserCreate {
	Logger logger = Logger.getLogger(UserCreate.class);
	
	@Property
	private User user;
	
	//导入服务接口
	@Inject
	private MisDAO dao;
	
	//初始化user实体
	void onPrepare(){
		user = new User();
	}
	
	//提交表单的时候执行存错，返回当前页面
	Object onSuccess(){
		//如果时间为空值输入系统当前时间
		if(user.getTime() == null){
			user.setTime(new Date());
		}
		logger.debug("user name:" + user.getName());
		User temp = dao.create(user);
		return UserList.class;
	}
}
