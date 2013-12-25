package com.tapestry.app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.tapestry.app.dao.PersonDao;

public class PersonServiceBean implements PersonService {

	// 注入 bean
	private PersonDao personDao;
	// 注入 set 集合类
	private Set<String> sets = new HashSet<String>();
	private List<String> lists = new ArrayList<String>();
	private Properties properties = new Properties();
	private Map<String, String> maps = new HashMap<String, String>();

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}

	// 注入对象
	private String hello;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void save() {
		System.out.println(hello);
		personDao.add();
	}

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

	public Set<String> getSets() {
		return sets;
	}

	public void setSets(Set<String> sets) {
		this.sets = sets;
	}
}
