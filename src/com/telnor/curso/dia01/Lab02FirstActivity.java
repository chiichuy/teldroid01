package com.telnor.curso.dia01;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * <h1>Lab 02</h1>
 * El objetivo del laboratorio 02 es utilizar un intento para pasar de una actividad a otra, enviando un parametro
 * de la primera a la segunda actividad.
 * @author admservices
 *
 */
public class Lab02FirstActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab02_first);
		
		//Se obtiene el boton a traves de la clase R y se le implementa un escuchador de clics.
		Button goToNextButton = (Button) findViewById(R.id.btn_lab02_firstActivity_goToNext);
		goToNextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//al recibir el clic, buscamos el contenido del campo de texto
				EditText campoTexto = (EditText) findViewById(R.id.et_lab02_param);
				String valorParametro = campoTexto.getText().toString();
				
				Intent goToSecondActivity = new Intent(getApplicationContext(),Lab02SecondActivity.class);
				//agregamos un "bundle" con el metodo putExtra, agregando una llave y el valor.
				goToSecondActivity.putExtra("llaveParam", valorParametro);
				startActivity(goToSecondActivity);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lab02_first, menu);
		return true;
	}

}
