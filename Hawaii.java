package KermisApp;

public class Hawaii extends RisicoVolleAttracties{
	
	////	CONSTRUCTOR		\\\\
	Hawaii(String naam, int prijs) {
		super(naam, prijs);
	}
	
	////	HA-HA-HA...SLOWCLAP	\\\\
	public String lachenMan() {
		ongelukken = random.nextInt(300);
		String lachen = "Nee... ik weet ook niet wat dit in godsnaam voor attractie is. Misschien wel Hula-hoopen...";
		return lachen + "\nEr zijn pas " + this.ongelukken + " ongelukken gebeurd met deze attractie.";
	}
	
	@Override
	public int draaiLimiet() {
		return 10;
	}

	@Override
	boolean opstellingskeuring() {
		return true;
	}
	
	@Override
	public void onderhoudsbeurtNodig() {
		if(this.getKaartjes()%10 == 0) {
			onderhoudsbeurtNodig = true;
		}else {
			onderhoudsbeurtNodig = false;
		}
	}
}
