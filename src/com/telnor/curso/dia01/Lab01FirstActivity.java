package com.telnor.curso.dia01;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * <h1>Lab 01</h1><br>
 * El objetivo del laboratorio 1 es ver como se compone una actividad con su layout, integrar un botón y generar
 * un intento de abrir una segunda actividad (Lab01SecondActivity) al dar clic al botón.
 * @author admservices
 *
 */
public class Lab01FirstActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//define la vista de contenido (el layout que esta actividad utilizará). La clase "R" nos provee acceso a los recursos
		//en la carpeta /res
		setContentView(R.layout.activity_lab01_first);
		
		//obtenemos a traves de la clase "R" el botón declarado en nuestro layout "activity_lab01_first" 
		//y le implementamos un escuchador de clic.
		Button goToNextButton = (Button) findViewById(R.id.btn_lab01_firstActivity_goToNext);
		goToNextButton.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View boton) {
				
				//Creamos un intento para ir a la siguiente actividad.
				Context contextoDeAplicacion = getApplicationContext();
				Intent irASegundaActividad = new Intent(contextoDeAplicacion,Lab01SecondActivity.class);
				startActivity(irASegundaActividad);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lab01_first, menu);
		return true;
	}

}
