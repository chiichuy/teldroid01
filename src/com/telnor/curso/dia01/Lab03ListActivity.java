package com.telnor.curso.dia01;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * <h1>Lab 03</h1>
 * El objetivo del laboratorio 03 es desplegar una lista simple utilizando un layout listView y un adaptador (clase Lab03ListAdapter) simple.
 * <p>
 * Una actividad que despliega una lista necesita tener un archivo de layout que tenga como raiz un ListView.
 * Se debera crear un adaptador para "pasar" un arreglo de datos a vista.
 * </p><p>
 * Al crear la actividad se deberá cargar un arreglo con informacion, crear una instancia del adaptador y enviarle el arreglo.
 * Una vez hecho esto, asignarle el adaptador a la vista tipo (ListView) del layout. Al ejecutar el ListView utilizara la información
 * del adaptador  y desplegara el arreglo como una lista.
 * </p>
 * @author admservices
 *
 */
public class Lab03ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab03_list);
		
		//obtengo la información, en este caso una lista estatica de usuarios.
		ArrayList<String> listaUsuarios = obtenerUsuarios();
		
		//obtengo la vista de tipo ListView del layout en el lab 03
		ListView lista = (ListView) findViewById(R.id.lv_lab03_simple);
		
		//creo un nuevo adaptador simple enviandole un layout estandar de android (android.R.layout.simple_list_item_1)
		//y la lista de usuarios.
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaUsuarios);
		
		//agrego el adaptador a la vista de tipo ListView
		lista.setAdapter(adaptador);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lab03_list, menu);
		return true;
	}

	/**
	 * Este metodo simula una lista de usuarios que en nuestra imaginacion, podria venir de un servicio REST, de base de datos, etc. 
	 * @return La lista de usuarios en un arreglo de String.
	 */
	protected ArrayList<String> obtenerUsuarios() {
		ArrayList<String> arregloUsuarios = new ArrayList<String>();
		arregloUsuarios.add("Adrian");
		arregloUsuarios.add("Luis");
		arregloUsuarios.add("Jesus");
		arregloUsuarios.add("Angel");
		arregloUsuarios.add("Eduardo");
		arregloUsuarios.add("Ivan");
		arregloUsuarios.add("Hilario");
		arregloUsuarios.add("Fernando");
		arregloUsuarios.add("Michel");
		arregloUsuarios.add("Andres");
		arregloUsuarios.add("Maria");
		arregloUsuarios.add("Francisco");
		return arregloUsuarios;
	}
}
