package com.telnor.curso.dia01;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

/**
 * <h1>Lab 02</h1>
 * El objetivo del laboratorio 02 es utilizar un intento para pasar de una actividad a otra, enviando un parametro
 * de la primera a la segunda actividad.
 * @author admservices
 *
 */
public class Lab02SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab02_second);
		
		//obtenemos el valor del bundle enviado de la primer actividad
		Bundle bundle = getIntent().getExtras();
		String parametroObtenido = bundle.getString("llaveParam");
		
		//obtenemos la vista tipo TextView para desplegar el valor del parametro si es que existe.
		TextView texto = (TextView) findViewById(R.id.tv_lab02_second);
		
		if(parametroObtenido == null) {
			texto.setText("La llamada a esta actividad no contenia un parametro");
		} else {
			texto.setText("El valor recibido es: " + parametroObtenido);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lab02_second, menu);
		return true;
	}

}
