package com.telnor.curso.dia01;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * Esta actividad nos servirá como menú a los laboratorios del dia 01
 * 
 * @author admservices
 * 
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button lab01Button = (Button) findViewById(R.id.btn_main_lab01);
		Button lab02Button = (Button) findViewById(R.id.btn_main_lab02);
		Button lab03Button = (Button) findViewById(R.id.btn_main_lab03);

		lab01Button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent goToLab01 = new Intent(getApplicationContext(),
						Lab01FirstActivity.class);
				startActivity(goToLab01);
			}
		});

		lab02Button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent goToLab02 = new Intent(getApplicationContext(),
						Lab02FirstActivity.class);
				startActivity(goToLab02);
			}
		});

		lab03Button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent goToLab03 = new Intent(getApplicationContext(),
						Lab03ListActivity.class);
				startActivity(goToLab03);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
