package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;

/**
 * Class Personnage, hérite d'Entite, et spécifie plus précisement une Entite personnage dans le jeu,
 * en précisant quelque propriété en plus pour le personnage
 */
public abstract class Personnage extends Entite {

    /**
     * Représente l'avion du personnage, protected car classe qui sera hérité
     */
    protected ObjectProperty<Avion> avion = new SimpleObjectProperty<Avion>();
        public Avion getAvion() {return avion.get();}
        public void setAvion(Avion avion) {this.avion.set(avion);}
        public ObjectProperty<Avion> avionProperty() {return avion;}

    /**
     * Représente la valeur définissant si le personnage est mort ou non, protected car classe qui sera hérité
     */
    protected BooleanProperty mort = new SimpleBooleanProperty();
        public Boolean getMort() {return mort.get();}
        public void setMort(Boolean mort) {this.mort.set(mort);}
        public BooleanProperty mortProperty() {return mort;}

    /**
     * Représente la liste contenant les projectiles tiré par le personnage
     */
    protected ArrayList<Projectile> listProjectile;

    /**
     * Attribut stockant la valeur de la date actuel, utilisé pour la gestion de la vitesse de tir
     */
    protected long currentDate;

    /**
     * Attribut contenant la dernière date à laquelle un tir a été effectué
     */
    protected long dateTir;

    /**
     * Méthode permettant l'accés à la valeur de currentDate
     * @return la valeur de currentDate
     */
    public long getCurrentDate() {
        return currentDate;
    }

    /**
     * Méthode permettant de définir la date actuelle
     * @param currentDate paramètre correspondant à la date actuel
     */
    public void setCurrentDate(long currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * Méthode permettant l'accés à la valeur de la date de dernier tir
     * @return retourne la valeur de la date du dernier tir contenu dans dateTir
     */
    public long getDateTir() {
        return dateTir;
    }

    /**
     * Méthode permettant de définir la dernière date à laquelle un tir a été effectué
     * @param dateTir paramètre correspondant à la dernière  date de tir
     */
    public void setDateTir(long dateTir) {
        this.dateTir = dateTir;
    }

    /**
     * Méthode permettant de récupérer la liste contenant les projectiles tiré par le personnage
     * @return la liste de projectile
     */
    public ArrayList<Projectile> getListProjectile() {
        return listProjectile;
    }

    /**
     * Méthode permettant de définir la liste de projectile
     * @param listProjectile liste de projectile qui va contenir la liste des projectiles tiré par le personnage
     */
    public void setListProjectile(ArrayList<Projectile> listProjectile) {
        this.listProjectile = listProjectile;
    }

    /**
     * Méthode retournant un boolean représentant si le personnage est mort ou non
     * @return boolean représentant si le personnage est mort ou non
     */
    public boolean isMort() {
        return getMort();
    }
}
