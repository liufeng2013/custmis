package com.tapestry.app.pages;

import org.apache.tapestry5.ioc.annotations.Inject;

import com.tapestry.app.services.PersonService;

public class Test {

	@Inject
	private PersonService personService;

	void setupRender() {
		personService.save();
		for (String str : personService.getSets()) {
			System.out.println(str);
		}
		System.out.println("========list===========");
		for (String value : personService.getLists()) {
			System.out.println(value);
		}
		System.out.println("========properties===========");
		for (Object key : personService.getProperties().keySet()) {
			System.out.println(key + "="
					+ personService.getProperties().getProperty((String) key));
		}
		System.out.println("========map===========");
		for (String key : personService.getMaps().keySet()) {
			System.out.println(key + "=" + personService.getMaps().get(key));
		}
	}
}
