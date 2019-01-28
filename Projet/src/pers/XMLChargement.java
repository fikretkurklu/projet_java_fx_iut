package pers;

import model.IChargement;
import model.Joueur;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Class XMLChargement, Implémente l'interface IChargement, ce qui permet de réaliser des chargement depuis
 * un fichier au format xml
 */
public class XMLChargement implements IChargement {

    /**
     * Méthode implémenté depuis l'interface, l'algorithme réecrit pour permettre le chargement d'un joueur
     * depuis un fichier de type xml
     * @return le joueur chargé depuis le fichier
     */
    @Override
    public Joueur chargeJoueur() {
        Joueur joueur = null;

        try (XMLDecoder ois = new XMLDecoder(new FileInputStream("joueur.xml"))) {
            joueur = ((Joueur) ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return joueur;
    }
}
