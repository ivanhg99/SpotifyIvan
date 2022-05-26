package com.example.spotify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller7 {
    @FXML
    private Button btn_pagart;

    @FXML
    private TextField campoa;

    @FXML
    private TextField campon;

    @FXML
    private TextField campom;

    @FXML
    private TextField campoc;

    @FXML
    void pagar_tarjeta(ActionEvent event) {
        if (campoa.getText().isEmpty() || campon.getText().isEmpty() || campom.getText().isEmpty() || campoc.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setContentText("Rellena todos los campos");
            alert.show();
        }else{
            Stage stage = (Stage) btn_pagart.getScene().getWindow();
            stage.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setContentText("Se ha realizado el pago con exito");
            alert.show();
        }
    }
}
