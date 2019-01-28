package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Classe Entite, classe abstrait représentant une entité présent dans le jeu
 */
public abstract class Entite {

    /**
     * Propriété positionX représentant la position x de l'entité, protected car classe qui sera hérité
     */
    protected final IntegerProperty positionX = new SimpleIntegerProperty();
        public Integer getPositionX() {return positionX.get();}
        public void setPositionX(Integer positionX) {this.positionX.set(positionX);}
        public IntegerProperty positionXProperty() {return positionX;}

    /**
     * Propriété positionY représentant la position y de l'entité, protected car classe qui sera hérité
     */
    protected final IntegerProperty positionY = new SimpleIntegerProperty();
        public Integer getPositionY() {return positionY.get();}
        public void setPositionY(Integer positionY) {this.positionY.set(positionY);}
        public IntegerProperty positionYProperty() {return positionY;}

    /**
     * Propriété vitesseEntite représentant la vitesse de l'entité, protected car classe qui sera hérité
     */
    protected final IntegerProperty vitesseEntite = new SimpleIntegerProperty();
        public Integer getVitesseEntite() {return vitesseEntite.get();}
        public void setVitesseEntite(Integer positionY) {this.vitesseEntite.set(positionY);}
        public IntegerProperty vitesseEntiteProperty() {return vitesseEntite;}
}
