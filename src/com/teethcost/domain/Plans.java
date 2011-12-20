package com.teethcost.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Plans {

	private List<String> plans = new ArrayList<String>();

	/**
	 * Checks to see if plans are null/empty, if it is then adds empty message.
	 */
	public List<String> getPlansForDisplay() {
		if (plans.isEmpty()) {
			plans.add("No Plans yet. Please add a plan.");
		}

		return plans;
	}

	public List<String> add(Serializable displayAsListItem) {
		if (displayAsListItem instanceof WizardFields) {
			plans.add(Integer.toString(((WizardFields) displayAsListItem)
					.getTeethNumber()));
		}

		return plans;
	}
}
