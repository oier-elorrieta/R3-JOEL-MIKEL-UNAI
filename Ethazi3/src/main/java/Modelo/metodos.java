package Modelo;

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

	public static String[] sartuSalgaiak() {
		Produktua elikagaiak[] = objektuak();

		String produktoIzena[] = new String[10];
		for(int i = 0; i < produktoIzena.length; i++) {
			produktoIzena[i] = elikagaiak[i].getIzena();
		}
		return produktoIzena;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String[] sartuAukeratutakoak(String aukera, String[] aukeratutakoak) { 		
		for(int i = 0; i < aukeratutakoak.length; i++) {
			if(aukeratutakoak[i] == null) {
				aukeratutakoak[i] = aukera;
				System.out.println(aukeratutakoak[i]);
				break;
			}
		}
		return aukeratutakoak;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String arraya(String[] aukeratutakoak) {
		String edukiontzi="";
		for(int i=0;i<aukeratutakoak.length;i++) {
			if(aukeratutakoak[i]!=null) {
				edukiontzi = edukiontzi+"<html>"+aukeratutakoak[i]+"<br><html>";
			}
		}
		return edukiontzi;
	}

	// *****************************************************************************************************************************************************************************************************

	public static  int[] sartuAukeratutakoZenbakiak(int zbk,int[] kantitateak) {
		for(int i = 0; i < kantitateak.length; i++) {
			if(kantitateak[i] == 0) {
				kantitateak[i] = zbk;
				break;
			}
		}
		return kantitateak;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String arrayaKantitateak(int[] kantitateak) {
		String edukiontzi=""; 
		for(int i=0;i<kantitateak.length;i++) {
			if(kantitateak[i]!=0) {
				edukiontzi = edukiontzi+"<html>"+"x"+kantitateak[i]+"<br><html>";
			} 
		}
		return edukiontzi;
	}

	// *****************************************************************************************************************************************************************************************************

	public static int[] sartuDirua(String aukera, int kantitatea, int[] dirua) {
		Produktua elikagaiak[] = objektuak();
		int kont = 0;
		for(int i=0;i<elikagaiak.length;i++) {
			if(elikagaiak[i].getIzena().equalsIgnoreCase(aukera)) {
				dirua[kont] = kantitatea * elikagaiak[i].getUnitatePrezioa(); 
				System.out.println(elikagaiak[i].getUnitatePrezioa()); 
				break;
			}else {
				kont++;
			}
		}
		return dirua;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String arrayaDirua(int[] dirua) {
		String edukiontzi=""; 
		for(int i=0;i<dirua.length;i++) {
			if(dirua[i]!= 0) {
				edukiontzi = edukiontzi+"<html>"+dirua[i]+"€"+"<br><html>";
			} 
		}
		return edukiontzi;
	}

	// *****************************************************************************************************************************************************************************************************

	public static int diruTotala(int[] kantitateak){
		int diruTotala = 0;
		Produktua elikagaiak[] = objektuak();
		for(int i=0;i<kantitateak.length;i++) {
			diruTotala = diruTotala + (kantitateak[i] * elikagaiak[i].getUnitatePrezioa());
		}
		return diruTotala;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String[] ezabatuArray(String[] aukeratutakoak) {
		for(int i = 0; i < aukeratutakoak.length; i++) {
			aukeratutakoak[i] = null;
		}
		return aukeratutakoak;
	}
	public static int[] ezabatuArray2(int[] kantitateak) {
		for(int i = 0; i < kantitateak.length; i++) {
			kantitateak[i] = 0;
		}
		return kantitateak;
	}
	public static int[] ezabatuArray3(int[] dirua) {
		for(int i = 0; i < dirua.length; i++) {
			dirua[i] = 0;
		}
		return dirua;
	}
}
