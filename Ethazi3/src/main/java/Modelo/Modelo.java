package Modelo;



public class Modelo {
	public String[] produktuakJaso() {
		return metodos.sartuSalgaiak();
	}
	public String[] sartuProduktuak(String aukera){
		return metodos.sartuAukeratutakoak(aukera);
	}
	/*public String arrayaIkusi(String aukera, String [] kk) {
		kk = sartuProduktuak(aukera, kk);
		for(int i=0;i<kk.length;i++) {
			System.out.println(kk[i]);
		};
		return kk[0];  
	}*/
	public String arraya(){
		return metodos.arraya();
	}
	public void clear() {
		metodos.ezabatu();
	}
}
