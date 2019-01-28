package model;

import javafx.scene.image.Image;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class Deplacement gérant tout les déplacements de tout les entités au sein du jeu, il est appelé par la classe GameManager
 */
public class Deplacement {

    /**
     * méthode deplacementJoueur comprenant deux paramètres permettant la gestion des déplacements du joueur
     * @param joueur Contient l'instance du joueur
     * @param input Contient un tableau ayant les valeurs correpondant au touche appuyé
     */
    public void deplacementJoueur(Joueur joueur, ArrayList<String> input) {
        if(input.contains("LEFT")) {
            if(joueur.positionX.get() > 0)
                joueur.setPositionX(joueur.getPositionX() - joueur.getVitesseEntite());
        }

        if(input.contains("RIGHT")) {
            if(joueur.positionX.get() < (512 - new Image(joueur.getAvion().getImageAvion()).getWidth()))
                joueur.setPositionX(joueur.getPositionX() + joueur.getVitesseEntite());
        }

        if(input.contains("UP")) {
            if(joueur.positionY.get() > 0)
                joueur.setPositionY(joueur.getPositionY() - joueur.getVitesseEntite());
        }

        if(input.contains("DOWN")) {
            if(joueur.positionY.get() < (512 - new Image(joueur.getAvion().getImageAvion()).getHeight())) {
                joueur.setPositionY(joueur.getPositionY() + joueur.getVitesseEntite());
            }
        }
    }

    /**
     * méthode deplacementEnnemi permettant la gestion du déplacement de l'ennemi, prend un paramètre
     * @param listEnnemi Contient la liste de tout les ennemis à déplacer
     */
    public void deplacementEnnemi(ArrayList<Ennemi> listEnnemi) {
        for(int i = 0; i < listEnnemi.size(); i++) {
            listEnnemi.get(i).setPositionY(listEnnemi.get(i).getPositionY() + listEnnemi.get(i).getVitesseEntite());

            if(listEnnemi.get(i).getPositionY() > (512 - new Image(listEnnemi.get(i).getAvion().getImageAvion()).getHeight())) {
                listEnnemi.get(i).setMort(true);
            }
        }
    }

    /**
     * méthode déplacerProjectile permettant la gestion du déplacement du projectile, prend un paramètre
     * @param projectile Contient l'instance du projectile à déplacer
     */
    public void deplacerProjectile(Projectile projectile) {
        projectile.setPositionY(projectile.getPositionY()+projectile.getVitesseProjectile());

        if(projectile.getPositionY() > (512 - new Image(projectile.getImageProjectile()).getHeight()) || projectile.getPositionY() < 0) {
            projectile.setActif(false);
        }
    }

    /**
     * méthode deplacementProjectileJoueur, permet le déplacement des projectiles présent au sein de la liste de projectile de joueur
     * @param joueur Contient l'instance du joueur permettant l'accès à la liste de projectile
     */
    public void deplacementProjectileJoueur(Joueur joueur) {
        for(int j = 0; j < joueur.listProjectile.size(); j++) {
            if(!joueur.getListProjectile().get(j).isActif()) {
                joueur.getListProjectile().remove(j);
            } else {
                deplacerProjectile(joueur.getListProjectile().get(j));
            }
        }
    }

    /**
     * méthode deplacementProjectileListEnnemi, permet le déplcement des projectiles présent au sein de laiste de projectile de chaque ennemi
     * @param listEnnemi Contient la liste des ennemi, dans chaque ennemi est présent une liste de projectile leur appartenant
     */
    public void deplacementProjectileListEnnemi(ArrayList<Ennemi> listEnnemi) {
        for(int i = 0; i < listEnnemi.size(); i++) {
            for(int j = 0; j < listEnnemi.get(i).listProjectile.size(); j++)
                if(!listEnnemi.get(i).getListProjectile().get(j).isActif()) {
                    listEnnemi.get(i).getListProjectile().remove(j);
                } else {
                    deplacerProjectile(listEnnemi.get(i).getListProjectile().get(j));
                }
        }
    }


}
