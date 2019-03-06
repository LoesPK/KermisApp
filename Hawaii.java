package weekOpdrachtKermis;

public class Hawaii extends RisicoVolleAttracties{
	
	////	CONSTRUCTOR		\\\\
	Hawaii(String naam, int prijs) {
		super(naam, prijs);
	}
	
	@Override
	public int draaiLimiet() {
		return 10;
	}

	@Override
	boolean opstellingskeuring() {
		return true;
	}
	
	@Override
	public void onderhoudsbeurtNodig() {
		if(this.getKaartjes()%10 == 0) {
			onderhoudsbeurtNodig = true;
		}else {
			onderhoudsbeurtNodig = false;
		}
	}
}
