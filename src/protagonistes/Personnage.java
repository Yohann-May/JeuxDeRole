package protagonistes;

import equipements.*;
import labyrinthe.Position;
import vue.Clavier;

/**
 * TODO commenter
 */
public class Personnage {
    protected Position position;
    protected String nom;
    protected int vieMax;
    protected int vieActuelle;
    protected Arme arme;
    protected Armure armure;

    /**
     * TODO commenter
     */
    public Personnage(String nom, int vie) {
        this.nom = nom;
        this.vieMax = vie;
        this.vieActuelle = vie;
        this.position = new Position(0, 0);
    }

    /**
     * TODO commenter
     */
    public String getNom() {
        return nom;
    }

    /**
     * TODO commenter
     */
    public int getVie() {
        return vieActuelle;
    }
    public int getVieMax() {
        return vieMax;
    }

    /**
     * TODO commenter
     */
    public void subirAttaque(Personnage personnage) {
        // TODO ajouter la vie de l'armure
        int degats = this.arme == null ? 1 : this.arme.getDegats();
        degats = this.armure == null ? degats : this.armure.subirDegats(degats);
        subirAttaque(degats, personnage);
    }

    /**
     * TODO commenter
     * @param degats
     * @param personnage
     */
    public void subirAttaque(int degats, Personnage personnage) {
        this.vieActuelle -= degats;
        System.out.println(this.getNom() + " subit une violente attaque de " + personnage.getNom());
        if (this.getVie() <= 0) {
            mourir();
        }
    }

    /**
     * TODO commenter
     */
    public Position getPosition() {
        return position;
    }

    /**
     * TODO commenter
     */
    public void seDeplacer(Position position) {
        this.position = position;
    }

    /**
     * TODO commenter
     */
    public boolean estMort() {
        return this.getVie() > 0;
    }

    /**
     * TODO commenter
     */
    public void mourir() {
        System.out.println("Le " + getNom() + " succombe à ses blessures...");
    }

    /**
     * TODO commenter
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

    public void setVie(int i) {
        this.vieActuelle = i;
    }
    public void setVieMax(int i) {
        this.vieMax = i;
    }
}
