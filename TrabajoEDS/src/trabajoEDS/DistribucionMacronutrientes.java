package trabajoEDS;

/**
 * Representa la distribucion de los macronutrientes totales y estas cantidades son adecuadas o no
 * 
 * @author Marta
 */
public class DistribucionMacronutrientes {	
	double energiaTotal;
	double grasasTotales;
	double azucarTotal;
	double salTotal;
	double calcioTotal;
	double hierroTotal;
	boolean cantidadEnergiaAdecuada;
	boolean cantidadGrasasAdecuada;
	boolean cantidadAzucarAdecuado;
	boolean cantidadSalAdecuada;
	boolean cantidadCalcioAdecuada;
	boolean cantidadHierroAdecuada;

	public double getEnergiaTotal() {
		return energiaTotal;
	}
	
	public double getGrasasTotales() {
		return grasasTotales;
	}
	
	public double getAzucarTotal() {
		return azucarTotal;
	}
	
	public double getSalTotal() {
		return salTotal;
	}
	
	public double getCalcioTotal() {
		return calcioTotal;
	}

	public double getHierroTotal() {
		return hierroTotal;
	}
	
	public boolean isCantidadEnergiaAdecuada() {
		return cantidadEnergiaAdecuada;
	}
	
	public boolean isCantidadGrasasAdecuada() {
		return cantidadGrasasAdecuada;
	}
	
	public boolean isCantidadAzucarAdecuado() {
		return cantidadAzucarAdecuado;
	}
	
	public boolean isCantidadSalAdecuada() {
		return cantidadSalAdecuada;
	}
	
	public boolean isCantidadCalcioAdecuada() {
		return cantidadCalcioAdecuada;
	}

	public boolean isCantidadHierroAdecuada() {
		return cantidadHierroAdecuada;
	}
	
	public void setEnergiaTotal(double energiaTotal) {
		this.energiaTotal = energiaTotal;
	}
	
	public void setGrasasTotales(double grasasTotales) {
		this.grasasTotales = grasasTotales;
	}
	
	public void setAzucarTotal(double azucarTotal) {
		this.azucarTotal = azucarTotal;
	}
	
	public void setSalTotal(double salTotal) {
		this.salTotal = salTotal;
	}
	
	public void setCalcioTotal(double calcioTotal) {
		this.calcioTotal = calcioTotal;
	}

	public void setHierroTotal(double hierroTotal) {
		this.hierroTotal = hierroTotal;
	}
	
	public void setCantidadEnergiaAdecuada(boolean cantidadEnergiaAdecuada) {
		this.cantidadEnergiaAdecuada = cantidadEnergiaAdecuada;
	}
	
	public void setCantidadGrasasAdecuada(boolean cantidadGrasasAdecuada) {
		this.cantidadGrasasAdecuada = cantidadGrasasAdecuada;
	}
	
	public void setCantidadAzucarAdecuado(boolean cantidadAzucarAdecuado) {
		this.cantidadAzucarAdecuado = cantidadAzucarAdecuado;
	}
	
	public void setCantidadSalAdecuada(boolean cantidadSalAdecuada) {
		this.cantidadSalAdecuada = cantidadSalAdecuada;
	}
	
	public void setCantidadCalcioAdecuada(boolean cantidadCalcioAdecuada) {
		this.cantidadCalcioAdecuada = cantidadCalcioAdecuada;
	}

	public void setCantidadHierroAdecuada(boolean cantidadHierroAdecuada) {
		this.cantidadHierroAdecuada = cantidadHierroAdecuada;
	}
		
}
