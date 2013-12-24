package com.tapestry.app.pages.crud;

import java.util.Date;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.tapestry.app.entities.Person;
import com.tapestry.app.services.MisDAO;

public class PersonCreate {

	@Property
	private Person person;
	// 导入服务接口
	@Inject
	private MisDAO dao;

	// 初始化 user 实体
	void onPrepare() {
		person = new Person();
	}

	// 提交表单的时候执行存储,返回当前页面
	Object onSuccess() {
		// 如果时间为空值输入系统当前时间
		if (person.getStartDate() == null) {
			person.setStartDate(new Date());
		}
		dao.create(person);
		return PersonList.class;
	}
}
