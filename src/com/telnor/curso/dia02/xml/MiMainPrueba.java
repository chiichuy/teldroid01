package com.telnor.curso.dia02.xml;

public class MiMainPrueba {
	

	public MiMainPrueba() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		String content;
		XMLParser xml =new XMLParser();
		content=xml.getXmlFromUrl("http://api.androidhive.info/pizza/?format=xml");
		System.out.println(content);
	}

}
