package vue;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import launch.Launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Joueur;
import pers.XMLSauvegarde;

import java.io.IOException;

/**
 * Class FenetreMenuJeu, hérite de Fenetre
 */
public class FenetreMenuJeu extends Fenetre{

    /**
     * Méthode permettant d'initialiser un joueur, utile pour transmettre les données d'une fenêtre à une autre
     * @param joueur joueur transmis
     */
    public void initJoueur(Joueur joueur) {
        this.setJoueur(joueur);
    }

    /**
     * Capture l'action lors du clique sur le bouton start
     * @param event évenement capturé
     * @throws Exception exception levée
     */
    @FXML
    public void handleStartJeu(ActionEvent event) throws Exception {

        FXMLoaderFenetreStart(getJoueur());

    }

    /**
     * Capture l'action lors du clique sur le bouton shop
     * @param event évenement capturé
     * @throws Exception exception levée
     */
    public void handleShop (ActionEvent event) throws Exception {

        FXMLoaderFenetreShop();

    }

    /**
     * Capture l'action lors du clique sur le bouton quitte
     * @param event évenement capturé
     */
    @FXML
    public void handleQuit(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Capture l'action lors du clique sur le bouton sauvegarde
     * @param event évenement capturé
     * @throws IOException exception levée
     */
    @FXML
    public void handleSave (ActionEvent event) throws IOException {

        XMLSauvegarde save = new XMLSauvegarde();

        save.sauveJoueur(getJoueur());

        FXMLoaderPopUp();

    }

    /**
     * Capture l'action lors du clique sur le bouton argent
     * @param event évenement capturé
     * @throws IOException exception levée
     */
    @FXML
    public void handleArgent (ActionEvent event) throws IOException {

        FXMLoaderFenetreArgent();

    }
}
