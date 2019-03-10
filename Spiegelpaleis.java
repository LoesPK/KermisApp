package KermisApp;

public class Spiegelpaleis extends Attractie{
	private int gereserveerdBedrag =0;
	
	Spiegelpaleis(String naam, int prijs) {
		super(naam, prijs);
	}

	////	HA-HA-HA...SLOWCLAP	\\\\
	public String lachenMan() {
		String lachen = "AAAAH da's schrikken!! \n\nJe eigen gezicht.";
		return lachen;
	}
}
