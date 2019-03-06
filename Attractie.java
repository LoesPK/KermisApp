package weekOpdrachtKermis;

import java.util.ArrayList;

public class Attractie {
	Prompter prompter = new Prompter();
	private String naam;
	private double prijs;
	private double oppervlakte;
	private double kassa;
	private int aantalKaartjes;
	private boolean attractieDisabled;
	
	
	Attractie(String naam, double prijs){
		this.naam = naam;
		this.prijs = prijs;
	}
	
	String getNaam() {
		return this.naam;
	}
	
	double getKassa() {
		return this.kassa;
	}
	
	public double getPrijs() {
		return this.prijs;
	}
	
	public int getKaartjes() {
		return this.aantalKaartjes;
	}
	
	
	String draaien(int i) throws Exception{
		
		
		if(attractieDisabled) {
			return "Deze sttractie mag niet meer rijden";
		}


		if(this instanceof RisicoVolleAttracties) {
			RisicoVolleAttracties b = (RisicoVolleAttracties)this;
			while(b.onderhoudsbeurtNodig == false) {
				this.kassa+=this.prijs;
				this.aantalKaartjes++;
				System.out.println(this.aantalKaartjes);
				System.out.println(b.onderhoudsbeurtNodig);
				break;
			}
			while(b.getKaartjes() % 5 == 0 && b.onderhoudsbeurtNodig == false) { 
				b.onderhoudsbeurtNodig();
				System.out.println(b.onderhoudsbeurtNodig);
				throw new Exception(b.getNaam() + " mag niet meer draaien en moet eerst gecontroleerd worden.");
			}
			return this.naam + " draait";
		}//end if risicovol
		
		else {
			this.kassa+=this.prijs;
			this.aantalKaartjes++;
			return this.naam + " draait";
		}
			
	}
	
	
	void attractieDisabled(Attractie att) {
		attractieDisabled = true;
	}
	
}
