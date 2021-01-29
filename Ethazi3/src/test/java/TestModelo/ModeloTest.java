package TestModelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Modelo.Karrito;
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
	public void ezabatu() {

		Karrito sidra = new Karrito("Sidra", 0, 3);

		ArrayList<Karrito> aukera = new ArrayList<Karrito>(10);

		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);

		ArrayList<Karrito> esperotakoa = new ArrayList<Karrito>(10);

		assertEquals(esperotakoa, metodos.ezabatu(aukera));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void pantailatu() {

		Karrito sidra = new Karrito("Sidra", 1, 3);

		ArrayList<Karrito> aukera = new ArrayList<Karrito>(10);

		aukera.add(sidra);

		String esperotakoa = "<html>" + "x" + "1" + "    " + "Sidra" + "      " + "  " + "3" + "<br><html>";

		assertEquals(esperotakoa, metodos.pantailatu(aukera));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void sartu() {

		Karrito sidra = new Karrito("Sidra", 1, 3);

		ArrayList<Karrito> esperotakoa1 = new ArrayList<Karrito>(10);

		esperotakoa1.add(sidra);

		ArrayList<Karrito> aukera1 = new ArrayList<Karrito>(10);

		aukera1 = metodos.sartu("Sidra", 1, aukera1);

		Karrito esperotakoa = esperotakoa1.get(0);

		Karrito aukera = aukera1.get(0);

		assertEquals(aukera.getBalioa(), esperotakoa.getBalioa());
		assertEquals(aukera.getElikagaia(), esperotakoa.getElikagaia());
		assertEquals(aukera.getKopuru(), esperotakoa.getKopuru());

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void sartuDirua() {

		int esperotakoa = 9;

		assertEquals(esperotakoa, metodos.sartuDirua("Sidra", 3));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void DiruTotalak() {

		Karrito sidra = new Karrito("Sidra", 0, 3);

		ArrayList<Karrito> aukera = new ArrayList<Karrito>(10);

		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);

		int esperotakoa = 30;

		assertEquals(esperotakoa, metodos.diruTotala(aukera));

	}

}