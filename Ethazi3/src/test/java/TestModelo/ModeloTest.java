package TestModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Produktua;
import Modelo.metodos;

public class ModeloTest {

	Produktua elikagaiak[] = metodos.objektuak();
	
	// *****************************************************************************************************************************************************************************************************
	
	@Test
	public void testSartuSalgaiak() {
		String aukera = elikagaiak[0].getIzena();
		
		String esperotakoa = "Sidra";
		
		metodos.sartuSalgaiak();
		
		assertEquals(esperotakoa, aukera);
	}
	
	@Test
	public void testSartuSalgaiak1() {
		String aukera = elikagaiak[2].getIzena();
		
		String esperotakoa = "Ura";
		
		metodos.sartuSalgaiak();
		
		assertEquals(esperotakoa, aukera);
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	@Test
	public void testDiruTotala() {
		
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = 1; 
		aukeratutakoak[1] = 1; 
		aukeratutakoak[2] = 1; 
		aukeratutakoak[3] = 1; 
		aukeratutakoak[4] = 1; 
		aukeratutakoak[5] = 1; 
		aukeratutakoak[6] = 1; 
		aukeratutakoak[7] = 1; 
		aukeratutakoak[8] = 1; 
		aukeratutakoak[9] = 1; 
		
		int esperotakoa = 0;
		
		for(int i=0;i<aukeratutakoak.length;i++) {
			esperotakoa = esperotakoa + (aukeratutakoak[i] * elikagaiak[i].getUnitatePrezioa());
		}
		
		assertEquals(esperotakoa, metodos.diruTotala(aukeratutakoak));	
	}
	
	@Test
	public void testDiruTotala1() {
		
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = 1; 
		aukeratutakoak[1] = 2; 
		aukeratutakoak[2] = 1; 
		aukeratutakoak[3] = 2; 
		aukeratutakoak[4] = 4; 
		aukeratutakoak[5] = 1; 
		aukeratutakoak[6] = 6; 
		aukeratutakoak[7] = 1; 
		aukeratutakoak[8] = 1; 
		aukeratutakoak[9] = 1; 
		
		int esperotakoa = 0;
		
		for(int i=0;i<aukeratutakoak.length;i++) {
			esperotakoa = esperotakoa + (aukeratutakoak[i] * elikagaiak[i].getUnitatePrezioa());
		}
		
		assertEquals(esperotakoa, metodos.diruTotala(aukeratutakoak));	
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	@Test
	public void testSartuDirua() {
		
		int esperotakoa[] = new int[10];
		esperotakoa[0] = 0; 
		esperotakoa[1] = 0; 
		esperotakoa[2] = 6; 
		esperotakoa[3] = 0; 
		esperotakoa[4] = 0; 
		esperotakoa[5] = 0; 
		esperotakoa[6] = 0; 
		esperotakoa[7] = 0; 
		esperotakoa[8] = 0; 
		esperotakoa[9] = 0; 
		
		int itzulera[] = new int[10];
		
		itzulera = metodos.sartuDirua("Ura", 2, esperotakoa);
		
		assertEquals(esperotakoa, itzulera);	
		
	}
	
}
