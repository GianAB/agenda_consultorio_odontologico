/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import application.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author giang
 */
public class MainFXMLController implements Initializable {

    @FXML
    public void onHomeAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainFXML.fxml"));
            
            VBox mainVBox = (VBox)((ScrollPane)((BorderPane)loader.load()).getCenter()).getContent();
            
            Scene mainScene = Main.getMainScene();
            
            ((ScrollPane)((BorderPane) mainScene.getRoot()).getCenter()).setContent(mainVBox);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @FXML
    public void onAgendaAction() {
        this.loadView("/view/AgendaFXML.fxml");
    }

    @FXML
    public void onPacientesAction() {
        this.loadView("/view/PacientesFXML.fxml");
    }

    @FXML
    public void onDentistasAction() {
        this.loadView("/view/DentistasFXML.fxml");
    }

    private synchronized void loadView(String diretorioCompleto) {
        FXMLLoader loadder = new FXMLLoader(getClass().getResource(diretorioCompleto));
        try {
            VBox vbMain = loadder.load();
            Scene mainScene = Main.getMainScene();
            ScrollPane mainScrollPane = (ScrollPane) ((BorderPane) mainScene.getRoot()).getCenter();

            mainScrollPane.setContent(vbMain);

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
