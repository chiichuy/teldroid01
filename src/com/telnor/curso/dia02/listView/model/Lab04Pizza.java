package com.telnor.curso.dia02.listView.model;

public class Lab04Pizza {

	private String id;
	private String nombre;
	private String costo;
	private String descripcion;

	public Lab04Pizza() {

	}

	public Lab04Pizza(String nombre, String costo, String descripcion) {
		this.nombre = nombre;
		this.costo = costo;
		this.descripcion = descripcion;
	}

	public Lab04Pizza(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
