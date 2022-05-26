package com.example.spotify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Controller4 {
    private FXMLLoader fxmlLoader;
    @FXML
    private TextField usuario_intro;

    @FXML
    private Button btn_pagar;

    @FXML
    private PasswordField pass_intro;

    @FXML
    private Button btn_free;

    @FXML
    private TextField genero_intro;

    @FXML
    private TextField email_intro;

    @FXML
    private TextField cp_intro;

    @FXML
    private TextField pais_intro;

    @FXML
    private DatePicker fecha_nacimiento;

    @FXML
    void free(ActionEvent event) {
        String usuarioi = usuario_intro.getText();
        String passi = pass_intro.getText();
        String emaili = email_intro.getText();
        String generoi = genero_intro.getText();
        String paisi = pais_intro.getText();
        String codigoi = cp_intro.getText();

        if (usuarioi.isEmpty() || passi.isEmpty() || emaili.isEmpty() || generoi.isEmpty()  || paisi.isEmpty() || codigoi.isEmpty()){
            System.out.println("pepe");
        }else {
            try {
                LocalDate fecha_a = LocalDate.now();
                LocalDate fecha_n = fecha_a.plusMonths(1);
                Statement stmt = Base_Datos.conexion().createStatement();
                stmt.executeUpdate("INSERT INTO usuario(username,password,email,genero,fecha_nacimiento,pais,codigo_postal)" +
                        "VALUES('" + usuarioi + "','" + passi + "','" + emaili + "','" + generoi + "','" + fecha_nacimiento.getValue() + "','" + paisi + "','" + codigoi + "')");
                ResultSet rs = stmt.executeQuery("SELECT id FROM usuario WHERE username LIKE '" + usuario_intro.getText() + "'");
// Procesa los resultados
                if (rs.next()) {
                    String id_usuario = rs.getString("id");
                    stmt.executeUpdate("INSERT INTO free(fecha_revision,tiempo_publicidad,usuario_id)" +
                            "VALUES('" + fecha_n + "',600,'" + id_usuario + "')");
                }
                Base_Datos.conexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) btn_free.getScene().getWindow();
            stage.close();
        }
    }


    @FXML
    void pagar_premium(ActionEvent event) {
        String usuarioi = usuario_intro.getText();
        String passi = pass_intro.getText();
        String emaili = email_intro.getText();
        String generoi = genero_intro.getText();
        String paisi = pais_intro.getText();
        String codigoi = cp_intro.getText();
        try{
            LocalDate fecha_a = LocalDate.now();
            LocalDate fecha_n = fecha_a.plusMonths(1);
            Statement stmt = Base_Datos.conexion().createStatement();
            stmt.executeUpdate("INSERT INTO usuario(username,password,email,genero,fecha_nacimiento,pais,codigo_postal)" +
                    "VALUES('"+usuarioi+"','"+passi+"','"+emaili+"','"+generoi+"','"+fecha_nacimiento.getValue()+"','"+paisi+"','"+codigoi+"')");
            ResultSet rse = stmt.executeQuery("SELECT id FROM usuario WHERE username LIKE '"+usuario_intro.getText()+"'");
// Procesa los resultados
            if (rse.next()) {
                String id_usuario = rse.getString("id");
                stmt.executeUpdate("INSERT INTO premium(fecha_renovación,usuario_id)" +
                        "VALUES('"+fecha_n+"','"+id_usuario+"')");
            }
            Base_Datos.conexion().close();
            fxmlLoader = new FXMLLoader(Main.class.getResource("pagar.fxml"));
            Stage stage1 = (Stage) btn_pagar.getScene().getWindow();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
