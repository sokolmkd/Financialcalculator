package com.team_argati.compound;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.team_argati.R;

public class CompoundActivity extends Activity {

	Spinner compoundingSpinner;
	String[] array;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.compound_interest_activity);
		compoundingSpinner = (Spinner) findViewById(R.id.compoundingSpinner);
		array = new String[] { "Daily", "Monthly", "Quarterly", "Semiannually",
				"Annually", "No Compound" };
		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, array);
		spinnerAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		compoundingSpinner.setAdapter(spinnerAdapter);
	}
}
