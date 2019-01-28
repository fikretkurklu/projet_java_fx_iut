package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Class FenetrePopup, hérite de Fenetre
 */
public class FenetrePopup extends Fenetre{

    /**
     * Bouton dans le fenêtre fxml
     */
    @FXML
    private Button buttonOk;

    /**
     * Gére le clique sur le bouton ok, et capture l'évefnement
     * @param event capture l'évenement
     */
    @FXML
    public void handleOk(ActionEvent event) {
        Stage stage = (Stage) buttonOk.getScene().getWindow();
        stage.close();
    }

}
