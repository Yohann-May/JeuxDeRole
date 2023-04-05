package labyrinthe;

/**
 * Classe Position
 * Permet de gerer les positions dans le labyrinthe
 */
public class Position {
    private int x;
    private int y;

    /**
     * Constructeur de la classe Position
     * @param x la position sur la ligne du labyrinthe
     * @param y la position sur la colonne du labyrinthe
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return la position sur la ligne du labyrinthe
     */
    public int getX() {
        return x;
    }

    /**
     * @return la position sur la colonne du labyrinthe
     */
    public int getY() {
        return y;
    }
}
