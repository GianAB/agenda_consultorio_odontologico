/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import application.Main;
import gui.utils.Alerts;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import model.services.PacienteService;

/**
 * FXML Controller class
 *
 * @author giang
 */
public class MainFXMLController implements Initializable {

    @FXML
    public void onHomeAction() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainFXML.fxml"));
        
        try {
            VBox mainVBox = (VBox) ((ScrollPane) ((BorderPane) loader.load()).getCenter()).getContent();

            Scene mainScene = Main.getMainScene();

            ((ScrollPane) ((BorderPane) mainScene.getRoot()).getCenter()).setContent(mainVBox);

        } catch (IOException e) {
            Alerts.showAlert(Alert.AlertType.ERROR, "Erro ao carregar a tela", null, e.getCause().toString());
        }
    }

    @FXML
    public void onAgendaAction() {
        this.loadView("/gui/AgendaFXML.fxml", x -> {
        });

    }

    @FXML
    public void onPacientesAction() {
        this.loadView("/gui/PacienteFXML.fxml", (PacienteFXMLController controller) -> {
            controller.setPacienteService(new PacienteService());
            controller.updateTableView();
        });

    }

    @FXML
    public void onDentistasAction() {
        this.loadView("/gui/DentistaFXML.fxml", x -> {
        });
    }

    private synchronized <T> void loadView(String diretorioCompleto, Consumer<T> inicializacaoElemento) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(diretorioCompleto));
        try {

            VBox vbMain = loader.load();
            Scene mainScene = Main.getMainScene();
            ScrollPane mainScrollPane = (ScrollPane) ((BorderPane) mainScene.getRoot()).getCenter();

            vbMain.prefHeightProperty().bind(mainScene.heightProperty());

            mainScrollPane.setContent(vbMain);

            T controller = loader.getController();
            inicializacaoElemento.accept(controller);

        } catch (IOException e) {
            Alerts.showAlert(Alert.AlertType.ERROR, "Erro ao carregar a tela", null, e.getCause().toString());
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
