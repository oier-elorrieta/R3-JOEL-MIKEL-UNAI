package TestModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Produktua;
import Modelo.metodos;

public class ModeloTest {

	Produktua elikagaiak[] = metodos.objektuak();
	
	// *****************************************************************************************************************************************************************************************************
	
	@Test
	public void testArrayaKantitateak() {
		
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = 1; 
		aukeratutakoak[1] = 1; 
		aukeratutakoak[2] = 1; 
		aukeratutakoak[3] = 1; 
		aukeratutakoak[4] = 1; 
		aukeratutakoak[5] = 1; 
		aukeratutakoak[6] = 1; 
		aukeratutakoak[7] = 0; 
		aukeratutakoak[8] = 1; 
		aukeratutakoak[9] = 1; 

		
		metodos.arrayaKantitateak(aukeratutakoak);
		
		int esperotakoa = 0;
		
		assertEquals(esperotakoa, aukeratutakoak[7]);	
	}
	
	@Test
	public void testArrayaKantitateak2() {
		
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = 1; 
		aukeratutakoak[1] = 0; 
		aukeratutakoak[2] = 1; 
		aukeratutakoak[3] = 1; 
		aukeratutakoak[4] = 1; 
		aukeratutakoak[5] = 1; 
		aukeratutakoak[6] = 1; 
		aukeratutakoak[7] = 1; 
		aukeratutakoak[8] = 1; 
		aukeratutakoak[9] = 1; 

		
		metodos.arrayaKantitateak(aukeratutakoak);
		
		int esperotakoa = 0;
		
		assertEquals(esperotakoa, aukeratutakoak[1]);	
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	@Test
	public void testArraya() {
		
		String aukeratutakoak[] = new String[10];
		aukeratutakoak[0] = "Ura"; 
		aukeratutakoak[1] = "Ura"; 
		aukeratutakoak[2] = "Ura"; 
		aukeratutakoak[3] = "Ura"; 
		aukeratutakoak[4] = "Ura"; 
		aukeratutakoak[5] = "Ura"; 
		aukeratutakoak[6] = "Ura"; 
		aukeratutakoak[7] = null; 
		aukeratutakoak[8] = "Ura"; 
		aukeratutakoak[9] = "Ura"; 

		
		metodos.arraya(aukeratutakoak);
		
		String esperotakoa = null;
		
		assertEquals(esperotakoa, aukeratutakoak[7]);	
	}
	
	@Test
	public void testArraya2() {
		
		String aukeratutakoak[] = new String[10];
		aukeratutakoak[0] = "Ura"; 
		aukeratutakoak[1] = "Ura"; 
		aukeratutakoak[2] = "Ura"; 
		aukeratutakoak[3] = "Ura"; 
		aukeratutakoak[4] = null; 
		aukeratutakoak[5] = "Ura"; 
		aukeratutakoak[6] = "Ura"; 
		aukeratutakoak[7] = "Ura"; 
		aukeratutakoak[8] = "Ura"; 
		aukeratutakoak[9] = "Ura"; 

		
		metodos.arraya(aukeratutakoak);
		
		String esperotakoa = null;
		
		assertEquals(esperotakoa, aukeratutakoak[4]);	
	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testEzabatuArray() {
		
		String aukeratutakoak[] = new String[10];
		aukeratutakoak[0] = null; 
		aukeratutakoak[1] = null; 
		aukeratutakoak[2] = null; 
		aukeratutakoak[3] = null; 
		aukeratutakoak[4] = null; 
		aukeratutakoak[5] = null; 
		aukeratutakoak[6] = null; 
		aukeratutakoak[7] = null; 
		aukeratutakoak[8] = null; 
		aukeratutakoak[9] = "Ura"; 

		
		metodos.ezabatuArray(aukeratutakoak);
		
		String esperotakoa = null;
		
		assertEquals(esperotakoa, aukeratutakoak[9]);	
	}
	
	@Test
	public void testEzabatuArray_() {
		
		String aukeratutakoak[] = new String[10];
		aukeratutakoak[0] = null; 
		aukeratutakoak[1] = null; 
		aukeratutakoak[2] = null; 
		aukeratutakoak[3] = null; 
		aukeratutakoak[4] = "Ura"; 
		aukeratutakoak[5] = null; 
		aukeratutakoak[6] = null; 
		aukeratutakoak[7] = null; 
		aukeratutakoak[8] = null; 
		aukeratutakoak[9] = null; 

		
		metodos.ezabatuArray(aukeratutakoak);
		
		String esperotakoa = null;
		
		assertEquals(esperotakoa, aukeratutakoak[4]);	
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	@Test
	public void testEzabatuArray2() {
		
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = 0; 
		aukeratutakoak[1] = 0; 
		aukeratutakoak[2] = 1; 
		aukeratutakoak[3] = 0; 
		aukeratutakoak[4] = 0; 
		aukeratutakoak[5] = 0; 
		aukeratutakoak[6] = 0; 
		aukeratutakoak[7] = 0; 
		aukeratutakoak[8] = 0; 
		aukeratutakoak[9] = 0; 

		
		metodos.ezabatuArray2(aukeratutakoak);
		
		int esperotakoa = 0;
		
		assertEquals(esperotakoa, aukeratutakoak[2]);	
	}
	
	@Test
	public void testEzabatuArray2_() {
		
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = 0; 
		aukeratutakoak[1] = 0; 
		aukeratutakoak[2] = 0; 
		aukeratutakoak[3] = 0; 
		aukeratutakoak[4] = 0; 
		aukeratutakoak[5] = 0; 
		aukeratutakoak[6] = 1; 
		aukeratutakoak[7] = 0; 
		aukeratutakoak[8] = 0; 
		aukeratutakoak[9] = 0; 

		
		metodos.ezabatuArray2(aukeratutakoak);
		
		int esperotakoa = 0;
		
		assertEquals(esperotakoa, aukeratutakoak[6]);	
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	@Test
	public void testEzabatuArray3() {
		
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = 0; 
		aukeratutakoak[1] = 0; 
		aukeratutakoak[2] = 1; 
		aukeratutakoak[3] = 0; 
		aukeratutakoak[4] = 0; 
		aukeratutakoak[5] = 0; 
		aukeratutakoak[6] = 0; 
		aukeratutakoak[7] = 0; 
		aukeratutakoak[8] = 0; 
		aukeratutakoak[9] = 0; 

		
		metodos.ezabatuArray3(aukeratutakoak);
		
		int esperotakoa = 0;
		
		assertEquals(esperotakoa, aukeratutakoak[2]);	
	}
	
	@Test
	public void testEzabatuArray3_() {
		
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = 0; 
		aukeratutakoak[1] = 0; 
		aukeratutakoak[2] = 0; 
		aukeratutakoak[3] = 0; 
		aukeratutakoak[4] = 0; 
		aukeratutakoak[5] = 0; 
		aukeratutakoak[6] = 1; 
		aukeratutakoak[7] = 0; 
		aukeratutakoak[8] = 0; 
		aukeratutakoak[9] = 0; 

		
		metodos.ezabatuArray3(aukeratutakoak);
		
		int esperotakoa = 0;
		
		assertEquals(esperotakoa, aukeratutakoak[6]);	
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	@Test
	public void testSartuAukeratutakoak() {
		
		String aukeratutakoak[] = new String[10];
		aukeratutakoak[0] = "Ura"; 
		aukeratutakoak[1] = "Ura"; 
		aukeratutakoak[2] = "Ura"; 
		aukeratutakoak[3] = null; 
		aukeratutakoak[4] = "Ura"; 
		aukeratutakoak[5] = "Ura"; 
		aukeratutakoak[6] = "Ura"; 
		aukeratutakoak[7] = "Ura"; 
		aukeratutakoak[8] = "Ura"; 
		aukeratutakoak[9] = "Ura"; 

		
		metodos.sartuAukeratutakoak("Kafea", aukeratutakoak);
		
		String esperotakoa = "Kafea";
		
		assertEquals(esperotakoa, aukeratutakoak[3]);	
		
	}
	
	@Test
	public void testSartuAukeratutakoak1() {
		
		String aukeratutakoak[] = new String[10];
		aukeratutakoak[0] = "Ura"; 
		aukeratutakoak[1] = "Ura"; 
		aukeratutakoak[2] = "Ura"; 
		aukeratutakoak[3] = "Ura"; 
		aukeratutakoak[4] = "Ura"; 
		aukeratutakoak[5] = "Ura"; 
		aukeratutakoak[6] = null; 
		aukeratutakoak[7] = "Ura"; 
		aukeratutakoak[8] = "Ura"; 
		aukeratutakoak[9] = "Ura"; 

		
		metodos.sartuAukeratutakoak("Colacao", aukeratutakoak);
		
		String esperotakoa = "Colacao";
		
		assertEquals(esperotakoa, aukeratutakoak[6]);	
		
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	@Test
	public void testSartuAukeratutakoZenbakiak() {
		
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = 1; 
		aukeratutakoak[1] = 1; 
		aukeratutakoak[2] = 1; 
		aukeratutakoak[3] = 0; 
		aukeratutakoak[4] = 1; 
		aukeratutakoak[5] = 1; 
		aukeratutakoak[6] = 1; 
		aukeratutakoak[7] = 1; 
		aukeratutakoak[8] = 1; 
		aukeratutakoak[9] = 1; 

		
		metodos.sartuAukeratutakoZenbakiak(4, aukeratutakoak);
		
		int esperotakoa = 4;
		
		assertEquals(esperotakoa, aukeratutakoak[3]);	
	}
	
	@Test
	public void testSartuAukeratutakoZenbakiak1() {
		
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = 1; 
		aukeratutakoak[1] = 1; 
		aukeratutakoak[2] = 1; 
		aukeratutakoak[3] = 1; 
		aukeratutakoak[4] = 1; 
		aukeratutakoak[5] = 1; 
		aukeratutakoak[6] = 1; 
		aukeratutakoak[7] = 0; 
		aukeratutakoak[8] = 1; 
		aukeratutakoak[9] = 1; 

		
		metodos.sartuAukeratutakoZenbakiak(8, aukeratutakoak);
		
		int esperotakoa = 8;
		
		assertEquals(esperotakoa, aukeratutakoak[7]);	
	}
	
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
	public void testArrayaDirua() {
		
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = 0; 
		aukeratutakoak[1] = 0; 
		aukeratutakoak[2] = 0; 
		aukeratutakoak[3] = 0; 
		aukeratutakoak[4] = 1; 
		aukeratutakoak[5] = 0; 
		aukeratutakoak[6] = 0; 
		aukeratutakoak[7] = 0; 
		aukeratutakoak[8] = 0; 
		aukeratutakoak[9] = 0; 

		
		metodos.arrayaDirua(aukeratutakoak);
		
		String esperotakoa = ""+"<html>"+"1"+"€"+"<br><html>";
		
		assertEquals(esperotakoa, metodos.arrayaDirua(aukeratutakoak));	
	}
	
	@Test
	public void testArrayaDirua1() {
		
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = 0; 
		aukeratutakoak[1] = 0; 
		aukeratutakoak[2] = 0; 
		aukeratutakoak[3] = 0; 
		aukeratutakoak[4] = 0; 
		aukeratutakoak[5] = 0; 
		aukeratutakoak[6] = 0; 
		aukeratutakoak[7] = 1; 
		aukeratutakoak[8] = 0; 
		aukeratutakoak[9] = 0; 

		
		metodos.arrayaDirua(aukeratutakoak);
		
		String esperotakoa = ""+"<html>"+"1"+"€"+"<br><html>";
		
		assertEquals(esperotakoa, metodos.arrayaDirua(aukeratutakoak));	
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
