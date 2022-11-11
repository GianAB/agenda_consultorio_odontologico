/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import application.Main;
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainFXML.fxml"));

            VBox mainVBox = (VBox) ((ScrollPane) ((BorderPane) loader.load()).getCenter()).getContent();

            Scene mainScene = Main.getMainScene();

            ((ScrollPane) ((BorderPane) mainScene.getRoot()).getCenter()).setContent(mainVBox);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @FXML
    public void onAgendaAction() {
        this.loadView("/gui/AgendaFXML.fxml", x -> {});

    }

    @FXML
    public void onPacientesAction() {
        this.loadView("/gui/PacientesFXML.fxml", (PacientesFXMLController controller) ->{
            controller.setPacienteService(new PacienteService());
            controller.updateTableView();
        });
        
    }

    @FXML
    public void onDentistasAction() {
        this.loadView("/gui/DentistasFXML.fxml", x ->{});
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
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao tentar acessar a tela", JOptionPane.ERROR_MESSAGE);
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
