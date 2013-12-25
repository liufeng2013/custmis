package com.tapestry.app.pages.ajax;

import java.util.Date;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = "context:assets/js/AJAXPeriodicUpdate.js")
public class AJAXPeriodicUpdate {

	@InjectComponent
	private Zone timeZone;
	@Inject
	private JavaScriptSupport javaScriptSupport;
	@Inject
	private Request request;

	public void setupRender() {
		javaScriptSupport.addInitializerCall("periodicTimeZoneUpdater",
				new JSONObject());
	}

	Object onRefreshTimeZone() {
		return request.isXHR() ? timeZone.getBody() : null;
	}

	public Date getServerTime() {
		return new Date();
	}
}
