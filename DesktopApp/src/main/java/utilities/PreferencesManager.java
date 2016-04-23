/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import static constantes.Constantes.*;
import java.util.prefs.Preferences;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vista.FXMLController;
import static vista.FXMLController.getSelectedRadioButtonID;

/**
 *
 * @author Victor
 */
public class PreferencesManager {

    public static void setPreferencesNormal(String roundsOption, String playerNumber, String gameOption, String player1Name, String player2Name, String customRounds) {
        Preferences prefs = Preferences.userNodeForPackage(FXMLController.class);
        prefs.put("roundsNormal", roundsOption);
        prefs.put("playerNumber", playerNumber);
        prefs.put("GameOptionNormal", gameOption);
        prefs.put("playerJ1Name", player1Name);
        if (playerNumber.equals(ID_RADIOBUTTON_2_PLAYERS)) {
            prefs.put("playerJ2Name", player2Name);
        }
        if (roundsOption.equals(ID_RADIOBUTTON_ROUND_CUSTOMIZED)) {
            prefs.put("roundCustomized", customRounds);
        }
    }

    public static void getPreferencesNormal(ObservableList<Node> nodoRound, ObservableList<Node> nodoPlayers, ObservableList<Node> nodoGame, TextField player1, TextField player2, TextField roundCustomed) {
        Preferences prefs = Preferences.userNodeForPackage(FXMLController.class);
        String roundsOption, playerNumber, gameOption, player1Name, player2Name,customRounds;
        roundsOption = prefs.get("roundsNormal", "");
        playerNumber = prefs.get("playerNumber", "");
        gameOption = prefs.get("GameOptionNormal", "");
        player1Name = prefs.get("playerJ1Name", "");
        System.out.println("player1Name devuelve: "+player1Name);
        player1.setText(player1Name);
        if (playerNumber.equals(ID_RADIOBUTTON_2_PLAYERS)) {
            player2Name = prefs.get("playerJ2Name", "");
        }
        if (roundsOption.equals(ID_RADIOBUTTON_ROUND_CUSTOMIZED)) {
            customRounds = prefs.get("roundCustomized", "");
        }
    }

}
