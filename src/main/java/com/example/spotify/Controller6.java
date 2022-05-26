package com.example.spotify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller6 {
    @FXML
    private Button btn_pagarp;

    @FXML
    private TextField campo;

    @FXML
    void pagarp(ActionEvent event) {
        if (campo.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setContentText("Rellena todos los campos");
            alert.show();
        }else{
            Stage stage = (Stage) btn_pagarp.getScene().getWindow();
            stage.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setContentText("Se ha realizado el pago con exito");
            alert.show();
        }

    }

}
