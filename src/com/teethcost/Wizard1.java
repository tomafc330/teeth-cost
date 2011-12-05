package com.teethcost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Class that will initiate the wizard for selecting a tooth.
 * 
 * @author tchan
 * 
 */
public class Wizard1 extends Activity {

	private static final String TEETH_NUMBER = "TEETH_NUM";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.wizard1);
	}

	public void buttonClicked(View view) {
		int btnId = view.getId();
		continueWizard2(Integer.toString(btnId));
	}

	/**
	 * Continues to the step 2 of the wizard.
	 */
	protected void continueWizard2(String buttonNumber) {
		Intent i = new Intent(this, Wizard2.class);
		i.putExtra(TEETH_NUMBER, buttonNumber);
		startActivityForResult(i, 0);
	}
}
