package Modelo;

public class Platerra {
	
	private String platerKodea;
	private String platerMota;
	private String izena;
	private double saltzekoPrezioa;
	private double erosPrezioa;
	
	public Platerra(String platerKodea, String platerMota, String izena, double saltzekoPrezioa, double erosPrezioa) { 
		this.platerKodea = platerKodea;
		this.platerMota = platerMota;
		this.izena = izena;
		this.saltzekoPrezioa = saltzekoPrezioa;
		this.erosPrezioa = erosPrezioa;
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

	public double getSaltzekoPrezioa() {
		return saltzekoPrezioa;
	}

	public void setSaltzekoPrezioa(double saltzekoPrezioa) {
		this.saltzekoPrezioa = saltzekoPrezioa;
	}

	public double getErosPrezioa() {
		return erosPrezioa;
	}

	public void setErosPrezioa(double erosPrezioa) {
		this.erosPrezioa = erosPrezioa;
	}

	 
	public String toString() {
		return "Platerra [platerKodea=" + platerKodea + ", platerMota=" + platerMota + ", izena=" + izena
				+ ", saltzekoPrezioa=" + saltzekoPrezioa + ", erosPrezioa=" + erosPrezioa + "]";
	}
	
	
}
