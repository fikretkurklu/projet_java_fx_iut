package vue;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import launch.Launch;
import model.Joueur;
import pers.XMLChargement;

import java.io.IOException;

/**
 * Controller de la fenêtre FenetreIntro
 */
public class FenetreIntro extends Fenetre{

    /**
     * Méthode permettant la gestion de l'action réaliser lorsque le bouton continuer est appuyé
     * @throws IOException exception levé
     */
    @FXML
    public void handleContinuer() throws IOException {

        XMLChargement load = new XMLChargement();
        setJoueur(load.chargeJoueur());

        FXMLoaderFenetreMenuJeu();
    }

    /**
     * Méthode permettant la gestion de l'action réaliser lorsque le bouton nouvelle partie est appuyé
     * @throws IOException exception levé
     */
    @FXML
    public void handleNew () throws IOException {
        FXMLoaderFenetreUsername();
    }

}
