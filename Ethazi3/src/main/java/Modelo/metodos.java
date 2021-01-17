package Modelo;

public class metodos {
	public static String[] irakurri() {
		autoa a1 = new autoa("7894EFE","Audi","Q5","marroia");
		autoa a2 = new autoa("2849FSR","Audi","A3","beltza");
		autoa a3 = new autoa("5864UYF","Seat","Panda","urdina");
		autoa a4 = new autoa("2567RWE","Citroen","C3","laranja");
		autoa[] autoak = new autoa[4];
		autoak[0] = a1;
		autoak[1] = a2;
		autoak[2] = a3;
		autoak[3] = a4;
		String[] matrikulak = new String[4];
		for(int i = 0; i < autoak.length;i++) {
			matrikulak[i] = autoak[i].getMatrikula();
		}
		return matrikulak;
	}
}
