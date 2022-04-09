package trabajoEDS;

/**
 * Representa 100 gr de un alimento
 * 
 * @author Marta
 */
public class Alimento {	
	String nombre;
	/**
	 * La energia debe introducirse en kcal
	 */
	double energia;
	double hidratosCarbono;
	double azucar;
	double grasas;
	double grasasSaturadas;
	double proteinas;
	double sal;
	/**
	 * El calcio debe introducirse en mg
	 */
	double calcio;
	/**
	 * El hierro debe introducirse en mg
	 */
	double hierro;
	
	public String getNombre() {
		return nombre;
	}

	public double getEnergia() {
		return energia;
	}

	public double getHidratosCarbono() {
		return hidratosCarbono;
	}

	public double getAzucar() {
		return azucar;
	}

	public double getGrasas() {
		return grasas;
	}

	public double getGrasasSaturadas() {
		return grasasSaturadas;
	}

	public double getProteinas() {
		return proteinas;
	}

	public double getSal() {
		return sal;
	}	

	public double getCalcio() {
		return calcio;
	}

	public double getHierro() {
		return hierro;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEnergia(double kcal) {
		this.energia = kcal;
	}

	public void setHidratosCarbono(double hidratosCarbono) {
		this.hidratosCarbono = hidratosCarbono;
	}

	/**
	 * Asigna la cantidad de azucar. Si el valor introducido es mayor al de los hidratos de carbono se asigna el valor de los hidratos.
	 * @param azucar
	 */
	public void setAzucar(double azucar) {
		double hidratos = this.getHidratosCarbono();
		if(azucar < hidratos)
			this.azucar = azucar;
		else this.azucar = hidratos;
	}

	public void setGrasas(double grasas) {
		this.grasas = grasas;
	}

	/**
	 * Asigna la cantidad de grasas saturadas. Si el valor introducido es mayor al de las grasas se asigna el valor de las grasas.
	 * @param grasasSaturadas
	 */
	public void setGrasasSaturadas(double grasasSaturadas) {
		double grasas = this.getGrasas();
		if(grasasSaturadas < grasas)
			this.grasasSaturadas = grasasSaturadas;
		else this.grasasSaturadas = grasas;
	}

	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public void setCalcio(double calcio) {
		this.calcio = calcio;
	}

	public void setHierro(double hierro) {
		this.hierro = hierro;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
