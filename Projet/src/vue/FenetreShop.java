package vue;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import launch.Launch;
import model.Avion;
import model.AvionChasse;
import model.AvionMarine;
import model.Joueur;
import stub.FabriqueAvion;
import stub.FabriqueAvionStub;

import java.util.ArrayList;

/**
 * Class FenetreShop, hérite de Fenetre
 */
public class FenetreShop extends Fenetre{


    /**
     * Attribut de FabriqueAvion
     */
    private FabriqueAvion fabriqueAvion;

    /**
     * ArrayList Avion contenant la liste d'avion
     */
    private ArrayList<Avion> listAvion;

    /**
     * ComboBox avion
     */
    @FXML
    private ComboBox<Avion> avionCombo;

    /**
     * Image représentant l'avion
     */
    @FXML
    private ImageView avionImage;

    /**
     * Label représentant le nombre de pts de l'avion dans la vue
     */
    @FXML
    private Label ptsVieAvion;

    /**
     * Label représentant le prix de l'avion dans la vue
     */
    @FXML
    private Label prix;


    /**
     * Méthode permettant de définir la fenêtre, réalisé dans une méthode à part au lieu de initialise, car on il doit être appelé
     * après initJoueur
     */
    public void settingShop() {
        fabriqueAvion = new FabriqueAvionStub();
        listAvion = new ArrayList<>();

        listAvion = fabriqueAvion.fabriqueAvion();

        for(int avionIndex = 0; avionIndex < listAvion.size(); avionIndex++) {
            avionCombo.getItems().add(listAvion.get(avionIndex));
        }


        avionCombo.setConverter(new StringConverter<Avion>() {
            @Override
            public String toString(Avion avion) {
                String returnString = avion == null ? "" : avion.getNomAvion();
                if(avion != null) {
                    for(int i = 0; i < avionCombo.getItems().size(); i++) {
                        if(avion.getNomAvion() == avionCombo.getItems().get(i).getNomAvion()) {
                            returnString = i + " " + returnString;
                        }
                    }
                }
                return returnString;
            }

            @Override
            public Avion fromString(String s) {
                return avionCombo.getItems().get(Integer.valueOf(s.charAt(0)));
            }
        });


        avionCombo.getSelectionModel().selectedItemProperty().addListener((v, oldAvion, newAvion ) -> {
            if (newAvion != null) {
                avionImage.setImage(new Image(newAvion.getImageAvion()));
                ptsVieAvion.textProperty().bind(newAvion.pointDeVieProperty().asString());
                prix.textProperty().bind(newAvion.prixProperty().asString());
            }
        });
    }

    /**
     * Méthode permettant la gestion de l'achat d'un avion par un joueur
     */
    public void handleAcheter (){

        if ( getJoueur().getArgent() >= avionCombo.getSelectionModel().selectedItemProperty().get().getPrix()) {
            getJoueur().getListAvionPosseder().add(avionCombo.getSelectionModel().selectedItemProperty().get());
            System.out.println(avionCombo.getSelectionModel().selectedItemProperty().get().getNomAvion()+" ACHETER ");

            getJoueur().setArgent(getJoueur().getArgent() - avionCombo.getSelectionModel().selectedItemProperty().get().getPrix());
        } else {
            System.out.println(avionCombo.getSelectionModel().selectedItemProperty().get().getNomAvion()+" PAS ASSEZ D'ARGENT ");
        }


    }

    /**
     * Méthode permettant d'initialiser un joueur, utile pour transmettre les données d'une fenêtre à une autre
     * @param joueur joueur transmis
     */
    public void initJoueur(Joueur joueur) {
        this.setJoueur(joueur);
        settingShop();
    }

    /**
     * Méthode gérant le retour à la page précedente, capturant l'évenement par la même occasion
     * @param event évenement capturé
     * @throws Exception exception levée
     */
    @FXML
    public void handleRetour (ActionEvent event) throws Exception {
        FXMLoaderFenetreMenuJeu();
    }

}
