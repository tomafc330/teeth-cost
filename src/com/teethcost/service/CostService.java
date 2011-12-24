package com.teethcost.service;

import android.content.Context;

import com.teethcost.domain.PlanCodeCost;
import com.teethcost.domain.WizardFields;

/**
 * Determines the teeth cost given the inputs.
 */
public class CostService {

	
	private PlanCodeDatasource planCodeDBAdapter;

	public CostService(Context context) {
		planCodeDBAdapter = new PlanCodeDatasource(context);
		planCodeDBAdapter.addBaseData();
		
	}
	
	public int getCost(WizardFields domain) {
		PlanCodeCost retreievePlanCodeCost = planCodeDBAdapter.retreievePlanCodeCost(domain);
		retreievePlanCodeCost.getPlanCode();
		retreievePlanCodeCost.getCost();
		return 0;
	}
}
