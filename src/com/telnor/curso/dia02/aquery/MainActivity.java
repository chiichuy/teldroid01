package com.telnor.curso.dia02.aquery;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.XmlDom;
import com.telnor.curso.dia01.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	AQuery aq;
	ProgressDialog pd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_aquery);

		// Inicializar aquery
		aq = new AQuery(this);
		
		// Cargando el progress 
		pd = new ProgressDialog(this);
		pd.setIndeterminate(true);
		pd.setCancelable(false);
		pd.setInverseBackgroundForced(false);
		pd.setCanceledOnTouchOutside(false);
		pd.setTitle("Descargando...");

		// Sobreescrivir el metodo click y asignarle algun metod definido
		aq.id(R.id.button1).clicked(this, "saluda");

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	// Metodo el cual se llamara al clickear el boton, donde puede recibir como
	// parametro un view
	public void saluda() {
		// Se asigna el text al label
		aq.id(R.id.label).text("Hola aQuery");
		
		
		Toast.makeText(getApplicationContext(), "Hola chuy", Toast.LENGTH_LONG)
				.show();
		
		//asyncJson();
		xml_ajax();
	}

	public void asyncJson() {

		//Preguntar por el perfil default de facebook
		//OJO se ocuparan permisos para poder utilizar esta funcion
		
		String url = "https://graph.facebook.com/chiichuy";
		aq.progress(pd).ajax(url, JSONObject.class, this, "jsonCallback");

	}

	public void jsonCallback(String url, JSONObject json, AjaxStatus status) {
		
		if (json != null) {
			try {
				String name = json.getString("name");
				int id = json.getInt("id");
				//Asignar el nombre del usuario en el label
				aq.id(R.id.label).text(name);
				//Asignar la foto del perfil en una image
				
				aq.id(R.id.imagen).progress(pd).image("https://graph.facebook.com/"+id+"/picture?type=large");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// ajax error
			Toast.makeText(getApplicationContext(), ":(", Toast.LENGTH_LONG)
			.show();
		}

	}
	
	public void xml_ajax(){        
	    String url = "http://api.androidhive.info/pizza/?format=xml";        
	    aq.ajax(url, XmlDom.class, this, "cargarContactos");        
	}
	 
	public void cargarContactos(String url, XmlDom xml, AjaxStatus status){
	 
	    List<XmlDom> contactos = xml.tags("item"); 
	    System.out.println("Saludando " + contactos.size());
	    List<String> titles = new ArrayList<String>();
	    
	    
	    for(XmlDom contacto: contactos){
	        titles.add(contacto.text("name"));
	        //imageUrl = entry.tag("content", "type", "image/jpeg").attr("src");
	    }
	    
	    System.out.println(titles.size());
	    
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	        	Toast.makeText(this, "Configuracion!", Toast.LENGTH_SHORT).show();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
