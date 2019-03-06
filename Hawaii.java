package weekOpdrachtKermis;

public class Hawaii extends RisicoVolleAttracties{
	
	Hawaii(String naam, double prijs) {
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
		onderhoudsbeurtNodig = false;
	}
}
