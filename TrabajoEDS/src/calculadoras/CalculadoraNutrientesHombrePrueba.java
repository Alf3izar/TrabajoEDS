package calculadoras;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculadoraNutrientesHombrePrueba extends CalculadoraNutrientesHombre {

	private static double cantidadEnergiaTotal;
	private static double cantidadEnergiaAdecuada;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cantidadEnergiaTotal = 2500;
		cantidadEnergiaAdecuada = 3000;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Pruebas finalizadas");
	}

	@Test
	void test() {
		boolean resultado = comprobarSiCantidadEnergiaEsAdecuada(cantidadEnergiaTotal, cantidadEnergiaAdecuada);
		assertEquals(true,resultado);
	}

}
