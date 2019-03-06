package weekOpdrachtKermis;

import java.util.ArrayList;

public class Kermis {
	private double kassa;
	private int aantalKaartjes;
	Prompter prompter = new Prompter();
	ArrayList<Attractie> attracties; 
	
	void attractieList() {
		attracties  = new ArrayList<Attractie>();
		attracties.add(new Botsauto("Botsauto's", 2.50));
		attracties.add(new Spin("De Spin", 2.25));
		attracties.add(new Spiegelpaleis("Spiegelpaleis", 2.75));
		attracties.add(new Spookhuis("Spookhuis", 3.20));
		attracties.add(new Hawaii("Hawaii", 2.90));
		attracties.add(new Ladderklimmen("Ladderklimmen", 5.00));

	}
	
	
	public void kermisTonen() {
		
		System.out.println("Welkom op de kermis");
		attractieList();
		
		for(Attractie a: attracties) {
			if( a instanceof RisicoVolleAttracties) {
				RisicoVolleAttracties b = (RisicoVolleAttracties)a;
				System.out.println(a.getNaam() + " moet eerst een keuring hebben.");
			}
		}
		

		
		while(true) {
			System.out.println(prompter.starten());
			prompter.keuzeMaken();
			switch(prompter.keuzeStart) {
				case "A": 
				int keuze = prompter.attractieRijden();
				System.out.println(keuze);
					rijden();
				break;
				case "O": omzetTonen();
				break;
				case "K": kaartenTonen();
				break;
				default: System.out.println("maak een keuze");
				break;
			}
		}
	}
	
	public void rijden() {
		try {
			System.out.println(attracties.get(prompter.keuze-1).draaien(prompter.keuze));
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			onderhoud((RisicoVolleAttracties)attracties.get(prompter.keuze-1));
		}finally {
			this.kassa += attracties.get(prompter.keuze-1).getPrijs();
			this.aantalKaartjes++;
		}
	}

	public void omzetTonen() {
		System.out.println("De kermis heeft in totaal: €" + this.kassa + " verdiend." );
		for(Attractie a : attracties) {
			if(a.getKassa()> 0.0) {
				System.out.println(a.getNaam() + " heeft €" + a.getKassa() + " verdiend.");
			}
		}
	}
	
	public void kaartenTonen() {
		System.out.println("De kermis heeft in totaal: " + this.aantalKaartjes + " kaartje(s) verkocht." );
		for(Attractie a : attracties) {
			if(a.getKaartjes()> 0) {
				System.out.println(a.getNaam() + " heeft " + a.getKaartjes() + " kaartje(s) verkocht.");
			}
		}
	}
	
	void onderhoud(RisicoVolleAttracties rva) {
		if(rva.onderhoudsbeurtNodig == true) {
			String reparatie = prompter.monteurAanroepen();
			if(reparatie.equals("M")){
				rva.onderhoudsbeurtNodig = false;
				System.out.println(rva + " is gecontroleerd en veilig!");
			}else {
				rva.attractieDisabled(rva);
			}
		}
	}
	
}
