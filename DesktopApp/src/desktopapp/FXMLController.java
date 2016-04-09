/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import static constantes.Constantes.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Victor
 */
public class FXMLController implements Initializable {

    private Parent root;

    @FXML
    private void handleButtonsMenuPrincipalAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = null;
        ResourceBundle bundle = ResourceBundle.getBundle("resources.UIResources");
        switch (((Button) event.getSource()).getId()) {
            case ID_BOTON_PLAY_MENU_PRINCIPAL:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuJuegoNormal.fxml"), bundle);
                break;
            case ID_BOTON_PLAY_ONLINE_MENU_PRINCIPAL:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuJuegoOnline.fxml"), bundle);
                break;
            case ID_BOTON_RULES_MENU_PRINCIPAL:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuRules.fxml"), bundle);
                break;
            case ID_BOTON_RULES_GRAPHICALLY_MENU_PRINCIPAL:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuRulesGrafico.fxml"), bundle);
                break;
            case ID_BOTON_DEVELOPERS_MENU_PRINCIPAL:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuDevelopers.fxml"), bundle);
                break;
            default:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuPrincipal.fxml"), bundle);
                break;
        }
        changeSceneRoot(event, loader, stage);
    }

    @FXML
    private void handleButtonsMenuNormalAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = null;
        ResourceBundle bundle = ResourceBundle.getBundle("resources.UIResources");
        switch (((Button) event.getSource()).getId()) {
            case ID_BOTON_PLAY_MENU_JUEGO_NORMAL:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuConfiguracionJuegoNormal.fxml"), bundle);
                break;
            case ID_BOTON_SCORES_MENU_JUEGO_NORMAL:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuJuegoOnline.fxml"), bundle);
                break;
            case ID_BOTON_BACKUP_MENU_JUEGO_NORMAL:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuJuegoNormal.fxml"), bundle);
                break;
            case ID_BOTON_BACK_MENU_JUEGO_NORMAL:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuPrincipal.fxml"), bundle);
                break;
            default:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuJuegoNormal.fxml"), bundle);
                break;
        }
        changeSceneRoot(event, loader, stage);
    }

    @FXML
    private void handleButtonsMenuOnlineAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = null;
        ResourceBundle bundle = ResourceBundle.getBundle("resources.UIResources");
        switch (((Button) event.getSource()).getId()) {
            case ID_BOTON_PLAY_MENU_JUEGO_ONLINE:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuOpcionesJuegoOnline.fxml"), bundle);
                break;
            case ID_BOTON_SCORES_MENU_JUEGO_ONLINE:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuJuegoOnline.fxml"), bundle);
                break;
            case ID_BOTON_BACK_MENU_JUEGO_ONLINE:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuPrincipal.fxml"), bundle);
                break;
            default:
                loader = new FXMLLoader(getClass().getResource("FXMLMenuJuegoOnline.fxml"), bundle);
                break;
        }
        changeSceneRoot(event, loader, stage);
    }

    @FXML
    private void handleButtonsBackRulesAction(ActionEvent event) {

    }

    @FXML
    private void handleButtonsMenuOpcionesJuegoOnlineAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        String boton=((Button) event.getSource()).getId();
        ResourceBundle bundle = ResourceBundle.getBundle("resources.UIResources");
        FXMLLoader loader = loader = new FXMLLoader(getClass().getResource("FXMLMenuJuegoNormal.fxml"), bundle);
        System.out.println("boton id: "+boton);
        if (boton.equals(ID_BOTON_PLAY_OPCIONES_MENU_ONLINE)) {
            System.out.println("BOTON PLAY");
            switch (getSelectedRadioButtonID(((ObservableList<Node>) ((VBox) stage.getScene().lookup("#RadioGroup_Games_Online")).getChildren()))) {
                case ID_RADIOBUTTON_GAME_OF_3:
                    loader = new FXMLLoader(getClass().getResource("FXMLMenuJuegoOnline.fxml"), bundle);
                    break;
                case ID_RADIOBUTTON_GAME_OF_5:
                    loader = new FXMLLoader(getClass().getResource("FXMLMenuJuegoOnline.fxml"), bundle);
                    break;
                case ID_RADIOBUTTON_GAME_OF_9:
                    loader = new FXMLLoader(getClass().getResource("FXMLMenuJuegoOnline.fxml"), bundle);
                    break;
            }
            switch (getSelectedRadioButtonID(((ObservableList<Node>) ((VBox) stage.getScene().lookup("#RadioGroup_Rounds_Online")).getChildren()))) {
                case ID_RADIOBUTTON_ROUND_OF_1:
                    //TODO SET VARIABLES
                    break;
                case ID_RADIOBUTTON_ROUND_OF_3:
                    ////////////////////////
                    break;
                case ID_RADIOBUTTON_ROUND_OF_5:
                    /////////////////////
                    break;
            }
        }else{
            if(boton.equals(ID_BOTON_RANDOMLY_OPCIONES_MENU_ONLINE)){
                //MAKE RANDOMLY THE SETTING OF THE GAME
                System.out.println("RANDOMLY");
            }else{
                //BACK
                loader = new FXMLLoader(getClass().getResource("FXMLMenuJuegoOnline.fxml"), bundle);
            }
        }
        changeSceneRoot(event, loader, stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private String getSelectedRadioButtonID(ObservableList<Node> lista) {
        String devuelve = "";
        for (Node nodo : lista) {
            RadioButton rb = (RadioButton) nodo;
            if (rb.isSelected()) {
                devuelve = rb.getId();
                break;
            }
        }
        return devuelve;
    }

    private void changeSceneRoot(ActionEvent event, FXMLLoader loader, Stage stage) {
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (root != null) {
            stage.getScene().setRoot(root);
        }
    }
}
