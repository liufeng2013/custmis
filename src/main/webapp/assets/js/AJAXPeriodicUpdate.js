PeriodicTimeZoneUpdater = Class.create({
			initialize : function() {
				var eventLink = $('refreshTimeZone');
				var updatesCount = 0;
				new PeriodicalExecuter(function(pe) {
							if (updatesCount++ < 4) {
								Tapestry.findZoneManager(eventLink)
										.updateFromURL(eventLink.href);
							} else {
								pe.stop();
							}
						}, 3);
			}
		});

Tapestry.Initializer.periodicTimeZoneUpdater = function(spec) {
	new PeriodicTimeZoneUpdater();
};