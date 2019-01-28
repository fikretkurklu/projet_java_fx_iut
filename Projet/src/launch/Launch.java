package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Launch extends Application {

    public static Stage stage;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage PrimaryStage) throws Exception {
        System.setProperty("quantum.multithreaded", "false");
        stage = PrimaryStage;

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/resource/fxml/FenetreIntro.fxml"));

        Scene FenetreUsernameScene = new Scene(root, 600, 400);
        FenetreUsernameScene.getStylesheets().add("/resource/stylesheets/style.css");

        stage.setTitle("Welcome");
        stage.setScene(FenetreUsernameScene);
        stage.show();
    }

}