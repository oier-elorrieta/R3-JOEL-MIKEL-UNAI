package App;

import BBDD.BBDDKonexioa;
import Controlador.Controlador;
import Modelo.Modelo;
import Vista.Vista;

public class Main {
	
	private static Modelo modelo;
	private static Vista vista;
	@SuppressWarnings("unused")
	private static Controlador controlador;
	private static BBDDKonexioa BBDD;
	
	public static void main(String[] args) {
		modelo = new Modelo();    
		vista = new Vista();
		BBDD = new BBDDKonexioa();
                
		controlador = new Controlador(modelo, vista, BBDD);
	}
}