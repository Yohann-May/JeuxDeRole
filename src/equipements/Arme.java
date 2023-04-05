package equipements;

/**
 * TODO commenter
 */
public class Arme extends Equipement {
    private int degats;

    /**
     * TODO commenter
     */
    public Arme(String nom, int degats) {
        super(nom);
        this.degats = degats;
    }

    /**
     * TODO commenter
     */
    public int getDegats() {
        return this.degats;
    }
}
