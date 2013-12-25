package com.tapestry.app.pages.kissyeditor;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = { "context:assets/kissyeditor/kissy-min.js",
		"context:assets/kissyeditor/uibase/uibase-pkg-min.js",
		"context:assets/kissyeditor/dd/dd-pkg-min.js",
		"context:assets/kissyeditor/overlay/overlay-pkg-min.js",
		"context:assets/kissyeditor/editor-all-pkg-min.js",
		"context:assets/kissyeditor/biz/ext/editor-plugin-pkg-min.js",
		"context:assets/kissyeditor/TEstart.js" })
public class KissyEditor {
	@Inject
	private JavaScriptSupport javaScriptSupport;
	@Property
	@Persist
	private String content;
	/*
	 * 这个 eid 是传给上传请求页面的，当多个文本编辑器同是使用一个上传请求时通过这个值的设置可以区别他们是那个文本编辑器的请求这里让它上传图片到
	 * work 目录下
	 */
	@PageActivationContext
	private static String eid = "work";

	void afterRender() {
		javaScriptSupport.addScript("start('" + eid + "');");
	}

	void onSuccess() {
	}
}
