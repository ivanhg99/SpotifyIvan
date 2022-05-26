package com.example.spotify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller5 {
    private FXMLLoader fxmlLoader;
    @FXML
    private Button btn_paypal;

    @FXML
    private Button btn_tarjeta;

    @FXML
    void pagar_paypal(ActionEvent event) {
        fxmlLoader = new FXMLLoader(Main.class.getResource("paypal.fxml"));
        Stage stage1 = (Stage) btn_paypal.getScene().getWindow();
        stage1.close();
        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Premium");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void tarjeta_credito(ActionEvent event) {
        fxmlLoader = new FXMLLoader(Main.class.getResource("tarjeta.fxml"));
        Stage stage1 = (Stage) btn_tarjeta.getScene().getWindow();
        stage1.close();
        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Premium");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
