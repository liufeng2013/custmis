package com.tapestry.app.pages.crud;

import java.util.List;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.tapestry.app.components.pagedloop.PagedLoop;
import com.tapestry.app.entities.Person;
import com.tapestry.app.services.MisDAO;

public class PersonList2 {

	// 打开 user 读写
	@Property
	private Person person;
	// 打开 user 阵列的读写
	@Property
	private List<Person> persons;
	// 导入操作数据库的服务
	@Inject
	private MisDAO dao;
	// 当前页面接收 user 的 id 值
	@PageActivationContext
	private Long id;
	// 开启 PagedLoop
	@Component(parameters = { "source=persons", "value=person", "rowsPerPage=1", "pagerPosition=bottom" })
	private PagedLoop personLoop;

	// 页面加载时设置渲染
	void setupRender() {
		// 查询 User 数据表
		StringBuffer sql = new StringBuffer();
		sql.append("from Person");
		persons = dao.findWithQuery(sql.toString());
	}

	// 单击 eventlink 执行删除操作
	Object onDelete(Long id) {
		dao.deleteByID(Person.class, id);
		return this;
	}
}
