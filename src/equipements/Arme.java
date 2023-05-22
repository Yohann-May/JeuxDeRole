package equipements;

/**
 * Classe Arme
 * Permet de gerer une arme d'un joueur
 */
public class Arme extends Equipement {
    private int degats;

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

    /**
     * @return les degats de l'arme
     */
    public int getDegats() {
        return this.degats;
    }
    
   
}
