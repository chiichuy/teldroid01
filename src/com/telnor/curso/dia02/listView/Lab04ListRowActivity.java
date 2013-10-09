package com.telnor.curso.dia02.listView;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.telnor.curso.dia01.R;
import com.telnor.curso.dia02.json.JSONParser;
import com.telnor.curso.dia02.listView.model.Lab04Pizza;
import com.telnor.curso.dia02.xml.XMLParser;

public class Lab04ListRowActivity extends Activity {
	Lab04RowAdapter listado;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab04_list_row);

		listado = new Lab04RowAdapter(this);
		listView = (ListView) findViewById(R.id.lab04_lv_contenedor);
		listView.setAdapter(listado);

		// EjecutorAsincronoXML ax = new EjecutorAsincronoXML();
		EjecutorAsincronoJSON ax = new EjecutorAsincronoJSON();
		ax.execute();
	}

	public void llenarDatos(ArrayList<Lab04Pizza> listaPizzas) {
		for (Lab04Pizza pizza : listaPizzas) {
			listado.add(new Lab04Pizza(pizza.getNombre(), pizza.getCosto(),
					pizza.getDescripcion()));
		}
		listado.notifyDataSetChanged();
	}

	private class EjecutorAsincronoXML extends AsyncTask<Void, Void, Void> {

		private static final String URL = "http://api.androidhive.info/pizza/?format=xml";
		private static final String KEY_ITEM = "item";
		private static final String KEY_NAME = "name";
		private static final String KEY_COST = "cost";
		private static final String KEY_DESC = "description";

		private ArrayList<Lab04Pizza> usuariosLista = new ArrayList<Lab04Pizza>();

		@Override
		protected Void doInBackground(Void... params) {
			XMLParser parser = new XMLParser();
			String xml = parser.getXmlFromUrl(URL);
			Document doc = parser.getDomElement(xml);
			NodeList nl = doc.getElementsByTagName(KEY_ITEM);
			for (int i = 0; i < nl.getLength(); i++) {
				Element e = (Element) nl.item(i);
				String name = parser.getValue(e, KEY_NAME);
				String cost = parser.getValue(e, KEY_COST);
				String description = parser.getValue(e, KEY_DESC);
				usuariosLista.add(new Lab04Pizza(name, cost, description));
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			llenarDatos(usuariosLista);
		}
	}

	private class EjecutorAsincronoJSON extends AsyncTask<Void, Void, Void> {

		private static final String URL = "http://api.androidhive.info/contacts/";
		private static final String TAG_CONTACTS = "contacts";
		private static final String TAG_NAME = "name";
		private static final String TAG_EMAIL = "email";
		private static final String TAG_PHONE = "phone";
		private static final String TAG_PHONE_MOBILE = "mobile";

		private ArrayList<Lab04Pizza> usuariosLista = new ArrayList<Lab04Pizza>();
		private JSONArray contacts = null;

		@Override
		protected Void doInBackground(Void... urls) {

			JSONParser jParser = new JSONParser();
			JSONObject json = jParser.getJSONFromUrl(URL);

			try {
				contacts = json.getJSONArray(TAG_CONTACTS);
				for (int i = 0; i < contacts.length(); i++) {
					JSONObject c = contacts.getJSONObject(i);
					String name = c.getString(TAG_NAME);
					String email = c.getString(TAG_EMAIL);
					JSONObject phone = c.getJSONObject(TAG_PHONE);
					String mobile = phone.getString(TAG_PHONE_MOBILE);
					usuariosLista.add(new Lab04Pizza(name, email, mobile));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			llenarDatos(usuariosLista);
		}
	}
}
