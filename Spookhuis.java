package weekOpdrachtKermis;

public class Spookhuis extends Attractie{

	////   CONSTRUCTOR   \\\\
	Spookhuis(String naam, int prijs) {
		super(naam, prijs);
	}
	
	////	HA-HA-HA...SLOWCLAP	\\\\
	public String lachenMan() {
		String lachen = "kijk... een spook \n eng enzo.";
		return lachen;
	}

}
