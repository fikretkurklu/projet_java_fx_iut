package model;

import javafx.scene.image.Image;

/**
 * Class AvionChasse héritant de la classe Avion, il permet d'intégrer un constructeur initialisant les propriétés avec des valeur par défaut
 * qu'un avion de chasse comprend.
 */
public class AvionChasse extends Avion {

    /**
     * AvionChasse constructeur vide, présent pour pouvoir utiliser la persistance sur cet classe
     */
    public AvionChasse() {
        setNomAvion("Avion Chasse");
        setImageAvion("/resource/image/Avion1.png");
        setPointDeVie(100);
        setVitesseDeTir(4);
        setPrix(0);
    }

    /**
     * AvionChasse constructeur acceptant 3 paramètres permettant d'avoir une instance ayant des paramètres initales
     * @param nomAvion correpond à nom de l'avion que l'on souhaite lui attribuer
     * @param pointDeVie correspond au point de vie que l'on souhaite attribuer à l'instance
     * @param vitesseDeTir correspond à la vitesse de tir que l'on souhaite attribuer à l'instance
     * @param prix correspond au prix de l'avion
     */
    public AvionChasse(String nomAvion, int pointDeVie, int vitesseDeTir, int prix) {
        setNomAvion(nomAvion);
        setImageAvion("/resource/image/Avion1.png");
        setPointDeVie(pointDeVie);
        setVitesseDeTir(vitesseDeTir);
        setPrix(prix);
    }

}
