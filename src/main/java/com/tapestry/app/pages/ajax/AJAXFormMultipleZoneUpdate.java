package com.tapestry.app.pages.ajax;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.DateField;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

public class AJAXFormMultipleZoneUpdate {

	@Property
	private String firstName;
	@Property
	private String lastName;
	@Property
	private Date birthday;
	@Inject
	private Request request;
	@InjectComponent
	private Zone formZone;
	@InjectComponent
	private Zone outZone;
	@Component(id = "firstName")
	private TextField firstNameField;
	@Component(id = "lastName")
	private TextField lastNameField;
	@Component(id = "birthday")
	private DateField birthdayField;
	@Component(id = "ajaxForm")
	private Form form;
	@Inject
	private AjaxResponseRenderer ajaxResponseRenderer;

	void setupRender() {
		if (firstName == null && lastName == null && birthday == null) {
			firstName = "飞";
			lastName = "风";
			birthday = new Date(0);
		}
	}

	void onValidateFromAjaxForm() {
		if (firstName == null || firstName.trim().equals("")) {
			form.recordError(firstNameField, "姓不能为空值！");
		}
		if (lastName == null || lastName.trim().equals("")) {
			form.recordError(lastNameField, "名不能为空值！");
		}
		if (birthday == null) {
			form.recordError(birthdayField, "生日不能为空值！");
			Date now = new Date();
			if (birthday.after(now)) {
				form.recordError(birthdayField, "生日必须是过去的时间！");
			}
		}
	}

	void onSuccess() {
		if (request.isXHR()) {
			ajaxResponseRenderer.addRender(formZone).addRender(outZone);
		}
	}

	void onFailue() {
		if (request.isXHR()) {
			ajaxResponseRenderer.addRender(formZone);
		}
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public DateFormat getBirthdayFormat() {
		return new SimpleDateFormat("yyyy-MM-dd");
	}
}
