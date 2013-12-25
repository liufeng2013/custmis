package com.tapestry.app.pages.ajax;

import java.util.Date;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

public class AJAXPeriodicUpdateMixin {

	@InjectComponent
	private Zone timeZone;
	@Inject
	private Request request;

	Object onRefreshTimeZone() {
		return request.isXHR() ? timeZone.getBody() : null;
	}

	public Date getServerTime() {
		return new Date();
	}
}
