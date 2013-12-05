package com.tapestry.app.pages.crud;

import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.tapestry.app.entities.User;
import com.tapestry.app.services.MisDAO;

public class UserList {

	//打开user读写
	@Property
	private User user;
	
	//代开user阵列的读写
	@Property
	private List<User> users;
	
	//导入操作数据库的服务
	@Inject
	private MisDAO dao;
	
	//页面加载时设置渲染
	void setupRender(){
		//查询User数据表
		StringBuffer sql = new StringBuffer();
		sql.append("from User");
		users = dao.findWithQuery(sql.toString());
	}
	
	//单击eventlink执行删除操作
	Object onDelete(Long id){
		dao.deleteByID(User.class, id);
		return this;
	}
}
