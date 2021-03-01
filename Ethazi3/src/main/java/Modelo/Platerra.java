package Modelo;

public class Platerra {
	
	private String platerKodea;
	private String platerMota;
	private String izena;
	private String tipoPosicion;
	private double saltzekoPrezioa;
	
	public Platerra(String platerKodea, String platerMota, String izena, String tipoPosicion, double saltzekoPrezioa) { 
		this.platerKodea = platerKodea;
		this.platerMota = platerMota;
		this.izena = izena;
		this.tipoPosicion = tipoPosicion;
		this.saltzekoPrezioa = saltzekoPrezioa;
	}

	public String getPlaterKodea() {
		return platerKodea;
	}

	public void setPlaterKodea(String platerKodea) {
		this.platerKodea = platerKodea;
	}

	public String getPlaterMota() {
		return platerMota;
	}

	public void setPlaterMota(String platerMota) {
		this.platerMota = platerMota;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getTipoPosicion() {
		return tipoPosicion;
	}

	public void setTipoPosicion(String tipoPosicion) {
		this.tipoPosicion = tipoPosicion;
	}

	public double getSaltzekoPrezioa() {
		return saltzekoPrezioa;
	}

	public void setSaltzekoPrezioa(double saltzekoPrezioa) {
		this.saltzekoPrezioa = saltzekoPrezioa;
	}

	 
	public String toString() {
		return "Platerra [platerKodea=" + platerKodea + ", platerMota=" + platerMota + ", izena=" + izena
				+ ", tipoPosicion=" + tipoPosicion + ", saltzekoPrezioa=" + saltzekoPrezioa + "]";
	}
	
	
}
