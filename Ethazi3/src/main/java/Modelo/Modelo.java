package Modelo;

import java.util.ArrayList;

public class Modelo {

	//private int kont = 0;
	private ArrayList<Karrito> karroa = new ArrayList<Karrito>();
	//private String[] arrayLaburpen = new String[kont];
	

	public String[] produktuakJaso() {
		return metodos.sartuSalgaiak();
	}
	/*public String[] sartuProduktuak(String aukera){
		return metodos.sartuAukeratutakoak(aukera);
	}
	public String arraya(String[] aukeratutakoak){
		return metodos.arraya(aukeratutakoak);
	}

	public int[] sartuAukeratutakoKantitateak(int zbk) {
		return metodos.sartuAukeratutakoZenbakiak(zbk);
	}
	public String arrayaKantitateak(int[] kantitateak) {
		return metodos.arrayaKantitateak(kantitateak);
	}
	/*public int[] sartuAukeratutakoenDirua(String aukera, int kantitatea) {
		return metodos.sartuDirua(aukera, kantitatea);
	}
	public String arrayaDirua(int[] dirua) {
		return metodos.arrayaDirua(dirua);
	}
	 
	public String[] clear1(String[] aukeratutakoak) {
		return metodos.ezabatuArray(aukeratutakoak);
	}
	public int[] clear2(int[] kantitateak) {
		return metodos.ezabatuArray2(kantitateak);
	}
	public int[] clear3(int[] dirua) {
		return metodos.ezabatuArray3(dirua);
	}*/
	public ArrayList<Karrito> sartu(String elikagaia,int kopuru) {
		/*System.out.println(elikagaia);
		System.out.println(kopuru);
		System.out.println(dirua); 
    	
		Karrito k = sortuObjekttua();
		k.setBalioa(dirua);
    	k.setElikagaia(elikagaia);
    	k.setKopuru(kopuru);
		karroa.add(k);
		System.out.println(karroa.size());
		String emaitza="";
		emaitza = k.toString();*/
		
		//karroa = metodos.sartu(elikagaia, kopuru, dirua, karroa);
		return metodos.sartu(elikagaia, kopuru, karroa); 
	}
	 
	public String pantailaratu() {
		return metodos.pantailatu(karroa);
	}
	public int diruTotala() {
		return metodos.diruTotala(karroa);
	}
}
