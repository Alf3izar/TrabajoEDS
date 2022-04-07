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
	boolean cantidadEnergiaAdecuada;
	boolean cantidadGrasasAdecuada;
	boolean cantidadAzucarAdecuado;
	boolean cantidadSalAdecuada;
	
	
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
	
	public void setCantidadEnergiaAdecuada(boolean cantidadEnergiaAdecuada) {
		this.cantidadEnergiaAdecuada = cantidadEnergiaAdecuada;
	}
	
	public void setCantidadGrasasAdecuadas(boolean cantidadGrasasAdecuada) {
		this.cantidadGrasasAdecuada = cantidadGrasasAdecuada;
	}
	
	public void setCantidadAzucarAdecuado(boolean cantidadAzucarAdecuado) {
		this.cantidadAzucarAdecuado = cantidadAzucarAdecuado;
	}
	
	public void setCantidadSalAdecuada(boolean cantidadSalAdecuada) {
		this.cantidadSalAdecuada = cantidadSalAdecuada;
	}
		
}
