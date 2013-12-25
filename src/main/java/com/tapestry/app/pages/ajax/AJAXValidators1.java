package com.tapestry.app.pages.ajax;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Request;

import com.tapestry.app.entities.Person;
import com.tapestry.app.services.MisDAO;

public class AJAXValidators1 {

	@Property
	private String firstName;
	@Property
	private String lastName;
	@Property
	private List<Person> persons;
	@InjectPage
	private AJAXValidators2 page2;
	@Inject
	private Request request;
	@Inject
	private MisDAO dao;

	void setupRender() {
		StringBuffer sql = new StringBuffer();
		sql.append("from Person");
		persons = dao.findWithQuery(sql.toString());
	}

	JSONObject onAjaxValidateFromFirstName() {
		String firstName = request.getParameter("param");
		try {
			validateFirstNameIsUnique(firstName);
		} catch (Exception e) {
			return new JSONObject().put("error", e.getMessage());
		}
		return new JSONObject();
	}

	Object onSuccess() {
		page2.set(firstName, lastName);
		return page2;
	}

	void validateFirstNameIsUnique(String firstName) throws Exception {
		if (firstName != null) {
			List<Person> persons = dao.findWithQuery(firstName);
			if (persons.size() > 0) {
				throw new Exception("姓已经存在.");
			}
		}
	}
}
