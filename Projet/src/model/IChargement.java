package model;

/**
 * Interface IChargement permettant de définir l'interface de base d'une classe permettant le chargement au sein de l'application
 */
public interface IChargement {

    /**
     * Méthode contenant le code de chargement du joueur
     * @return la valeur du joueur chargé à partir d'un type de fichier demandé
     */
    public Joueur chargeJoueur();

}
