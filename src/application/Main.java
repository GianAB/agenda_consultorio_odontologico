/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package application;

import db.DB;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author giang
 */
public class Main extends Application {

    private static Scene mainScene;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainFXML.fxml"));
            BorderPane borderPane = loader.load();
            ScrollPane scrollPaneCenter = (ScrollPane) borderPane.getCenter();

            scrollPaneCenter.setFitToHeight(true);
            scrollPaneCenter.setFitToWidth(true);

            mainScene = new Scene(borderPane);

            primaryStage.setScene(mainScene);
            primaryStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        
        }finally{
            DB.closeConnection();
        }
        
    }

    public static Scene getMainScene() {
        return mainScene;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
