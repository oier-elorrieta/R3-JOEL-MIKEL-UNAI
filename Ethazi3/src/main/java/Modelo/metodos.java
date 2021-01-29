package Modelo;

import java.util.ArrayList;

public class metodos { 

	public static Produktua[] objektuak() {

		Produktua sidra = new Produktua("Sidra", 0, "Edaria", 3, 1);
		Produktua kafea = new Produktua("Kafea", 0, "Edaria", 3, 1);
		Produktua ura = new Produktua("Ura", 0, "Edaria", 3, 1);
		Produktua zukua = new Produktua("Zukua", 0, "Edaria", 3, 1);
		Produktua garagardoa = new Produktua("Garagardoa", 0, "Edaria", 3, 1);
		Produktua ardoa = new Produktua("Ardoa", 0, "Edaria", 3, 1);
		Produktua txakoli = new Produktua("Txakoli", 0, "Edaria", 3, 1);
		Produktua tortilla = new Produktua("Patata tortilla", 0, "Janaria", 3, 1);
		Produktua gilda = new Produktua("Gilda", 0, "Janaria", 3, 1);
		Produktua colacao = new Produktua("Colacao", 0, "Edaria", 3, 1);
		Produktua elikagaiak[] = new Produktua[10];
		elikagaiak[0] = sidra;
		elikagaiak[1] = kafea;
		elikagaiak[2] = ura;	
		elikagaiak[3] = zukua;
		elikagaiak[4] = garagardoa;
		elikagaiak[5] = ardoa;
		elikagaiak[6] = txakoli;
		elikagaiak[7] = tortilla;
		elikagaiak[8] = gilda;
		elikagaiak[9] = colacao; 
		return elikagaiak;
	}

	// *****************************************************************************************************************************************************************************************************

	public static ArrayList<Karrito> sartu(String elikagaia,int kopuru, ArrayList<Karrito> karroa) {
		int dirua = sartuDirua(elikagaia, kopuru);
		System.out.println(elikagaia);
		System.out.println(kopuru);
		System.out.println(dirua); 
		Karrito k = new Karrito(elikagaia, kopuru, dirua);
		karroa.add(k);
		System.out.println(karroa.size());
		return karroa;
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	public static String pantailatu(ArrayList<Karrito> karroa) {
		String edukiontzi= "";
		for(int i=0;i<karroa.size();i++) { 
			edukiontzi  = edukiontzi + "<html>"+karroa.get(i).toString()+"<br><html>"; 
		}
		return edukiontzi;
	}

	// *****************************************************************************************************************************************************************************************************
	
	public static String[] sartuSalgaiak() {
		Produktua elikagaiak[] = objektuak();

		String produktoIzena[] = new String[10];
		for(int i = 0; i < produktoIzena.length; i++) {
			produktoIzena[i] = elikagaiak[i].getIzena();
		}
		return produktoIzena;
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	public static int sartuDirua(String aukera, int kantitatea) {
		Produktua elikagaiak[] = objektuak();
		int dirua = 1;
		for(int i=0;i<elikagaiak.length;i++) {
			if(elikagaiak[i].getIzena().equalsIgnoreCase(aukera)) {
				dirua = kantitatea * elikagaiak[i].getUnitatePrezioa(); 
				break;
			} 
		}
		return dirua;
	}

	// *****************************************************************************************************************************************************************************************************
	
	public static int diruTotala(ArrayList<Karrito> karroa) {
		int kont = 0;
		for(int i = 0; i < karroa.size(); i++) {
			System.out.println(karroa.get(i).getBalioa());
			System.out.println(karroa.get(i).getBalioa()*karroa.get(i).getKopuru());
			kont = kont + karroa.get(i).getBalioa();
		}
		return kont;
		
	}
	
	// *****************************************************************************************************************************************************************************************************
}
