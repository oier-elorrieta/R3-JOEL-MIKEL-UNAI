package Modelo;

import java.util.ArrayList;

public class Karro {
	ArrayList<Karrito> karroa = new ArrayList<Karrito>();
	
	public Karro(ArrayList<Karrito> karroa) {
		this.karroa = karroa;
	}
	
	int kont = 0;
	
	public ArrayList<Karrito> ArrayList(ArrayList<Karrito> karroa){
		return karroa;
	}
	
	public String pantailaratu(ArrayList<Karrito> karroa) {
		
		Karrito kk= karroa.get(kont);
		String kkizena = kk.getElikagaia();
		int kkantitate = kk.getKopuru();
		int dirua = kk.getBalioa();
		String emaitza = kkizena+ " "+ kkantitate+" "+dirua;
		kont++;
		return emaitza;
	}
	
	public ArrayList<Karrito> getKarroa() {
		return karroa;
	}
	
	public void setKarroa(ArrayList<Karrito> karroa) {
		this.karroa = karroa;
	}

	public void sartuKarritoan(String elikagaia, int kopuru, int balioa) { 
		Karrito k = new Karrito(elikagaia, kopuru, balioa);
		karroa.add(k); 
	}
}
