package vue;

import javafx.animation.AnimationTimer;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import model.*;

import javafx.scene.control.Label;

import java.io.IOException;

/**
 * Classe FenetreJeu, hérite de Fenetre
 */
public class FenetreJeu extends Fenetre{


    /**
     * GameManager permettant la gestion du jeu
     */
    private GameManager gameManager;

    /**
     * GraphicsContext permettant la gestion de l'affichage dans le canvas
     */
    private GraphicsContext gc;

    /**
     * Canvas présent dans la fenêtre fxml
     */
    @FXML
    private Canvas canvasGame;

    /**
     * Label score présent sur la fenêtre fxml
     */
    @FXML
    private Label labelScore;

    /**
     * Label argent présent sur la fenêtre argent
     */
    @FXML
    private Label labelArgent;

    /**
     * Animation timer contenant la boucle de jeu
     */
    private AnimationTimer boucleJeu;

    /**
     * Boolean pour savoir si le joueur joue toujours ou non
     */
    private boolean isPlaying;

    /**
     * Boutton quit du FXML
     */
    @FXML
    private Button buttonQuit;
    /**
     * Label points de vie du fxml
     */
    @FXML
    private Label labelPtsVie;

    /**
     * Test si le jeu est terminé
     */
    private boolean isGameOver;

    @FXML
    private Label labelGameOver;


    /**
     * Méthode permettant d'initialiser un joueur, utile pour transmettre les données d'une fenêtre à une autre
     * @param joueur joueur transmis
     */
    public void initJoueur(Joueur joueur) {
        this.setJoueur(joueur);
        gameManager = new GameManager(getJoueur());
        isPlaying = false;
        startGame();
        buttonQuit.setVisible(false);
    }

    /**
     * Méthode capturant le fait qu'une touche du clavier à été cliqué
     * @param event évenement capturé
     */
    @FXML
    public void handleKeyPressed(KeyEvent event) {
        String code = event.getCode().toString();
        if(code == "ESCAPE" && !isGameOver ) {
            if(isPlaying) {
                boucleJeu.stop();
                buttonQuit.setVisible(true);

            } else {
                boucleJeu.start();
                buttonQuit.setVisible(false);
            }
            isPlaying = !isPlaying;
        } else {
            gameManager.toucheAppuyer(code);
        }
    }

    /**
     * Méthode permettant de quitter la partie si le joueur clique sur quit
     * @throws IOException exception levé
     */
    @FXML
    private void handleQuit () throws IOException {

        getJoueur().getListProjectile().clear();

        FXMLoaderFenetreMenuJeu();

    }



    /**
     * Méthode capturant le fait qu'une touche du clavier à été relaché
     * @param event évenement capturé
     */
    @FXML
    public void handleKeyReleased(KeyEvent event) {
        String code = event.getCode().toString();
        gameManager.toucheRelache(code);
    }

    /**
     * Méthode lançant le jeu et dessinant les images nécessaire dans le canvas
     */
    public void startGame() {
        gc = canvasGame.getGraphicsContext2D();
        labelArgent.textProperty().bind(getJoueur().argentProperty().asString());
        labelScore.textProperty().bind(gameManager.currentScoreProperty().asString());
        labelPtsVie.textProperty().bind(gameManager.ptsDeVieProperty().asString());
        labelGameOver.setVisible(false);
        boucleJeu = new AnimationTimer() {
            private long fps = -1;

            public void handle(long currentNanotime) {

                if (currentNanotime - fps >= 3000000) {
                    gc.clearRect(0, 0, 512, 512);
                    isGameOver = gameManager.gestionGeneral();


                    for (int iE = 0; iE < gameManager.getListEnnemi().size(); iE++) {
                        gc.drawImage(new Image(gameManager.getListEnnemi().get(iE).getAvion().getImageAvion()), gameManager.getListEnnemi().get(iE).getPositionX(), gameManager.getListEnnemi().get(iE).getPositionY());
                        for (int iPE = 0; iPE < gameManager.getListEnnemi().get(iE).getListProjectile().size(); iPE++) {
                            gc.drawImage(new Image(gameManager.getListEnnemi().get(iE).getListProjectile().get(iPE).getImageProjectile()), gameManager.getListEnnemi().get(iE).getListProjectile().get(iPE).getPositionX(), gameManager.getListEnnemi().get(iE).getListProjectile().get(iPE).getPositionY());
                        }
                    }

                    for (int i = 0; i < gameManager.getJoueur().getListProjectile().size(); i++) {
                        gc.drawImage(new Image(gameManager.getJoueur().getListProjectile().get(i).getImageProjectile()), gameManager.getJoueur().getListProjectile().get(i).getPositionX(), gameManager.getJoueur().getListProjectile().get(i).getPositionY());
                    }

                    gc.drawImage(new Image(gameManager.getJoueur().getAvion().getImageAvion()), gameManager.getJoueur().getPositionX(), gameManager.getJoueur().getPositionY());

                    fps = currentNanotime;
                }
                if (isGameOver){
                    this.stop();
                    buttonQuit.setVisible(true);
                    labelGameOver.setVisible(true);
                }

            }
        };
        isPlaying = true;
        boucleJeu.start();
    }

}