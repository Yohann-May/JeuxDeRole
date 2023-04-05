package equipements;

public class Arme extends Equipement {
    private int degats;

    public Arme(String nom, int degats) {
        super(nom);
        this.degats = degats;
    }
}
