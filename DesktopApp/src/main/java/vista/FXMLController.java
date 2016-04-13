/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.mycompany.datapptgame.MetaMessage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import static constantes.Constantes.*;
import eu.hansolo.enzo.notification.Notification;
import eu.hansolo.enzo.notification.Notification.Notifier;
import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.DataContainer;
import modelo.ModalidadJuego;
import static modelo.ModalidadJuego.*;

/**
 *
 * @author Victor
 */
public class FXMLController implements Initializable {

    private Parent root;
    private static DataContainer datos;

    @FXML
    private ComboBox cbox;

    @FXML
    private void handleButtonsMenuPrincipalAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = null;
        ResourceBundle bundle = ResourceBundle.getBundle("strings.UIResources");
        switch (((Button) event.getSource()).getId()) {
            case ID_BOTON_PLAY_MENU_PRINCIPAL:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuJuegoNormal.fxml"), bundle);
                break;
            case ID_BOTON_PLAY_ONLINE_MENU_PRINCIPAL:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuJuegoOnline.fxml"), bundle);
                break;
            case ID_BOTON_RULES_MENU_PRINCIPAL:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuRules.fxml"), bundle);
                break;
            case ID_BOTON_RULES_GRAPHICALLY_MENU_PRINCIPAL:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLRulesGraphic.fxml"), bundle);
                break;
            case ID_BOTON_DEVELOPERS_MENU_PRINCIPAL:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuDevelopers.fxml"), bundle);
                break;
            default:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuPrincipal.fxml"), bundle);
                break;
        }
        changeSceneRoot(event, loader, stage);
    }

    @FXML
    private void handleButtonBackAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ResourceBundle bundle = ResourceBundle.getBundle("strings.UIResources");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuPrincipal.fxml"), bundle);
        changeSceneRoot(event, loader, stage);
    }

    @FXML
    private void handleButtonsMenuNormalAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = null;
        ResourceBundle bundle = ResourceBundle.getBundle("strings.UIResources");
        switch (((Button) event.getSource()).getId()) {
            case ID_BOTON_PLAY_MENU_JUEGO_NORMAL:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuOpcionesNormal.fxml"), bundle);
                break;
            case ID_BOTON_SCORES_MENU_JUEGO_NORMAL:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLScores.fxml"), bundle);
                break;
            case ID_BOTON_BACKUP_MENU_JUEGO_NORMAL:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuJuegoNormal.fxml"), bundle);
                break;
            case ID_BOTON_BACK_MENU_JUEGO_NORMAL:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuPrincipal.fxml"), bundle);
                break;
            default:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuJuegoNormal.fxml"), bundle);
                break;
        }
        changeSceneRoot(event, loader, stage);
    }

    @FXML
    private void handleButtonsMenuOnlineAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = null;
        ResourceBundle bundle = ResourceBundle.getBundle("strings.UIResources");
        switch (((Button) event.getSource()).getId()) {
            case ID_BOTON_PLAY_MENU_JUEGO_ONLINE:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuOpcionesJuegoOnline.fxml"), bundle);
                break;
            case ID_BOTON_SCORES_MENU_JUEGO_ONLINE:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuJuegoOnline.fxml"), bundle);
                break;
            case ID_BOTON_BACK_MENU_JUEGO_ONLINE:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuPrincipal.fxml"), bundle);
                break;
            default:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuJuegoOnline.fxml"), bundle);
                break;
        }
        changeSceneRoot(event, loader, stage);
    }

    @FXML
    private void handleRadioButtonsAction(ActionEvent event) {
        String rb = ((Node) event.getSource()).getId();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        TextField txtField, txtField1, txtFieldRounds;
        switch (rb) {
            case ID_RADIOBUTTON_1_PLAYERS:
                txtField1 = (TextField) stage.getScene().lookup("#TxtFieldP1");
                txtField = (TextField) stage.getScene().lookup("#TxtFieldP2");
                txtField.setManaged(false);
                txtField.setVisible(false);
                txtField1.setPrefWidth(490.0);
                break;
            case ID_RADIOBUTTON_2_PLAYERS:
                txtField1 = (TextField) stage.getScene().lookup("#TxtFieldP1");
                txtField = (TextField) stage.getScene().lookup("#TxtFieldP2");
                txtField.setManaged(true);
                txtField.setVisible(true);
                txtField1.setPrefWidth(230.0);
                break;
            case ID_RADIOBUTTON_ROUND_CUSTOMIZED:
                txtFieldRounds = (TextField) stage.getScene().lookup("#NumberRoundsCustom");
                txtFieldRounds.setManaged(true);
                txtFieldRounds.setVisible(true);
                break;
            default:
                txtFieldRounds = (TextField) stage.getScene().lookup("#NumberRoundsCustom");
                txtFieldRounds.setManaged(false);
                txtFieldRounds.setVisible(false);
                break;
        }
    }

    @FXML
    private void handleButtonsMenuOpcionesJuegoOnlineAction(ActionEvent event) {
        boolean cargarPantalla = true;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        String boton = ((Button) event.getSource()).getId();
        ResourceBundle bundle = ResourceBundle.getBundle("strings.UIResources");
        FXMLLoader loader = loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuJuegoNormal.fxml"), bundle);
        if (boton.equals(ID_BOTON_PLAY_OPCIONES_MENU_ONLINE)) {
            if (((Button) stage.getScene().lookup("#" + ID_BOTON_RANDOMLY_OPCIONES_MENU_ONLINE)).isVisible()) {
                setVisibilitiesStateMenuOpcionesOnline(stage, false);
                cargarPantalla = false;
            } else {
                switch (getSelectedRadioButtonID(((ObservableList<Node>) ((VBox) stage.getScene().lookup("#RadioGroup_Games_Online")).getChildren()))) {
                    case ID_RADIOBUTTON_GAME_OF_3:
                        loader = new FXMLLoader(getClass().getResource("/fxml/FXMLJuegoGame3.fxml"), bundle);
                        break;
                    case ID_RADIOBUTTON_GAME_OF_5:
                        loader = new FXMLLoader(getClass().getResource("/fxml/FXMLJuegoGame5.fxml"), bundle);
                        break;
                    case ID_RADIOBUTTON_GAME_OF_9:
                        loader = new FXMLLoader(getClass().getResource("/fxml/FXMLJuegoGame9.fxml"), bundle);
                        break;
                }
                switch (getSelectedRadioButtonID(((ObservableList<Node>) ((VBox) stage.getScene().lookup("#RadioGroup_Rounds_Online")).getChildren()))) {
                    case ID_RADIOBUTTON_ROUND_OF_1:
                        datos.setRoundsLimit(1);
                        break;
                    case ID_RADIOBUTTON_ROUND_OF_3:
                        datos.setRoundsLimit(3);
                        break;
                    case ID_RADIOBUTTON_ROUND_OF_5:
                        datos.setRoundsLimit(5);
                        break;
                }
                String player1Name = ((TextField) stage.getScene().lookup("#TxtFieldP1Online")).getText();
                if (!player1Name.isEmpty()) {
                    datos.setNombreJ1(((TextField) stage.getScene().lookup("#TxtFieldP1Online")).getText());
                } else {
                    cargarPantalla = false;
                    showAlertFields(bundle, bundle.getString("P1NoSetted"));
                }
            }
        } else {
            if (boton.equals(ID_BOTON_RANDOMLY_OPCIONES_MENU_ONLINE)) {
                //MAKE RANDOMLY THE SETTING OF THE GAME
            } else {
                //BACK
                if (!((Button) stage.getScene().lookup("#" + ID_BOTON_RANDOMLY_OPCIONES_MENU_ONLINE)).isVisible()) {
                    setVisibilitiesStateMenuOpcionesOnline(stage, true);
                    cargarPantalla = false;
                } else {
                    loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuJuegoOnline.fxml"), bundle);
                    datos = null;
                }
            }
        }
        if (cargarPantalla) {
            changeSceneRoot(event, loader, stage);
        }
    }

    @FXML
    private void handleButtonsMenuOpcionesJuegoNormalAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        StringBuilder excepcion = new StringBuilder();
        boolean everythingOk = true;
        FXMLLoader loader = null;
        ResourceBundle bundle = ResourceBundle.getBundle("strings.UIResources");
        switch (((Node) event.getSource()).getId()) {
            case ID_BOTON_PLAY_OPCIONES_MENU_NORMAL:
                String player1Name = ((TextField) stage.getScene().lookup("#TxtFieldP1")).getText();
                switch (getSelectedRadioButtonID(((ObservableList<Node>) ((VBox) stage.getScene().lookup("#RadioGroup_Games_Normal")).getChildren()))) {
                    case ID_RADIOBUTTON_GAME_OF_3:
                        loader = new FXMLLoader(getClass().getResource("/fxml/FXMLJuegoGame3.fxml"), bundle);
                        datos.setFactorAlgoritmo(1);
                        break;
                    case ID_RADIOBUTTON_GAME_OF_5:
                        loader = new FXMLLoader(getClass().getResource("/fxml/FXMLJuegoGame5.fxml"), bundle);
                        datos.setFactorAlgoritmo(2);
                        break;
                    case ID_RADIOBUTTON_GAME_OF_9:
                        loader = new FXMLLoader(getClass().getResource("/fxml/FXMLJuegoGame9.fxml"), bundle);
                        datos.setFactorAlgoritmo(4);
                        break;
                }
                switch (getSelectedRadioButtonID(((ObservableList<Node>) ((VBox) stage.getScene().lookup("#RadioGroup_Rounds_Normal")).getChildren()))) {
                    case ID_RADIOBUTTON_ROUND_OF_1:
                        datos.setRoundsLimit(1);
                        break;
                    case ID_RADIOBUTTON_ROUND_OF_3:
                        datos.setRoundsLimit(3);
                        break;
                    case ID_RADIOBUTTON_ROUND_OF_5:
                        datos.setRoundsLimit(5);
                        break;
                    case ID_RADIOBUTTON_ROUND_CUSTOMIZED:
                        String roundsCustom = ((TextField) stage.getScene().lookup("#NumberRoundsCustom")).getText();
                        if (roundsCustom != null && !roundsCustom.isEmpty()) {
                            try {
                                datos.setRoundsLimit(Integer.parseInt(roundsCustom));
                            } catch (NumberFormatException ex) {
                                everythingOk = false;
                                excepcion.append(bundle.getString("RoundFormatFail"));
                            }
                        } else {
                            everythingOk = false;
                            excepcion.append(bundle.getString("NoRoundSetted"));
                        }
                        break;
                }
                if (!player1Name.isEmpty()) {
                    datos.setNombreJ1(((TextField) stage.getScene().lookup("#TxtFieldP1")).getText());
                } else {
                    everythingOk = false;
                    excepcion.append(bundle.getString("P1NoSetted"));
                }
                if (getSelectedRadioButtonID(((ObservableList<Node>) ((VBox) stage.getScene().lookup("#RadioGroup_Player_Normal")).getChildren())).equals(ID_RADIOBUTTON_2_PLAYERS)) {
                    String player2Name = ((TextField) stage.getScene().lookup("#TxtFieldP2")).getText();
                    if (!player2Name.isEmpty()) {
                        datos.setNombreJ2(player2Name);
                    } else {
                        everythingOk = false;
                        excepcion.append(bundle.getString("P2NoSetted"));
                    }
                } else {
                    datos.setNombreJ2("CPU");
                }
                System.out.println("nombreJ1: " + datos.getNombreJ1() + ", nombreJ2: " + datos.getNombreJ2() + ", roundLim: " + datos.getRoundsLimit() + ", gameType: " + datos.getModalidadJuego());

                break;
            case ID_BOTON_BACK_OPCIONES_MENU_NORMAL:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuJuegoNormal.fxml"), bundle);
                datos = null;
                break;
            default:
                loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuOpcionesJuegoNormal.fxml"), bundle);
                break;
        }
        if (everythingOk) {
            changeSceneRoot(event, loader, stage);
        } else {
            showAlertFields(bundle, excepcion.toString());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (datos == null) {
            System.out.println("ESTA NULL");
            datos = new DataContainer();
        }
        if (url.getPath().substring(url.getPath().lastIndexOf("/") + 1).equals("FXMLScores.fxml")) {
            //ENTRA EN SCORES
            List<String> list = new ArrayList<String>();
            list.add(rb.getString("VictoriesOption"));
            list.add(rb.getString("RoundsOption"));
            list.add(rb.getString("AverageOption"));
            ObservableList obList = FXCollections.observableList(list);
            cbox.getItems().clear();
            cbox.setItems(obList);
            cbox.setValue(list.get(0));
        }
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

    private void setVisibilitiesStateMenuOpcionesOnline(Stage stage, boolean visibilityButton) {
        ObservableList<Node> nodos = ((ObservableList<Node>) ((VBox) stage.getScene().lookup("#VBoxParentOnlineOptions")).getChildren());
        for (int i = 1; i < nodos.size(); i++) {
            nodos.get(i).setVisible(!visibilityButton);
        }
        ((Button) stage.getScene().lookup("#" + ID_BOTON_RANDOMLY_OPCIONES_MENU_ONLINE)).setVisible(visibilityButton);
        ((Button) stage.getScene().lookup("#" + ID_BOTON_RANDOMLY_OPCIONES_MENU_ONLINE)).setManaged(visibilityButton);
    }

    private void showAlertFields(ResourceBundle bundle, String excepcion) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(bundle.getString("Warning"));
        alert.setHeaderText(null);
        alert.setContentText(bundle.getString("HaveWrongFields"));
        Label label = new Label(bundle.getString("TheWarningsAre"));
        TextArea textArea = new TextArea(excepcion);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);
        alert.showAndWait();

        
    }
    
    private void notificacionToast(){
        ///////////////////////////////////////////
        Notification info = new Notification("Title", "Info-Message");

        // Show the custom notification
        Notifier.INSTANCE.notify(info);

        // Show a predefined Warning notification
//        Notifier.INSTANCE.notifyWarning("Warning","This is a warning");
    }

    @FXML
    private void gestionaJuego(MouseEvent event) {
        MetaMessage msg = null;
        Enum chosen = datos.getMapFichas().get(v.getId());
        if (datos.isTurno() && chosen != null) {
            datos.setChosen1(chosen);
            datos.setIdImagenPulsada1((int) v.getTag());
            if (datos.getModalidadJuego() == ModalidadJuego.DOS.ordinal()) {
                cambiaAzul(activity, datos);
                datos.cambiaTurno();
                //TOSTADA INDICANDO TURNO SEGUNDO JUGADOR (CON NOMBRE DE JUGADOR)
                Toast t = Toast.makeText(activity.getApplicationContext(), datos.getNombreJ2() + activity.getResources().getString(R.string.turno), Toast.LENGTH_LONG);//SUSTITUIR POR EL METODO notificacionToast()
                t.setGravity(Gravity.CENTER, 0, 0);
                t.show();
                android.util.Log.d("VERIFICA", "cambia jugador...");
            } else {
                //JUEGA MAQUINA
                if (datos.getModalidadJuego() == ModalidadJuego.UNO.ordinal()) {
                    datos.setChosen2(getEnumFromOrdinal((int) (Math.random() * (((datos.getFactorAlgoritmo()) * 2) + 1)), datos));
                    Log.d("PRUEBA", "datos es: " + datos);
                    Log.d("PRUEBA", "setChosen2 es: " + datos.getChosen2() + " y el getEnum da: " + getEnumFromOrdinal((int) (Math.random() * (((datos.getFactorAlgoritmo()) * 2) + 1)), datos) + " y el datos.algoritmo da: " + datos.getFactorAlgoritmo());
                    comunEvaluacionGanador(datos.getChosen2(), false, activity, datos, false);
                    //datos.setJugando(false);
                    datos.setIdImagenPulsada2(gestionaPulsadoMaquina(datos.getChosen2(), datos));
                    ((ImageView) activity.findViewById(R.id.player2Muestra)).setImageResource(datos.getIdImagenPulsada2());
                    android.util.Log.d("VERIFICA", "victorias J1 " + datos.getVictoriesP1() + " y victorias Maquina " + datos.getVictoriesP2());
                } else {
                    //JUEGO ONLINE
                    msg = new MetaMessage();
                    msg.setType(TypeMessage.PARTIDA);
                    OpcionJuego oj = new OpcionJuego();
                    oj.setOpcion(datos.getChosen1().ordinal());
                    if (datos.getChosen2() != null) {
                        ((ImageView) activity.findViewById(R.id.player2Muestra)).setImageResource(datos.getIdImagenPulsada2());
                        comunEvaluacionGanador(datos.getChosen2(), false, activity, datos, true);
                    }
                    msg.setContent(oj);

                }
            }
        } else {
            if (!datos.isTurno() && chosen != null) {
                datos.setChosen2(chosen);
                datos.setIdImagenPulsada2((int) v.getTag());
                cambiaRojo(activity, datos);
                //datos.setJugando(false);
                ((ImageView) activity.findViewById(R.id.player2Muestra)).setImageResource(datos.getIdImagenPulsada2());
                comunEvaluacionGanador(datos.getChosen2(), false, activity, datos, false);
                datos.cambiaTurno();
                android.util.Log.d("VERIFICA", "victorias J1 " + datos.getVictoriesP1() + " y victorias J2 " + datos.getVictoriesP2());
            }
        }
        return msg;
    }

}
