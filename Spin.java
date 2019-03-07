package KermisApp;

public class Spin extends RisicoVolleAttracties implements GokAttractie{
	private int gereserveerdBedrag =0;
	
	////   CONSTRUCTOR   \\\\
	Spin(String naam, int prijs) {
		super(naam, prijs);
	}
	
	////	HA-HA-HA...SLOWCLAP	\\\\
	public String lachenMan() {
		String lachen;
		ongelukken = random.nextInt(300);
		if(Kermis.getEten()>0) {
			lachen  = "BhaAaaARF \nHad ik nou maar niet dat eten gekocht";
		}else {
			lachen = "whoOwHoWOOhooo.... \nnu ben ik duizelig....";
		}
		return lachen 	 + "\nEr zijn pas " + this.ongelukken + " ongelukken gebeurd met deze attractie.";
	}
	
	@Override
	public int draaiLimiet() {
		return 5;
	}

	@Override
	boolean opstellingskeuring() {
		this.opstellingskeuring = true;
		return opstellingskeuring;
	}
	
	@Override
	
	public void onderhoudsbeurtNodig() {
		if(this.getKaartjes() % 5 == 0) {
			onderhoudsbeurtNodig = true;
		}else {
			onderhoudsbeurtNodig = false;
		}
	}

	//_-_-_-_-_-_-_-_-_-_-___KANSSPELBESLASTING___-_-_-_-_-_-_-_-_-_-_\\
	public int kansSpelBelastingBetalen(int kassa){
		gereserveerdBedrag += (this.getPrijs()*0.3);
//		System.out.println("kassa is "+ (this.getPrijs() - (this.getPrijs()*0.3))); // check of berekening klopt
		kassa += (this.getPrijs() - (this.getPrijs()*0.3));
		return kassa;
	}
	
	////	GETTER BELASTING GERESERVEERD		\\\\
	public int getGereserveerdBedrag() {
		return gereserveerdBedrag;
	}
	
}
