package Modelo;

public class Karrito {
	
	private String elikagaia;
	private int kopuru;
	private double balioa;
	
	public Karrito(String elikagaia, int kopuru, double balioa) { 
		this.elikagaia = elikagaia;
		this.kopuru = kopuru;
		this.balioa = balioa;
	}
	
	public String getElikagaia() {
		return elikagaia;
	}
	
	public void setElikagaia(String elikagaia) {
		this.elikagaia = elikagaia;
	}
	
	public int getKopuru() {
		return kopuru;
	}
	
	public void setKopuru(int kopuru) {
		this.kopuru = kopuru;
	}
	
	public double getBalioa() { 
		return balioa;
	}
	
	public void setBalioa(int balioa) {
		this.balioa = balioa;
	}

	@Override 
	public String toString() {
		return "<html>"+"<p>"+"x"+kopuru+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
								 +elikagaia+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
								 +balioa+"€"+"&nbsp;<p>"+"<html>";
	}
	
	
	
}
