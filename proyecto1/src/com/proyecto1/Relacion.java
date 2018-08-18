package com.proyecto1;

public class Relacion  {

     	private String actividad;
     	private String sucesor;
		
     	public Relacion() {}
     	     	
     	
     	public String getActividad() {
			return actividad;
		}
		
     	public void setActividad(String actividad) {
			this.actividad = actividad;
		}
		
     	public String getSucesor() {
			return sucesor;
		}
		
     	public void setSucesor(String sucesor) {
			this.sucesor = sucesor;
		}

		@Override
		public String toString() {
			return "Relacion [actividad=" + actividad + ", sucesor=" + sucesor + "]";
		}


     
}
