/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import application.Main;
import db.DB;
import gui.utils.Alerts;
import gui.utils.Utils;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Paciente;
import model.services.PacienteService;

/**
 * FXML Controller class
 *
 * @author giang
 */
public class PacienteFXMLController implements Initializable {

    private PacienteService service;

    @FXML
    private TableView<Paciente> tbvPacientes;

    @FXML
    private TableColumn<Paciente, Integer> tbcId;

    @FXML
    private TableColumn<Paciente, String> tbcNome;

    @FXML
    private TableColumn<Paciente, String> tbcSobrenome;

    @FXML
    private TableColumn<Paciente, String> tbcCpf;

    @FXML
    private Button btnNew;

    private ObservableList<Paciente> obsList;

    @FXML
    public void onBtNewAction(ActionEvent event) {
            this.criarFormularioDeDialogo("/gui/PacienteFormFXML.fxml", Utils.stageAtual(event));
    }

    public void setPacienteService(PacienteService service) {
        this.service = service;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
    }

    private void initializeNodes() {
        tbcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
        tbcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        Stage stage = (Stage) Main.getMainScene().getWindow();

        tbvPacientes.prefHeightProperty().bind(stage.heightProperty());
    }

    public void updateTableView() {
        if (service == null) {
            throw new IllegalStateException("O servico está nulo!");
        }

        List<Paciente> list = service.findAll();
        obsList = FXCollections.observableArrayList(list);
        tbvPacientes.setItems(obsList);
    }

    private void criarFormularioDeDialogo(String diretorioCompleto, Stage stagePai) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(diretorioCompleto));
            Pane pane = loader.load();

            Stage stageDialogo = new Stage();
            stageDialogo.setTitle("Novo Paciente");
            stageDialogo.setScene(new Scene(pane));
            stageDialogo.setResizable(false);
            stageDialogo.initOwner(stagePai);
            stageDialogo.initModality(Modality.WINDOW_MODAL);
            stageDialogo.showAndWait();

        } catch (IOException e) {
            Alerts.showAlert(Alert.AlertType.ERROR, "Erro ao carregar a tela", null, e.getCause().toString());
        }

    }
}
