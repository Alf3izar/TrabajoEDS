package calculable;

import java.util.ArrayList;

import trabajoEDS.*;

public class CalculadoraMujer extends Calculadora{
	@Override
	public DistribucionMacronutrientes calculoHabitosCorrectos(Persona persona) {
		DistribucionMacronutrientes solucion = super.calculoIngestaDiaria(persona);
		final int CANTIDAD_ENERGIA_ADECUADA = 2200;
		
		if(solucion.getEnergiaTotal() < CANTIDAD_ENERGIA_ADECUADA) {
			solucion.setCantidadEnergiaAdecuada(true);
		}
		
		//obtener 30% 
		int cantidadAzucarAdecuada = (CANTIDAD_ENERGIA_ADECUADA * 30)/100;
		if(solucion.getAzucarTotal() < cantidadAzucarAdecuada) {
			solucion.setCantidadAzucarAdecuado(true);
		}
		
		return solucion;
	}
		
}
