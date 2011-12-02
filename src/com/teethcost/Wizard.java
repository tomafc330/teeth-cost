package com.teethcost;

import android.app.Activity;
import android.os.Bundle;

/**
 * Class that will initiate the wizard for selecting a tooth.
 * @author tchan
 *
 */
public class Wizard extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.wizard1);
	}
}
