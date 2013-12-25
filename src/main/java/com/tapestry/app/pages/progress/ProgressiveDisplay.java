package com.tapestry.app.pages.progress;

import org.apache.tapestry5.annotations.Property;

public class ProgressiveDisplay {

	static final private String[] ALL_THINGS = { "吃饭", "睡觉", "绘画" };
	@Property
	private String[] things;
	@Property
	private String thing;

	public void onProgressiveDisplayFromShowThings() {
		things = ALL_THINGS;
		sleep(5000);
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}
