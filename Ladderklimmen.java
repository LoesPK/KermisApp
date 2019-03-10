package KermisApp;

public class Ladderklimmen extends Attractie implements GokAttractie{
	private int gereserveerdBedrag =0;
	
	////	CONSTRUCTOR		\\\\
	Ladderklimmen(String naam, int prijs) {
		super(naam, prijs);
	}
	
	////	HA-HA-HA...SLOWCLAP	\\\\
	public String lachenMan() {
		String lachen = "Boe!! \nNiet vallen hoor. \nHe als je daar toch staat, haal de dakgoot gelijk effe leeg.";
		return lachen;
	}
	
	//_-_-_-_-_-_-_-_-_-_-___KANSSPELBESLASTING___-_-_-_-_-_-_-_-_-_-_\\
	public int kansSpelBelastingBetalen(int kassa){
		gereserveerdBedrag += (this.getPrijs()*0.3);
//		System.out.println("kassa is "+ (this.getPrijs() - (this.getPrijs()*0.3))); // check of berekening klopt
		kassa += (this.getPrijs() - (this.getPrijs()*0.3));
		return kassa;
	}
	
	////	GETTER & SETTER BELASTING GERESERVEERD		\\\\
	public int getGereserveerdBedrag() {
		return gereserveerdBedrag;
	}
	public void setGereserveerdBedrag(int g) {
		gereserveerdBedrag = g;
	}
	
}
