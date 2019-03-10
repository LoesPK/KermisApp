package KermisApp;

import java.util.Random;

abstract class RisicoVolleAttracties extends Attractie{
	Random random = new Random();
	int ongelukken = 0;
	protected boolean keuringGehad = false;
	
	protected boolean opstellingskeuring = false;
	boolean onderhoudsbeurtNodig = false;
	
	////   SUPER CONSTRUCTOR   \\\\
	RisicoVolleAttracties(String naam, int prijs) {
		super(naam, prijs);
	}
	
	////	HA-HA-HA...SLOWCLAP	\\\\
	public String lachenMan() {
		String lachen = "";
		return lachen;
	}
	

	
	abstract boolean opstellingskeuring();
	abstract int draaiLimiet();
	abstract void onderhoudsbeurtNodig();
}
