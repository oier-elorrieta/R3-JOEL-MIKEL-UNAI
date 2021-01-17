package Modelo;

public class autoa {
	private String matrikula;
	private String marka;
	private String modelo;
	private String kolorea;
	
	public autoa(String matrikula, String marka, String modelo, String kolorea) { 
		this.matrikula = matrikula;
		this.marka = marka;
		this.modelo = modelo;
		this.kolorea = kolorea;
	}
	
	public String getMatrikula() {
		return matrikula;
	}
	public void setMatrikula(String matrikula) {
		this.matrikula = matrikula;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getKolorea() {
		return kolorea;
	}
	public void setKolorea(String kolorea) {
		this.kolorea = kolorea;
	}
	
	@Override
	public String toString() {
		return "autoa [matrikula=" + matrikula + ", marka=" + marka + ", modelo=" + modelo + ", kolorea=" + kolorea
				+ "]";
	}
}
