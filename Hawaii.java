package KermisApp;

public class Hawaii extends RisicoVolleAttracties{

	
	////	CONSTRUCTOR		\\\\
	Hawaii(String naam, int prijs) {
		super(naam, prijs);
	}
	
	////	HA-HA-HA...SLOWCLAP	\\\\
	public String lachenMan() {
		ongelukken = random.nextInt(300);
		String lachen = "Nee... ik weet ook niet wat dit in godsnaam voor attractie is. Misschien wel Hula-hoopen...";
		return lachen + "\nEr zijn pas " + this.ongelukken + " ongelukken gebeurd met deze attractie.";
	}
	
	@Override
	public int draaiLimiet() {
		return 10;
	}

	@Override
	boolean opstellingskeuring() {
		
		this.opstellingskeuring = true;
		return opstellingskeuring;
	}
	
	@Override
	
	public void onderhoudsbeurtNodig() {
		
		if(this.getKaartjes() % 10 == 0 && opstellingskeuring ==true) {
			onderhoudsbeurtNodig = true;
		}else if(this.opstellingskeuring == false) {
			while(this.opstellingskeuring ==false) {
				String keus = Prompter.opstellingsKeuring();
				if(keus.equals("K")) {
					opstellingskeuring();
				}if(!keus.equals("K")) {
					System.out.println("Doe toch maar wel...");
					continue;
				}
				return;
			}
			
		}else {
			onderhoudsbeurtNodig = false;
		}
	}
}
