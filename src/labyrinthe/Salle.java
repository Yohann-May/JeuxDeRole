package labyrinthe;



import equipements.*;
import protagonistes.Monstre;

/**
 * Classe Salle
 * Une salle est une piece dans le labyrinthe elle peut etre relie a d'autre salle par des portes
 * Peut contenir des monstres et/ou des tresors
 */
public class Salle {

	private Position position;
    private Monstre monstre;
    private Equipement tresor;
    private Position[] portes;
    
    
    public Salle() {
    }

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
        this.portes = new Position[4];
    }

    /**
     * Ajoute une salle accessible par une porte.
     * La salle est stockee dans le parametre "portes" composé comme cela
     * |Nord|Sud|Ouest|Est|
     * @param salle nouvelle salle a relier (par une porte)
     */
    public void ajouterPorte(Salle salle) {
        int sx = salle.getPosition().getX();
        int sy = salle.getPosition().getY();
        if (sx == this.getPosition().getX() - 1 && sy == this.getPosition().getY()) { // Nord
            this.portes[0] = salle.getPosition();
        } else if (sx == this.getPosition().getX() + 1 && sy == this.getPosition().getY()) { // Sud
            this.portes[1] = salle.getPosition();
        } else if (sx == this.getPosition().getX() && sy == this.getPosition().getY() - 1) { // Ouest
            this.portes[2] = salle.getPosition();
        } else if (sx == this.getPosition().getX() && sy == this.getPosition().getY() + 1) { // Est
            this.portes[3] = salle.getPosition();
        }
    }

    /**
     * @return la liste des portes de la salle
     */
    public Position[] getPortes() {
        return portes;
    }

    /**
     * @return la position de la salle
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @return true si un monstre est dans la salle | false sinon
     */
    public boolean contientMonstre() {
        return this.monstre != null && this.monstre.getVie() != 0;
    }

    /**
     * @return true si un tresor est dans la salle | false sinon
     */
    public boolean contientTresor() {
        return this.tresor != null;
    }

    /**
     * @return le monstre dans la salle
     */
    public Monstre getMonstre() {
        return this.monstre;
    }

    /**
     * @return le tresor dans la salle
     */
    public Equipement getTresor() {
        return this.tresor;
    }

    /**
     * Attribue un tresor a la salle
     * @param tresor a attribuer
     */
    public void setTresor(Equipement tresor) {
        this.tresor = tresor;
    }

    /**
     * Attribue un monstre a la salle
     * @param monstre a attribuer
     */
    public void setMonstre(Monstre monstre) {
        this.monstre = monstre;
    }

    /**
     * Affiche les directions possible dans cette salle
     */
    public void afficherDirectionPossible() {
        System.out.print("Les directions disponibles sont : ");
        for (int i = 0; i < this.getPortes().length; i++) {
            if (this.portes[i] != null) {
                switch (i) {
                    case 0 -> System.out.print("Nord ");
                    case 1 -> System.out.print("Sud ");
                    case 2 -> System.out.print("Ouest ");
                    case 3 -> System.out.print("Est ");
                }
            }
        }
        System.out.println();
    }
}
