package com.tapestry.app.pages.ajax;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

import com.tapestry.app.pages.Index;

public class AJAXSelect1 {

	static final private String[] ALL_MAKES = new String[] { "梅州市", "河源市" };
	static final private String[] NO_MODELS = new String[] {};
	static final private String[] MEIZHOU_MODELS = new String[] { " 五华县", "兴宁县" };
	static final private String[] HEYUAN_MODELS = new String[] { "紫金县", "龙川县" };
	
	@Property
	private String areaMake;
	@Property
	private String cithModel;
	@Property
	private String keywords;
	@Property
	private String[] areaMakes;
	@Property
	@SuppressWarnings("unused")
	private String[] cithModels;
	@InjectPage
	private AJAXSelect2 page2;
	@InjectComponent
	private Zone cithModelZone;
	@Inject
	private ComponentResources componentResources;
	@Inject
	private Request request;

	void setupRender() {
		if (areaMakes == null) {
			areaMakes = ALL_MAKES;
			cithModels = NO_MODELS;
		}
	}

	Object onValueChangedFromAreaMake(String areaMake) {
		this.areaMake = areaMake;
		areaMakes = ALL_MAKES;
		if (areaMake == null) {
			cithModels = NO_MODELS;
		} else if (areaMake.equals(areaMakes[0])) {
			cithModels = MEIZHOU_MODELS;
		} else if (areaMake.equals(areaMakes[1])) {
			cithModels = HEYUAN_MODELS;
		} else {
			cithModels = NO_MODELS;
		}
		cithModel = null;
		return request.isXHR() ? cithModelZone.getBody() : null;
	}

	Object onSuccess() {
		page2.set(areaMake, cithModel, keywords);
		componentResources.discardPersistentFieldChanges();
		return page2;
	}

	Object onGoHome() {
		componentResources.discardPersistentFieldChanges();
		return Index.class;
	}
}
