package weekOpdrachtKermis;

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
	String draaien(int i) throws onderhoudNodigException{

		//----->___CONTROLE VOOR DISABLED ATTRACTIE (ALS NIET GEREPAREERD IS___<------\\
		if(attractieDisabled) {											// ------> zou eigenlijk nog mogelijkheid moeten zijn hem alsnog te repareren//
			System.err.println("Deze attractie mag niet meer rijden.");	
		}

		
		//----->___ATTRACTIE RISICOVOL___<------\\
		if(this instanceof RisicoVolleAttracties) {						//--------> controleert of attractie risicovol is//
			RisicoVolleAttracties r = (RisicoVolleAttracties)this;
			//___geen onderhoudsbeurt nodig___\\
			while(r.onderhoudsbeurtNodig == false) {					//--------> als attractie risicovol is, maar geen onderhoudsbeurt nodig heeft mag hij rijden//
				this.kassa+=this.prijs;
				this.aantalKaartjes++;
				r.onderhoudsbeurtNodig();
				break;
			}
			//___wel onderhoudsbeurt nodig___\\
			while(r.onderhoudsbeurtNodig == true) { 					//--------> als attractie risicovol is en onderhoudsbeurt nodig heeft, mag hij niet rijden en moet hij gecontroleerd worden//
				throw new onderhoudNodigException();//throwt exception
			}
			return this.naam + " draait.\n" +
					this.lachenMan();
		}//end if risicovol
		
		//----->___ATTRACTIE GOKATTRACTIE___<------\\
		else if(this instanceof GokAttractie) {							
			GokAttractie g = (GokAttractie)this;
			this.kassa = g.kansSpelBelastingBetalen(this.kassa);
			this.aantalKaartjes++;
			
			//___belasting innen___\\
			if(this.aantalKaartjes%2 ==0) { 							//--------> voor elke 13 kaartjes verkocht, wordt de belasting geïnd//
				System.err.println("De attractie moet een kansspelbelasting betalen van 15%");//
				Kermis.setKassa(Belastingadviseur.belastingInnen(Kermis.getKassa(), g.getGereserveerdBedrag()));
			}
			return this.naam + " draait.\n" +
			this.lachenMan();		}
		
		//----->___ATTRACTIE NORMAAL___<------\\
		else {															
			this.kassa+=this.prijs;
			this.aantalKaartjes++;
			return this.naam + " draait.\n" +
			this.lachenMan();		}
			
	}
	
	
	
	
}
