package com.example.spotify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller3 {
    private FXMLLoader fxmlLoader;
    @FXML
    private Button estudiantesp;

    @FXML
    void estudiantesp(ActionEvent event) {
        fxmlLoader = new FXMLLoader(Main.class.getResource("metodos_pagar.fxml"));
        Stage stage1 = (Stage) estudiantesp.getScene().getWindow();
        stage1.close();
        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Metodos");
            stage.setScene(scene);
            stage.show();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setContentText("Este es el plan estudiantes el importe es de 4,99€ al mes");
            alert.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void familiarp(ActionEvent event) {
        fxmlLoader = new FXMLLoader(Main.class.getResource("metodos_pagar.fxml"));
        Stage stage1 = (Stage) estudiantesp.getScene().getWindow();
        stage1.close();
        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Metodos");
            stage.setScene(scene);
            stage.show();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setContentText("Este es el plan familiar el importe es de 14,99€ al mes");
            alert.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void individualp(ActionEvent event) {
        fxmlLoader = new FXMLLoader(Main.class.getResource("metodos_pagar.fxml"));
        Stage stage1 = (Stage) estudiantesp.getScene().getWindow();
        stage1.close();

        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Metodos");
            stage.setScene(scene);
            stage.show();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setContentText("Este es el plan individual el importe es de 9,99€ al mes");
            alert.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
