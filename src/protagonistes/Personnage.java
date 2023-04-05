package protagonistes;

import equipements.*;
import labyrinthe.Position;

public class Personnage {
    protected Position position;
    protected String nom;
    protected int vie;
    protected Arme arme;
    protected Armure armure;

    public Personnage(String nom, int vie) {
        this.nom = nom;
        this.vie = vie;
        this.position = new Position(0, 0);
    }

    public String getNom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }

    public void subirAttaque(int degats, Personnage personnage) {
        this.vie -= degats;
        System.out.println(this.getNom() + " subit une violente attaque de " + personnage.getNom());
        if (this.getVie() <= 0) {
            mourir();
        }
    }

    public Position getPosition() {
        return position;
    }

    public void seDeplacer(Position position) {
        this.position = position;
    }

    public boolean estMort() {
        return this.getVie() > 0;
    }

    public void mourir() {
        System.out.println("Le " + getNom() + " succombe à ses blessures...");
    }
}
