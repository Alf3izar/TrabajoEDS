package trabajoEDS;

/**
 * Representa 100 gr de un alimento
 * 
 * @author Marta
 */
public class Alimento {	
	/**
	 * Nombre del alimento
	 */
	String nombre;
	
	/**
	 * Energia total del alimento. Debe introducirse en Kcal
	 */
	double energia;
	
	/**
	 * Hidratos de carbono totales del alimento. Debe introducirse en gr
	 */
	double hidratosCarbono;
	
	/**
	 * Azucar total del alimento. Debe introducirse en gr
	 */
	double azucar;
	
	/**
	 * Grasas totales del alimento. Deben introducirse en gr
	 */
	double grasas;
	
	/**
	 * Grasas saturadas totales del alimento. Deben introducirse en gr
	 * y su valor no puede exceder el de las grasas
	 */
	double grasasSaturadas;
	
	/**
	 * Proteinas totales del alimento. Debe introducirse en gr
	 */
	double proteinas;
	
	/**
	 * Sal total del alimento. Debe introducirse en gr
	 */
	double sal;
	
	/**
	 * Calcio total del alimento. Debe introducirse en mg
	 */
	double calcio;
	
	/**
	 * Hierro total del alimento. Debe introducirse en mg
	 */
	double hierro;
	
	/**
	 * Inicializa un nuevo objeto de la clase Alimento
	 */
	public Alimento() {}
	
	/**	 
	 * Devuelve el nombre del alimento
	 * 
	 * @return nombre del alimento
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve la energia total
	 * 
	 * @return energia total del alimento
	 */
	public double getEnergia() {
		return energia;
	}

	/**
	 * Devuelve los hidratos de carbono totales del alimento
	 * 
	 * @return hidratos de carbono totales del alimento
	 */
	public double getHidratosCarbono() {
		return hidratosCarbono;
	}

	/**
	 * Devuelve el azucar total del alimento	 
	 * 
	 * @return azucar total del alimento
	 */
	public double getAzucar() {
		return azucar;
	}

	/**
	 * Devuelve las grasas totales del alimento
	 * 
	 * @return grasas totales del alimento
	 */
	public double getGrasas() {
		return grasas;
	}

	/**
	 * Devuelve las grasas saturadas totales del alimento	 
	 * 
	 * @return grasas saturadas totales del alimento
	 */
	public double getGrasasSaturadas() {
		return grasasSaturadas;
	}

	/**
	 * Devuelve las proteinas totales del alimento
	 * 
	 * @return proteinas totales del alimento
	 */
	public double getProteinas() {
		return proteinas;
	}

	/**
	 * Devuelve la sal total del alimento
	 * 
	 * @return sal total del alimento
	 */
	public double getSal() {
		return sal;
	}	

	/**
	 * Devuelve el calcio total del alimento
	 * 
	 * @return calcio total del alimento
	 */
	public double getCalcio() {
		return calcio;
	}

	/**
	 * Devuelve el hierro total del alimento
	 * 
	 * @return hierro total del alimento
	 */
	public double getHierro() {
		return hierro;
	}

	/**
	 * Registra el nombre del alimento
	 * 
	 * @param nombre nombre del alimento a introducir
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Registra la energia del alimento
	 * La energia debe introducirse en kcal
	 * 
	 * @param kcal energia a introducir del alimento (en kcal)
	 */
	public void setEnergia(double kcal) {
		this.energia = kcal;
	}

	/**
	 * Registra los hidratos de carbono del alimento
	 * Los hidratos de carbono deben de introducirse en gr
	 * 
	 * @param hidratosCarbono hidratos de carbono a introducir del alimento (en gr)
	 */
	public void setHidratosCarbono(double hidratosCarbono) {
		this.hidratosCarbono = hidratosCarbono;
	}

	/**
	 * Registra el azucar del alimento
	 * El azucar debe introducirse en gr y su cantidad no puede exceder la de hidratos de carbono
	 * 
	 * @param azucar azucar a introducir del alimento (en gr)
	 */
	public void setAzucar(double azucar) {
		double hidratos = this.getHidratosCarbono();
		if(azucar < hidratos)
			this.azucar = azucar;
		else this.azucar = hidratos;
	}

	/**
	 * Registra las grasas del alimento
	 * Las grasas deben introducirse en gr
	 * 
	 * @param grasas grasas a introducir del alimento (en gr)
	 */
	public void setGrasas(double grasas) {
		this.grasas = grasas;
	}

	/**
	 * Registra las grasas saturadas del alimento
	 * Las grasas saturadas deben introducirse en gr y su cantidad no puede exceder la de las grasas
	 * 
	 * @param grasasSaturadas grasas saturadas a introducir del alimento (en gr)
	 */
	public void setGrasasSaturadas(double grasasSaturadas) {
		double grasas = this.getGrasas();
		if(grasasSaturadas < grasas)
			this.grasasSaturadas = grasasSaturadas;
		else this.grasasSaturadas = grasas;
	}

	/**
	 * Registra las proteinas del alimento
	 * Las proteinas deben introducirse en gr
	 * 
	 * @param proteinas proteinas a introducir del alimento (en gr)
	 */
	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}

	/**
	 * Registra la sal del alimento
	 * La sal debe introducirse en gr
	 * 
	 * @param sal sal a introducir del alimento (en gr)
	 */
	public void setSal(double sal) {
		this.sal = sal;
	}

	/**
	 * Registra el calcio del alimento
	 * El calcio debe introducirse en mg
	 * 
	 * @param calcio calcio a introducir del alimento (en mg)
	 */
	public void setCalcio(double calcio) {
		this.calcio = calcio;
	}

	/**
	 * Registra el hierro del alimento
	 * El hierro debe introducirse en mg
	 * 
	 * @param hierro hierro a introducir del alimento (en mg)
	 */
	public void setHierro(double hierro) {
		this.hierro = hierro;
	}
}
