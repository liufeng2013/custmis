package com.tapestry.app.pages.crud;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.tapestry.app.entities.Person;
import com.tapestry.app.services.MisDAO;

public class PersonUpdate {

	// 接收页面传来的 id 值
	@PageActivationContext
	private Long id;
	// 设置 user 可读写
	@Property
	private Person person;
	// 导入服务
	@Inject
	private MisDAO dao;

	// 页面加载时运行
	void onPrepare() {
		// user 为空数据时根据页面传递过来的 id 查询数据
		if (person == null) {
			person = dao.findByID(Person.class, id);
		}
	}

	// 提交表单保存 user 数据
	Object onSuccess() {
		dao.update(person);
		return PersonList.class;
	}
}
