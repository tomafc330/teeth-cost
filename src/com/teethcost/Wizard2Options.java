package com.teethcost;

import com.teethcost.domain.FillingType;
import com.teethcost.domain.WizardFields;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Activity that provides the screen for selecting options after the user has selected a tooth.
 * @author tchan
 *
 */
public class Wizard2Options extends Activity {

	private boolean surfaceM = false;
	private boolean surfaceO = false;
	private boolean surfaceD = false;
	private FillingType fillingType;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wizard2);

		// TODO get the view based on the tooth number
	}

	private void retrieveUIInput() {
		retrieveSurface();
		retrieveFillingType();
	}

	private void retrieveSurface() {
		if (((CheckBox) findViewById(R.id.checkBoxM)).isChecked()) {
			surfaceM = true;
		}
		if (((CheckBox) findViewById(R.id.checkBoxO)).isChecked()) {
			surfaceO = true;
		}
		if (((CheckBox) findViewById(R.id.checkBoxD)).isChecked()) {
			surfaceD = true;
		}
	}

	private void retrieveFillingType() {
		CharSequence fillingTypeText = ((RadioButton) findViewById(R.id.surface)).getText();
		
		if (fillingTypeText != null) {
			fillingType = FillingType.valueOf(fillingTypeText.toString());
		}
	}

	/**
	 * Happens when user clicks finished.
	 */
	public void finishClicked(View view) {
		retrieveUIInput();
		if (validateInput()) {

			// add info into the bundle
				
			// calculate the cost based on the inputs

			// return
			setResult(RESULT_OK, getIntent());
			finish();

		} else {
			Toast.makeText(getApplicationContext(), "Notnull", Toast.LENGTH_SHORT)
			.show();
		}
	}

	private boolean validateInput() {
		if (surfaceD || surfaceM || surfaceO) {
			return true;
		}
		return false;

	}

}
