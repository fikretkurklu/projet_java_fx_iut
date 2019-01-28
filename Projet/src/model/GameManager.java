package model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;
import pers.XMLSauvegarde;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Class GameManager permettant la gestion des différents entités entre eux au sein du jeu
 */
public class GameManager {

    /**
     * Valeur correspondant au score actuel
     */
    private int score;

    /**
     * Valeur correspondant à une instance du joueur
     */
    private Joueur joueur;

    /**
     * Valeur correspondant à un nombre aléatoire représentant la position x à laquel le joueur va apparaitre
     */
    private int randomPositionX;

    /**
     * Valeur correspondant à la dernière date à laquelle un ennemi est apparue
     */
    private long dateEnnemySpawn;

    /**
     * Valeur correspondant à la date actuelle au sein du jeu
     */
    private long currentDate;

    /**
     * Instance de random, nécessaire pour génrer la valeur de randomPositionX
     */
    private Random random;

    /**
     * Liste comprenant l'ensemble des ennemi présent dans le jeu à un instant t
     */
    private ArrayList<Ennemi> listEnnemi;

    /**
     * Liste comprenant toute les touches appuyé par le joueur sous format de chaine de caractères
     */
    private ArrayList<String> input;

    /**
     * Instance de Déplacement pour gérer les déplacements dans le jeu
     */
    private Deplacement deplacement;

    /**
     * Instance de Tir pour gérer les tir dans le jeu
     */
    private Tir tir;

    /**
     * Score de la partie courante + property
     */
    private final IntegerProperty currentScore = new SimpleIntegerProperty();
        public Integer getCurrentScore() {return currentScore.get();}
        public void setCurrentScore(Integer meilleurScore) {this.currentScore.set(meilleurScore);}
        public IntegerProperty currentScoreProperty() {return  currentScore;}

    /**
     * Timeline qui agrémente le score de 1 toute les 2secondes
     */
    private Timeline timeline;


    /**
    * Instance de gestion des colisions
    */
    private Colision col;

    /**
     * Propriété contenant le nombre de points de vie de l'utilisateur
     */
    private final IntegerProperty ptsDeVie = new SimpleIntegerProperty();
        public Integer getPtsDeVie() {return ptsDeVie.get();}
        public void setPtsDeVie(Integer ptsDeVie) {this.ptsDeVie.set(ptsDeVie);}
        public IntegerProperty ptsDeVieProperty() {return  ptsDeVie;}



    /**
     * Constructeur de GameManager prenant un paramètre, il génére les instances nécessaire au bon fonctionnement du jeu
     * @param joueur instance de joueur qui va être utilisé dans le jeu
     */

    public GameManager(Joueur joueur) {
        this.joueur = joueur;
        col = new Colision();

        joueurSetting();

        random = new Random();
        listEnnemi = new ArrayList<>();
        input = new ArrayList<>();

        deplacement = new Deplacement();
        tir = new Tir();
        setPtsDeVie(joueur.getAvion().getPointDeVie());

        timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> setCurrentScore(getCurrentScore() +1 ) ));
    }

    /**
     * Méthode permettant de réaliser les actions nécessaire pour que l'instance de Joueur soit bon pour un début
     * de partie
     */
    public void joueurSetting() {
        joueur.setPositionX(100);
        joueur.setPositionY(100);

        XMLSauvegarde xmlSauvegarde = new XMLSauvegarde();
        xmlSauvegarde.sauveJoueur(joueur);
    }

    /**
     * Méthode permettant le spawn des ennemis dans le jeu
     */
    public void ennemySpawn() {
        currentDate = new Date().getTime();
        randomPositionX = 0 + random.nextInt(412);

        if(dateEnnemySpawn == 0) {
            dateEnnemySpawn = new Date().getTime();
            listEnnemi.add(new Ennemi(randomPositionX, -50, 2));
        }

        if((currentDate - dateEnnemySpawn) > 800) {
            listEnnemi.add(new Ennemi(randomPositionX, -50, 2));
            dateEnnemySpawn = currentDate;
        }
    }

    /**
     * Méthode permettant l'ajout du code correspondant à l'appui d'une certaine touche du clavier par le joueur
     * @param code chaine de caractère correspondant à la touche appuyé
     */
    public void toucheAppuyer(String code) {
        if (!input.contains(code))
            input.add(code);
    }

    /**
     * Méthode permettant la suppresion du code présent dans la table représentant une touche qui
     * a été appuyé mais qui ne l'ai plus
     * @param code code de la touche relaché par l'utilisateur
     */
    public void toucheRelache(String code) {
        input.remove(code);
    }

    /**
     * Méthode faisant appelle au différente méthode de la classe Deplacement pour gérer les déplacement au sein
     * du jeu
     */
    public void gestionMouvement() {
        deplacement.deplacementJoueur(joueur, input);
        deplacement.deplacementEnnemi(listEnnemi);

        deplacement.deplacementProjectileJoueur(joueur);
        deplacement.deplacementProjectileListEnnemi(listEnnemi);
    }

    /**
     * Méthode faisant appelle au différente méthode de la classe Tir pour gérer les tir au sein
     * du jeu
     */
    public void gestionTir() {
        tir.tirJoueur(joueur, input);
        tir.tirEnnemi(listEnnemi);
    }

    /**
     * Méthode permettant la gestion des mort au sein du jeu
     * @return la valeur de si le joueur et mort ou non
     */
    public Boolean gestionMort() {
        for(int i = 0; i < listEnnemi.size(); i++) {
            if (listEnnemi.get(i).isMort()) {
                listEnnemi.remove(i);
            }
        }
        if ( getPtsDeVie() <= 0){

            timeline.stop();
            return true;

        }

        return false;
    }

    /**
     * Méthode permettant la gestion des colisions ( fait appel aux méthodes de classes de la classe Colision )
     */

    public void gestionCollisionJeu( ){
        col.gestionCollision(listEnnemi,joueur);
        setPtsDeVie(col.gestionCollisionAvion(listEnnemi,joueur,getPtsDeVie()));
    }


    /**
     * Méthode permettant la gestion du score de la partie courante
     */

    public void gestionScore() {
        timeline.play();
        if ( getCurrentScore() > joueur.getMeilleurScore()){
            joueur.meilleurScoreProperty().bind(currentScoreProperty());
        }
    }


    /**
     * Méthode faisant appellé à toute les méthode nécessaire au bon fonctionnement du jeu
     * @return la valeur de mort
     */
    public Boolean gestionGeneral() {
        ennemySpawn();

        gestionMouvement();

        gestionTir();

        gestionCollisionJeu();

        gestionScore();

        return gestionMort();

    }

    /**
     * Méthode permettant de récupérer la valeur de l'instance de joueur
     * @return retourne l'instance de joueur
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * Méthode permettant de définir le joueur au sein de GameManager
     * @param joueur contient l'instance de joueur
     */
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    /**
     * Méthode permettant de récupérer la liste d'ennemi actuel
     * @return une ArrayList représentant la liste d'ennmi
     */
    public ArrayList<Ennemi> getListEnnemi() {
        return listEnnemi;
    }

    /**
     * Méthode permettant de définir la liste d'ennemi
     * @param listEnnemi représente une ArrayList qui va contenir les ennemi du jeu
     */
    public void setListEnnemi(ArrayList<Ennemi> listEnnemi) {
        this.listEnnemi = listEnnemi;
    }
}
