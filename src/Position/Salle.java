package Position;

import Equipement.*;
import Protagoniste.Monstre;

import java.util.LinkedList;

public class Salle {
    private Position position;

    private Monstre monstre;

    private Equipement tresor;
    private LinkedList<Salle> portes;
    public Salle(Position position, Monstre monstre, Equipement tresor) {
        this.position = position;
        this.monstre = monstre;
        this.tresor = tresor;
        this.portes = new LinkedList<Salle>();
    }

    public void ajouterPorte(Salle salle) {
        this.portes.addLast(salle);
    }

    public Position getPosition() {
        return position;
    }
}
