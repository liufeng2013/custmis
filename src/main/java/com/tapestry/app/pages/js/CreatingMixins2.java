package com.tapestry.app.pages.js;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import com.tapestry.app.entities.MyOrder;

public class CreatingMixins2 {

	@SessionState
	@Property
	@SuppressWarnings("unused")
	private MyOrder myOrder;
}
