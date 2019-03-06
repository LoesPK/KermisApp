package weekOpdrachtKermis;

public class Ladderklimmen extends Attractie implements GokAttractie{
	private double gereserveerdBedrag =0;
	
	Ladderklimmen(String naam, double prijs) {
		super(naam, prijs);
	}
	
	public double kansSpelBelastingBetalen(double kassa){
		gereserveerdBedrag += (this.getPrijs()*0.3);
//		System.out.println("kassa is "+ (this.getPrijs() - (this.getPrijs()*0.3))); // check of berekening klopt
		kassa += (this.getPrijs() - (this.getPrijs()*0.3));
		return kassa;
	}
	
	public double getGereserveerdBedrag() {
		return gereserveerdBedrag;
	}
	
}
