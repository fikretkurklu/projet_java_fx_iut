package stub;

import model.Avion;

import java.util.ArrayList;

/**
 * Class FabriqueAvion, abstraite, contient les attributs et méthodes d'une fabrique d'avion
 */
public abstract class FabriqueAvion {

    /**
     * Liste d'avion retourné à la fin de la fabrication
     */
    protected ArrayList<Avion> listAvion;

    /**
     * Méthode fabrique avion qui va permettre la création des avion
     * @return Liste d'avion
     */
    public abstract ArrayList<Avion> fabriqueAvion();

}
