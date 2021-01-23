package Modelo;



public class Modelo {
	public String[] produktuakJaso() {
		return metodos.sartuSalgaiak();
	}
	public String[] sartuProduktuak(String aukera){
		return metodos.sartuAukeratutakoak(aukera);
	}
	public String arraya(){
		return metodos.arraya();
	}
	public void clear() {
		metodos.ezabatu();
	}
	public int[] sartuAukeratutakoKantitateak(int zbk) {
		return metodos.sartuAukeratutakoZenbakiak(zbk);
	}
	public String arrayaKantitateak() {
		return metodos.arrayaKantitateak();
	}
}
