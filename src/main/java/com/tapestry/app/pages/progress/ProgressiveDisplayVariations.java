package com.tapestry.app.pages.progress;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class ProgressiveDisplayVariations {

	@Property
	private int sleepTimeMillis;
	@Inject
	private Block resultSixBlock;

	public void onProgressiveDisplayFromShowOne() {
		sleep(1000);
	}

	public void onProgressiveDisplayFromShowTwo() {
		sleep(2000);
	}

	public void onProgressiveDisplayFromShowThree(int sleepTimeMillis) {
		this.sleepTimeMillis = sleepTimeMillis;
		sleep(sleepTimeMillis);
	}

	public void onProgressiveDisplayFromShowFour() {
		sleep(4000);
	}

	public void onProgressiveDisplayFromShowFive() {
		sleep(5000);
	}

	public Block onProgressiveDisplayFromShowSix() {
		sleep(6000);
		return resultSixBlock;
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}
