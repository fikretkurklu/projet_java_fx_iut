package stub;

import model.Avion;

import java.util.ArrayList;

/**
 * Class FabriqueAvionVide, hérite de FabriqueAvion
 */
public class FabriqueAvionVide extends FabriqueAvion {

    /**
     * Méthode fabriqueAvion, retourne une liste d'avion vide
     * @return la liste d'avion vide
     */
    @Override
    public ArrayList<Avion> fabriqueAvion() {
        listAvion = new ArrayList<>();
        return listAvion;
    }

}
