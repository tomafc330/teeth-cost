package com.teethcost;

import java.io.Serializable;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.teethcost.domain.Plans;
import com.teethcost.domain.WizardFields;

public class ListPlans extends ListActivity {

	private Plans plans = new Plans();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_plans);

		setUpButtonListener(savedInstanceState);
		fillData();
	}

	private void fillData() {
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, plans.getPlansForDisplay()));
	}
	
	private void fillData(Serializable displayAsListItem) {
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, plans.add(displayAsListItem)));
	}

	protected void setUpButtonListener(Bundle savedValues) {
		// Capture our button from layout
		Button button = (Button) findViewById(R.id.confirm);
		// Register the onClick listener with the implementation above
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				startWizard();
			}
		});
	}

	protected void startWizard() {
		Intent i = new Intent(this, Wizard1Teeth.class);
		startActivityForResult(i, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		Serializable displayAsListItem = displayAsListItem(intent);
		fillData(displayAsListItem);
	}

	private Serializable displayAsListItem(Intent intent) {
		return intent.getSerializableExtra(Wizard1Teeth.WIZARD_FIELDS);
	}
}