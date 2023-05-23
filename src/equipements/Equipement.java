package equipements;

/**
 * Classe Equipement
 * Permet de gerer les Arme et Armure d'un joueur
 */
public class Equipement {
    protected String nom;
    protected int vie;
    protected int degats;
    
    
    public Equipement() {
    }

    /**
     * Constructeur de la classe Equipement
     * @param nom nom de l'equipement
     */
    public Equipement(String nom) {
        this.nom = nom;
    }

    /**
     * @return le nom de l'equipement
     */
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
}
