package calculadoras;

import models.*;

/**
 * CalculadoraNutrientesMujer es la clase que calcula los nutrientes adecuados si la persona es mujer
 * 
 * @author Raul
 */

public class CalculadoraNutrientesMujer extends CalculadoraNutrientes{
	/**
	 * Inicializando las variables que se declararan posteriormente dependiendo de la edad
	 * 
	 */
	private double cantidadEnergiaAdecuada;//(kcal)
	private double cantidadCalcioAdecuada;//(mg)
	private double cantidadHierroAdecuada;//(mg)
	private double cantidadProteinasAdecuada;//(g)
	private int edadPersona;
	private double cantidadGrasasAdecuada;//(kcal)
	private double cantidadGrasasSaturadasAdecuada;//(kcal)
	private double cantidadHidratosCarbonoMinimaAdecuada;//(kcal)
	private double cantidadHidratosCarbonoMaximaAdecuada;//(kcal)
	private double cantidadAzucarAdecuada;//(kcal)

	/**
	 * Este metodo sirve para cambiar porcentualmente la energia adecuada dependiendo de la actividad física
	 * Si es LEVE se resta un 10%, si es intensa se suma un 20% y si es moderada no se modifica
	 *  
	 * @param El parametro persona es la persona sobre la que estamos haciendo el calculo y en este caso se necesita 
	 * para ver el atributo ActividadFisica de esa persona y calcular en consecuencia
	 * 
	 * @param El parametro cantidadEnergiaAdecuada como dice su propio nombre, es la cantidad de energia adecuada que declaramos
	 * en el programa dependiendo de la edad de la persona
	 * 
	 * @return El valor de retorno tambien es bastante autodescriptivo, pues es la cantidad de energia adecuada
	 * 
	 */
	public static double modificarEnergiaAdecuadoDependiendoActividadFisica(Persona persona, double cantidadEnergiaAdecuada) {
		if (persona.getActividadFisica().equals(ActividadFisica.LEVE)) {
			cantidadEnergiaAdecuada -= (cantidadEnergiaAdecuada * 0.1);
		}
		else if (persona.getActividadFisica().equals(ActividadFisica.INTENSA)) {
			cantidadEnergiaAdecuada += (cantidadEnergiaAdecuada * 0.2);
		}
		return cantidadEnergiaAdecuada;
	} 

	/**
	 * Este metodo sirve para comprovar si la energía total es mayor de la recomendada
	 *  
	 * @param El parametro cantidadEnergiaTotal es la cantidad de energia total que se saca de "solucion" (un objeto de la clase DistribucionMacronutrientes) 
	 * 
	 * @param El parametro cantidadEnergiaAdecuada es la cantidad de energia adecuada que declaramos
	 * en el programa dependiendo de la edad de la persona
	 * 
	 * @return El valor de retorno sera true si la cantidad de energia adecuada es mayor que la total y false si es menor
	 * 
	 */
	public static boolean comprobarSiCantidadEnergiaEsAdecuada(double cantidadEnergiaTotal, double cantidadEnergiaAdecuada) {
		if(cantidadEnergiaTotal < cantidadEnergiaAdecuada) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Este metodo sirve para comprovar si la cantidad de grasas totales es mayor de la recomendada
	 *  
	 * @param El parametro cantidadGrasasTotal es la cantidad de grasas totales que se saca de "solucion" (un objeto de la clase DistribucionMacronutrientes) 
	 * 
	 * @param El parametro cantidadGrasasAdecuada es la cantidad de grasas adecuada que declaramos
	 * en el programa dependiendo de la edad de la persona
	 * 
	 * @return El valor de retorno sera true si la cantidad de grasas adecuada es mayor que la total y false si es menor
	 * 
	 */
	public static boolean comprobarSiCantidadGrasasTotalesEsAdecuada(double cantidadGrasasTotal, double cantidadGrasasAdecuada) {
		if(cantidadGrasasTotal < cantidadGrasasAdecuada) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Este metodo sirve para comprovar si la cantidad de grasas saturadas totales es mayor de la recomendada
	 *  
	 * @param El parametro cantidadGrasasSaturadasTotal es la cantidad de grasas saturadas totales que se saca de "solucion" (un objeto de la clase DistribucionMacronutrientes) 
	 * 
	 * @param El parametro cantidadGrasasSaturadasAdecuada es la cantidad de grasas saturadas adecuada que declaramos
	 * en el programa dependiendo de la edad de la persona
	 * 
	 * @return El valor de retorno sera true si la cantidad de grasas saturadas adecuada es mayor que la total y false si es menor
	 * 
	 */
	public static boolean comprobarSiCantidadGrasasSaturadasEsAdecuada(double cantidadGrasasSaturadasTotal, double cantidadGrasasSaturadasAdecuada) {
		if(cantidadGrasasSaturadasTotal < cantidadGrasasSaturadasAdecuada) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Este metodo sirve para comprovar si la cantidad de sal total es mayor de la recomendada
	 *  
	 * @param El parametro cantidadSalTotal es la cantidad de sal totale que se saca de "solucion" (un objeto de la clase DistribucionMacronutrientes) 
	 * 
	 * @return El valor de retorno sera true si la cantidad de sal adecuada es mayor que la total y false si es menor
	 * 
	 */
	public static boolean comprobarSiCantidadSalEsAdecuada(double cantidadSalTotal) {
		if(cantidadSalTotal < 5) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Este metodo sirve para comprovar si la cantidad de hidratos de carbono total es mayor de la recomendada
	 *  
	 * @param El parametro cantidadHidratosCarbonoTotal es la cantidad de hidratos de carbono totale que se saca de "solucion" (un objeto de la clase DistribucionMacronutrientes) 
	 * 
	 * @param El parametro cantidadHidratosCarbonoMinimaAdecuada es la cantidad de hidratos de carbono adecuada minimas que declaramos
	 * en el programa dependiendo de la edad de la persona
	 * 
	 * @param El parametro cantidadHidratosCarbonoMaximaAdecuada es la cantidad de hidratos de carbono adecuada maxima que declaramos
	 * en el programa dependiendo de la edad de la persona
	 * 
	 * @return El valor de retorno sera true si la cantidad de hidratos de carbono adecuada es mayor que la total y false si es menor
	 * 
	 */
	public static boolean comprobarSiCantidadHidratosCarbonoEsAdecuada(double cantidadHidratosCarbonoTotal, double cantidadHidratosCarbonoMinimaAdecuada, double cantidadHidratosCarbonoMaximaAdecuada ) {
		if(cantidadHidratosCarbonoTotal > cantidadHidratosCarbonoMinimaAdecuada && cantidadHidratosCarbonoTotal < cantidadHidratosCarbonoMaximaAdecuada) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Este metodo sirve para comprovar si la cantidad de azucar totale es mayor de la recomendada
	 *  
	 * @param El parametro cantidadAzucarTotal es la cantidad de azucar totale que se saca de "solucion" (un objeto de la clase DistribucionMacronutrientes) 
	 * 
	 * @param El parametro cantidadAzucarAdecuada es la cantidad de azucar adecuada que declaramos
	 * en el programa dependiendo de la edad de la persona
	 * 
	 * @return El valor de retorno sera true si la cantidad de azucar adecuada es mayor que la total y false si es menor
	 * 
	 */
	public static boolean comprobarSiCantidadAzucarEsAdecuada(double cantidadAzucarTotal, double cantidadAzucarAdecuada ) {
		if(cantidadAzucarTotal < cantidadAzucarAdecuada) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Este metodo sirve para comprovar si la cantidad de calcio totale es mayor de la recomendada
	 *  
	 * @param El parametro cantidadCalcioTotal es la cantidad de calcio totale que se saca de "solucion" (un objeto de la clase DistribucionMacronutrientes) 
	 * 
	 * @param El parametro cantidadCalcioAdecuada es la cantidad de calcio adecuada que declaramos
	 * en el programa dependiendo de la edad de la persona
	 * 
	 * @return El valor de retorno sera true si la cantidad de calico adecuada es mayor que la total y false si es menor
	 * 
	 */
	public static boolean comprobarSiCantidadCalcioEsAdecuada(double cantidadCalcioTotal, double cantidadCalcioAdecuada ) {
		if(cantidadCalcioTotal < cantidadCalcioAdecuada) {
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * Este metodo sirve para comprovar si la cantidad de hierro totale es mayor de la recomendada
	 *  
	 * @param El parametro cantidadHierroTotal es la cantidad de hierro totale que se saca de "solucion" (un objeto de la clase DistribucionMacronutrientes) 
	 * 
	 * @param El parametro cantidadHierroAdecuada es la cantidad de hierro adecuada que declaramos
	 * en el programa dependiendo de la edad de la persona
	 * 
	 * @return El valor de retorno sera true si la cantidad de hierro adecuada es mayor que la total y false si es menor
	 * 
	 */
	public static boolean comprobarSiCantidadHierroEsAdecuada(double cantidadHierroTotal, double cantidadHierroAdecuada ) {
		if(cantidadHierroTotal < cantidadHierroAdecuada) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Este metodo sirve para comprovar si la cantidad de proteinas totale es mayor de la recomendada
	 *  
	 * @param El parametro cantidadProteinasTotal es la cantidad de proteinas totale que se saca de "solucion" (un objeto de la clase DistribucionMacronutrientes) 
	 * 
	 * @param El parametro cantidadProteinasAdecuada es la cantidad de proteinas adecuada que declaramos
	 * en el programa dependiendo de la edad de la persona
	 * 
	 * @return El valor de retorno sera true si la cantidad de proteinas adecuada es mayor que la total y false si es menor
	 * 
	 */
	public static boolean comprobarSiCantidadProteinasEsAdecuada(double cantidadProteinasTotal, double cantidadProteinasAdecuada ) {
		if(cantidadProteinasTotal < cantidadProteinasAdecuada) {
			return true;
		}
		else {
			return false;
		}
	}


	@Override
	public DistribucionNutrientes calculoHabitosCorrectos(Persona persona) {

		DistribucionNutrientes solucion = super.calculoIngestaDiaria(persona);

		if (persona.getEdad()>=0 && persona.getEdad()<=1) {
			cantidadEnergiaAdecuada = 950;
			cantidadCalcioAdecuada = 525;
			cantidadHierroAdecuada = 7;
			cantidadProteinasAdecuada = 20;
		}
		else if (persona.getEdad()>=1 && persona.getEdad()<=3) {
			cantidadEnergiaAdecuada = 1250;
			cantidadCalcioAdecuada = 600;
			cantidadHierroAdecuada = 7;
			cantidadProteinasAdecuada = 23;
		}
		else if (persona.getEdad()>=4 && persona.getEdad()<=5) {
			cantidadEnergiaAdecuada = 1700;
			cantidadCalcioAdecuada = 700;
			cantidadHierroAdecuada = 9;
			cantidadProteinasAdecuada = 30;
		}
		else if (persona.getEdad()>=6 && persona.getEdad()<=9) {
			cantidadEnergiaAdecuada = 2000;
			cantidadCalcioAdecuada = 800;
			cantidadHierroAdecuada = 9;
			cantidadProteinasAdecuada = 36;
		}
		else if (persona.getEdad()>=10 && persona.getEdad()<=12) {
			cantidadEnergiaAdecuada = 2300;
			cantidadCalcioAdecuada = 1300;
			cantidadHierroAdecuada = 18;
			cantidadProteinasAdecuada = 41;
		}
		else if (persona.getEdad()>=13 && persona.getEdad()<=15) {
			cantidadEnergiaAdecuada = 2500;
			cantidadCalcioAdecuada = 1300;
			cantidadHierroAdecuada = 18;
			cantidadProteinasAdecuada = 45;
		}
		else if (persona.getEdad()>=16 && persona.getEdad()<=19) {
			cantidadEnergiaAdecuada = 2300;
			cantidadCalcioAdecuada = 1300;
			cantidadHierroAdecuada = 18;
			cantidadProteinasAdecuada = 43;
		}
		else if (persona.getEdad()>=20 && persona.getEdad()<=39) {
			cantidadEnergiaAdecuada = 2300;
			cantidadCalcioAdecuada = 1000;
			cantidadHierroAdecuada = 18;
			cantidadProteinasAdecuada = 41;
		}
		else if (persona.getEdad()>=40 && persona.getEdad()<=49) {
			cantidadEnergiaAdecuada = 2185;
			cantidadCalcioAdecuada = 1000;
			cantidadHierroAdecuada = 18;
			cantidadProteinasAdecuada = 41;
		}
		else if (persona.getEdad()>=50 && persona.getEdad()<=59) {
			cantidadEnergiaAdecuada = 2075;
			cantidadCalcioAdecuada = 1200;
			cantidadHierroAdecuada = 10;
			cantidadProteinasAdecuada = 41;
		}
		else if (persona.getEdad()>=60) {
			cantidadEnergiaAdecuada = 1875;
			cantidadCalcioAdecuada = 1200;
			cantidadHierroAdecuada = 10;
			cantidadProteinasAdecuada = 41;
		}

		//Cambiando porcentualmente la energia adecuada dependiendo de la actividad física
		//Si es LEVE se resta un 10%, si es intensa se suma un 20% y si es moderada no se modifica
		cantidadEnergiaAdecuada= modificarEnergiaAdecuadoDependiendoActividadFisica(persona, cantidadEnergiaAdecuada);

		//Comprobando si la energía total es mayor de la recomendada
		solucion.setCantidadEnergiaAdecuada(comprobarSiCantidadEnergiaEsAdecuada(solucion.getEnergiaTotal(), cantidadEnergiaAdecuada));

		//Declarando la cantidad de grasas adecuadas (el 30% de la energía total) 
		cantidadGrasasAdecuada = (cantidadEnergiaAdecuada*0.3);

		//Comprobando si las grasas totales es mayor de la recomendada
		solucion.setCantidadGrasasAdecuada(comprobarSiCantidadGrasasTotalesEsAdecuada(solucion.getGrasasTotales(), cantidadGrasasAdecuada));

		//Declarando la cantidad de grasa saturadas adecuadas (el 10% de la energía total) 
		cantidadGrasasSaturadasAdecuada = (cantidadEnergiaAdecuada*0.1);

		//Comprobando si las grasas saturadas totales es mayor de la recomendada
		solucion.setCantidadGrasasSaturadasAdecuada(comprobarSiCantidadGrasasSaturadasEsAdecuada(solucion.getGrasasSaturadasTotales(), cantidadGrasasSaturadasAdecuada));

		//Comprobando si la sal total es mayor de la recomendada (<5g)
		solucion.setCantidadSalAdecuada(comprobarSiCantidadSalEsAdecuada(solucion.getSalTotal()));

		//Declarando la cantidad de Hidratos de carbono adecuada (más de 45% y menos del 65% de la energía total) 
		cantidadHidratosCarbonoMinimaAdecuada = (cantidadEnergiaAdecuada*0.45);
		cantidadHidratosCarbonoMaximaAdecuada = (cantidadEnergiaAdecuada*0.65);

		//Comprobando si los Hidratos de carbono totales son mayor o menor que la recomendada 
		solucion.setCantidadHidratosCarbonoAdecuada(comprobarSiCantidadHidratosCarbonoEsAdecuada(solucion.getHidratosCarbonoTotales(), cantidadHidratosCarbonoMinimaAdecuada, cantidadHidratosCarbonoMaximaAdecuada));

		//Declarando la cantidad de Azucar adecuada (<10%) 
		cantidadAzucarAdecuada = (cantidadEnergiaAdecuada * 0.1);

		//Comprobando si el azucar total es mayor de la recomendada
		solucion.setCantidadAzucarAdecuada(comprobarSiCantidadAzucarEsAdecuada(solucion.getAzucarTotal(), cantidadAzucarAdecuada));

		//Comprobando si la cantidad de calcio total es mayor de la recomendada
		solucion.setCantidadCalcioAdecuada(comprobarSiCantidadCalcioEsAdecuada(solucion.getCalcioTotal(), cantidadCalcioAdecuada));

		//Comprobando si la cantidad de hierro total es mayor de la recomendada
		solucion.setCantidadHierroAdecuada(comprobarSiCantidadHierroEsAdecuada(solucion.getHierroTotal(), cantidadHierroAdecuada));

		//Comprobando si la cantidad de hierro total es mayor de la recomendada
		solucion.setCantidadProteinasAdecuada(comprobarSiCantidadProteinasEsAdecuada(solucion.getProteinasTotales(), cantidadProteinasAdecuada));

		return solucion;

	}

}
