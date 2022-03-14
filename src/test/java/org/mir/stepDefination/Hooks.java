package org.mir.stepDefination;

import java.util.Objects;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() {

		// write a code that will goive you place id
		// Execute this code only when placeId is null

		if (Objects.isNull(ReusuableStepDefination.placeId)) {
			ReusuableStepDefination std = new ReusuableStepDefination();
			std.addPayload();
			std.callResourceDynamically("ADDPLACEAPI", "POST");
			std.getPlaceId();
		}

	}

}
