package model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Date;

/**
 * Class Tir, permet de gérer les tir des différents entité personnage présent au sein du jeu
 */
public class Tir {

    /**
     * Méthode permettant de gérer le tir du joueur
     * @param joueur correspond à l'instance du joueur
     * @param input tableau représentant les touches appuyé par le joueur
     */
    public void tirJoueur(Joueur joueur, ArrayList<String> input) {
        joueur.setCurrentDate(new Date().getTime());

        if (joueur.getDateTir() == 0) {
            joueur.setDateTir(new Date().getTime());
        }
        if (input.contains("SPACE")) {
            if ((joueur.getCurrentDate() - joueur.getDateTir()) > 250 ) {
                //joueur.getListProjectile().add(new Projectile(joueur.getPositionX(), joueur.getPositionY(), -8));
                joueur.getListProjectile().add(new Projectile(joueur.getPositionX() + (int) (new Image(joueur.getAvion().getImageAvion()).getWidth() / 2), joueur.getPositionY(), -8));
                joueur.setDateTir(joueur.getCurrentDate());
            }
        }
    }

    /**
     * Méthode permettant de gérer le tir des ennemi
     * @param listEnnemi correspond à la liste des ennemi contenant les ennemi ayant besoin d'une gestion de leur tir
     */
    public void tirEnnemi(ArrayList<Ennemi> listEnnemi) {
        for(int i = 0; i < listEnnemi.size(); i++) {
            listEnnemi.get(i).setCurrentDate(new Date().getTime());
            if ( listEnnemi.get(i).getDateTir() == 0 ) {
                listEnnemi.get(i).setDateTir(new Date().getTime());
            }
            if ((listEnnemi.get(i).getCurrentDate() - listEnnemi.get(i).getDateTir()) > 500) {
                listEnnemi.get(i).getListProjectile().add(new Projectile(listEnnemi.get(i).getPositionX(), listEnnemi.get(i).getPositionY(), +4));
                listEnnemi.get(i).setDateTir(listEnnemi.get(i).getCurrentDate());
            }
        }

    }

}
