package weekOpdrachtKermis;

import java.util.Scanner;

public class Prompter {
	Scanner scanner = new Scanner(System.in);
	int keuze;
	String keuzeStart;
	//------------welkomstbericht + menu------------//
	
	String starten() {
		String desc = "Wilt u een ritje maken in een attractie(A)"
				+ " De omzet (O) zien van de kermis en alle attracties."
				+ "Of de verkochte kaartjes (K) zien van de kermis en alle attracties.";
		return desc;
	}
	
	int attractieRijden() {
		
		System.out.println("Kies \n" +
				"1. \tvoor botsauto's \t €2,50 \n" + 
				"2. \tvoor spin \t\t €2,25 \n" + 
				"3. \tvoor spiegelpaleis \t €2,75 \n" + 
				"4. \tvoor spookhuis \t\t €3,20 \n" + 
				"5. \tvoor Hawaii \t\t €2,90 \n" + 
				"6. \tvoor ladderklimmen \t €5,00 ");
		keuze = Integer.parseInt(scanner.nextLine());
		return keuze;
	} 
	
	String keuzeMaken() {
		keuzeStart = scanner.nextLine().toUpperCase();
		
		return keuzeStart;
	}
	
	String monteurAanroepen() {
		System.out.println("Wilt u de attractie laten controleren door Fred de monteur? Druk op m, anders druk op elke andere knop");
		String maken = scanner.nextLine().toUpperCase();
		if(maken.equals("M")) {
			System.out.println("De onderhoudsmonteur controleert de attractie");
		}else {
			System.out.println("Levensgevaarlijk om de monteur niet langs te laten komen. Je mag deze attractie niet meer gebruiken");
		}
		return maken;
	}
	
}
