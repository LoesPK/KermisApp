package weekOpdrachtKermis;

public class Spin extends RisicoVolleAttracties implements GokAttractie{
	private int gereserveerdBedrag =0;
	
	Spin(String naam, int prijs) {
		super(naam, prijs);
	}
	
	@Override
	public int draaiLimiet() {
		return 5;
	}

	@Override
	boolean opstellingskeuring() {
		return true;
	}
	
	@Override
	public void onderhoudsbeurtNodig() {
		if(this.getKaartjes() % 5 == 0) {
			onderhoudsbeurtNodig = true;
		}else {
			onderhoudsbeurtNodig = false;
		}
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
