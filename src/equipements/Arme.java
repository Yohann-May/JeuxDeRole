package equipements;

/**
 * Classe Arme
 * Permet de gerer une arme d'un joueur
 */
public class Arme extends Equipement {

    public Arme() {
    	super();
    }

    /**
     * Constructeur de la classe Arme
     * @param nom nom de l'arme
     * @param degats degats de l'arme
     */
    public Arme(String nom, int degats) {
        super(nom);
        this.degats = degats;
    }
}
