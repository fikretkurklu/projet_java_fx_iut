package model;

import javafx.scene.image.Image;

/**
 * Class AvionMarine héritant de la classe Avion, il permet d'intégrer un constructeur initialisant les propriétés avec des valeur par défaut
 * qu'un avion marine comprend.
 */
public class AvionMarine extends Avion {

    /**
     * AvionMarine Constructeur correspond au constructeur n'acceptant pas de paramètres, nécessaire à l'utilisation de la sérialisation
     */
    public AvionMarine() {
        setNomAvion("Avion Marine");
        setImageAvion("/resource/image/Avion4.png");
        setPointDeVie(150);
        setVitesseDeTir(4);
        setPrix(100);
    }

    /**
     * AvionMarine Constructeur correspond au constructeur acceptant 3 paramètres permettant d'avoir une instance avec des valeurs de bases
     * @param nomAvion nom que l'on souhaite donné à l'avion
     * @param pointDeVie nombre de point de vie que l'on souhaite donné à l'avion
     * @param vitesseDeTir vitesse de tir que l'on souhaite attribué à l'avion
     * @param prix correpond au prix de l'avion
     */
    public AvionMarine(String nomAvion, int pointDeVie, int vitesseDeTir, int prix) {
        setNomAvion(nomAvion);
        setImageAvion("/resource/image/Avion4.png");
        setPointDeVie(pointDeVie);
        setVitesseDeTir(vitesseDeTir);
        setPrix(prix);
    }

}
