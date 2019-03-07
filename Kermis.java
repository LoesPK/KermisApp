package KermisApp;
import java.util.ArrayList;

public class Kermis {
	private static int kassa;
	private int aantalKaartjes;
	private static int aantalVerkochtEten;
	private static Prompter prompter = new Prompter();
	ArrayList<Attractie> attracties; 
	ArrayList<Eetkraampje> eetkramen;

	
	//_-_-_-_-_-_-_-_-_-_-___ATTRACTIES AANMAKEN___-_-_-_-_-_-_-_-_-_-_\\
	void attractieList() {
		attracties  = new ArrayList<Attractie>();
		attracties.add(new Botsauto("Botsauto's", 250));
		attracties.add(new Spin("De Spin", 225));
		attracties.add(new Spiegelpaleis("Spiegelpaleis", 275));
		attracties.add(new Spookhuis("Spookhuis", 320));
		attracties.add(new Hawaii("Hawaii", 290));
		attracties.add(new Ladderklimmen("Ladderklimmen", 500));
	}
	//_-_-_-_-_-_-_-_-_-_-___EETKRAAMPJES AANMAKEN___-_-_-_-_-_-_-_-_-_-_//
	void eetkraamList() {
		eetkramen  = new ArrayList<Eetkraampje>();
		eetkramen.add(new Hotdogkraam("Hotdogkraam 'Of je worst lust'", "hotdog", 200));
		eetkramen.add(new Hamburgerkraam("Hamburgerkraam 'Broodje moeeeeeh'", "hamburger", 255));
		eetkramen.add(new Saladebar("Saladebar 'Vegantastisch'", "bak sla", 300));
		eetkramen.add(new Tostikraam("Tostikraam 'Tosti van Josti'", "tosti", 150));

	}
	
	//_-_-_-_-_-_-_-_-_-_-___KASSA GETTER EN SETTER___-_-_-_-_-_-_-_-_-_-_\\
	public static int getKassa() {
		return kassa;
	}
	public static void setKassa(int k) {
		kassa = k;
	}
	
	//_-_-_-_-_-_-_-_-_-_-___DE KERMIS___-_-_-_-_-_-_-_-_-_-_\\
	public void kermisTonen() {
		System.out.println("Welkom op de kermis. De attracties en eetkraampjes worden geladen\n");

		attractieList();
		eetkraamList();
		//----->___ONDERHOUSRIJKE ATTRACTIES CONTROLEREN___<------\\
		for(Attractie a: attracties) {
			if( a instanceof RisicoVolleAttracties) {
				RisicoVolleAttracties b = (RisicoVolleAttracties)a;
				System.out.println(a.getNaam() + " moet eerst een keuring hebben, de monteur Fred gaat aan de slag.");
			}

		}
		for(int i = 0; i<6; i++) {
			System.out.println("...");
		}
		System.out.println("Zo, de attracties zijn gecontroleerd");
		
		//----->___SWITCH OM KEUZE TE MAKEN___<------\\
		while(true) {
			System.out.println(prompter.starten());
			prompter.keuzeMaken();
			switch(prompter.keuzeStart) {
				case "A": 
				int keuzeA = prompter.attractieRijden();
					rijden();
					break;
				case "O": omzetTonen();
					break;
				case "K": kaartenTonen();
						System.out.println(" ");
						  etenTonen();
					break;
				case "E": 
				int keuzeE = prompter.eten();
					eten();
					break;
				default: System.out.println("maak een keuze");
					break;
			}
		}
	}
	
	//_-_-_-_-_-_-_-_-_-_-___ATTRACTIE RIJDEN___-_-_-_-_-_-_-_-_-_-_\\
	public void rijden() {
		try {
			System.out.println(attracties.get(prompter.keuze-1).draaien());
			
		} catch (onderhoudNodigException e) {
			System.err.println(attracties.get(prompter.keuze-1).getNaam() + e.getMessage());
			Kermis.kassa =- attracties.get(prompter.keuze-1).getPrijs();
			this.aantalKaartjes--;
			onderhoud((RisicoVolleAttracties)attracties.get(prompter.keuze-1));
		}finally {
			System.out.println("finally");
//			System.out.println(attracties.get(prompter.keuze-1).getNaam() + " draait.\n" +
//					attracties.get(prompter.keuze-1).lachenMan());
////			Kermis.kassa += attracties.get(prompter.keuze-1).getPrijs();
//			this.aantalKaartjes++;
		}
	}
	
	//_-_-_-_-_-_-_-_-_-_-___ETEN___-_-_-_-_-_-_-_-_-_-_\\
	public void eten() {
			System.out.println(eetkramen.get(prompter.keuze-1).etenVerkopen(prompter.keuze));
			Kermis.kassa += eetkramen.get(prompter.keuze-1).getPrijs();
			Kermis.aantalVerkochtEten++;
	}
	

	//_-_-_-_-_-_-_-_-_-_-___OMZET___-_-_-_-_-_-_-_-_-_-_\\
	public void omzetTonen() {
		//----->___OMZET KERMIS___<------\\
		System.out.println("De kermis heeft in totaal: €" + String.format("%.2f",(double)kassa*0.01) + " verdiend." );
		//----->___OMZET ATTRACTIES___<------\\
		for(Attractie a : attracties) {
			if(a.getKassa()> 0.0) { // Alleen tonen als er omzet is... anders wordt overzicht onduidelijk
				System.out.println(a.getNaam() + " heeft €" + String.format("%.2f",(double)a.getKassa()*0.01) + " verdiend.");
			}
		}
		//----->___OMZET EETKRAAMPJES___<------\\
		for(Eetkraampje e : eetkramen) {
			if(e.getVerkochtEten()> 0) { // Alleen tonen als er omzet is... anders wordt overzicht onduidelijk
				System.out.println(e.getNaam() + " heeft €" + String.format("%.2f",(double)e.getKassa()*0.01) + " verdiend.");
			}
		}
		System.out.println("");
	}
	
	//_-_-_-_-_-_-_-_-_-_-___KAARTEN___-_-_-_-_-_-_-_-_-_-_\\
	public void kaartenTonen() {
		System.out.println("De kermis heeft in totaal: " + this.aantalKaartjes + " kaartje(s) verkocht." );
		for(Attractie a : attracties) {
			if(a.getKaartjes()> 0) { // Alleen tonen als er kaarten verkocht zijn... anders wordt overzicht onduidelijk
				System.out.println(a.getNaam() + " heeft " + a.getKaartjes() + " kaartje(s) verkocht.");
			}
		}
	}
	
	//_-_-_-_-_-_-_-_-_-_-___ETEN___-_-_-_-_-_-_-_-_-_-_\\
	public void etenTonen() {
		System.out.println("De kermis heeft in totaal: " + Kermis.aantalVerkochtEten + " etenswaar verkocht." );
		for(Eetkraampje e : eetkramen) {
			if(e.getVerkochtEten()> 0) { // Alleen tonen als er eten verkocht is... anders wordt overzicht onduidelijk
				System.out.println(e.getNaam() + " heeft " + e.getVerkochtEten() + " " + e.getEten() + " verkocht.");
			}
		}
	}
	
 public static int getEten() {
	 return Kermis.aantalVerkochtEten;
 }
	
	//_-_-_-_-_-_-_-_-_-_-___ONDERHOUD___-_-_-_-_-_-_-_-_-_-_\\
	static void onderhoud(RisicoVolleAttracties rva) {
		if(rva.onderhoudsbeurtNodig == true) {
			String reparatie = Prompter.monteurAanroepen();
			if(reparatie.equals("M")){
				rva.onderhoudsbeurtNodig = false;
				System.out.println(rva.getNaam() + " is gecontroleerd en veilig!");
			}else {
				rva.attractieDisabled(rva);
			}
		}
	}
	
}//END CLASS KERMIS
