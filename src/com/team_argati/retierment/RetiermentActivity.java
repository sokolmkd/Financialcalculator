package com.team_argati.retierment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.team_argati.R;

public class RetiermentActivity extends Activity {

	GridView gridView;
	String[] gridTextFields;
	float[] gridEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.retierment_main);
		populateItems();
		gridView = (GridView) findViewById(R.id.gridview_retierment);
		gridView.setAdapter(new GridAdapter(gridTextFields, gridEditText, getApplicationContext()));
	}

	public void populateItems() {
		gridTextFields = new String[] { "Contribution%", "Employer Match%",
				"Return Rate%", "Years Until Retire" };
		gridEditText = new float[] { 3, 3, 10, 20 };

	}

	class GridAdapter extends BaseAdapter {
		String[] gridTextFields;
		float[] gridEditText;
		Context c;

		public GridAdapter(String[] a, float[] b, Context c) {
			this.gridTextFields = a;
			this.gridEditText = b;
			this.c = c;
		}

		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public Object getItem(int arg0) {
			return arg0;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			View view = convertView;
			final ViewHolder holder;
			if (convertView == null) {
				LayoutInflater inflater = (LayoutInflater) c
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(R.layout.retierment_grid_item, parent,
						false);
				holder = new ViewHolder();
				holder.text = (TextView) view.findViewById(R.id.retierment_text_view);
				holder.editText = (EditText) view.findViewById(R.id.retierment_edit_text);
				holder.minus = (ImageButton) view.findViewById(R.id.minus);
				holder.plus = (ImageButton) view.findViewById(R.id.plus);
				view.setTag(holder);
			} else {
				holder = (ViewHolder) view.getTag();
			}

			holder.text.setText(gridTextFields[position]);
			holder.editText.setText(gridEditText[position]+"");
			return view;
		}

		class ViewHolder {
			public TextView text;
			public EditText editText;
			public ImageButton minus;
			public ImageButton plus;
		}
	}
}
