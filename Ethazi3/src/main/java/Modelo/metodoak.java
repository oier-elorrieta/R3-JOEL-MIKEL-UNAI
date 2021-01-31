package Modelo;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class metodoak { 

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

	public static ArrayList<Karritoa> sartuProduktuaArrayan(String elikagaia,int kopuru, ArrayList<Karritoa> karroa) {
		double dirua = sartuDirua(elikagaia, kopuru);
		Karritoa Prod = new Karritoa(elikagaia, kopuru, dirua);
		karroa.add(Prod);
		return karroa;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String pantailatuProduktua(ArrayList<Karritoa> karroa) {
		String PantailatukoDena= "";
		for(int i=0;i<karroa.size();i++) { 
			PantailatukoDena  = PantailatukoDena + "<html>"+karroa.get(i).toString()+"<br><html>"; 
		}
		return PantailatukoDena;
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

	public static double sartuDirua(String aukera, int kantitatea) {
		Produktua elikagaiak[] = objektuak();
		double dirua = 0;
		for(int i=0;i<elikagaiak.length;i++) {
			if(elikagaiak[i].getIzena().equalsIgnoreCase(aukera)) {
				dirua = kantitatea * elikagaiak[i].getUnitatePrezioa(); 
				break;
			} 
		}
		return dirua;
	}

	// *****************************************************************************************************************************************************************************************************

	public static double diruTotala(ArrayList<Karritoa> karroa) {
		double diruTotala = 0;
		for(int i = 0; i < karroa.size(); i++) {
			diruTotala = diruTotala + karroa.get(i).getBalioa();
		}
		return diruTotala;
	}

	// *****************************************************************************************************************************************************************************************************

	public static ArrayList<Karritoa> ezabatuArraya(ArrayList<Karritoa> karroa) {
		karroa.clear();
		return karroa;
	}

	// *****************************************************************************************************************************************************************************************************

	public static Object argazkiaAukeratu(String aukera) {
		ImageIcon argazkia = null;
		switch(aukera) {
		case "Zukua":
			argazkia = new ImageIcon("argazkiak/zumo.jpg");
			break;
		case "Sidra":
			argazkia = new ImageIcon("argazkiak/sidra.jpg");
			break;
		case "Ura":
			argazkia = new ImageIcon("argazkiak/ura.jpg");
			break;
		case "Kafea":
			argazkia = new ImageIcon("argazkiak/cafe.jpg");
			break;
		case "Txakoli":
			argazkia = new ImageIcon("argazkiak/txakoli.jpg");
			break;
		case "Patata tortilla":
			argazkia = new ImageIcon("argazkiak/tortilla.jpg");
			break;
		case "Garagardoa":
			argazkia = new ImageIcon("argazkiak/garagardoa.png");
			break;
		case "Colacao":
			argazkia = new ImageIcon("argazkiak/colacao.jpg");
			break;
		case "Ardoa":
			argazkia = new ImageIcon("argazkiak/ardoa.jpg");	
			break;	
		case "Gilda":	
			argazkia = new ImageIcon("argazkiak/gilda.jpg");
			break;
		}
		return argazkia;
	}

}
