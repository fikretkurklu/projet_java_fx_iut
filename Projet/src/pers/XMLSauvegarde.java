package pers;

import model.ISauvegarde;
import model.Joueur;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Class XMLSauvegarde, Implémente l'interface ISauvegarde, ce qui permet de réaliser des sauvegarde sous
 * le format xml
 */
public class XMLSauvegarde implements ISauvegarde {

    /**
     * Méthode implémenté depuis l'interface, l'algorithme réecrit pour permettre la sauvegarde dans un fichier
     * de type xml
     * @param joueur correspond à l'instance du joueur à sauvegarder
     */
    @Override
    public void sauveJoueur(Joueur joueur) {
        try (XMLEncoder oos = new XMLEncoder(new FileOutputStream("joueur.xml"))) {
            oos.writeObject(joueur);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
