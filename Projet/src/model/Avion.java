package model;

import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.io.Serializable;

/**
 * Class Avion abstrait et implémentant la sérialisation, il permet d'avoir une classe de base pour les avions
 * contenant les propriétés par défaut des avions au sein du jeu.
 */
public abstract class Avion implements Serializable {

    /**
     * StringProperty nomAvion correspondant au nom de l'avion, protected ainsi il peut être accessible dans la classe fille
     */
    protected StringProperty nomAvion = new SimpleStringProperty();
        public String getNomAvion() {return nomAvion.get();}
        public void setNomAvion(String nomAvion) {this.nomAvion.set(nomAvion);}
        public StringProperty nomAvionProperty() {return nomAvion;}

    /**
     * StringProperty imageAvion correpondant au lien vers l'image représentant l'avion, protected ainsi il peut être accessible dans la classe fille
     */
    protected StringProperty imageAvion = new SimpleStringProperty();
        public String getImageAvion() {return imageAvion.get();}
        public void setImageAvion(String imageAvion) {this.imageAvion.set(imageAvion);}
        public StringProperty imageAvionProperty() {return imageAvion;}

    /**
     * IntegerProperty pointDeVie correspondant au nombre de point de vie de l'avion, protected ainsi il peut être accessible dans la classe fille
     */
    protected IntegerProperty pointDeVie = new SimpleIntegerProperty();
        public Integer getPointDeVie() {return pointDeVie.get();}
        public void setPointDeVie(Integer pointDeVie) {this.pointDeVie.set(pointDeVie);}
        public IntegerProperty pointDeVieProperty() {return pointDeVie;}

    /**
     * IntegerProperty vitesseDeTir correpondant à la vitesse de tir de l'avion, protected ainsi il peut être accessible dans la classe fille
     */
    protected IntegerProperty vitesseDeTir = new SimpleIntegerProperty();
        public Integer getVitesseDeTir() {return vitesseDeTir.get();}
        public void setVitesseDeTir(Integer vitesseDeTir) {this.vitesseDeTir.set(vitesseDeTir);}
        public IntegerProperty vitesseDeTirProperty() {return vitesseDeTir;}

    /**
     * IntegerProperty prix correpondant au de l'avion, protected ainsi il peut être accessible dans la classe fille
     */
    protected IntegerProperty prix = new SimpleIntegerProperty();
        public Integer getPrix() {return prix.get();}
        public void setPrix(Integer pointDeVie) {this.prix.set(pointDeVie);}
        public IntegerProperty prixProperty() {return prix;}

}
