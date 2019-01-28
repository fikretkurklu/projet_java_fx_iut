package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;
import java.util.Date;

/**
 * Class Ennemi, hérite de Personnage, permet de représenter un Ennemi au sein du jeu
 */
public class Ennemi extends Personnage {

    /**
     * Constructeur d'un ennemi, il définit par exemple l'image par défaut d'un ennemi
     * @param positionX valeur de la position x où doit être positionné un ennemi
     * @param positionY valeur de la position y où doit être positionné un ennemi
     * @param vitesseEntite valeur de la vitesse de l'entité ennemi
     */
    public Ennemi(int positionX, int positionY, int vitesseEntite) {
        setPositionX(positionX);
        setPositionY(positionY);
        setMort(false);
        setVitesseEntite(vitesseEntite);
        setAvion(new AvionEnnemi());

        listProjectile = new ArrayList<Projectile>();
    }

}
