package weekOpdrachtKermis;

public class Spin extends RisicoVolleAttracties{

	
	////   CONSTRUCTOR   \\\\
	Spin(String naam, int prijs) {
		super(naam, prijs);
	}
	
	@Override
	public int draaiLimiet() {
		return 5;
	}

	@Override
	boolean opstellingskeuring() {
		this.opstellingskeuring = true;
		return opstellingskeuring;
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
