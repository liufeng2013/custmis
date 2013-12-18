Tapestry.FieldEventManager.addMethods({

	initialize : function(field) {
		this.field = $(field);

		var id = this.field.id;
		this.fieldContainer = this.field.parentNode;
		Element.extend(this.fieldContainer);

		var labelSelector = "label[for='" + id + "']";
		this.label = this.field.up("form").down(labelSelector);

		if (this.label) {
			this.labelContainer = this.label.parentNode;
			Element.extend(this.labelContainer);
		}

		var msgId = id + '-msg';
		this.msg = $(msgId);

		if (!this.msg) {
			this.msg = new Element('strong', {
				'id' : msgId,
				'class' : 'msg'
			});
			this.fieldContainer.insert({
				bottom : this.msg
			});
		}

		this.msgContainer = this.msg.parentNode;
		Element.extend(this.msgContainer);

		this.translator = Prototype.K;

		var fem = $(this.field.form).getFormEventManager();

		if (fem.validateOnBlur) {

			document.observe(Tapestry.FOCUS_CHANGE_EVENT, function(event) {
				/*
				 * If changing focus *within the same form* then perform
				 * validation. Note that Tapestry.currentFocusField does not
				 * change until after the FOCUS_CHANGE_EVENT notification.
				 */
				if (Tapestry.currentFocusField == this.field
						&& this.field.form == event.memo.form)
					this.validateInput();

			}.bindAsEventListener(this));
		}

		if (fem.validateOnSubmit) {
			$(this.field.form).observe(Tapestry.FORM_VALIDATE_FIELDS_EVENT,
					this.validateInput.bindAsEventListener(this));
		}
	},

	showValidationMessage : function(message) {
		$(this.field).getStorage().validationError = true;
		$(this.field.form).getStorage().validationError = true;

		this.msg.update(message);

		if (this.label) {
			this.label.addClassName("error-label");
			this.labelContainer.addClassName("error-label-c");
		}
		this.field.addClassName("error-field");
		this.fieldContainer.addClassName("error-field-c");
		this.msg.addClassName("error-msg");
		this.msgContainer.addClassName("error-msg-c");
	},

	removeDecorations : function() {

		this.msg.update(null);

		if (this.label) {
			this.label.removeClassName("error-label");
			this.labelContainer.removeClassName("error-label-c");
		}
		this.field.removeClassName("error-field");
		this.fieldContainer.removeClassName("error-field-c");
		this.msg.removeClassName("error-msg");
		this.msgContainer.removeClassName("error-msg-c");
	}
});