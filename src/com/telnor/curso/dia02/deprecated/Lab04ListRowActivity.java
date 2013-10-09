package com.telnor.curso.dia02.deprecated;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.widget.ListView;

import com.telnor.curso.dia01.R;
import com.telnor.curso.dia02.xml.XMLParser;

public class Lab04ListRowActivity extends Activity {
	static final String URL = "http://api.androidhive.info/pizza/?format=xml";
	static final String KEY_ITEM = "item";
	static final String KEY_ID = "id";
	static final String KEY_NAME = "name";
	static final String KEY_COST = "cost";
	static final String KEY_DESC = "description";

	Lab04RowAdapter listado;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lab04_list_row);

		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		
		listado = new Lab04RowAdapter(this);

		listView = (ListView) findViewById(R.id.lab04_lv_contenedor);

		listView.setAdapter(listado);
		cargarInfo();
	}

	public void cargarInfo() {

		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(URL);
		Document doc = parser.getDomElement(xml);
		NodeList nodeList = doc.getElementsByTagName(KEY_ITEM);

		listado.clear();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Element element = (Element) nodeList.item(i);
			String name = parser.getValue(element, KEY_NAME);
			listado.add(new Lab04Pizza(name));

		}

		listado.notifyDataSetChanged();

	}

}
