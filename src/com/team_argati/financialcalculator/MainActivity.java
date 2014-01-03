package com.team_argati.financialcalculator;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.team_argati.R;
import com.team_argati.compound.CompoundActivity;
import com.team_argati.loan.LoanActivity;

public class MainActivity extends Activity implements OnItemClickListener{

	private static ArrayList<SingleRow>  adapter ;
	String names [];
	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		adapter = new ArrayList<SingleRow>();
		Resources res = getResources();
		names = res.getStringArray(R.array.calculator_names);
		adapter.add(new SingleRow(getApplicationContext(),names[3],R.drawable.compound_interest_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[0],R.drawable.tvm_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[4],R.drawable.credit_card_payoff));
		adapter.add(new SingleRow(getApplicationContext(),names[5],R.drawable.retierment_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[7],R.drawable.calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[2],R.drawable.loan_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[9],R.drawable.roi_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[1],R.drawable.currency_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[8],R.drawable.apr_calculator));
		
		adapter.add(new SingleRow(getApplicationContext(),names[17],R.drawable.miscelanous_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[15],R.drawable.bond_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[14],R.drawable.percent_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[12],R.drawable.discount_tax_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[11],R.drawable.credit_card_min_payment));
		adapter.add(new SingleRow(getApplicationContext(),names[13],R.drawable.irr_npv_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[16],R.drawable.stock_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[10],R.drawable.auto_loan_calculator));
		adapter.add(new SingleRow(getApplicationContext(),names[6],R.drawable.tips_calculator));
		
		listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(new CustomView(getApplicationContext(), adapter));
		listView.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent i = new Intent(this, CompoundActivity.class);
		startActivity(i);
		
	}
	
	
	
}

class CustomView extends BaseAdapter{

	ArrayList<SingleRow> lista;
	Context context;
	
	public CustomView(Context c , ArrayList<SingleRow> lista){
		this.lista = lista;
		this.context = c;
	}
	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		return lista.get(position);
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
        		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.single_list_item, parent, false);
                holder = new ViewHolder();
                holder.text = (TextView) view.findViewById(R.id.text);
                holder.image = (ImageView) view.findViewById(R.id.image);
                view.setTag(holder);
        } else {
                holder = (ViewHolder) view.getTag();
        }

        holder.text.setText(lista.get(position).desc);
        holder.image.setImageBitmap(lista.get(position).pic);
        return view;
}
	  class ViewHolder {
           public TextView text;
           public ImageView image;
   }
}

