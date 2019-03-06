package weekOpdrachtKermis;

public class Spiegelpaleis extends Attractie  implements GokAttractie{
	private int gereserveerdBedrag =0;
	
	Spiegelpaleis(String naam, int prijs) {
		super(naam, prijs);
	}

	////	HA-HA-HA...SLOWCLAP	\\\\
	public String lachenMan() {
		String lachen = "AAAAH da's schrikken!! \n\nJe eigen gezicht.";
		return lachen;
	}
	
	@Override
	public int kansSpelBelastingBetalen(int kassa) {
		gereserveerdBedrag += (this.getPrijs()*0.3);
//		System.out.println("kassa is "+ (this.getPrijs() - (this.getPrijs()*0.3))); // check of berekening klopt
		kassa += (this.getPrijs() - (this.getPrijs()*0.3));
		return kassa;
	}

	@Override
	public int getGereserveerdBedrag() {
		return gereserveerdBedrag;
	}
}
