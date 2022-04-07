package trabajoEDS;
import java.util.ArrayList;

/**
 * Representa una persona
 * 
 * @author Marta
 *
 */
public class Persona {
	String nombre;
	Genero genero;
	int edad;
	/**
	 * La altura debe introducirse en cm
	 */
	int altura;
	/**
	 * El peso debe introducirse en kg
	 */
	double peso;
	ActividadFisica actividadFisica;
	ArrayList<AlimentoCantidad> alimentosDiarios;	
	
	
	public String getNombre() {
		return nombre;
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public ActividadFisica getActividadFisica() {
		return actividadFisica;
	}
	
	public ArrayList<AlimentoCantidad> getAlimentosDiarios() {
		return alimentosDiarios;
	}
	
	public double getImc() {
		double estaturaMetros = (double)this.getAltura() / 100;
		double imc = this.getPeso() / (estaturaMetros * estaturaMetros);
		return imc;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	/**
	 * Asigna la altura (cm)
	 * @param altura
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	/**
	 * Asigna el peso (kg)
	 * @param peso
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setActividadFisica(ActividadFisica actividadFisica) {
		this.actividadFisica = actividadFisica;
	}
	
	public void setAlimentosDiarios(ArrayList<AlimentoCantidad> alimentosDiarios) {
		this.alimentosDiarios = alimentosDiarios;
	}
	
	
}
