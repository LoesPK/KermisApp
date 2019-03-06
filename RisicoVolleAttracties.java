package weekOpdrachtKermis;

abstract class RisicoVolleAttracties extends Attractie{
	protected boolean opstellingskeuring = false;
	boolean onderhoudsbeurtNodig;
	
	////   SUPER CONSTRUCTOR   \\\\
	RisicoVolleAttracties(String naam, int prijs) {
		super(naam, prijs);
	}
	
	
	abstract boolean opstellingskeuring();
	abstract int draaiLimiet();
	abstract void onderhoudsbeurtNodig();
}
