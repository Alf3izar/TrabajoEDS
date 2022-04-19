package calculable;

import java.util.ArrayList;

import trabajoEDS.Alimento;
import trabajoEDS.AlimentoCantidad;
import trabajoEDS.Persona;
import trabajoEDS.DistribucionMacronutrientes;

/**
 * Calculadora es la clase abstracta base para todas las calculadoras de macronutrientes
 * @author Marta
 *
 */
public abstract class Calculadora {
	/**
	 * Constante que representa 100gr
	 */
	final int ESTANDAR_GRAMOS = 100;	
		
	/**
	 * Constructor vacio
	 * Utilizado por los constructores de las subclases, normalmente implicito
	 */
	protected Calculadora() {}
	
	public abstract DistribucionMacronutrientes calculoHabitosCorrectos(Persona persona);
	
	/**
	 * Calcula y almacena en un objeto de la clase DesgloseMacronutrientes el desglose del total de macronutrientes ingeridos por una persona
	 * 
	 * @param persona persona a la que se va a realizar el calculo de los habitos correctos
	 * @return desglose del total de macronutrientes ingeridos por una persona
	 */
	protected DistribucionMacronutrientes calculoIngestaDiaria(Persona persona) {
		DistribucionMacronutrientes solucion = new DistribucionMacronutrientes();

		ArrayList<AlimentoCantidad> alimentosDiarios = persona.getAlimentosDiarios();
		
		double energiaTotal  = calculoEnergiaTotal(alimentosDiarios);		
		double grasasTotales = calculoGrasasTotales(alimentosDiarios);
		double azucarTotal   = calculoAzucarTotal(alimentosDiarios);
		double salTotal 	 = calculoSalTotal(alimentosDiarios);
				
		solucion.setEnergiaTotal(energiaTotal);
		solucion.setGrasasTotales(grasasTotales);
		solucion.setAzucarTotal(azucarTotal);
		solucion.setSalTotal(salTotal);

		return solucion;		
	}
		
	/**
	 * Calcula la suma total de energia consumida por una persona dado un ArrayList<AlimentoCantidad>
	 * Para obtener el total se hace una regla de tres por cada alimento entre los gramos consumidos y el ESTANDAR_GRAMOS
	 * 
	 * @param alimentosDiarios
	 * @return kcal totales ingeridas 
	 */
	private double calculoEnergiaTotal(ArrayList<AlimentoCantidad> alimentosDiarios) {		
		double total = 0;
		
		for(int i = 0; i < alimentosDiarios.size(); i++) {
			AlimentoCantidad alimentoCantidad = alimentosDiarios.get(i);
			
			Alimento alimento = alimentoCantidad.getAlimento();
			int gramosConsumidos = alimentoCantidad.getGramos();			
			double energia100gr = alimento.getEnergia();
			
			double energiaConsumida = (gramosConsumidos * energia100gr) / ESTANDAR_GRAMOS;
			total += energiaConsumida;
		}
		
		return total;
	}
	
	/**
	 * Calcula la suma total de grasas consumidas por una persona dado un ArrayList<AlimentoCantidad>
	 * Para obtener el total se hace una regla de tres por cada alimento entre los gramos consumidos y el ESTANDAR_GRAMOS
	 * 
	 * @param alimentosDiarios
	 * @return
	 */
	private double calculoGrasasTotales(ArrayList<AlimentoCantidad> alimentosDiarios) {
		double total = 0;
		
		for(int i = 0; i < alimentosDiarios.size(); i++) {
			AlimentoCantidad alimentoCantidad = alimentosDiarios.get(i);
			
			Alimento alimento = alimentoCantidad.getAlimento();
			int gramosConsumidos = alimentoCantidad.getGramos();			
			double grasas100gr = alimento.getGrasas();
			
			double grasasConsumidas = (gramosConsumidos * grasas100gr) / ESTANDAR_GRAMOS;
			total += grasasConsumidas;
		}
		
		return total;
	}

	/**
	 * Calcula la suma total del azucar consumido por una persona dado un ArrayList<AlimentoCantidad>
	 * Para obtener el total se hace una regla de tres por cada alimento entre los gramos consumidos y el ESTANDAR_GRAMOS 
	 * 
	 * @param alimentosDiarios
	 * @return
	 */
	private double calculoAzucarTotal(ArrayList<AlimentoCantidad> alimentosDiarios) {
		double total = 0;
		
		for(int i = 0; i < alimentosDiarios.size(); i++) {
			AlimentoCantidad alimentoCantidad = alimentosDiarios.get(i);
			
			Alimento alimento = alimentoCantidad.getAlimento();
			int gramosConsumidos = alimentoCantidad.getGramos();			
			double azucar100gr = alimento.getAzucar();
			
			double azucarConsumido = (gramosConsumidos * azucar100gr) / ESTANDAR_GRAMOS;
			total += azucarConsumido;
		}
		
		return total;
	}

	/**
	 * Calcula la suma total de la sal consumida por una persona dado un ArrayList<AlimentoCantidad>
	 * Para obtener el total se hace una regla de tres por cada alimento entre los gramos consumidos y el ESTANDAR_GRAMOS
	 * 
	 * @param alimentosDiarios
	 * @return
	 */
	private double calculoSalTotal(ArrayList<AlimentoCantidad> alimentosDiarios) {
		double total = 0;
		
		for(int i = 0; i < alimentosDiarios.size(); i++) {
			AlimentoCantidad alimentoCantidad = alimentosDiarios.get(i);
			
			Alimento alimento = alimentoCantidad.getAlimento();
			int gramosConsumidos = alimentoCantidad.getGramos();			
			double sal100gr = alimento.getSal();
			
			double salConsumida = (gramosConsumidos * sal100gr) / ESTANDAR_GRAMOS;
			total += salConsumida;
		}
		
		return total;
	}
}
