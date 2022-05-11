package models;
import java.util.ArrayList;

/**
 * Representa una persona
 * 
 * @author Marta
 *
 */
public class Persona {
	/**
	 * Nombre de la persona
	 */
	private String nombre;
	
	/**
	 * Genero de la persona
	 */
	private Genero genero;
	
	/**
	 * Edad de la persona
	 */
	private int edad;
	
	/**
	 * Altura de la persona. Debe introducirse en cm
	 */
	private int altura;
	
	/**
	 * Peso de la persona. Debe introducirse en kg
	 */
	private double peso;
	
	/**
	 * Actividad fisica de la persona
	 */
	private ActividadFisica actividadFisica;
	
	/**
	 * Lista de alimentos y cantidades correspondientes consumidas por la persona en un dia
	 */
	private ArrayList<AlimentoCantidad> alimentosDiarios;	
	
	/**
	 * Devuelve el nombre de la persona
	 * 
	 * @return nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Devuelve el genero de la persona
	 * 
	 * @return genero de la persona
	 */
	public Genero getGenero() {
		return genero;
	}
	
	/**
	 * Devuelve la edad de la persona
	 * 
	 * @return edad de la persona
	 */
	public int getEdad() {
		return edad;
	}
	
	/**
	 * Devuelve la altura de la persona en cm
	 * 
	 * @return altura de la persona (en cm)
	 */
	public int getAltura() {
		return altura;
	}
	
	/**
	 * Devuelve el peso de la persona en kg
	 * 
	 * @return peso de la persona (en kg)
	 */
	public double getPeso() {
		return peso;
	}
	
	/**
	 * Devuelve la actividad fisica realizada por la persona
	 * 
	 * @return actividad fisica realizada por la persona
	 */
	public ActividadFisica getActividadFisica() {
		return actividadFisica;
	}
	
	/**
	 * Devuelve una lista de alimentos y cantidad correspondiente consumidos por la persona en un dia
	 * 
	 * @return ArrayList de alimentos y cantidad correspondiente consumidos por la persona en un dia
	 */
	public ArrayList<AlimentoCantidad> getAlimentosDiarios() {
		return alimentosDiarios;
	}
	
	/**
	 * Calcula el IMC de la persona
	 * 
	 * @return IMC de la persona
	 */
	public double getImc() {
		double estaturaMetros = (double)this.getAltura() / 100;
		double imc = this.getPeso() / (estaturaMetros * estaturaMetros);
		return imc;
	}
	
	/**
	 * Registra el nombre de la persona
	 * 
	 * @param nombre nombre de la persona a introducir
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Registra el genero de la persona
	 * 
	 * @param genero genero de la persona a introducir
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	/**
	 * Registra la edad de la persona
	 * 
	 * @param edad edad de la persona a introducir
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	/**
	 * Registra la altura de la persona en cm
	 * @param altura a asignar (en cm)
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	/**
	 * Registra el peso de la persona en kg
	 * 
	 * @param peso peso a asignar (en kg)
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	/**
	 * Registra la actividad fisica realizada por la persona
	 * 
	 * @param actividadFisica actividad fisica realizada por la persona a introducir
	 */
	public void setActividadFisica(ActividadFisica actividadFisica) {
		this.actividadFisica = actividadFisica;
	}
	
	/**
	 * Registra el listado de alimentos y cantidad correspondiente consumidos por la persona en un dia
	 * 
	 * @param alimentosDiarios ArrayList a introducir de alimentos y cantidad correspondiente consumidos por la persona en un dia
	 */
	public void setAlimentosDiarios(ArrayList<AlimentoCantidad> alimentosDiarios) {
		this.alimentosDiarios = alimentosDiarios;
	}
	
	
}
