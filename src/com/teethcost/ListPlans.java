package com.teethcost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.teethcost.domain.Plans;

public class ListPlans extends Activity {

	private Plans plans = new Plans();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_plans);

		setUpButtonListener(savedInstanceState);
		ListView list = (ListView) findViewById(R.id.list_plans);
		list.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, plans.getPlansForDisplay()));
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
		Intent i = new Intent(this, Wizard.class);
		startActivityForResult(i, 0);
	}
}