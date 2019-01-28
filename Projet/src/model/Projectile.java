package model;

import javafx.beans.property.*;
import javafx.scene.image.Image;

/**
 * Class Projectile, hérite de Entite, représente un projectile au sein du jeu
 */
public class Projectile extends Entite{

    /**
     * Propriété correspondant à la vitesse du projectile
     */
    private IntegerProperty vitesseProjectile = new SimpleIntegerProperty();
        public Integer getVitesseProjectile() {return vitesseProjectile.get();}
        public void setVitesseProjectile(Integer vitesseProjectile) {this.vitesseProjectile.set(vitesseProjectile);}
        public IntegerProperty vitesseProjectileProperty() {return vitesseProjectile;}

    /**
     * Propriété correspondant au lien qui méne à l'image représentant le projectile
     */
    private StringProperty imageProjectile = new SimpleStringProperty();
        public String getImageProjectile() {return imageProjectile.get();}
        public void setImageProjectile(String imageProjectile) {this.imageProjectile.set(imageProjectile);}
        public StringProperty imageProjectileProperty() {return imageProjectile;}

    /**
     * Propriété représentant si le projectile est toujours actif ou non, selon le cas il ne
     * sera plus affiché dans le jeu
     */
    private BooleanProperty actif = new SimpleBooleanProperty();
        public Boolean getActif() {return actif.get();}
        public void setActif(Boolean actif) {this.actif.set(actif);}
        public BooleanProperty actifProperty() {return actif;}

    /**
     * Constructeur de la classe Projectile
     * @param positionX valeur correspondant à la position x du projectile
     * @param positionY valeur correspondant à la position y du projectile
     * @param vitesseProjectile valeur correspondant à la vitesse du projectile
     */
    public Projectile(int positionX, int positionY, int vitesseProjectile) {
        setVitesseProjectile(vitesseProjectile);
        setPositionX(positionX);
        setPositionY(positionY);
        setImageProjectile("/resource/image/Tir1.png");

        setActif(true);
    }

    /**
     * Méthode permettant de savoir la valeur de la propriété actif
     * @return retourne la valeur de la proprité actif
     */
    public boolean isActif() {
        return getActif();
    }
}
