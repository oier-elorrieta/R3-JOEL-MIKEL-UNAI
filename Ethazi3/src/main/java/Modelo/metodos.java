package Modelo;

public class metodos { 
	static String[] aukeratutakoak = new String[10];
	static int[] kantitateak = new int[10];
	//static int kont=0;
	public static String[] sartuSalgaiak() {
		String sidra = "Sidra";
		String kafea = "Kafea";
		String ura = "Ura";
		String zukua = "Zukua";
		String garagardoa = "Garagardoa";
		String ardoa = "Ardoa";
		String txakoli = "Txakoli";
		String tortilla = "Patata tortilla";
		String gilda = "Gilda";
		String colacao = "Colacao"; 
		String elikagaiak[] = {sidra,kafea,ura,zukua,garagardoa,ardoa,tortilla,txakoli,gilda,colacao};
		return elikagaiak;
	}
	public static String[] sartuAukeratutakoak(String aukera) {	
		//String[] aukeratutakoak = new String[10];
		for(int i = 0; i < aukeratutakoak.length; i++) {
			if(aukeratutakoak[i] == null) {
				aukeratutakoak[i] = aukera;
				System.out.println(aukeratutakoak[i]);
				//kont++;
				break;
			}
		}
		return aukeratutakoak;
	}
	public static String arraya() {
		String kk="";
		int kont = 1;
		for(int i=0;i<aukeratutakoak.length;i++) {
			if(aukeratutakoak[i]!=null) {
			kk = kk+"<html>"+kont+"."+aukeratutakoak[i]+" ----><br><html>";
			}
			kont++;
		}
		return kk;
	}
	public static void ezabatu() {
		for(int i = 0; i < aukeratutakoak.length; i++) {
			aukeratutakoak[i] = null;
		}
	}
	public static int[] sartuAukeratutakoZenbakiak(int zbk) {
		for(int i = 0; i < kantitateak.length; i++) {
			if(kantitateak[i] == 0) {
				kantitateak[i] = zbk;
				break;
			}
		}
		return kantitateak;
	}
	public static String arrayaKantitateak() {
		String kk=""; 
		for(int i=0;i<kantitateak.length;i++) {
			if(kantitateak[i]!=0) {
			kk = kk+"<html>"+kantitateak[i]+"<br><html>";
			} 
		}
		return kk;
	}
}
