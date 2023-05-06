package protagonistes;

import equipements.*;
import labyrinthe.Position;
import vue.Clavier;

/**
 * Classe Personnage
 * Permet de gerer des personnages ayant une position, un nom, un nombre de point de vie, une arme et une armure
 */
public class Personnage {
    protected Position position;
    protected String nom;
    protected int vieMax;
    protected int vieActuelle;
    protected Arme arme;
    protected Armure armure;
    
    public Personnage() {
    }

    /**
     * Constructeur de la classe Personnage
     * @param nom nom du personnage
     * @param vie points de vie du personnage
     */
    public Personnage(String nom, int vie) {
        this.nom = nom;
        this.vieMax = vie;
        this.vieActuelle = vie;
        this.position = new Position(0, 0);
    }

    /**
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return la vie actuelle du personnage
     */
    public int getVie() {
        return vieActuelle;
    }

    /**
     * @return lavie max du personnage
     */
    public int getVieMax() {
        return vieMax;
    }

    /**
     * Le personnage (this) subit une attaque d'un attaquant
     * @param attaquant personnage donnant l'attaque
     */
    public void subirAttaque(Personnage attaquant) {
        int degats = attaquant.getArme() == null ? 1 : attaquant.getArme().getDegats();
        degats = this.armure == null ? degats : this.armure.subirDegats(degats);
        if (this.armure != null && this.armure.estCasser()) {
            this.armure = null;
        }
        subirAttaque(degats);
        System.out.println(this.getNom() + " subit une violente attaque de " + attaquant.getNom());
    }

    /**
     * @return l'arme du personnage
     */
    private Arme getArme() {
        return this.arme;
    }

    /**
     * Le personnage subit un nombre de degats, meurt si la vie tombe en dessous de 0
     * @param degats degats a subir
     */
    public void subirAttaque(int degats) {
        this.vieActuelle -= degats;
        if (this.getVie() <= 0) {
            mourir();
        }
    }

    /**
     * @return la position du personnage
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Deplace le personnage dans le labyrinthe
     * @param position position a laquelle se deplacer
     */
    public void seDeplacer(Position position) {
        this.position = position;
    }

    /**
     * @return true si le personnage est mort | false sinon
     */
    public boolean estMort() {
        return this.getVie() > 0;
    }

    /**
     * Fait mourir le personnage
     */
    public void mourir() {
        System.out.println("Le " + getNom() + " succombe à ses blessures...");
    }

    /**
     * Attribue un equipement au personnage
     * @param e l'equipement a equiper
     */
    public void recupererEquipement(Equipement e) {
        int choix;
        if (e instanceof Arme) {
            if (this.arme == null) {
                this.arme = (Arme) e;
                System.out.println(this.getNom() + " s'equipe de son " + e.getNom());
            } else {
                do {
                    System.out.println("Vous possedez deja une " + this.arme.getNom() + " effectuant " + this.arme.getDegats() + " degats. Voulez vous changer pour equiper " + e.getNom() + " ? (1 - Oui ou 2 - Non)");
                    choix = Clavier.entrerClavierInt();
                } while (choix < 1 || choix > 2);
                if (choix == 1) {
                    this.arme = (Arme) e;
                    System.out.println(this.getNom() + " s'equipe de son " + e.getNom());
                }
            }
        } else if (e instanceof Armure) {
            if (this.armure == null) {
                this.armure = (Armure) e;
                System.out.println(this.getNom() + " s'equipe de son " + e.getNom());
            } else {
                do {
                    System.out.println("Vous possedez deja une " + this.armure.getNom() + " possedant " + this.arme.getDegats() + " points de vie. Voulez vous changer pour equiper " + e.getNom() + " ? (1 - Oui ou 2 - Non)");
                    choix = Clavier.entrerClavierInt();
                } while (choix < 1 || choix > 2);
                if (choix == 1) {
                    this.armure = (Armure) e;
                    System.out.println(this.getNom() + " s'equipe de son " + e.getNom());
                }
            }
        }
    }

    /**
     * Attribue i vie au personnage
     * @param i vie a attribuer
     */
    public void setVie(int i) {
        this.vieActuelle = i;
    }

    /**
     * Change la valeur maximale de la vie du personnage
     * @param i nouvelle valeur maximale
     */
    public void setVieMax(int i) {
        this.vieMax = i;
    }
    
    
    
}
