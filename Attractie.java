package weekOpdrachtKermis;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Attractie {
	Prompter prompter = new Prompter();
	private String naam;
	private int prijs;
	private double oppervlakte;
	private int kassa;
	private int aantalKaartjes;
	private boolean attractieDisabled;
	
	
	
	
	////   SUPER CONSTRUCTOR   ////
	Attractie(String naam, int prijs){
		this.naam = naam;
		this.prijs = prijs;
	}
	
	////   NAAM   ////
	String getNaam() {
		return this.naam;
	}
	////   KASSA   ////
	int getKassa() {
		return this.kassa;
	}
	void setKassa(int k) {
		this.kassa = k; 
	}
	
	////   PRIJS   ////
	public int getPrijs() {
		return this.prijs;
	}
	public int getKaartjes() {
		return this.aantalKaartjes;
	}
	
	
	String draaien(int i) throws onderhoudNodigException{
		
		
		if(attractieDisabled) {											// ------> controleert of attractie disabled is. zou eigenlijk nog mogelijkheid moeten zijn hem alsnog te repareren//
			System.out.println("Deze attractie mag niet meer rijden.");	
		}

		
		
		if(this instanceof RisicoVolleAttracties) {						//--------> controleert of attractie risicovol is//
			RisicoVolleAttracties r = (RisicoVolleAttracties)this;
			
			while(r.onderhoudsbeurtNodig == false) {					//--------> als attractie risicovol is, maar geen onderhoudsbeurt nodig heeft mag hij rijden//
				this.kassa+=this.prijs;
				this.aantalKaartjes++;
				r.onderhoudsbeurtNodig();
				break;
			}
			while(r.onderhoudsbeurtNodig == true) { 					//--------> als attractie risicovol is en onderhoudsbeurt nodig heeft, mag hij niet rijden en gecontroleerd worden//
//				b.onderhoudsbeurtNodig();
				throw new onderhoudNodigException();//throwt exception
			}
			return this.naam + " draait";
		}//end if risicovol
		else if(this instanceof GokAttractie) {							//--------> controleert of attractie een gokattractie is//
			GokAttractie g = (GokAttractie)this;
			this.kassa = g.kansSpelBelastingBetalen(this.kassa);
			this.aantalKaartjes++;
			if(this.aantalKaartjes%13 ==0) { 							//--------> voor elke 13 kaartjes verkocht, wordt de belasting geïnd//
				System.out.println("De attractie moet een kansspelbelasting betalen van 15%");//
				Kermis.setKassa(Belastingadviseur.belastingInnen(Kermis.getKassa(), g.getGereserveerdBedrag()));
				System.out.println("De kassa heeft nu " + this.getKassa()); // check of kassa gokattracties werkt
			}
			return this.naam + " draait";
		}
		else {															// ------> voor alle normale attracties//
			this.kassa+=this.prijs;
			this.aantalKaartjes++;
			return this.naam + " draait";
		}
			
	}
	
	
	void attractieDisabled(Attractie att) {
		attractieDisabled = true;
	}
	
}
