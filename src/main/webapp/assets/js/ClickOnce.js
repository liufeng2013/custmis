var alreadyClickedOnce = false;
ClickOnce = Class.create({
			initialize : function(elementId) {
				Event.observe($(elementId), 'click', this.doClickOnce
								.bindAsEventListener(this));
			},
			doClickOnce : function(e) {
				if (alreadyClickedOnce) {
					e.stop();
				}
				alreadyClickedOnce = true;
			}
		});

Tapestry.Initializer.clickOnce = function(spec) {
	new ClickOnce(spec.elementId);
};