package com.tapestry.app.pages.component;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.corelib.components.PageLink;



public class AtComponent {

	@Component(id="myPage", parameters={"page=index"})
	private PageLink index;
}