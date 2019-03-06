package weekOpdrachtKermis;

public class Spin extends RisicoVolleAttracties{

	
	////   CONSTRUCTOR   \\\\
	Spin(String naam, int prijs) {
		super(naam, prijs);
	}
	
	////	HA-HA-HA...SLOWCLAP	\\\\
	public String lachenMan() {
		String lachen;
		if(Eetkraampje.getVerkochtEten()>0) {
			lachen  = "BhaAaaARF \n Had ik nou maar niet dat eten gekocht";
		}else {
			lachen = "whoOwHoWOOhooo.... \n nu ben ik duizelig....";
		}
		return lachen;
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
