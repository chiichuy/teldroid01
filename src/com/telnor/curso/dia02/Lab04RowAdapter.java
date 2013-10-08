package com.telnor.curso.dia02;

import com.telnor.curso.dia01.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Lab04RowAdapter extends ArrayAdapter<Lab04Pizza> {
	
	public Lab04RowAdapter(Context context){
		super(context,R.layout.activity_lab04_row,R.id.lab04_nombre);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = super.getView(position, convertView, parent);
		
		Lab04Pizza pizza  = getItem(position);
		
		TextView tv = (TextView) view.findViewById(R.id.lab04_nombre);
		
		tv.setText(pizza.getNombre());
		
		return view;
	}
	
	
}

