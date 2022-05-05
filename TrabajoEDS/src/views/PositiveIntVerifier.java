package views;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase encargada de comprobar que el String introducido en un JTextField es un int positivo.
 * En caso de no serlo lanza mensajes de alerta para que el usuario reintroduzca un valor valido.
 *  
 * @author Marta
 *
 */
public class PositiveIntVerifier extends InputVerifier{

	@Override
	public boolean verify(JComponent input) {
		if(input instanceof JTextField) {
			JTextField textField = (JTextField) input;
			String text = textField.getText();
			
			if(text.isEmpty()) {
				return true;
			}
			
			return parse(input, text);
		}
		return true;
	}
	
	/**
	 * Intenta parsear el texto a double, si no puede devuelve false y lanza una alerta mediante un mensaje de dialogo
	 * 
	 * @param editor
	 * @param text
	 * @return true si se ha parseado, false no se ha parseado
	 */
	private boolean parse(JComponent input, String text) {
		String beautyText = beautifyText(text);
		try {
			int number = Integer.parseInt(beautyText);
			return checkPositiveNumber(input, number);
		}
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(input, "Por favor introduce un numero entero");
			return false;
		}
		
	}
	
	/**
	 * Comprueba si el numero es negativo. En caso de serlo lanza una alerta mediante un mensaje de dialogo y devuelve false
	 * 
	 * @param editor
	 * @param number
	 * @return false si el numero es negativo, true si el numero es positivo
	 */
	private boolean checkPositiveNumber(JComponent input, int number) {
		if(number < 0) {
			JOptionPane.showMessageDialog(input, "El numero no puede ser negativo");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Formatea el texto recibido quitando todos los espacios en blanco
	 * 
	 * @param text
	 * @return texto formateado
	 */
	private String beautifyText(String text) {
		String beautyText = text;
		beautyText = beautyText.replaceAll(" ", "");
		return beautyText;
	}

}
