/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.mycompany.datapptgame.MetaMessage;
import com.sun.webkit.Timer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import static constantes.Constantes.*;
import eu.hansolo.enzo.notification.Notification;
import eu.hansolo.enzo.notification.Notification.Notifier;
import eu.hansolo.enzo.notification.NotificationEvent;
import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.DataContainer;
import com.mycompany.datapptgame.Fichas3;
import com.mycompany.datapptgame.Fichas5;
import com.mycompany.datapptgame.Fichas9;
import com.mycompany.datapptgame.ModalidadJuego;

/**
 *
 * @author Victor
 */
public class FXMLController implements Initializable {

    private Parent root;
    private static DataContainer datos;
    private final String RUTA_IMAGENES="imagenes";

    @FXML
    private ComboBox cbox;
    @FXML
    private Label resultJ1;
    @FXML
    private Label resultJ2;
    @FXML
    private Label winnerLabel;
    @FXML
    private ImageView resultImagenJ1Choosed;
    @FXML
    private ImageView resultImagenJ2Choosed;
    @FXML
    private Button buttonContinueResult;

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
        changeSceneRoot(loader, stage);
    }

    @FXML
    private void handleButtonBackAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ResourceBundle bundle = ResourceBundle.getBundle("strings.UIResources");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuPrincipal.fxml"), bundle);
        changeSceneRoot(loader, stage);
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
        changeSceneRoot(loader, stage);
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
        changeSceneRoot(loader, stage);
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
        } else if (boton.equals(ID_BOTON_RANDOMLY_OPCIONES_MENU_ONLINE)) {
            //MAKE RANDOMLY THE SETTING OF THE GAME
        } else //BACK
        if (!((Button) stage.getScene().lookup("#" + ID_BOTON_RANDOMLY_OPCIONES_MENU_ONLINE)).isVisible()) {
            setVisibilitiesStateMenuOpcionesOnline(stage, true);
            cargarPantalla = false;
        } else {
            loader = new FXMLLoader(getClass().getResource("/fxml/FXMLMenuJuegoOnline.fxml"), bundle);
            datos = null;
        }
        if (cargarPantalla) {
            changeSceneRoot(loader, stage);
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
                        datos.setModalidadJuego(ModalidadJuego.DOS.ordinal());
                    } else {
                        everythingOk = false;
                        excepcion.append(bundle.getString("P2NoSetted"));
                    }
                } else {
                    datos.setNombreJ2("CPU");
                    datos.setModalidadJuego(ModalidadJuego.UNO.ordinal());
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
            changeSceneRoot(loader, stage);
            if (((Node) event.getSource()).getId() == ID_BOTON_PLAY_OPCIONES_MENU_NORMAL) {
                datos.setTurno(true);
                notificacionToast(datos.getNombreJ1() + bundle.getString("Turno"));
            }
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
        //TODO: PONER UN IF CONDICIONANDO LA VISTA DEL RESULT A EL NUMERO DE PARTIDAS JUGADAS Y TAMBIEN MOSTRANDO LAS IMAGENES CORRECTAS
        if (url.getPath().substring(url.getPath().lastIndexOf("/") + 1).equals("FXMLResult.fxml")) {
            comunEvaluacionGanador(datos.getChosen2(), datos, false);
            resultImagenJ1Choosed.setImage(new Image(datos.getIdImagenPulsada1()));
            if(datos.rondasFinalizadas()){
                buttonContinueResult.setDisable(true);
            }
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

    private void changeSceneRoot(FXMLLoader loader, Stage stage) {
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

    private void notificacionToast(String mensaje) {
        ///////////////////////////////////////////
        Notification info = new Notification("", mensaje);
        // Show the custom notification
        EventHandler<NotificationEvent> handler = new EventHandler<NotificationEvent>() {

            @Override
            public void handle(NotificationEvent event) {
                ((Notifier) event.getSource()).INSTANCE.stop();
            }
        };
        Notifier.INSTANCE.setOnHideNotification(handler);
        Notifier.INSTANCE.setPopupLifetime(Duration.seconds(2));
        Notifier.INSTANCE.notify(info);
        // Show a predefined Warning notification
//        Notifier.INSTANCE.notifyWarning("Warning","This is a warning");
    }

    private void cambiaAzul(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switch (datos.getFactorAlgoritmo()) {
            case 1:
                //SET IMAGENES PARA 3 y cambiar visibilidad de los Opciones
                System.out.println("ENTRA EN OPCION 3");
                ((Node) stage.getScene().lookup("#ImagenJ1ChoosedG3")).setVisible(true);
                ((Node) stage.getScene().lookup("#ImagenJ2ChoosedG3")).setVisible(false);
                ((ImageView) stage.getScene().lookup("#piedra3")).setImage(new Image("imagenes/piedraazul.png"));
                ((ImageView) stage.getScene().lookup("#papel3")).setImage(new Image("imagenes/papelazul.png"));
                ((ImageView) stage.getScene().lookup("#tijera3")).setImage(new Image("imagenes/tijerasazul.png"));
                break;
            case 2:
                //SET IMAGENES PARA 5 y cambiar visibilidad de los Opciones
                System.out.println("ENTRA EN OPCION 5");
                ((Node) stage.getScene().lookup("#ImagenJ1ChoosedG5")).setVisible(true);
                ((Node) stage.getScene().lookup("#ImagenJ2ChoosedG5")).setVisible(false);
                ((ImageView) stage.getScene().lookup("#piedra5")).setImage(new Image("imagenes/piedraazul.png"));
                ((ImageView) stage.getScene().lookup("#papel5")).setImage(new Image("imagenes/papelazul.png"));
                ((ImageView) stage.getScene().lookup("#tijera5")).setImage(new Image("imagenes/tijerasazul.png"));
                ((ImageView) stage.getScene().lookup("#spock5")).setImage(new Image("imagenes/spockazul.png"));
                ((ImageView) stage.getScene().lookup("#lagarto5")).setImage(new Image("imagenes/lizardazul.png"));
                break;
            case 4:
                //SET IMAGENES PARA 9 y cambiar visibilidad de los Opciones
                System.out.println("ENTRA EN OPCION 9");
                ((Node) stage.getScene().lookup("#ImagenJ1ChoosedG9")).setVisible(true);
                ((Node) stage.getScene().lookup("#ImagenJ2ChoosedG9")).setVisible(false);
                ((ImageView) stage.getScene().lookup("#piedra9")).setImage(new Image("imagenes/piedraazul.png"));
                ((ImageView) stage.getScene().lookup("#papel9")).setImage(new Image("imagenes/papelazul.png"));
                ((ImageView) stage.getScene().lookup("#tijera9")).setImage(new Image("imagenes/tijerasazul.png"));
                ((ImageView) stage.getScene().lookup("#agua9")).setImage(new Image("imagenes/waterazul.png"));
                ((ImageView) stage.getScene().lookup("#aire9")).setImage(new Image("imagenes/windazul.png"));
                ((ImageView) stage.getScene().lookup("#pistola9")).setImage(new Image("imagenes/gunazul.png"));
                ((ImageView) stage.getScene().lookup("#humano9")).setImage(new Image("imagenes/humanazul.png"));
                ((ImageView) stage.getScene().lookup("#esponja9")).setImage(new Image("imagenes/spongeazul.png"));
                ((ImageView) stage.getScene().lookup("#fuego9")).setImage(new Image("imagenes/fireazul.png"));
                break;
        }
    }

    private Enum getEnumFromOrdinal(int ordinal, DataContainer datos) {
        Enum res = null;
        boolean sal = false;
        switch (datos.getFactorAlgoritmo()) {
            case 1:
                for (int i = 0; i < Fichas3.values().length && !sal; i++) {
                    if (i == ordinal) {
                        res = Fichas3.values()[i];
                        sal = true;
                    }
                }
            case 2:
                for (int i = 0; i < Fichas5.values().length && !sal; i++) {
                    if (i == ordinal) {
                        res = Fichas5.values()[i];
                        sal = true;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < Fichas9.values().length && !sal; i++) {
                    if (i == ordinal) {
                        res = Fichas9.values()[i];
                        sal = true;
                    }
                }
                break;
        }
        return res;
    }

    private void comunEvaluacionGanador(Enum chosen, DataContainer datos, boolean online) {
        //TODO
        //((ImageView) activity.findViewById(R.id.player1Muestra)).setImageResource(datos.getIdImagenPulsada1());
        switch (logicaJuego(chosen.ordinal(), datos)) {
            case 0:
                //empata
                //((TextView) activity.findViewById(R.id.textViewWinner)).setText(activity.getResources().getString(R.string.draw));
                
                break;
            case 1:
                //gana chosen1 (Gana Jugador 1)
                //((TextView) activity.findViewById(R.id.textViewWinner)).setText(datos.getNombreJ1().toUpperCase() + activity.getResources().getString(R.string.win));
                datos.sumaVictoriasP1();
                break;
            case 2:
                //gana chosen (Gana Jugador 2)
                //((TextView) activity.findViewById(R.id.textViewWinner)).setText(datos.getNombreJ2().toUpperCase() + activity.getResources().getString(R.string.win));
                datos.sumaVictoriasP2();
                break;
        }
        //cambiarVistaAResult(activity, datos, online);
    }

    private int logicaJuego(int chosen, DataContainer datos) {
        int res = 0;
        if (chosen == datos.getOrdinalChosen1()) {
            //EMPATA
            res = 0;
        } else {
            boolean ganaChosen = false;
            datos.avanzaRonda();
            //TODO
            if (datos.rondasFinalizadas()) {
                //activity.findViewById(R.id.buttonNextResult).setEnabled(false);
            }
            for (int j = ((chosen + 1) % ((datos.getFactorAlgoritmo() * 2) + 1)), i = 0; i < (datos.getFactorAlgoritmo()) && !ganaChosen; i++, j = ((j + 1) % ((datos.getFactorAlgoritmo() * 2) + 1))) {
                if (datos.getOrdinalChosen1() == j) {
                    //CHOSEN GANA
                    ganaChosen = true;
                    res = 2;
                }
            }
            if (!ganaChosen) {
                //GANA CHOSEN1
                res = 1;
            }
        }
        return res;
    }

    @FXML
    private void gestionaJuego(MouseEvent event) {
        Node nodo = (Node) event.getSource();
        System.out.println("EN LA GESTION JUEGO: "+datos.getModalidadJuego()+" ");
        ResourceBundle bundle = ResourceBundle.getBundle("strings.UIResources");
        MetaMessage msg = null;
        Enum chosen = datos.getMapFichas().get(nodo.getId());
        System.out.println("turno: " + datos.isTurno());
        if (datos.isTurno() && chosen != null) {
            datos.setChosen1(chosen);
            String fullURL=((Image) ((ImageView) nodo).getImage()).impl_getUrl();
            datos.setIdImagenPulsada1(RUTA_IMAGENES.concat(fullURL.substring(fullURL.lastIndexOf("/"))));
            System.out.println("imagen: " + datos.getIdImagenPulsada1());
            if (datos.getModalidadJuego() == ModalidadJuego.DOS.ordinal()) {
                cambiaAzul(event);
                datos.cambiaTurno();
                //TOSTADA INDICANDO TURNO SEGUNDO JUGADOR (CON NOMBRE DE JUGADOR)
                notificacionToast(datos.getNombreJ2() + bundle.getString("Turno"));
            } else {//JUEGA MAQUINA
                if (datos.getModalidadJuego() == ModalidadJuego.UNO.ordinal()) {
                    System.out.println("ENTRA EN EVALUACION 1 JUGADOR");
                    datos.setChosen2(getEnumFromOrdinal((int) (Math.random() * (((datos.getFactorAlgoritmo()) * 2) + 1)), datos));
                    
                    
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLResult.fxml"), bundle);

                    changeSceneRoot(loader, stage);
                    
                    
                    
                    
                    
                    
                    //comunEvaluacionGanador(datos.getChosen2(), datos, false);
                    //datos.setJugando(false);
                    //datos.setIdImagenPulsada2(gestionaPulsadoMaquina(datos.getChosen2(), datos));
                    /*((ImageView) activity.findViewById(R.id.player2Muestra)).setImageResource(datos.getIdImagenPulsada2());//Posiblemente para borrar, pasar al onload de la vista de RESULT*/
                } /*else {
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
                }*/
            }
        }else {
         if (!datos.isTurno() && chosen != null) {
         datos.setChosen2(chosen);
         //datos.setIdImagenPulsada2((int) v.getTag());
         //cambiaRojo(activity, datos);
         //datos.setJugando(false);
         //((ImageView) activity.findViewById(R.id.player2Muestra)).setImageResource(datos.getIdImagenPulsada2());
         comunEvaluacionGanador(datos.getChosen2(), datos, false);
         datos.cambiaTurno();
         }
         //        return msg;
         }
    }
}
