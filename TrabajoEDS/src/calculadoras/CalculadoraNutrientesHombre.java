package calculadoras;

import models.*;



/**
 * CalculadoraNutrientesHombre es la clase que calcula los nutrientes adecuados si la persona es hombre.
 *
 * @author Raul
 */

public class CalculadoraNutrientesHombre extends CalculadoraNutrientes{
	
	/**
	 * Por alguna razon el JavaDoc da un error si no coloco un constructor vacio aqui y lo comento
	 */
	public CalculadoraNutrientesHombre() {
		
	}
	
	/** Inicializando las variables que se declararan posteriormente dependiendo de la edad. 
	 * 
	 * 
	 * La cantidad de energia adecuada*/
	private double cantidadEnergiaAdecuada;//(kcal)
	
	/** La cantidad calcio adecuada. */
	private double cantidadCalcioAdecuada;//(mg)
	
	/** La cantidad hierro adecuada. */
	private double cantidadHierroAdecuada;//(mg)
	
	/** La cantidad proteinas adecuada. */
	private double cantidadProteinasAdecuada;//(g)
	
	/** La edad persona. */
	private int edadPersona;
	
	/** La cantidad grasas adecuada. */
	private double cantidadGrasasAdecuada;//(kcal)
	
	/** La cantidad grasas saturadas adecuada. */
	private double cantidadGrasasSaturadasAdecuada;//(kcal)
	
	/** La cantidad hidratos carbono minima adecuada. */
	private double cantidadHidratosCarbonoMinimaAdecuada;//(kcal)
	
	/** La cantidad hidratos carbono maxima adecuada. */
	private double cantidadHidratosCarbonoMaximaAdecuada;//(kcal)
	
	/** La cantidad azucar adecuada. */
	private double cantidadAzucarAdecuada;//(kcal)
	
	/**
	 * Este metodo sirve para cambiar porcentualmente la energia adecuada dependiendo de la actividad física
	 * Si es LEVE se resta un 10%, si es intensa se suma un 20% y si es moderada no se modifica
	 *  
	 *
	 * @param persona the persona
	 * @param cantidadEnergiaAdecuada the cantidad energia adecuada
	 * @return El valor de retorno tambien es bastante autodescriptivo, pues es la cantidad de energia adecuada
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
	 * Este metodo sirve para comprobar si la energía total es mayor de la recomendada
	 *  
	 *
	 * @param cantidadEnergiaTotal the cantidad energia total
	 * @param cantidadEnergiaAdecuada the cantidad energia adecuada
	 * @return El valor de retorno sera true si la cantidad de energia adecuada es mayor que la total y false si es menor
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
	 * Este metodo sirve para comprobar si la cantidad de grasas totales es mayor de la recomendada
	 *  
	 *
	 * @param cantidadGrasasTotal the cantidad grasas total
	 * @param cantidadGrasasAdecuada the cantidad grasas adecuada
	 * @return El valor de retorno sera true si la cantidad de grasas adecuada es mayor que la total y false si es menor
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
	 * Este metodo sirve para comprobar si la cantidad de grasas saturadas totales es mayor de la recomendada
	 *  
	 *
	 * @param cantidadGrasasSaturadasTotal the cantidad grasas saturadas total
	 * @param cantidadGrasasSaturadasAdecuada the cantidad grasas saturadas adecuada
	 * @return El valor de retorno sera true si la cantidad de grasas saturadas adecuada es mayor que la total y false si es menor
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
	 * Este metodo sirve para comprobar si la cantidad de sal total es mayor de la recomendada
	 *  
	 *
	 * @param cantidadSalTotal the cantidad sal total
	 * @return El valor de retorno sera true si la cantidad de sal adecuada es mayor que la total y false si es menor
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
	 * Este metodo sirve para comprobar si la cantidad de hidratos de carbono total es mayor de la recomendada
	 *  
	 *
	 * @param cantidadHidratosCarbonoTotal the cantidad hidratos carbono total
	 * @param cantidadHidratosCarbonoMinimaAdecuada the cantidad hidratos carbono minima adecuada
	 * @param cantidadHidratosCarbonoMaximaAdecuada the cantidad hidratos carbono maxima adecuada
	 * @return El valor de retorno sera true si la cantidad de hidratos de carbono adecuada es mayor que la total y false si es menor
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
	 * Este metodo sirve para comprobar si la cantidad de azucar total es mayor de la recomendada
	 *  
	 *
	 * @param cantidadAzucarTotal the cantidad azucar total
	 * @param cantidadAzucarAdecuada the cantidad azucar adecuada
	 * @return El valor de retorno sera true si la cantidad de azucar adecuada es mayor que la total y false si es menor
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
	 * Este metodo sirve para comprobar si la cantidad de calcio total es mayor de la recomendada
	 *  
	 *
	 * @param cantidadCalcioTotal the cantidad calcio total
	 * @param cantidadCalcioAdecuada the cantidad calcio adecuada
	 * @return El valor de retorno sera true si la cantidad de calcio adecuada es mayor que la total y false si es menor
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
	 * Este metodo sirve para comprobar si la cantidad de hierro total es mayor de la recomendada
	 *  
	 *
	 * @param cantidadHierroTotal the cantidad hierro total
	 * @param cantidadHierroAdecuada the cantidad hierro adecuada
	 * @return El valor de retorno sera true si la cantidad de hierro adecuada es mayor que la total y false si es menor
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
	 * Este metodo sirve para comprobar si la cantidad de proteinas total es mayor de la recomendada
	 *  
	 *
	 * @param cantidadProteinasTotal the cantidad proteinas total
	 * @param cantidadProteinasAdecuada the cantidad proteinas adecuada
	 * @return El valor de retorno sera true si la cantidad de proteinas adecuada es mayor que la total y false si es menor
	 */
	public static boolean comprobarSiCantidadProteinasEsAdecuada(double cantidadProteinasTotal, double cantidadProteinasAdecuada ) {
		if(cantidadProteinasTotal < cantidadProteinasAdecuada) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Calculo habitos correctos.
	 *
	 * @param persona the persona
	 * @return the distribucion nutrientes
	 */
	@Override
	public DistribucionNutrientes calculoHabitosCorrectos(Persona persona) {
		// TODO Auto-generated method stub

		DistribucionNutrientes solucion = super.calculoIngestaDiaria(persona);
		edadPersona=persona.getEdad();
		
		if (edadPersona>=0 && edadPersona<1) {
			cantidadEnergiaAdecuada = 950;
			cantidadCalcioAdecuada = 525;
			cantidadHierroAdecuada = 7;
			cantidadProteinasAdecuada = 20;
		}
		else if (edadPersona>=1 && edadPersona<=3) {
			cantidadEnergiaAdecuada = 1250;
			cantidadCalcioAdecuada = 600;
			cantidadHierroAdecuada = 7;
			cantidadProteinasAdecuada = 23;
		}
		else if (edadPersona>=4 && edadPersona<=5) {
			cantidadEnergiaAdecuada = 1700;
			cantidadCalcioAdecuada = 700;
			cantidadHierroAdecuada = 9;
			cantidadProteinasAdecuada = 30;
		}
		else if (edadPersona>=6 && edadPersona<=9) {
			cantidadEnergiaAdecuada = 2000;
			cantidadCalcioAdecuada = 800;
			cantidadHierroAdecuada = 9;
			cantidadProteinasAdecuada = 36;
		}
		else if (edadPersona>=10 && edadPersona<=12) {
			cantidadEnergiaAdecuada = 2450;
			cantidadCalcioAdecuada = 1300;
			cantidadHierroAdecuada = 12;
			cantidadProteinasAdecuada = 43;
		}
		else if (edadPersona>=13 && edadPersona<=15) {
			cantidadEnergiaAdecuada = 2750;
			cantidadCalcioAdecuada = 1300;
			cantidadHierroAdecuada = 15;
			cantidadProteinasAdecuada = 54;
		}
		else if (edadPersona>=16 && edadPersona<=19) {
			cantidadEnergiaAdecuada = 3000;
			cantidadCalcioAdecuada = 1300;
			cantidadHierroAdecuada = 15;
			cantidadProteinasAdecuada = 56;
		}
		else if (edadPersona>=20 && edadPersona<=39) {
			cantidadEnergiaAdecuada = 3000;
			cantidadCalcioAdecuada = 1000;
			cantidadHierroAdecuada = 10;
			cantidadProteinasAdecuada = 54;
		}
		else if (edadPersona>=40 && edadPersona<=49) {
			cantidadEnergiaAdecuada = 2850;
			cantidadCalcioAdecuada = 1000;
			cantidadHierroAdecuada = 10;
			cantidadProteinasAdecuada = 54;
		}
		else if (edadPersona>=50 && edadPersona<=59) {
			cantidadEnergiaAdecuada = 2700;
			cantidadCalcioAdecuada = 1000;
			cantidadHierroAdecuada = 10;
			cantidadProteinasAdecuada = 54;
		}
		else if (edadPersona>=60) {
			cantidadEnergiaAdecuada = 2400;
			cantidadCalcioAdecuada = 1200;
			cantidadHierroAdecuada = 10;
			cantidadProteinasAdecuada = 54;
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
