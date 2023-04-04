package Protagoniste;

import Equipement.*;
import Position.Position;

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

    public void subirAttaque(int degats) {

    }

    public Position getPosition() {
        return position;
    }

    public void seDeplacer(Position position) {
        this.position = position;
    }
}
