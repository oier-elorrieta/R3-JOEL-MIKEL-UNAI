package Modelo;



public class Modelo {

	public String[] produktuakJaso() {
		return metodos.sartuSalgaiak();
	}
	public String[] sartuProduktuak(String aukera, String[] aukeratutakoak){
		return metodos.sartuAukeratutakoak(aukera, aukeratutakoak);
	}
	public String arraya(String[] aukeratutakoak){
		return metodos.arraya(aukeratutakoak);
	}

	public int[] sartuAukeratutakoKantitateak(int zbk, int[] kantitateak) {
		return metodos.sartuAukeratutakoZenbakiak(zbk, kantitateak);
	}
	public String arrayaKantitateak(int[] kantitateak) {
		return metodos.arrayaKantitateak(kantitateak);
	}
	public int[] sartuAukeratutakoenDirua(String aukera, int kantitatea, int[] dirua) {
		return metodos.sartuDirua(aukera, kantitatea, dirua);
	}
	public String arrayaDirua(int[] dirua) {
		return metodos.arrayaDirua(dirua);
	}
	public int diruTotala(int[] kantitateak) {
		return metodos.diruTotala(kantitateak);
	}
	public String[] clear1(String[] aukeratutakoak) {
		return metodos.ezabatuArray(aukeratutakoak);
	}
	public int[] clear2(int[] kantitateak) {
		return metodos.ezabatuArray2(kantitateak);
	}
	public int[] clear3(int[] dirua) {
		return metodos.ezabatuArray3(dirua);
	}
}
