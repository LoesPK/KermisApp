package weekOpdrachtKermis;

public class Belastingadviseur {
	
	public static double belastingInnen(double k, double gereserveerdBedrag) {
		System.out.println("De kassa van de kermis heeft voor de belastingen €" + k + " geld in de kassa.");
		double KermisKassa = k - gereserveerdBedrag;
		System.out.println("De belasting die betaalt moet worden is " + gereserveerdBedrag);
		System.out.println("De kassa van de kermis heeft nu €" + KermisKassa + " geld in de kassa.");
		return KermisKassa; 
	}
}
