package com.telnor.curso.dia01;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 * <h1>Lab 01</h1><br>
 * El objetivo del laboratorio 1 es ver como se compone una actividad con su layout, integrar un botón y generar
 * un intento de abrir una segunda actividad (Lab01SecondActivity) al dar clic al botón.
 * @author admservices
 *
 */
public class Lab01SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab01_second);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lab01_second, menu);
		return true;
	}

}
