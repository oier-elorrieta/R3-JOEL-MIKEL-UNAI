package Modelo;

public class metodos { 
	static String[] aukeratutakoak = new String[10];
	static int kont=0;
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
				kont++;
				break;
			}
		}
		return aukeratutakoak;
	}
	public static String arraya() {
		String kk = aukeratutakoak[0]+" --->"
				+ "\n         "
				+"\n"+ aukeratutakoak[1]+" --->";
		return kk;
	}
	public static void ezabatu() {
		for(int i = 0; i < aukeratutakoak.length; i++) {
			aukeratutakoak[i] = null;
		}
	}
}
