package com.teethcost;

import com.teethcost.domain.WizardFields;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Class that will initiate the wizard for selecting a tooth.
 * 
 * @author tchan
 * 
 */
public class Wizard1Teeth extends Activity {

	public static final String WIZARD_FIELDS = "domain";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.wizard1);
	}

	public void toothClicked(View view) {
		String str = ((Button)view).getText().toString();
		continueWizard2(str);
	}

	/**
	 * Continues to the step 2 of the wizard.
	 */
	protected void continueWizard2(String buttonNumber) {
		Intent i = new Intent(this, Wizard2Options.class);
		WizardFields wizardFields = new WizardFields();
		wizardFields.setTeethNumber(Integer.parseInt(buttonNumber));
		i.putExtra(WIZARD_FIELDS, wizardFields);
		startActivityForResult(i, 0);
		
	}
	
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	if (intent == null) { // ie. someone pressed back
    		return;
    	}
        setResult(RESULT_OK, intent);
        getIntent().putExtra(WIZARD_FIELDS, intent.getSerializableExtra(WIZARD_FIELDS));
        finish();
    }
}
