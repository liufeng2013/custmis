package com.tapestry.app.pages.event;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;

public class MyEvent {

	@Property
	@PageActivationContext
	private int count;
	
	// 执行 eventlink 递增加 +1,newCount就是默认值1
	void onAdd(int newCount) {
		count += newCount;
	}
	
	// 执行 actionlink 递增加+2,meCount 就是默认值2
	void onActionFromAddTwo(int meCount) {
		count += meCount;
	}
	
	// 设置为0
	void onClear() {
		count = 0;
	}
}
