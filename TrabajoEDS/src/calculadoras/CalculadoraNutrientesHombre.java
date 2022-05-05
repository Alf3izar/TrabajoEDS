package calculadoras;

import models.*;

public class CalculadoraNutrientesHombre extends CalculadoraNutrientes{
	@Override
	public DistribucionMacronutrientes calculoHabitosCorrectos(Persona persona) {
		// TODO Auto-generated method stub

		DistribucionMacronutrientes solucion = super.calculoIngestaDiaria(persona);

		//Inicializando la cantidad de energía adecuada dependiendo de la edad
		double CANTIDAD_ENERGIA_ADECUADA = 0;//(kcal)
		double CANTIDAD_CALCIO_ADECUADA = 0;//(mg)
		double CANTIDAD_HIERRO_ADECUADA = 0;//(mg)
		double CANTIDAD_PROTEINAS_ADECUADA = 0;//(g)
		
		if (persona.getEdad()>=0 && persona.getEdad()<=0.5) {
			CANTIDAD_ENERGIA_ADECUADA = 650;
			CANTIDAD_CALCIO_ADECUADA = 400;
			CANTIDAD_HIERRO_ADECUADA = 7;
			CANTIDAD_PROTEINAS_ADECUADA = 14;
		}
		else if (persona.getEdad()>=0.6 && persona.getEdad()<=0.9) {
			CANTIDAD_ENERGIA_ADECUADA = 950;
			CANTIDAD_CALCIO_ADECUADA = 525;
			CANTIDAD_HIERRO_ADECUADA = 7;
			CANTIDAD_PROTEINAS_ADECUADA = 20;
		}
		else if (persona.getEdad()>=1 && persona.getEdad()<=3) {
			CANTIDAD_ENERGIA_ADECUADA = 1250;
			CANTIDAD_CALCIO_ADECUADA = 600;
			CANTIDAD_HIERRO_ADECUADA = 7;
			CANTIDAD_PROTEINAS_ADECUADA = 23;
		}
		else if (persona.getEdad()>=4 && persona.getEdad()<=5) {
			CANTIDAD_ENERGIA_ADECUADA = 1700;
			CANTIDAD_CALCIO_ADECUADA = 700;
			CANTIDAD_HIERRO_ADECUADA = 9;
			CANTIDAD_PROTEINAS_ADECUADA = 30;
		}
		else if (persona.getEdad()>=6 && persona.getEdad()<=9) {
			CANTIDAD_ENERGIA_ADECUADA = 2000;
			CANTIDAD_CALCIO_ADECUADA = 800;
			CANTIDAD_HIERRO_ADECUADA = 9;
			CANTIDAD_PROTEINAS_ADECUADA = 36;
		}
		else if (persona.getEdad()>=10 && persona.getEdad()<=12) {
			CANTIDAD_ENERGIA_ADECUADA = 2450;
			CANTIDAD_CALCIO_ADECUADA = 1300;
			CANTIDAD_HIERRO_ADECUADA = 12;
			CANTIDAD_PROTEINAS_ADECUADA = 43;
		}
		else if (persona.getEdad()>=13 && persona.getEdad()<=15) {
			CANTIDAD_ENERGIA_ADECUADA = 2750;
			CANTIDAD_CALCIO_ADECUADA = 1300;
			CANTIDAD_HIERRO_ADECUADA = 15;
			CANTIDAD_PROTEINAS_ADECUADA = 54;
		}
		else if (persona.getEdad()>=16 && persona.getEdad()<=19) {
			CANTIDAD_ENERGIA_ADECUADA = 3000;
			CANTIDAD_CALCIO_ADECUADA = 1300;
			CANTIDAD_HIERRO_ADECUADA = 15;
			CANTIDAD_PROTEINAS_ADECUADA = 56;
		}
		else if (persona.getEdad()>=20 && persona.getEdad()<=39) {
			CANTIDAD_ENERGIA_ADECUADA = 3000;
			CANTIDAD_CALCIO_ADECUADA = 1000;
			CANTIDAD_HIERRO_ADECUADA = 10;
			CANTIDAD_PROTEINAS_ADECUADA = 54;
		}
		else if (persona.getEdad()>=40 && persona.getEdad()<=49) {
			CANTIDAD_ENERGIA_ADECUADA = 2850;
			CANTIDAD_CALCIO_ADECUADA = 1000;
			CANTIDAD_HIERRO_ADECUADA = 10;
			CANTIDAD_PROTEINAS_ADECUADA = 54;
		}
		else if (persona.getEdad()>=50 && persona.getEdad()<=59) {
			CANTIDAD_ENERGIA_ADECUADA = 2700;
			CANTIDAD_CALCIO_ADECUADA = 1000;
			CANTIDAD_HIERRO_ADECUADA = 10;
			CANTIDAD_PROTEINAS_ADECUADA = 54;
		}
		else if (persona.getEdad()>=60) {
			CANTIDAD_ENERGIA_ADECUADA = 1875;
			CANTIDAD_CALCIO_ADECUADA = 1200;
			CANTIDAD_HIERRO_ADECUADA = 10;
			CANTIDAD_PROTEINAS_ADECUADA = 54;
		}

		//Cambiando porcentualmente la energia adecuada dependiendo de la actividad física
		//Si es LEVE se resta un 10%, si es intensa se suma un 20% y si es moderada no se modifica
		if (persona.getActividadFisica().equals(ActividadFisica.LEVE)) {
			CANTIDAD_ENERGIA_ADECUADA -= (CANTIDAD_ENERGIA_ADECUADA * 10)/100;
		}
		else if (persona.getActividadFisica().equals(ActividadFisica.INTENSA)) {
			CANTIDAD_ENERGIA_ADECUADA += (CANTIDAD_ENERGIA_ADECUADA * 20)/100;
		}
		
		//Comprovando si la energía total es mayor de la recomendada
		if(solucion.getEnergiaTotal() < CANTIDAD_ENERGIA_ADECUADA) {
			solucion.setCantidadEnergiaAdecuada(true);
		}
		else {
			solucion.setCantidadEnergiaAdecuada(false);
		}

		//Inicializando la cantidad de grasas adecuadas (el 30% de la energía total) 
		double cantidadGrasasAdecuada = (CANTIDAD_ENERGIA_ADECUADA*0.3);

		//Comprovando si las grasas totales es mayor de la recomendada
		if(solucion.getGrasasTotales() < cantidadGrasasAdecuada) {
			solucion.setCantidadGrasasAdecuada(true);
		}
		else {
			solucion.setCantidadGrasasAdecuada(false);
		}

		//Inicializando la cantidad de grasa saturadas adecuadas (el 10% de la energía total) 
		double cantidadGrasasSaturadasAdecuada = (CANTIDAD_ENERGIA_ADECUADA*0.1);

		//Comprovando si las grasas saturadas totales es mayor de la recomendada
		if(solucion.getGrasasSaturadasTotales() < cantidadGrasasSaturadasAdecuada) {
			solucion.setCantidadGrasasSaturadasAdecuada(true);
		}
		else {
			solucion.setCantidadGrasasSaturadasAdecuada(false);
		}

		//Comprovando si la sal total es mayor de la recomendada (<5g)
		if(solucion.getSalTotal() < 5) {
			solucion.setCantidadSalAdecuada(true);
		}
		else {
			solucion.setCantidadSalAdecuada(false);
		}
		
		//Inicializando la cantidad de Hidratos de carbono adecuada (más de 45% y menos del 65% de la energía total) 
		double cantidadHidratosCarbonoMinimaAdecuada = (CANTIDAD_ENERGIA_ADECUADA*0.45);
		double cantidadHidratosCarbonoMaximaAdecuada = (CANTIDAD_ENERGIA_ADECUADA*0.65);
		
		//Comprovando si los Hidratos de carbono totales son mayor o menor que la recomendada 
		if(solucion.getHidratosCarbonoTotales() > cantidadHidratosCarbonoMinimaAdecuada && solucion.getHidratosCarbonoTotales() < cantidadHidratosCarbonoMaximaAdecuada) {
			solucion.setCantidadHidratosCarbonoAdecuada(true);
		}
		else {
			solucion.setCantidadHidratosCarbonoAdecuada(false);
		}
		
		//Inicializando la cantidad de Azucar adecuada (<10%) 
		double cantidadAzucarAdecuada = (CANTIDAD_ENERGIA_ADECUADA * 0.1);
		//Comprovando si el azucar total es mayor de la recomendada
		if(solucion.getAzucarTotal() < cantidadAzucarAdecuada) {
			solucion.setCantidadAzucarAdecuada(true);
		}
		
		//Comprovando si la cantidad de calcio total es mayor de la recomendada
		if(solucion.getCalcioTotal() < CANTIDAD_CALCIO_ADECUADA) {
			solucion.setCantidadCalcioAdecuada(true);
		}
		else {
			solucion.setCantidadCalcioAdecuada(false);
		}
		
		//Comprovando si la cantidad de hierro total es mayor de la recomendada
		if(solucion.getHierroTotal() < CANTIDAD_HIERRO_ADECUADA) {
			solucion.setCantidadHierroAdecuada(true);
		}
		else {
			solucion.setCantidadHierroAdecuada(false);
		}
		
		//Comprovando si la cantidad de hierro total es mayor de la recomendada
		if(solucion.getProteinasTotales() < CANTIDAD_PROTEINAS_ADECUADA) {
			solucion.setCantidadProteinasAdecuada(true);
		}
		else {
			solucion.setCantidadProteinasAdecuada(false);
		}

		return solucion;

	}
}
