package Modelo;

public class Platerra {
	
	private String platerKodea;
	private String platerMota;
	private String izena;
	private double prezioa;
	
	public Platerra(String platerKodea, String platerMota, String izena, double prezioa) { 
		this.platerKodea = platerKodea;
		this.platerMota = platerMota;
		this.izena = izena;
		this.prezioa = prezioa;
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
	
	public double getPrezioa () {
		return prezioa;
	}
	
	public void setPrezioa (double prezioa) {
		this.prezioa = prezioa;
	}
	
}
