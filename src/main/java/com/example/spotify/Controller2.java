package com.example.spotify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    Controller pepito;
    private FXMLLoader fxmlLoader;
    @FXML
    private Button btn_inicio;

    @FXML
    private TextField usuario_i;

    @FXML
    private PasswordField pass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void recibe(Controller c){
        pepito=c;
    }

    @FXML
    void iniciar_user(ActionEvent event) {
try{
    Statement stmt = Base_Datos.conexion().createStatement();
    ResultSet rs = stmt.executeQuery("SELECT username,password FROM usuario");
    int cont = 0;
// Procesa los resultados
    while (rs.next()) {
        String nombre_us = rs.getString("username");
        String nombre_pass = rs.getString("password");
        if (usuario_i.getText().equals(nombre_us) && pass.getText().equals(nombre_pass)) {
            pepito.recibe(usuario_i.getText());
            Stage stage = (Stage) btn_inicio.getScene().getWindow();
            cont++;
            stage.close();
        }
    }
    if(cont == 0){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setContentText("Usuario o contraseña incorrecto vuelve a intentarlo");
        alert.show();
    }
    Base_Datos.conexion().close();
} catch (SQLException e) {
    e.printStackTrace();
}

    }
    @FXML
    void registrar(ActionEvent event) {
        fxmlLoader = new FXMLLoader(Main.class.getResource("registro.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Registro");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
