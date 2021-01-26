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
	
	public int[] sartuAukeratutakoKantitateak(int zbk) {
		return metodos.sartuAukeratutakoZenbakiak(zbk);
	}
	public String arrayaKantitateak() {
		return metodos.arrayaKantitateak();
	}
	public int[] sartuAukeratutakoenDirua(String aukera, int kantitatea) {
		return metodos.sartuDirua(aukera, kantitatea);
	}
	public String arrayaDirua() {
		return metodos.arrayaDirua();
	}
	public int diruTotala() {
		return metodos.diruTotala();
	}
	public void clear() {
		metodos.ezabatu();
	}
}
