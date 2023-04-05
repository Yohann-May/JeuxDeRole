package protagonistes;

import equipements.*;

public class Hero extends Personnage {
    public Hero(String nom, int vie) {
        super(nom, vie);
    }

    public void sEquiper(Equipement equipement) {
        if (equipement instanceof Arme) {
            if (this.arme != null) {
                this.arme = (Arme) equipement;
            }
        } else if (equipement instanceof Armure) {
            if (this.armure != null) {
                this.armure = (Armure) equipement;
            }
        }
    }

    public void fuir() {

    }
}
