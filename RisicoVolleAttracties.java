package weekOpdrachtKermis;

abstract class RisicoVolleAttracties extends Attractie{
	private int draaiLimiet;
	boolean onderhoudsbeurtNodig;
	
	RisicoVolleAttracties(String naam, int prijs) {
		super(naam, prijs);
	}
	abstract boolean opstellingskeuring();
	abstract int draaiLimiet();
	abstract void onderhoudsbeurtNodig();
}
