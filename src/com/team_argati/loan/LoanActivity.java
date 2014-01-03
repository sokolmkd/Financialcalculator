package com.team_argati.loan;

import android.app.TabActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.team_argati.R;

public class LoanActivity extends TabActivity {
	
	TabHost mTabHost;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.loan_activity);

		mTabHost = (TabHost) findViewById(android.R.id.tabhost);

		setupTab(new TextView(this), "Tab 1");

		setupTab(new TextView(this), "Tab 2");
		setupTab(new TextView(this), "Tab 3");
	}

	private void setupTab(final View view, final String tag) {

		View tabview = createTabView(mTabHost.getContext(), tag);

		TabSpec setContent = mTabHost.newTabSpec(tag).setIndicator(tabview)
				.setContent(new TabContentFactory() {

					public View createTabContent(String tag) {
						return view;
					}

				});

		mTabHost.addTab(setContent);

	}

	private static View createTabView(final Context context, final String text) {

		View view = LayoutInflater.from(context)
				.inflate(R.layout.tabs_bg, null);

		TextView tv = (TextView) view.findViewById(R.id.tabsText);

		tv.setText(text);

		return view;

	}

}
