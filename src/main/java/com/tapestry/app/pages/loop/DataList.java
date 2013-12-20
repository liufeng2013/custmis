package com.tapestry.app.pages.loop;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Property;

public class DataList {

	@Property
	private String nameOne;
	@Property
	private String nameTwo;
	
	@Property
	private String[] nameOnes;
	@Property
	private String[] nameTwos;
	
	@Property
	private List<String> oneLists;
	@Property
	private List<String> twoLists;
	
	void setupRender() {
		String oneString = "张三/李四/王五/";
		nameOnes = oneString.split("/");
		oneLists = new ArrayList<String>();
		
		for(String str:nameOnes) {
			oneLists.add(str);
		}
		
		String twoString = "刘备/关羽/张飞/";
		nameTwos = twoString.split("/");
		twoLists = new ArrayList<String>();
		
		for(String str2:nameTwos) {
			twoLists.add(str2);
		}
	}
}
