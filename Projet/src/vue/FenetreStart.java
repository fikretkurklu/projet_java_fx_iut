package vue;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import launch.Launch;
import model.Avion;
import model.AvionChasse;
import model.Joueur;

import javax.naming.Binding;
import java.util.ArrayList;

/**
 * Class FenetreStart, hérite de Fenetre
 */
public class FenetreStart extends Fenetre{

    /**
     * Liste view présent sur la fenêtre fxml
     */
    @FXML
    private ListView<Avion> laListe;

    /**
     * Liste view présent sur la fenêtre fxml
     */
    @FXML
    private ListView<Avion> laListeAffichage;

    /**
     * Bouton start présent sur la fenêtre fxml
     */
    @FXML
    public Button buttonStart;

    /**
     * Méthode permettant d'initialiser un joueur, utile pour transmettre les données d'une fenêtre à une autre
     * @param joueur joueur transmis
     */
    public void initJoueur(Joueur joueur) {
        setJoueur(joueur);
        settingStartMenu();
    }

    /**
     * Méthode permettant le paramètrage de la fenêtre, méthode appelée à la fin de la méthode initJoueur
     */
    public void settingStartMenu() {
        getJoueur().genererAvion();

        laListeAffichage.setItems(getJoueur().getListAvion());
        laListe.setItems(getJoueur().getListAvion());

        laListe.setCellFactory(param -> cellFactoryAvion());

        buttonStart.setVisible(false);

        laListeAffichage.setCellFactory(param -> new ListCell<Avion>(){
            @Override
            protected void updateItem(Avion item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    textProperty().unbind();
                    setText("");
                } else {
                    textProperty().bind(item.nomAvionProperty());
                }
            }

        });

        laListeAffichage.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Avion>() {
            @Override
            public void changed(ObservableValue<? extends Avion> observable, Avion oldValue, Avion newValue) {
                getJoueur().setAvion(newValue);

                if(getJoueur().getAvion() != null) {
                    buttonStart.setVisible(true);
                }
            }
        });
    }

    /**
     * Méthode gérant le retour à une fenêtre, capturant l'évenement
     * @param event évenement capturé
     * @throws Exception exception levée
     */
    public void handleRetour (ActionEvent event) throws Exception {
        getJoueur().setListAvionObs(FXCollections.observableArrayList());
        getJoueur().setListAvion(getJoueur().getListAvionObs());

        FXMLoaderFenetreMenuJeu();
    }

    /**
     * Méthode gérant le clique sur le bouton start, capturant l'évenement
     * @param event évenement capturé
     * @throws Exception exception levée
     */
    public void handleStart (ActionEvent event) throws Exception {
        getJoueur().setListAvionObs(FXCollections.observableArrayList());
        getJoueur().setListAvion(getJoueur().getListAvionObs());

        FXMLoaderFenetreJeu();
    }

    /**
     * Méthode permettant la création d'une cell factory avion
     * @return une ListCell Avion
     */
    private ListCell<Avion> cellFactoryAvion() {
        return new ListCell<Avion>() {

            private TextField leTextField = null;
            private Avion itemBind = null;

            @Override
            protected void updateItem(Avion item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    leTextField = new TextField();
                    leTextField.textProperty().bindBidirectional(item.nomAvionProperty());
                    itemBind = item;
                    setGraphic(leTextField);
                } else {
                    setText("");
                    setGraphic(null);
                    if (leTextField != null && itemBind != null) {
                        leTextField.textProperty().unbindBidirectional(itemBind.nomAvionProperty());
                    }
                }
            }

        };
    }



}
