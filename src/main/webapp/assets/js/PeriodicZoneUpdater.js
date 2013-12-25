PeriodicZoneUpdater = Class.create({
			initialize : function(spec) {
				this.zoneElement = $(spec.zoneElementId).getStorage();
				this.eventURL = spec.eventURL;
				this.frequencySecs = spec.frequencySecs;
				this.maxUpdates = spec.maxUpdates;
				// Use Prototype's PeriodicalExecuter to run updateZone() every
				// 3 seconds, this.maxUpdates times.
				var updatesCount = 0;
				new PeriodicalExecuter(function(pe) {
							if (updatesCount++ < this.maxUpdates) {
								this.updateZone();
							} else {
								pe.stop();
							}
						}.bind(this), this.frequencySecs);
			},
			updateZone : function() {
				var zoneManager = this.zoneElement.zoneManager;
				if (!zoneManager) {
					return;
				}
				zoneManager.updateFromURL(this.eventURL);
			}
		});

// Extend the Tapestry.Initializer with a static method that instantiates a
// PeriodicZoneUpdater.
Tapestry.Initializer.periodicZoneUpdater = function(spec) {
	new PeriodicZoneUpdater(spec);
};