package weekOpdrachtKermis;

public class Eetkraampje {
	private String naam;
	private int prijs;
	private String eten;
	private double oppervlakte;
	private int kassa;
	private static int aantalVerkochtEten;
	
	////	SUPER CONSTRUCTOR   \\\\
	Eetkraampje(String naam, String eten, int prijs){
		this.naam = naam;
		this.prijs = prijs;
		this.eten = eten;
	}
	////	ETEN VERKOPEN	\\\\
	public String etenVerkopen(int i) {
		this.kassa+=this.prijs;
		this.aantalVerkochtEten++;
		String grapjeSorry = lachenMan();
		return "Lekkere " + this.eten + " gekocht bij " + this.naam + "\n"
				+ grapjeSorry;
	}

	////	HA-HA-HA...SLOWCLAP	\\\\
	public String lachenMan() {
		String lachen = "";
		return lachen;
	}
	
	
	////   NAAM   \\\\
	String getNaam() {
		return this.naam;
	}	
	
	////   ETEN   \\\\
	String getEten() {
		return this.eten;
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
	
	////	ETEN   \\\\
	public static int getVerkochtEten() {
		return aantalVerkochtEten;
	}
	
}
