package equipements;

/**
 * Classe Equipement
 * Permet de gerer les Arme et Armure d'un joueur
 */
public class Equipement {
    protected String nom;
    
    
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
    
    /**
     * @return nom de l'équipement
     */
}
