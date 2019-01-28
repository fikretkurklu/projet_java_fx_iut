package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import java.util.function.UnaryOperator;

/**
 * Class FenetreUsername, hérite de Fenetre
 */
public class FenetreUsername extends Fenetre{

    /**
     * TextField de la fenêtre fxml
     */
    @FXML
    private TextField inputPseudo;

    /**
     * Label pseudo de la fenêtre fxml
     */
    @FXML
    private Label pseudo;

    /**
     * TextFormatter de string
     */
    private TextFormatter<String> textFormatter;

    /**
     * Méthode appelé à l'initialisation de la fenêtre
     */
    public void initialize() {
        textFormatter = getTextFormatter();

        pseudo.textProperty().bind(getJoueur().nomJoueurProperty());
        inputPseudo.textProperty().bindBidirectional(getJoueur().nomJoueurProperty());
    }


    /**
     * Retourne le text formatter
     * @return text formatter string
     */
    private TextFormatter<String> getTextFormatter() {
        UnaryOperator<TextFormatter.Change> filter = getFilter();
        return new TextFormatter<>(filter);
    }

    /**
     * filtre du TextFormatter qui n'acceptre que les caractère de l'alphabet
     * @return un UnaryOperator TextFormatter.Change
     */
    private UnaryOperator<TextFormatter.Change> getFilter() {
        return change -> {
            String text = change.getText();

            if (text.matches("[a-zA-Z]*") || text.isEmpty()) {
                return change;
            }

            return null;
        };
    }

    /**
     * Méthode permettant la gestion de l'appuie sur le bouton valider
     * @param event evenement attraper
     * @throws Exception exception levée
     */
    @FXML
    public void handleValider (ActionEvent event) throws Exception {
        getJoueur().genererAvionBase();

        FXMLoaderFenetreMenuJeu();
    }
}
