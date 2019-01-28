package model;

import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class joueur, hérite de Personnage et implémente l'interface Serializable
 * Permet de représenter un joueur au sein de l'application
 */
public class Joueur extends Personnage implements Serializable {

    /**
     * StringProperty représentant le nom du joueur
     */
    private final StringProperty nomJoueur = new SimpleStringProperty();
        public String getNomJoueur() {return nomJoueur.get();}
        public void setNomJoueur(String nomJoueur) {this.nomJoueur.set(nomJoueur);}
        public StringProperty nomJoueurProperty() {return nomJoueur;}

    /**
     * IntegerProperty représentant l'argent actuel du joueur
     */
    private final IntegerProperty argent = new SimpleIntegerProperty();
        public Integer getArgent() {return argent.get();}
        public void setArgent(Integer argent) {this.argent.set(argent);}
        public IntegerProperty argentProperty() {return argent;}

    /**
     * IntegerProperty représentant le meilleur score réalisé par le joueur
     */
    private final IntegerProperty meilleurScore = new SimpleIntegerProperty();
        public Integer getMeilleurScore() {return meilleurScore.get();}
        public void setMeilleurScore(Integer meilleurScore) {this.meilleurScore.set(meilleurScore);}
        public IntegerProperty meilleurScoreProperty() {return  meilleurScore;}

    /**
     * Observable List utilisé lors de l'affichage de la liste de l'avion possédé par le joueur
     */
    private ObservableList<Avion> listAvionObs = FXCollections.observableArrayList();;

    /**
     * List contenant les avions possédé par le joueur
     */
    private final ListProperty<Avion> listAvion = new SimpleListProperty<>(listAvionObs);
        public ObservableList<Avion> getListAvion() {return listAvion.get();}
        public void setListAvion(ObservableList<Avion> listAvion) {this.listAvion.set(listAvion);}
        public ListProperty<Avion> listAvionProperty() {return listAvion;}

    /**
     *
     */
    private ArrayList<Avion> listAvionPosseder;

    /**
     * Constructeur de Joueur ne prenant aucun paramètre, nécessaire pour le bon fonctionnement de la sérialisation
     */
    public Joueur() {}

    /**
     * Constructeur Joueur prenant les paramètres nécessaire à la bonne utilisation d'un joueur de base
     * @param nomJoueur valeur du nom du joueur
     * @param positionX valeur de la position x du joueur à l'écran
     * @param positionY valeur de la position y du joueur à l'écran
     * @param argent valeur de l'argent possédé par le joueur
     * @param vitesseEntite valeur de la vitesse de l'entité joueur
     */
    public Joueur(String nomJoueur, int positionX, int positionY, int argent, int vitesseEntite){
        setNomJoueur(nomJoueur);
        setPositionX(positionX);
        setPositionY(positionY);
        setArgent(argent);
        setVitesseEntite(vitesseEntite);

        listAvionPosseder = new ArrayList<Avion>();
        listProjectile = new ArrayList<Projectile>();
    }

    /**
     * Genere des avions de base que le joueur doit avoir en début de partie
     */
    public void genererAvionBase() {
        listAvionPosseder.add(new AvionChasse("Avion Chasse", 100, 10, 50));
    }

    /**
     * Genere les avions ajouté au sein de l'observable list lors de la première execution
     */
    public void genererAvion() {
        for(int i = 0; i < getListAvionPosseder().size(); i++) {
            listAvionObs.add(listAvionPosseder.get(i));
        }
    }

    /**
     * Permet de récupérer le contenu de la liste d'avion posseder par l'utilisateur
     * @return contenu de la liste
     */
    public ArrayList<Avion> getListAvionPosseder() {
        return listAvionPosseder;
    }

    /**
     * Permet de définir une liste pour les avions posséder par l'utilisateur
     * @param listAvionPosseder Liste fourni
     */
    public void setListAvionPosseder(ArrayList<Avion> listAvionPosseder) {
        this.listAvionPosseder = listAvionPosseder;
    }

    public ObservableList<Avion> getListAvionObs() {
        return listAvionObs;
    }

    public void setListAvionObs(ObservableList<Avion> listAvionObs) {
        this.listAvionObs = listAvionObs;
    }
}