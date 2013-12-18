package com.tapestry.app.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.services.Heartbeat;

@Import(library="context:assets/js/CustomError.js")
public class CustomError {

	@Parameter(name="for",required=true,allowNull=false,defaultPrefix=BindingConstants.COMPONENT)
	private Field field;
	
	@Environmental
	private Heartbeat heartbeat;
	
	private Element labelElement;
	
	boolean beginRender(MarkupWriter writer) {
		final Field field = this.field;
		labelElement = writer.element("span", "class", "msg");
		
		Runnable command = new Runnable() {
			public void run() {
				String fieldId = field.getClientId();
				labelElement.forceAttributes("id", fieldId + "-msg");
			}
		};
		
		heartbeat.defer(command);
		return false;
	}
	
	void afterRender(MarkupWriter writer) {
		writer.end();
	}
}
