package equipements;

/**
 * Classe Armure
 * Permet de gerer l'armure d'un joueur
 */
public class Armure extends Equipement {
    private int vie;

    /**
     * Constructeur de la classe Armure
     * @param nom nom de l'armure
     * @param vie vie pouvant etre encaisse par l'armure
     */
    public Armure(String nom, int vie) {
        super(nom);
        this.vie = vie;
    }

    /**
     * L'armure subit des degats et retourne le nombre de degats restants a subir, 0 si tout a ete encaisse par l'armure
     * @param degats les degats a subir par l'armure
     * @return le nombre de degats restant a subir
     */
    public int subirDegats(int degats) {
        if (this.vie < degats) {
            this.casser();
            return degats - this.vie;
        }
        else {
            this.vie = this.vie - degats;
        }
        return 0;
    }

    /**
     * Quand l'armure casse message envoye
     */
    private void casser() {
        this.vie = 0;
        System.out.println(this.getNom() + " casse sous les dégats subis...");
    }
}
