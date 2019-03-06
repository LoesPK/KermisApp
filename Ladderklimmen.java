package weekOpdrachtKermis;

public class Ladderklimmen extends Attractie implements GokAttractie{
	private int gereserveerdBedrag =0;
	
	Ladderklimmen(String naam, int prijs) {
		super(naam, prijs);
	}
	
	public int kansSpelBelastingBetalen(int kassa){
		gereserveerdBedrag += (this.getPrijs()*0.3);
//		System.out.println("kassa is "+ (this.getPrijs() - (this.getPrijs()*0.3))); // check of berekening klopt
		kassa += (this.getPrijs() - (this.getPrijs()*0.3));
		return kassa;
	}
	
	public int getGereserveerdBedrag() {
		return gereserveerdBedrag;
	}
	
}
