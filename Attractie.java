package KermisApp;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Attractie {
	Prompter prompter = new Prompter();
	private String naam;
	private int prijs;
	private int kassa;
	private int aantalKaartjes;
	private boolean attractieDisabled;
	
	////   SUPER CONSTRUCTOR   \\\\
	Attractie(String naam, int prijs){
		this.naam = naam;
		this.prijs = prijs;
	}
	
	////   NAAM   \\\\
	String getNaam() {
		return this.naam;
	}
	////   KASSA   \\\\
	int getKassa() {
		return this.kassa;
	}
	void setKassa(int k) {
		this.kassa = k; 
	}
	
	////   PRIJS   \\\\
	public int getPrijs() {
		return this.prijs;
	}
	
	////   KAARTJES   \\\\
	public int getKaartjes() {
		return this.aantalKaartjes;
	}
	
	////   ATTRACTIE DISABELEN   \\\\	
	void attractieDisabled(Attractie att) {
		attractieDisabled = true;
	}
	
	
	////	HA-HA-HA...SLOWCLAP	\\\\
	public String lachenMan() {
		String lachen = "";
		return lachen;
	}
	
	
	//_-_-_-_-_-_-_-_-_-_-___ATTRACTIE LATEN DRAAIEN___-_-_-_-_-_-_-_-_-_-_\\
	String draaien() throws onderhoudNodigException{

		//----->___CONTROLE VOOR DISABLED ATTRACTIE (ALS NIET GEREPAREERD IS___<------\\
		while(attractieDisabled) {											// ------> zou eigenlijk nog mogelijkheid moeten zijn hem alsnog te repareren//
			return "Deze attractie mag niet meer rijden.";
		}
		
		
		
		//----->___ATTRACTIE RISICOVOL___<------\\
		if(this instanceof RisicoVolleAttracties || this instanceof GokAttractie) {						//--------> controleert of attractie risicovol is//
			System.out.println("kom je hier? 1");
			if(this instanceof RisicoVolleAttracties) {
				RisicoVolleAttracties r = (RisicoVolleAttracties)this;
				
				r.onderhoudsbeurtNodig();
				if(!r.onderhoudsbeurtNodig) {					//--------> als attractie risicovol is, maar geen onderhoudsbeurt nodig heeft mag hij rijden//
					System.out.println("geen onderhoud nodig");
				}
				
				//___wel onderhoudsbeurt nodig___\\
				else { 					//--------> als attractie risicovol is en onderhoudsbeurt nodig heeft, mag hij niet rijden en moet hij gecontroleerd worden//
					this.aantalKaartjes++;
					this.kassa+=this.prijs;
					throw new onderhoudNodigException();//throwt exception
				}
				
			}
			
			System.out.println("kom je hier? 2");
			
			if(this instanceof GokAttractie) {
				System.out.println("kom je hier gok?");
				GokAttractie g = (GokAttractie)this;
				this.kassa = g.kansSpelBelastingBetalen(this.kassa);
				if(this.aantalKaartjes%2 ==0 && this.aantalKaartjes!=0) { 							//--------> voor elke 13 kaartjes verkocht, wordt de belasting geïnd//
					System.err.println("De attractie moet een kansspelbelasting betalen van 15%");//
					Kermis.setKassa(Belastingadviseur.belastingInnen(Kermis.getKassa(), g.getGereserveerdBedrag()));
				}
			}
			
			
			
		}else {
			this.aantalKaartjes++;
			this.kassa+=this.prijs;
			System.out.println(this.aantalKaartjes + " " + this.kassa);
		}
//		this.aantalKaartjes++;
		return "Whieeeeee";
//		return this.naam + " draait.\n" +
//		this.lachenMan();
		
	}
	
			
}
	

