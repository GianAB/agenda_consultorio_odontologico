/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import application.Main;
import db.DB;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
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
public class PacientesFXMLController implements Initializable {

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
    public void onBtNewAction() {
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
}
