package com.proyecto1;

import java.util.ArrayList;
import java.util.List;

public class Actividad {
	
	private String id;
	private int duracion;
	private int x;
	private int y;
	public ArrayList<String> sucesor = new ArrayList<String>();
	
	public Actividad() {
	}
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ArrayList<String> getSucesor() {
		return sucesor;
	}
	public void setSucesor(String elemento) {
		this.sucesor.add(elemento);
	}

	public String imprimeLista() {
		String x = " ";
		if (sucesor != null) {
			for (String string : sucesor) {
				x = x + string +" ";
			}
		}else{
			x= "Sin sucesor";
		} 
		return x;
	}
	
	@Override
	public String toString() {
		return "Actividad [id=" + id + ", duracion=" + duracion + ", x=" + x + ", y=" + y + ", sucesor=" + imprimeLista()
				+ "]";
	}
	

	

}
