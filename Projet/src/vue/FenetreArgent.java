package vue;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import model.Joueur;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.function.UnaryOperator;

/**
 * Class FenetreArgent, hérite de Fenetre
 */
public class FenetreArgent extends Fenetre{

    /**
     * TextField présent sur la fenêtre fxml
     */
    @FXML
    private TextField textField;

    /**
     * TextFormatter présent sur le textfield
     */
    private TextFormatter<String> textFormatter;

    /**
     * Récupére le text formatter string
     * @return le text formatter
     */
    private TextFormatter<String> getTextFormatter() {
        UnaryOperator<TextFormatter.Change> filter = getFilter();
        return new TextFormatter<>(filter);
    }

    /**
     * Filtre du textFormateur , accepte seulement les nombres
     * @return retourne UnaryOperator de TextFormatter.Change
     */
    private UnaryOperator<TextFormatter.Change> getFilter() {
        return change -> {
            String text = change.getText();

            if (text.matches("[0-9]*") || text.isEmpty()) {
                return change;
            }

            return null;
        };
    }

    /**
     * méthode appelé au lancement de la fenêtre
     */
    public void initialize() {

        textFormatter = getTextFormatter();
        textField.setTextFormatter(textFormatter);

    }

    /**
     * Méthode permettant d'initialiser un joueur, utile pour transmettre les données d'une fenêtre à une autre
     * @param joueur joueur transmis
     */
    public void initJoueur(Joueur joueur) {
        this.setJoueur(joueur);
    }

    /**
     * Méthode permettant la gestion du clique sur le bouton valider
     * @param event evenement capturé
     * @throws IOException exception levé
     */
    @FXML
    public void handleValider(ActionEvent event) throws IOException {

        String argent = textField.getText();
        int argentInt = Integer.parseInt(argent);
        getJoueur().setArgent(argentInt);
        System.out.println(getJoueur().getArgent());

        FXMLoaderPopUp();

    }

    /**
     * Méthode permettant la gestion du clique sur le bouton retour
     * @param event evenement capturé
     * @throws IOException exception levé
     */
    @FXML
    public void handleRetour(ActionEvent event) throws IOException {
        FXMLoaderFenetreMenuJeu();
    }
}
