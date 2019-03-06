package weekOpdrachtKermis;

public class Spin extends RisicoVolleAttracties{
	
	Spin(String naam, double prijs) {
		super(naam, prijs);
	}
	
	@Override
	public int draaiLimiet() {
		return 5;
	}

	@Override
	boolean opstellingskeuring() {
		return true;
	}
	
	@Override
	public void onderhoudsbeurtNodig() {
		if(this.getKaartjes() % 5 == 0) {
			onderhoudsbeurtNodig = true;
		}else {
			onderhoudsbeurtNodig = false;
		}
	}

}
