package Modelo;

public class Produktua {
	
	private String izena;
	private int data;
	private String mota;
	private int unitatePrezioa;
	private int erosPrezioa;
	
	public Produktua(String izena, int data, String mota, int unitatePrezioa, int erosPrezioa) {
		this.izena = izena;
		this.data = data;
		this.mota = mota;
		this.unitatePrezioa = unitatePrezioa;
		this.erosPrezioa = erosPrezioa;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public int getUnitatePrezioa() {
		return unitatePrezioa;
	}

	public void setUnitatePrezioa(int unitatePrezioa) {
		this.unitatePrezioa = unitatePrezioa;
	}

	public int getErosPrezioa() {
		return erosPrezioa;
	}

	public void setErosPrezioa(int erosPrezioa) {
		this.erosPrezioa = erosPrezioa;
	}
}
