package stub;

import model.Avion;
import model.AvionChasse;
import model.AvionMarine;
import model.AvionSpitfire;

import java.util.ArrayList;

/**
 * Class FabriqueAvionStub, hérite de FabriqueAvion
 */
public class FabriqueAvionStub extends FabriqueAvion {

    /**
     * Méthode permettant la création d'une liste contenant des valeurs par défaut d'avion
     * @return la liste contenant les avions
     */
    @Override
    public ArrayList<Avion> fabriqueAvion() {
        listAvion = new ArrayList<>();

        listAvion.add(new AvionChasse("Avion Chasse", 100, 10, 50));
        listAvion.add(new AvionMarine("Avion Marine 92i", 100, 10, 150));
        listAvion.add(new AvionSpitfire("Avion Spitfire Dozo", 200, 30, 300));

        return listAvion;
    }

}
