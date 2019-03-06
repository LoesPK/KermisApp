package weekOpdrachtKermis;

public class Belastingadviseur {
	
	public static int belastingInnen(int k, int gereserveerdBedrag) {
		System.out.println("De kassa van de kermis heeft voor de belastingen €" + k + " geld in de kassa.");
		int KermisKassa = k - gereserveerdBedrag;
		System.out.println("De belasting die betaalt moet worden is " + gereserveerdBedrag);
		System.out.println("De kassa van de kermis heeft nu €" + KermisKassa + " geld in de kassa.");
		return KermisKassa; 
	}
}
