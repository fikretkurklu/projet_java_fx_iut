package model;

import java.util.ArrayList;

/**
 * Class Colision, gestion de la colision au sein du projet
 */
public class Colision {


    /**
     * Méthode permettant la gestion des collisions entre les missilles du joueur et les avions ennemi
     * @param listEnnemi la liste d'ennemi
     * @param joueur le joueur
     */
    public void gestionCollision(ArrayList<Ennemi> listEnnemi, Joueur joueur) {
        if (!listEnnemi.isEmpty() && !joueur.listProjectile.isEmpty()) {
            for (int i = 0; i < joueur.getListProjectile().size(); i++) {

                for (int j = 0; j < listEnnemi.size(); j++) {
                    if (listEnnemi.get(j).getPositionX() <= joueur.listProjectile.get(i).getPositionX() && joueur.listProjectile.get(i).getPositionX() <= listEnnemi.get(j).getPositionX() + 50
                            && listEnnemi.get(j).getPositionY() <= joueur.listProjectile.get(i).getPositionY() && joueur.listProjectile.get(i).getPositionY() <= listEnnemi.get(j).getPositionY() + 50) {

                        listEnnemi.get(j).setMort(true);
                        joueur.listProjectile.remove(i);
                        joueur.setArgent(joueur.getArgent() + 2);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Méthode permettant la gestion des collisions entre les avions ennemis et l'avion du joueur
     * @param listEnnemi la liste d'ennemi
     * @param joueur le joueur
     * @param ptsVie le nombre de points de vie du joueur
     * @return le nombre de points de vie
     */
    public int gestionCollisionAvion(ArrayList<Ennemi> listEnnemi, Joueur joueur, int ptsVie){

        if (!listEnnemi.isEmpty()){

            for(int i =0; i < listEnnemi.size(); i++ ){
                if ( listEnnemi.get(i).getPositionX()-20 <= joueur.getPositionX() && joueur.getPositionX() <= listEnnemi.get(i).getPositionX()+40 &&
                        listEnnemi.get(i).getPositionY()-20 <= joueur.getPositionY() && joueur.getPositionY() <= listEnnemi.get(i).getPositionY()+40) {
                    listEnnemi.get(i).setMort(true);
                    ptsVie = ptsVie - 50;
                    break;
                }
            }

        }
        return ptsVie;
    }

    /*public void gestionColisionTir( ArrayList<Ennemi> listEnnemi, Joueur joueur ){

        if (!listEnnemi.isEmpty()){

            for (int i=0 ; i < listEnnemi.size() ; i++) {

                for (int j =0 ; j < listEnnemi.get(i).getListProjectile().size() ; j++ ){

                    if ( listEnnemi.get(i).getListProjectile().get(i).getPositionX() <= joueur.getPositionX() && joueur.getPositionX() <= listEnnemi.get(i).getListProjectile().get(i).getPositionX() +10 &&
                            listEnnemi.get(i).getListProjectile().get(i).getPositionY() <= joueur.getPositionY() && joueur.getPositionY() <= listEnnemi.get(i).getListProjectile().get(i).getPositionY() +10 ) {
                        joueur.getAvion().setPointDeVie(joueur.getAvion().getPointDeVie() - 50);
                        System.out.println("Joueur touché par un missile ennemi");
                    }

                }

            }

        }


    }*/


}
