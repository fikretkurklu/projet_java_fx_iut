package vue;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import launch.Launch;
import model.Joueur;

import java.io.IOException;

/**
 * Class Fenetre, abstraite et regroupe les méthodes permettant la navigation d'une fenêtre à une autre
 */
public abstract class Fenetre {

    /**
     * Propriété joueur
     */
    private final ObjectProperty<Joueur> joueur = new SimpleObjectProperty<>(new Joueur("", 0, 0,0, 4));
        public final Joueur getJoueur()  { return joueur.get(); }
        public final void setJoueur(Joueur value) { joueur.set(value); }
        public ObjectProperty<Joueur> joueurProperty() {return joueur;}

    /**
     * Méthode permettant le chargement de la fenêtre menu jeu
     * @throws IOException exception levé
     */
    public void FXMLoaderFenetreMenuJeu() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/resource/fxml/FenetreMenuJeu.fxml"));

        GridPane root = (GridPane) loader.load();

        Scene fenetreMenuJeu = new Scene(root);

        FenetreMenuJeu fenetreMenuJeuController = loader.getController();
        fenetreMenuJeuController.initJoueur(getJoueur());
        fenetreMenuJeu.getStylesheets().add("/resource/stylesheets/style.css");

        Launch.stage.setTitle("Menu Start");
        Launch.stage.setScene(fenetreMenuJeu);
    }

    /**
     * Méthode permettant le chargement de la fenêtre Username
     * @throws IOException exception levé
     */
    public void FXMLoaderFenetreUsername() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/resource/fxml/FenetreUsername.fxml"));

        GridPane root = (GridPane) loader.load();

        Scene fenetreUsername = new Scene(root);
        fenetreUsername.getStylesheets().add("/resource/stylesheets/style.css");

        FenetreUsername fenetreUsernameController = loader.getController();

        Launch.stage.setTitle("Menu Start");
        Launch.stage.setScene(fenetreUsername);
    }

    /**
     * Méthode permettant le chargement de la fenêtre Argent
     * @throws IOException exception levé
     */
    public void FXMLoaderFenetreArgent() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/resource/fxml/FenetreArgent.fxml"));

        AnchorPane root = (AnchorPane) loader.load();

        Scene fenetreArgent = new Scene(root);
        fenetreArgent.getStylesheets().add("/resource/stylesheets/style.css");

        FenetreArgent fenetreArgentController = loader.getController();
        fenetreArgentController.initJoueur(getJoueur());

        Launch.stage.setTitle("Menu Cheat");
        Launch.stage.setScene(fenetreArgent);
    }

    /**
     * Méthode permettant le chargement de la fenêtre start
     * @param joueur joueur à transmettre dans la fenêtre
     * @throws IOException exception levé
     */
    public void FXMLoaderFenetreStart(Joueur joueur) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/resource/fxml/FenetreStart.fxml"));

        Pane root = (Pane) loader.load();

        Scene fenetreStart = new Scene(root);
        fenetreStart.getStylesheets().add("/resource/stylesheets/style.css");

        FenetreStart fenetreMenuStartController = loader.getController();
        fenetreMenuStartController.initJoueur(getJoueur());

        Launch.stage.setTitle("Menu Start");
        Launch.stage.setScene(fenetreStart);
    }

    /**
     * Méthode permettant le chargement de la fenêtre shop
     * @throws IOException exception levé
     */
    public void FXMLoaderFenetreShop() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/resource/fxml/FenetreShop.fxml"));

        AnchorPane root = (AnchorPane) loader.load();

        Scene fenetreShop = new Scene(root);
        fenetreShop.getStylesheets().add("/resource/stylesheets/style.css");

        FenetreShop fenetreShopController = loader.getController();
        fenetreShopController.initJoueur(getJoueur());

        Launch.stage.setTitle("Menu Start");
        Launch.stage.setScene(fenetreShop);
    }

    /**
     * Méthode permettant le chargement de la fenêtre popup
     * @throws IOException exception levé
     */
    public void FXMLoaderPopUp() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/resource/fxml/FenetrePopup.fxml"));

        AnchorPane root = (AnchorPane) loader.load();

        Scene FenetreUsernameScene = new Scene(root, 300, 200);
        FenetreUsernameScene.getStylesheets().add("/resource/stylesheets/style.css");

        Stage stage = new Stage();

        stage.setTitle("Save");
        stage.setScene(FenetreUsernameScene);
        stage.show();
    }

    /**
     * Méthode permettant le chargement de la fenêtre jeu
     * @throws IOException exception levé
     */
    public void FXMLoaderFenetreJeu() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/resource/fxml/FenetreJeu.fxml"));

        Pane root = (Pane) loader.load();

        Scene jeuScene = new Scene(root);
        jeuScene.getRoot().requestFocus();

        FenetreJeu fenetreJeuController = loader.getController();
        fenetreJeuController.initJoueur(getJoueur());

        Launch.stage.setTitle("Jeu");
        Launch.stage.setResizable(false);
        Launch.stage.setScene(jeuScene);
    }

}
