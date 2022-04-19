package trabajoEDS;

/**
 * Relaciona un Alimento con los gramos consumidos de este
 * 
 * @author Marta
 */
public class AlimentoCantidad {
	/**
	 * Objeto de la clase Alimento
	 */
	Alimento alimento;
	
	/**
	 * Gramos consumidos del alimento
	 */
	int gramos;
	
	/**
	 * Inicializa un nuevo objeto de la clase AlimentoCantidad 
	 * 
	 * @param alimento alimento consumido
	 * @param gramos gramos consumidos
	 */
	public AlimentoCantidad(Alimento alimento, int gramos){
		this.alimento = alimento;
		setGramos(gramos);
	}
	
	/**
	 * Devuelve los gramos consumidos del alimento
	 * 
	 * @return gramos consumidos del alimento
	 */
	public int getGramos() {
		return this.gramos;
	}
	
	/**
	 * Devuelve el alimento consumido
	 * 
	 * @return Alimento consumido
	 */
	public Alimento getAlimento() {
		return this.alimento;
	}
	
	/**
	 * Registra los gramos consumidos del alimento
	 * Los gramos no pueden ser menores que 0
	 * 
	 * @param gramos gramos consumidos a introducir
	 */
	public void setGramos(int gramos) {
		if(gramos > 0)
			this.gramos = gramos;
		else this.gramos = 0;
	}
	
}
