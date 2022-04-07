package trabajoEDS;

/**
 * Relaciona un Alimento con los gramos consumidos de este
 * 
 * @author Marta
 */
public class AlimentoCantidad {
	Alimento alimento;
	int gramos;
	
	public AlimentoCantidad(Alimento alimento, int gramos){
		this.alimento = alimento;
		setGramos(gramos);
	}
	
	public int getGramos() {
		return this.gramos;
	}
	
	public Alimento getAlimento() {
		return this.alimento;
	}
	
	public void setGramos(int gramos) {
		if(gramos > 0)
			this.gramos = gramos;
		else this.gramos = 0;
	}

	@Override
	public String toString() {
		return "AlimentoCantidad [alimento=" + alimento + ", gramos=" + gramos + "]";
	}
	
	
}
