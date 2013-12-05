package com.tapestry.app.pages.crud;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.tapestry.app.entities.User;
import com.tapestry.app.services.MisDAO;


public class UserUpdate {

	//接收页面传来的id值
	@PageActivationContext
	private Long id;
	
	//设置user可读写
	@Property
	private User user;
	
	//导入服务
	@Inject
	private MisDAO dao;
	
	//页面加载时运行
	void onPrepare(){
		//user为空数据时根据页面传递过来的id查询数据
		if(user == null){
			user = dao.findByID(User.class, id);
		}
	}
	
	//提交表单保存user数据
	Object onSuccess(){
		dao.update(user);
		return UserList.class;
	}
}