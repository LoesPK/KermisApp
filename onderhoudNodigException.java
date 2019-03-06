package weekOpdrachtKermis;

public class onderhoudNodigException extends Exception{

	////	ERROR MESSAGE		\\\\
	@Override
	public String getMessage() {
		return " mag niet meer draaien en moet eerst gecontroleerd worden.";
	}
	
}
