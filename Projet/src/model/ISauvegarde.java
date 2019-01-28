package model;

/**
 * Interface ISauvegarde permettant de définir l'interface de base d'une classe permettant la sauvegarde de l'application
 */
public interface ISauvegarde {

    /**
     * Méthode contenant le code de sauvegarde du joueur
     * @param joueur correspond à l'instance du joueur à sauvegarder
     */
    public void sauveJoueur(Joueur joueur);

}
