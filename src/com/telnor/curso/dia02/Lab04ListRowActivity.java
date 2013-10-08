package com.telnor.curso.dia02;

import com.telnor.curso.dia01.R;
import com.telnor.curso.dia01.R.layout;
import com.telnor.curso.dia01.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class Lab04ListRowActivity extends Activity {

	Lab04RowAdapter listado;
	ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab04_list_row);
		
		listado = new Lab04RowAdapter(this);
		
		lv = (ListView) findViewById(R.id.lab04_lv_contenedor);
		
		cargarInfo();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lab04_list_row, menu);
		return true;
	}
	
	public void cargarInfo(){
		listado.clear();
		Lab04Pizza pizza;
		
		pizza = new Lab04Pizza();
		pizza.setNombre("Carnivora");
		
		listado.add(pizza);
		
		pizza = new Lab04Pizza();
		pizza.setNombre("Suprema");
		
		listado.add(pizza);
		
		listado.notifyDataSetChanged();
		
	}

}
