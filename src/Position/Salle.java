package Position;

import Equipement.*;
import Protagoniste.Monstre;

public class Salle {
    private Position position;

    private Monstre monstre;

    private Equipement tresor;
    private Salle[] portes;

    /**
     * Une salle compose un labyrinthe et un joueur peut effectuer des actions :
     *  - combattre
     *  - recuperer un equipement
     *  - fuir
     *  - se deplacer
     * @param position position de la salle
     * @param monstre monstre dans la salle (non obligatoire)
     * @param tresor tresor dans la salle si monstre vaincu (non obligatoire)
     */
    public Salle(Position position, Monstre monstre, Equipement tresor) {
        this.position = position;
        this.monstre = monstre;
        this.tresor = tresor;
        this.portes = new Salle[4];
    }

    /**
     * Cette fonction ajoute une salle accessible par une porte.
     * La salle est stockee dans le parametre "portes" composé comme cela
     * |Nord|Sud|Ouest|Est|
     * @param salle nouvelle salle a relier (par une porte)
     */
    public void ajouterPorte(Salle salle) {
        int sx = salle.getPosition().getX();
        int sy = salle.getPosition().getY();
        if (sx == this.getPosition().getX() - 1 && sy == this.getPosition().getY()) { // Nord
            this.portes[0] = salle;
        } else if (sx == this.getPosition().getX() + 1 && sy == this.getPosition().getY()) { // Sud
            this.portes[1] = salle;
        } else if (sx == this.getPosition().getX() && sy == this.getPosition().getY() - 1) { // Ouest
            this.portes[2] = salle;
        } else if (sx == this.getPosition().getX() && sy == this.getPosition().getY() + 1) { // Est
            this.portes[3] = salle;
        }
    }

    /**
     * @return la liste des portes de la salle
     */
    public Salle[] getPortes() {
        return portes;
    }

    /**
     * @return la position de la salle
     */
    public Position getPosition() {
        return position;
    }
}
