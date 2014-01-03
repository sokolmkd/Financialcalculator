package com.team_argati.financialcalculator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SingleRow {

	String desc;
	Bitmap pic;
	public SingleRow(Context c , String desc , int pic){
		this.desc = desc;
		this.pic = BitmapFactory.decodeResource(c.getResources(), pic);
		
	}
}
