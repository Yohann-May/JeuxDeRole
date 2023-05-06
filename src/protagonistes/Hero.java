package protagonistes;


/**
 * Classe Hero heritant de la classe Personnage
 * Permet de gerer un hero possedant un nom et des points de vie
 */
public class Hero extends Personnage {
	
	public Hero() {
		super();
    }
	
    /**
     * Constructeur de la classe
     * @param nom nom du hero
     * @param vie nombre de point de vie du hero
     */
    public Hero(String nom, int vie) {
        super(nom, vie);
    }
}
