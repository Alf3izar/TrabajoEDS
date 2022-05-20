package models;

/**
 * Representa la distribucion de los nutrientes totales consumidos en un dia y si estas cantidades son adecuadas o no
 * 
 * @author Marta
 */
public class DistribucionNutrientes {	
	/**
	 * Cantidad total de energia consumida en un dia
	 */
	private double energiaTotal;
	
	/**
	 * Cantidad total de hidratos de carbono consumida en un dia
	 */
	private double hidratosCarbonoTotales;
	
	/**
	 * Cantidad total de azucar consumida en un dia
	 */
	private double azucarTotal;
	
	/**
	 * Cantidad total de grasas consumida en un dia
	 */
	private double grasasTotales;
	
	/**
	 * Cantidad total de grasas saturadas consumida en un dia
	 */
	private double grasasSaturadasTotales;
	
	/**
	 * Cantidad total de proteinas consumida en un dia
	 */
	private double proteinasTotales;
	
	/**
	 * Cantidad total de sal consumida en un dia
	 */
	private double salTotal;
	
	/**
	 * Cantidad total de hierro consumida en un dia
	 */
	private double calcioTotal;
	
	/**
	 * Cantidad total de hierro consumida en un dia
	 */
	private double hierroTotal;
	
	
	/**
	 * Representa si la cantidad de energia es adecuada o no
	 */
	private boolean cantidadEnergiaAdecuada;
	
	/**
	 * Representa si la cantidad de hidratos de carbono es adecuada o no
	 */
	private boolean cantidadHidratosCarbonoAdecuada;
	
	/**
	 * Representa si la cantidad de azucar es adecuada o no
	 */
	private boolean cantidadAzucarAdecuada;
	
	/**
	 * Representa si la cantidad de grasas es adecuada o no
	 */
	private boolean cantidadGrasasAdecuada;
	
	/**
	 * Representa si la cantidad de grasas saturadas es adecuada o no
	 */
	private boolean cantidadGrasasSaturadasAdecuada;
	
	/**
	 * Representa si la cantidad de proteinas es adecuada o no
	 */
	private boolean cantidadProteinasAdecuada;
	
	/**
	 * Representa si la cantidad de sal es adecuada o no
	 */
	private boolean cantidadSalAdecuada;
	
	/**
	 * Representa si la cantidad de calcio es adecuada o no
	 */
	private boolean cantidadCalcioAdecuada;
	
	/**
	 * Representa si la cantidad de hierro es adecuada o no
	 */
	private boolean cantidadHierroAdecuada;
	
	/**
	 * Inicializa un nuevo objeto de la clase DistribucionMacronutrientes
	 */
	public DistribucionNutrientes() {}

	/**
	 * Devuelve la energia total consumida en kcal
	 * 
	 * @return energia total consumida (en kcal)
	 */
	public double getEnergiaTotal() {
		return energiaTotal;
	}
	
	/**
	 * Devuelve los hidratos de carbono totales consumidos en gr
	 * 
	 * @return hidratos de carbono totales consumidos (en gr)
	 */
	public double getHidratosCarbonoTotales() {
		return hidratosCarbonoTotales;
	}	
	
	/**
	 * Devuelve las grasas totales consumidas en gr
	 * 
	 * @return grasas totales consumidas (en gr)
	 */
	public double getGrasasTotales() {
		return grasasTotales;
	}
	
	/**
	 * Devuelve las grasas saturadas totales consumidas en gr
	 * 
	 * @return grasas saturadas totales consumidas (en gr)
	 */
	public double getGrasasSaturadasTotales() {
		return grasasSaturadasTotales;
	}	
	
	/**
	 * Devuelve el azucar total consumido en gr
	 * 
	 * @return azucar total consumido (en gr)
	 */
	public double getAzucarTotal() {
		return azucarTotal;
	}
	
	/**
	 * Devuelve las proteinas totales consumidas en gr
	 * 
	 * @return proteinas totales consumidas (en gr)
	 */
	public double getProteinasTotales() {
		return proteinasTotales;
	}
	
	/**
	 * Devuelve la sal total consumida en gr
	 * 
	 * @return sal total consumida (en gr)
	 */
	public double getSalTotal() {
		return salTotal;
	}
	
	/**
	 * Devuelve el calcio total consumido en mg
	 * 
	 * @return calcio total consumido (en mg)
	 */
	public double getCalcioTotal() {
		return calcioTotal;
	}

	/**
	 * Devuelve el hierro total consumido en mg
	 * 
	 * @return hierro total consumido (en mg)
	 */
	public double getHierroTotal() {
		return hierroTotal;
	}
	
	/**
	 * Devuelve si la cantidad total de energia consumida es adecuada o no
	 * 
	 * @return true si la cantidad total de energia consumida es adecuada, false si no lo es
	 */
	public boolean isCantidadEnergiaAdecuada() {		
		return cantidadEnergiaAdecuada;
	}
	
	/**
	 * Devuelve si la cantidad de grasas totales consumidas es adecuada o no
	 * 
	 * @return true si la cantidad de grasas totales consumidas es adecuada, false si no lo es
	 */
	public boolean isCantidadGrasasAdecuada() {
		return cantidadGrasasAdecuada;
	}
	
	/**
	 * Devuelve si la cantidad de grasas saturadas totales consumidas es adecuada o no
	 * 
	 * @return true si la cantidad total de grasas saturadas consumidas es adecuada, false si no lo es
	 */
	public boolean isCantidadGrasasSaturadasAdecuada() {
		return cantidadGrasasSaturadasAdecuada;
	}
	
	/**
	 * Devuelve si la cantidad de hidratos de carbono totales consumidos es adecuada o no
	 * 
	 * @return true si la cantidad total de hidratos de carbono consumidos es adecuada, false si no lo es
	 */
	public boolean isCantidadHidratosCarbonoAdecuada() {
		return cantidadHidratosCarbonoAdecuada;
	}
	
	/**
	 * Devuelve si la cantidad de azucar total consumido es adecuada o no
	 * 
	 * @return true si la cantidad de azucar total consumido es adecuada, false si no lo es
	 */
	public boolean isCantidadAzucarAdecuada() {
		return cantidadAzucarAdecuada;
	}
	
	/**
	 * Devuelve si la cantidad de proteinas totales consumidas es adecuada o no
	 * 
	 * @return true si la cantidad de proteinas total consumidas es adecuada, false si no lo es
	 */
	public boolean isCantidadProteinasAdecuada() {
		return cantidadProteinasAdecuada;
	}
	
	/**
	 * Devuelve si la cantidad de sal total consumida es adecuada o no
	 * 
	 * @return true si la cantidad de sal total consumida es adecuada, false si no lo es
	 */
	public boolean isCantidadSalAdecuada() {
		return cantidadSalAdecuada;
	}
	
	/**
	 * Devuelve si la cantidad de calcio total consumido es adecuada o no
	 * 
	 * @return true si la cantidad de calcio total consumido es adecuada, false si no lo es
	 */
	public boolean isCantidadCalcioAdecuada() {
		return cantidadCalcioAdecuada;
	}

	/**
	 * Devuelve si la cantidad de hierro total consumido es adecuada o no
	 * 
	 * @return true si la cantidad de hierro total consumido es adecuada, false si no lo es
	 */
	public boolean isCantidadHierroAdecuada() {
		return cantidadHierroAdecuada;
	}
		
	/**
	 * Registra la energia total consumida
	 * La energia debe introducirse en kcal
	 * 
	 * @param energiaTotal energia total consumida a introducir (en kcal)
	 */
	public void setEnergiaTotal(double energiaTotal) {
		this.energiaTotal = energiaTotal;
	}
	
	/**
	 * Registra los hidratos de carbono totales consumidos
	 * Los hidratos de carbono deben introducirse en gr
	 * 
	 * @param hidratosCarbonoTotales hidratos de carbono totales consumidos a introducir (en gr)
	 */
	public void setHidratosCarbonoTotales(double hidratosCarbonoTotales) {
		this.hidratosCarbonoTotales = hidratosCarbonoTotales;
	}
	
	/**
	 * Registra el azucar total consumido
	 * El azucar debe introducirse en gr
	 * 
	 * @param azucarTotal azucar total consumido a introducir (en gr)
	 */
	public void setAzucarTotal(double azucarTotal) {
		this.azucarTotal = azucarTotal;
	}
	
	/**
	 * Registra las grasas totales consumidas
	 * Las grasas deben introducirse en gr
	 * 
	 * @param grasasTotales grasas totales consumidas a introducir (en gr)
	 */
	public void setGrasasTotales(double grasasTotales) {
		this.grasasTotales = grasasTotales;
	}
	
	/**
	 * Registra las grasas saturadas totales consumidas
	 * Las grasas saturads deben introducirse en gr
	 * 
	 * @param grasasSaturadasTotales grasas saturadas totales consumidas a introducir (en gr)
	 */
	public void setGrasasSaturadasTotales(double grasasSaturadasTotales) {
		this.grasasSaturadasTotales = grasasSaturadasTotales;
	}
	
	/**
	 * Registra las proteinas totales consumidas
	 * Las proteinas deben introducirse en gr
	 * 
	 * @param proteinasTotales proteinas totales consumidas a introducir (en gr)
	 */
	public void setProteinasTotales(double proteinasTotales) {
		this.proteinasTotales = proteinasTotales;
	}
	
	/**
	 * Registra la sal total consumida
	 * La sal debe introducirse en gr
	 * 
	 * @param salTotal sal total consumida a introducir (en gr)
	 */
	public void setSalTotal(double salTotal) {
		this.salTotal = salTotal;
	}
	
	/**
	 * Registra el calcio total consumido
	 * El calcio debe introducirse en mg
	 * 
	 * @param calcioTotal calcio total consumido a introducir (en mg)
	 */
	public void setCalcioTotal(double calcioTotal) {
		this.calcioTotal = calcioTotal;
	}

	/**
	 * Registra el hierro total consumido
	 * El hierro debe introducirse en mg
	 * 
	 * @param hierroTotal hierro total consumido a introducir (en mg)
	 */
	public void setHierroTotal(double hierroTotal) {
		this.hierroTotal = hierroTotal;
	}
	
	/**
	 * Registra si la cantidad total de energia consumida es adecuada o no
	 * 
	 * @param cantidadEnergiaAdecuada true si la cantidad total de energia consumida es adecuada, si no false
	 */
	public void setCantidadEnergiaAdecuada(boolean cantidadEnergiaAdecuada) {
		this.cantidadEnergiaAdecuada = cantidadEnergiaAdecuada;
	}
	
	/**
	 * Registra si la cantidad total de hidratos de carbono consumidos es adecuada o no
	 * 
	 * @param cantidadHidratosCarbonoAdecuada true si la cantidad total de hidratos de carbono consumidos es adecuada, si no false
	 */
	public void setCantidadHidratosCarbonoAdecuada(boolean cantidadHidratosCarbonoAdecuada) {
		this.cantidadHidratosCarbonoAdecuada = cantidadHidratosCarbonoAdecuada;
	}
	
	/**
	 * Registra si la cantidad total de azucar consumida es adecuada o no
	 * 
	 * @param cantidadAzucarAdecuado true si la cantidad total de azucar consumida es adecuada, si no false
	 */
	public void setCantidadAzucarAdecuada(boolean cantidadAzucarAdecuado) {
		this.cantidadAzucarAdecuada = cantidadAzucarAdecuado;
	}
	
	/**
	 * Registra si la cantidad total de grasas consumidas es adecuada o no
	 * 
	 * @param cantidadGrasasAdecuada true si la cantidad total de grasas consumidas es adecuada, si no false
	 */
	public void setCantidadGrasasAdecuada(boolean cantidadGrasasAdecuada) {
		this.cantidadGrasasAdecuada = cantidadGrasasAdecuada;
	}
	
	/**
	 * Registra si la cantidad total de grasas saturadas consumidas es adecuada o no
	 * 
	 * @param cantidadGrasasSaturadasAdecuada true si la cantidad total de grasas saturadas consumidas es adecuada, si no false
	 */
	public void setCantidadGrasasSaturadasAdecuada(boolean cantidadGrasasSaturadasAdecuada) {
		this.cantidadGrasasSaturadasAdecuada = cantidadGrasasSaturadasAdecuada;
	}
	
	/**
	 * Registra si la cantidad total de proteinas consumidas es adecuada o no
	 * 
	 * @param cantidadProteinasAdecuada true si la cantidad total de proteinas consumidas es adecuada, si no false
	 */
	public void setCantidadProteinasAdecuada(boolean cantidadProteinasAdecuada) {
		this.cantidadProteinasAdecuada = cantidadProteinasAdecuada;
	}
	
	/**
	 * Registra si la cantidad total de sal consumida es adecuada o no
	 * 
	 * @param cantidadSalAdecuada true si la cantidad total de sal consumida es adecuada, si no false
	 */
	public void setCantidadSalAdecuada(boolean cantidadSalAdecuada) {
		this.cantidadSalAdecuada = cantidadSalAdecuada;
	}
	
	/**
	 * Registra si la cantidad total de calcio consumido es adecuada o no
	 * 
	 * @param cantidadCalcioAdecuada true si la cantidad total de calcio consumido es adecuada, si no false
	 */
	public void setCantidadCalcioAdecuada(boolean cantidadCalcioAdecuada) {
		this.cantidadCalcioAdecuada = cantidadCalcioAdecuada;
	}

	/**
	 * Registra si la cantidad total de hierro consumido es adecuada o no
	 * 
	 * @param cantidadHierroAdecuada true si la cantidad total de hierro consumido es adecuada, si no false
	 */
	public void setCantidadHierroAdecuada(boolean cantidadHierroAdecuada) {
		this.cantidadHierroAdecuada = cantidadHierroAdecuada;
	}
		
}
