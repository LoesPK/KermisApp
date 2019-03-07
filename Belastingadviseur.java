package KermisApp;

public class Belastingadviseur {
	//_-_-_-_-_-_-_-_-_-_-___BELASTING INNEN___-_-_-_-_-_-_-_-_-_-_\\
	public static int belastingInnen(int k, int gereserveerdBedrag) { // int k = kassa van de kermis op dat moment, int gereserveerd bedrag is het gereserveerde stuk belasting van de gokattractie
		System.out.println("De kassa van de kermis heeft voor de belastingen €" + String.format("%.2f",(double)k*0.01) + " geld in de kassa." );
		int KermisKassa = k - gereserveerdBedrag;
		System.out.println("De belasting die betaalt moet worden is €" + String.format("%.2f",(double)gereserveerdBedrag*0.01) );
		System.out.println("De kassa van de kermis heeft nu €" + String.format("%.2f",(double)KermisKassa*0.01) + " geld in de kassa.");
		return KermisKassa; 
	}
}
