package weekOpdrachtKermis;

public class Spin extends RisicoVolleAttracties{

	
	////   CONSTRUCTOR   \\\\
	Spin(String naam, int prijs) {
		super(naam, prijs);
	}
	
	////	HA-HA-HA...SLOWCLAP	\\\\
	public String lachenMan() {
		String lachen;
		ongelukken = random.nextInt(300);
		if(Eetkraampje.getVerkochtEten()>0) {
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



}
