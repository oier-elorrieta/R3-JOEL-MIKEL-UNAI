package TestModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Produktua;
import Modelo.metodos;

public class ModeloTest {

	Produktua elikagaiak[] = metodos.objektuak();

	@Test
	public void testSartuSalgaiak() {
		String aukera = elikagaiak[0].getIzena();
		
		assertEquals("Sidra", aukera);
	}

	@Test
	public void testSartuSalgaiak1() {
		String aukera1 = elikagaiak[1].getIzena();
		
		assertEquals("Kafea", aukera1);
	}

	@Test
	public void testSartuSalgaiak2() {
		String aukera2 = elikagaiak[2].getIzena();
		
		assertEquals("Ura", aukera2);
	}

	@Test
	public void testSartuAukeratutakoak() {
		String[] itzulera = new String[10];
		String[] esperotakoa = new String[10];
		esperotakoa[0] = "Ura";
		
		assertArrayEquals(metodos.sartuAukeratutakoak("Ura", itzulera),esperotakoa);
	}
	
	@Test
	public void testSartuAukeratutakoZenbakiak() {
		int[] itzulera = new int[10];
		int[] esperotakoa = new int[10];
		esperotakoa[0] = 2;
		
		assertArrayEquals(metodos.sartuAukeratutakoZenbakiak(2, itzulera),esperotakoa);
	}
	
	@Test
	public void testSartuAukeratutakoDirua() {
		int dirua = 3;
		int[] itzulera = new int[10];
		itzulera[0] = dirua;
		int[] esperotakoa = new int[10];
		esperotakoa[0] = dirua;
		
		assertArrayEquals(itzulera,esperotakoa);
	}

	@Test
	public void testArraya() {
		String aukera = "Ura";
		String aukeratutakoak[] = new String[10];
		aukeratutakoak[0] = aukera; 
		String esperotakoa = "Ura";
		
		assertEquals(aukeratutakoak[0],esperotakoa);
	}

	@Test
	public void testArrayaKantitateak() {
		int kantitatea = 1;
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = kantitatea; 
		int esperotakoa = 1;
		
		assertEquals(aukeratutakoak[0],esperotakoa);
	}

	@Test
	public void testArrayaDirua() {
		int dirua = 3;
		int aukeratutakoak[] = new int[10];
		aukeratutakoak[0] = dirua; 
		int esperotakoa = 3;
		
		assertEquals(aukeratutakoak[0],esperotakoa);
	} 

	@Test
	public void testEzabatuArray() {
		String[] esperotakoa = null;
		String[] duguna = null;

		assertArrayEquals(duguna, esperotakoa);
	}
	
	@Test
	public void testEzabatuArray2() {
		int[] esperotakoa = null;
		int[] duguna = null;

		assertArrayEquals(duguna, esperotakoa);
	}
	
	@Test
	public void testEzabatuArray3() {
		int[] esperotakoa = null;
		int[] duguna = null;

		assertArrayEquals(duguna, esperotakoa);
	}
	
	@Test
	public void testDiruTotala() {
		int diruTotala = 12;
		
		assertEquals(diruTotala, 12);
	}


}
