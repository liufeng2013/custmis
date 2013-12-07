package com.tapestry.app.pages.context;

import org.apache.log4j.Logger;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;

public class ActivationContext {
	Logger logger = Logger.getLogger(ActivationContext.class);

	@Property
	private String strOne;
	
	//传递strOne到浏览器地址栏
	String onPassivate(){
		return strOne;
	}
	
	/**
	 * 从地址栏中获得strOne值
	 * 注意：当传递的值是中文是会被转码,所以看不到中文。
	 * 当做检索的时候想通过地址栏传递查询变量时,可使用ajax不刷新查看中文
	 */
	void onActivate(String strOne){
		logger.debug("strOne:" + strOne);
		this.strOne = strOne;
	}
	
	/**
	 * @PageActivationContext是onPassivate()与onActivate()2个函数的封装。
	 * 使用@PageActivationContext就不用再写onPassivate()与onActivate()了,
	 * 跟@Property类似
	 */
	@Property
	@PageActivationContext
	private String strTwo;
}
