/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.utils;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 *
 * @author giang
 */
public class Utils {

    public static Stage stageAtual(ActionEvent event) {
        return (Stage)((Node) event.getSource()).getScene().getWindow();
    }
}
