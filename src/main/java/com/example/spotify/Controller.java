package com.example.spotify;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button boton_podcast_gust;

    @FXML
    private Button boton_seguir_podcast;

    @FXML
    private Pane panel_podcastsigue;

    @FXML
    private TableView<PodcastTodoClase> tabla_podcast_sigue;

    @FXML
    private TableColumn<PodcastTodoClase, String> columna_titulopodcastsigue;

    @FXML
    private TableColumn<PodcastTodoClase, String> columna_desc_podcastsigue;


    ObservableList<PodcastTodoClase> podcassiguel;
    @FXML
    private Pane panel_podcastodo;

    @FXML
    private TableView<PodcastTodoClase> tabla_todo_podcast;

    @FXML
    private TableColumn<PodcastTodoClase, String> columna_titulopodcasttodo;

    @FXML
    private TableColumn<PodcastTodoClase, String> columna_desc_podcasttodo;

    @FXML
    private TableColumn<PodcastTodoClase, String> columna_fecha_podcast_todo;

    ObservableList<PodcastTodoClase> podcasttodol;
    @FXML
    private Pane panel_sigue_art;

    @FXML
    private TextField buscador_artista;

    @FXML
    private Label texto_artista_si;

    @FXML
    private ImageView foto_usuario_artista;

    @FXML
    private Button seguir_art;

    @FXML
    private TableView<ArtistaSigueClase> tabla_sigue_artista;

    @FXML
    private TableColumn<ArtistaSigueClase, String> columna_art_si;

    ObservableList<ArtistaSigueClase> usuariosiartl;
    @FXML
    private TableView<UsuarioClase> tabla_sigue_usuario;

    @FXML
    private TableColumn<UsuarioClase, String> columna_user;

    ObservableList<UsuarioClase> usuariosil;
    @FXML
    private Pane panel_canciongusta;

    @FXML
    private TableView<CanciongustClase> tabla_cancionnesgustar;

    @FXML
    private TableColumn<CanciongustClase, String> columna_cancionnom;

    ObservableList<CanciongustClase> canciongustl;
    @FXML
    private Pane panel_playlistn;

    @FXML
    private TableView<PlaylistClase> tabla_nombres_playlist;

    @FXML
    private TableColumn<PlaylistClase, String> columna_playnom;

    ObservableList<PlaylistClase> playlistl;
    @FXML
    private Pane panel_artistasforever;

    @FXML
    private TableView<ArtistaaasClase> tabla_artistaas;

    @FXML
    private TableColumn<ArtistaaasClase, String> columna_allartista;

    ObservableList<ArtistaaasClase> artistatodol;

    @FXML
    private ImageView ajustes1;

    @FXML
    private ImageView ajustes2;

    @FXML
    private Label podcast1;

    @FXML
    private Label podcast2;

    @FXML
    private Label podcast3;

    @FXML
    private Label podcast4;

    @FXML
    private Label artista1;

    @FXML
    private Label artista2;

    @FXML
    private Label artista3;

    @FXML
    private Label artista4;

    @FXML
    private Pane panel_podcastc;

    @FXML
    private Text titulo_podcast;

    @FXML
    private TableView<PodcastClase> tabla_podcast;

    @FXML
    private TableColumn<PodcastClase, String> columna_titulop;

    @FXML
    private TableColumn<PodcastClase, String> columna_desc;

    @FXML
    private TableColumn<PodcastClase, String> columna_fecha;

    ObservableList<PodcastClase> podcastl;
    @FXML
    private Pane panel_artistas;

    @FXML
    private Text titulo_artista;

    @FXML
    private TableView<ArtistaClase> tabla_artista;

    @FXML
    private TableColumn<ArtistaClase, String> columna_nombreal;

    @FXML
    private TableColumn<ArtistaClase, String> columna_anio;

    ObservableList<ArtistaClase> artistal;
    @FXML
    private TableView<CancionClase> tabla_album;

    @FXML
    private TableColumn<CancionClase, String> columna_can;

    @FXML
    private TableColumn<CancionClase, String> numero_rep;

    @FXML
    private TableColumn<CancionClase, String> columna_dur;

    ObservableList<CancionClase> canciones;
    @FXML
    private Pane panel_albumes;

    @FXML
    private Label album1;

    @FXML
    private Label album2;

    @FXML
    private Label album3;

    @FXML
    private Label album4;

    @FXML
    private Text titulo_album;

    @FXML
    private Label nombre_artista;

    @FXML
    private Label cancion1;

    @FXML
    private Label cancion4;

    @FXML
    private Label cancion3;

    @FXML
    private Label cancion2;

    @FXML
    private Label cancion5;

    @FXML
    private Label cancion8;

    @FXML
    private Label cancion7;

    @FXML
    private Label cancion6;

    @FXML
    private HBox playlist;

    @FXML
    private Pane panel_playlist;

    @FXML
    private Pane panel_playlist_cancion;

    @FXML
    private TextField titulo_playlist;

    @FXML
    private Label nombre_cancionrep;

    @FXML
    private Label nombre_cancion;

    @FXML
    private TextField cancion_para_playlist;

    @FXML
    private Button anade_playlist;

    ArrayList<String> usuario_sigue = new ArrayList<String>();
    @FXML
    private Text idioma_pre;

    @FXML
    private Pane idiomas;

    @FXML
    private Button dejar_de_seguir1;

    @FXML
    private Button dejar_de_seguir7;

    @FXML
    private Button dejar_de_seguir6;

    @FXML
    private Button dejar_de_seguir5;

    @FXML
    private Button dejar_de_seguir4;

    @FXML
    private Button dejar_de_seguir3;

    @FXML
    private Button dejar_de_seguir2;

    @FXML
    private Label usuario1;

    @FXML
    private Label usuario2;

    @FXML
    private Label usuario3;

    @FXML
    private Label usuario4;

    @FXML
    private Label usuario5;

    @FXML
    private Label usuario6;

    @FXML
    private Label usuario7;

    @FXML
    private Pane panel_amigo;

    @FXML
    private TextField buscador_usuario;

    @FXML
    private Label texto_usuario;

    @FXML
    private ImageView foto_usuario_amigo;

    @FXML
    private Button seguir;

    @FXML
    private Pane panel_explorar;

    @FXML
    private ComboBox<String> ajustes;

    @FXML
    private Label nombre_usuario;

    @FXML
    private ImageView corazon;

    @FXML
    public HBox podcast;

    @FXML
    public HBox artistas;

    @FXML
    public HBox albumes;

    @FXML
    public HBox canciones_que_te_gustan;

    @FXML
    public HBox escuchadas_recientemente;

    @FXML
    public HBox hechas_para_ti;

    @FXML
    private HBox casa;

    @FXML
    private HBox explora;

    @FXML
    private HBox radio;

    @FXML
    private TextField buscar;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Pane panel_generos;

    @FXML
    private Pane panel_podcast;

    @FXML
    private Pane panel_exitos;

    @FXML
    private Pane panel_novedades;

    private String pp;

    private String po;

    private FXMLLoader fxmlLoader;

    private int pe = 1;

    Controller Controlador1;

    @FXML
    void raton_se_mueve(MouseEvent event) {
        event.getPickResult().getIntersectedNode().setStyle("-fx-border-color: red; -fx-border-width: 5;");
    }

    @FXML
    void raton_se_va(MouseEvent event) {
        casa.setStyle("-fx-border-color: none; -fx-border-width: none;");
        explora.setStyle("-fx-border-color: none; -fx-border-width: none;");
        radio.setStyle("-fx-border-color: none; -fx-border-width: none;");
        podcast.setStyle("-fx-border-color: none; -fx-border-width: none;");
        artistas.setStyle("-fx-border-color: none; -fx-border-width: none;");
        albumes.setStyle("-fx-border-color: none; -fx-border-width: none;");
        canciones_que_te_gustan.setStyle("-fx-border-color: none; -fx-border-width: none;");
        escuchadas_recientemente.setStyle("-fx-border-color: none; -fx-border-width: none;");
        hechas_para_ti.setStyle("-fx-border-color: none; -fx-border-width: none;");
        playlist.setStyle("-fx-border-color: none; -fx-border-width: none;");
    }

    @FXML
    void click(MouseEvent event) {
        pp = event.getPickResult().getIntersectedNode().getId();
        switch (pp) {
            case "casa":
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_playlist.setVisible(false);
                panel_albumes.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                scroll.setVvalue(0.0);
                break;
            case "explora":
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(true);
                panel_amigo.setVisible(false);
                panel_playlist.setVisible(false);
                panel_albumes.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "radio":
                System.out.println("c");
                break;
            case "hechas_para_ti":
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_playlist.setVisible(false);
                panel_albumes.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                scroll.setVvalue(0);
                break;
            case "escuchadas_recientemente":
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_playlist.setVisible(false);
                panel_albumes.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                scroll.setVvalue(0.33);
                break;
            case "canciones_que_te_gustan":
                canciongustl.clear();
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.titulo FROM cancion " +
                            "INNER JOIN guarda_cancion g ON cancion.id = g.cancion_id INNER JOIN usuario u ON u.id = g.usuario_id WHERE u.username LIKE '" + nombre_usuario.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        CanciongustClase h = new CanciongustClase(tit);
                        canciongustl.add(h);
                    }
                    tabla_cancionnesgustar.setItems(canciongustl);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(true);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(true);
                panel_albumes.setVisible(false);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "albumes":
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_playlist.setVisible(false);
                panel_albumes.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                scroll.setVvalue(0.66);
                break;
            case "artistas":
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_playlist.setVisible(false);
                panel_albumes.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                scroll.setVvalue(1);
                break;
            case "podcast":
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_playlist.setVisible(false);
                panel_albumes.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                scroll.setVvalue(1.1);
                break;

            case "playlist":
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(false);
                panel_playlist.setVisible(true);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_albumes.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "al_motomami":
                canciones.clear();
                titulo_album.setText(album1.getText());
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.* FROM cancion " +
                            "INNER JOIN album a ON cancion.album_id = a.id WHERE a.titulo LIKE'" + titulo_album.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        int nr = rs.getInt("numero_reproducciones");
                        int dura = rs.getInt("duracion");
                        CancionClase c = new CancionClase(tit, nr, dura);
                        canciones.add(c);
                    }
                    tabla_album.setItems(canciones);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(false);
                panel_albumes.setVisible(true);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "al_malquerer":
                canciones.clear();
                titulo_album.setText(album2.getText());
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.* FROM cancion " +
                            "INNER JOIN album a ON cancion.album_id = a.id WHERE a.titulo LIKE'" + titulo_album.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        int nr = rs.getInt("numero_reproducciones");
                        int dura = rs.getInt("duracion");
                        CancionClase c = new CancionClase(tit, nr, dura);
                        canciones.add(c);
                    }
                    tabla_album.setItems(canciones);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(false);
                panel_albumes.setVisible(true);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "al_madrile":
                canciones.clear();
                titulo_album.setText(album3.getText());
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.* FROM cancion " +
                            "INNER JOIN album a ON cancion.album_id = a.id WHERE a.titulo LIKE'" + titulo_album.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        int nr = rs.getInt("numero_reproducciones");
                        int dura = rs.getInt("duracion");
                        CancionClase c = new CancionClase(tit, nr, dura);
                        canciones.add(c);
                    }
                    tabla_album.setItems(canciones);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(false);
                panel_albumes.setVisible(true);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "al_avida":
                canciones.clear();
                titulo_album.setText(album4.getText());
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.* FROM cancion " +
                            "INNER JOIN album a ON cancion.album_id = a.id WHERE a.titulo LIKE'" + titulo_album.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        int nr = rs.getInt("numero_reproducciones");
                        int dura = rs.getInt("duracion");
                        CancionClase c = new CancionClase(tit, nr, dura);
                        canciones.add(c);
                    }
                    tabla_album.setItems(canciones);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(false);
                panel_albumes.setVisible(true);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "a_rosalia":
                artistal.clear();
                titulo_artista.setText(artista1.getText());
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT album.* FROM album " +
                            "INNER JOIN artista a ON album.artista_id = a.id WHERE a.nombre LIKE'" + titulo_artista.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        int an = rs.getInt("anyo");
                        ArtistaClase b = new ArtistaClase(tit, an);
                        artistal.add(b);
                    }
                    tabla_artista.setItems(artistal);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(true);
                panel_albumes.setVisible(false);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "a_tangana":
                artistal.clear();
                titulo_artista.setText(artista2.getText());
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT album.* FROM album " +
                            "INNER JOIN artista a ON album.artista_id = a.id WHERE a.nombre LIKE'" + titulo_artista.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        int an = rs.getInt("anyo");
                        ArtistaClase b = new ArtistaClase(tit, an);
                        artistal.add(b);
                    }
                    tabla_artista.setItems(artistal);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(true);
                panel_albumes.setVisible(false);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "a_elche":
                artistal.clear();
                titulo_artista.setText(artista3.getText());
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT album.* FROM album " +
                            "INNER JOIN artista a ON album.artista_id = a.id WHERE a.nombre LIKE'" + titulo_artista.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        int an = rs.getInt("anyo");
                        ArtistaClase b = new ArtistaClase(tit, an);
                        artistal.add(b);
                    }
                    tabla_artista.setItems(artistal);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(true);
                panel_albumes.setVisible(false);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "a_hungara":
                artistal.clear();
                titulo_artista.setText(artista4.getText());
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT album.* FROM album " +
                            "INNER JOIN artista a ON album.artista_id = a.id WHERE a.nombre LIKE'" + titulo_artista.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        int an = rs.getInt("anyo");
                        ArtistaClase b = new ArtistaClase(tit, an);
                        artistal.add(b);
                    }
                    tabla_artista.setItems(artistal);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(false);
                panel_artistas.setVisible(true);
                panel_albumes.setVisible(false);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "p_wild":
                podcastl.clear();
                titulo_podcast.setText(podcast1.getText());
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT capitulo.* FROM capitulo " +
                            "INNER JOIN podcast p ON capitulo.podcast_id = p.id WHERE p.titulo LIKE'" + titulo_podcast.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String titu = rs.getString("titulo");
                        String desc = rs.getString("descripcion");
                        Date fe = rs.getDate("fecha");
                        PodcastClase a = new PodcastClase(titu, desc, fe);
                        podcastl.add(a);
                    }
                    tabla_podcast.setItems(podcastl);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(true);
                panel_artistas.setVisible(false);
                panel_albumes.setVisible(false);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "p_estirando":
                podcastl.clear();
                titulo_podcast.setText(podcast2.getText());
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT capitulo.* FROM capitulo " +
                            "INNER JOIN podcast p ON capitulo.podcast_id = p.id WHERE p.titulo LIKE'" + titulo_podcast.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String titu = rs.getString("titulo");
                        String desc = rs.getString("descripcion");
                        Date fe = rs.getDate("fecha");
                        PodcastClase a = new PodcastClase(titu, desc, fe);
                        podcastl.add(a);
                    }
                    tabla_podcast.setItems(podcastl);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(true);
                panel_artistas.setVisible(false);
                panel_albumes.setVisible(false);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "p_dentri":
                podcastl.clear();
                titulo_podcast.setText(podcast3.getText());
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT capitulo.* FROM capitulo " +
                            "INNER JOIN podcast p ON capitulo.podcast_id = p.id WHERE p.titulo LIKE'" + titulo_podcast.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String titu = rs.getString("titulo");
                        String desc = rs.getString("descripcion");
                        Date fe = rs.getDate("fecha");
                        PodcastClase a = new PodcastClase(titu, desc, fe);
                        podcastl.add(a);
                    }
                    tabla_podcast.setItems(podcastl);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(true);
                panel_artistas.setVisible(false);
                panel_albumes.setVisible(false);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "p_cuarto":
                podcastl.clear();
                titulo_podcast.setText(podcast4.getText());
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT capitulo.* FROM capitulo " +
                            "INNER JOIN podcast p ON capitulo.podcast_id = p.id WHERE p.titulo LIKE'" + titulo_podcast.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String titu = rs.getString("titulo");
                        String desc = rs.getString("descripcion");
                        Date fe = rs.getDate("fecha");
                        PodcastClase a = new PodcastClase(titu, desc, fe);
                        podcastl.add(a);
                    }
                    tabla_podcast.setItems(podcastl);
                    Base_Datos.conexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                panel_sigue_art.setVisible(false);
                panel_canciongusta.setVisible(false);
                panel_artistasforever.setVisible(false);
                panel_playlist_cancion.setVisible(false);
                panel_podcastc.setVisible(true);
                panel_artistas.setVisible(false);
                panel_albumes.setVisible(false);
                panel_playlist.setVisible(false);
                idiomas.setVisible(false);
                panel_explorar.setVisible(false);
                panel_amigo.setVisible(false);
                panel_podcastodo.setVisible(false);
                panel_podcastsigue.setVisible(false);
                break;
            case "icancion1":
                nombre_cancionrep.setText(cancion1.getText());
                nombre_artista.setText("Rosalia");
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.titulo FROM cancion " +
                            "INNER JOIN guarda_cancion g ON cancion.id = g.cancion_id INNER JOIN usuario u ON u.id = g.usuario_id WHERE u.username LIKE '" + nombre_usuario.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        if (tit.equals(nombre_cancionrep.getText())) {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_lover.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 0;
                            break;
                        } else {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_love.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 1;
                        }
                    }
                } catch (SQLException | FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "icancion2":
                nombre_cancionrep.setText(cancion2.getText());
                nombre_artista.setText("Alejandro Sanz");
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.titulo FROM cancion " +
                            "INNER JOIN guarda_cancion g ON cancion.id = g.cancion_id INNER JOIN usuario u ON u.id = g.usuario_id WHERE u.username LIKE '" + nombre_usuario.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        if (tit.equals(nombre_cancionrep.getText())) {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_lover.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 0;
                            break;
                        } else {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_love.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 1;
                        }
                    }
                } catch (SQLException | FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "icancion3":
                nombre_cancionrep.setText(cancion3.getText());
                nombre_artista.setText("Alejandro Sanz");
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.titulo FROM cancion " +
                            "INNER JOIN guarda_cancion g ON cancion.id = g.cancion_id INNER JOIN usuario u ON u.id = g.usuario_id WHERE u.username LIKE '" + nombre_usuario.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        if (tit.equals(nombre_cancionrep.getText())) {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_lover.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 0;
                            break;
                        } else {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_love.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 1;
                        }
                    }
                } catch (SQLException | FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "icancion4":
                nombre_cancionrep.setText(cancion4.getText());
                nombre_artista.setText("C. Tangana");
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.titulo FROM cancion " +
                            "INNER JOIN guarda_cancion g ON cancion.id = g.cancion_id INNER JOIN usuario u ON u.id = g.usuario_id WHERE u.username LIKE '" + nombre_usuario.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        if (tit.equals(nombre_cancionrep.getText())) {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_lover.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 0;
                            break;
                        } else {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_love.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 1;
                        }
                    }
                } catch (SQLException | FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "icancion5":
                nombre_cancionrep.setText(cancion5.getText());
                nombre_artista.setText("Sebastian Yatra");
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.titulo FROM cancion " +
                            "INNER JOIN guarda_cancion g ON cancion.id = g.cancion_id INNER JOIN usuario u ON u.id = g.usuario_id WHERE u.username LIKE '" + nombre_usuario.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        if (tit.equals(nombre_cancionrep.getText())) {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_lover.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 0;
                            break;
                        } else {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_love.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 1;
                        }
                    }
                } catch (SQLException | FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "icancion6":
                nombre_cancionrep.setText(cancion6.getText());
                nombre_artista.setText("Rosalia");
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.titulo FROM cancion " +
                            "INNER JOIN guarda_cancion g ON cancion.id = g.cancion_id INNER JOIN usuario u ON u.id = g.usuario_id WHERE u.username LIKE '" + nombre_usuario.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        if (tit.equals(nombre_cancionrep.getText())) {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_lover.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 0;
                            break;
                        } else {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_love.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 1;
                        }
                    }
                } catch (SQLException | FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "icancion7":
                nombre_cancionrep.setText(cancion7.getText());
                nombre_artista.setText("J. Balvin");
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.titulo FROM cancion " +
                            "INNER JOIN guarda_cancion g ON cancion.id = g.cancion_id INNER JOIN usuario u ON u.id = g.usuario_id WHERE u.username LIKE '" + nombre_usuario.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        if (tit.equals(nombre_cancionrep.getText())) {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_lover.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 0;
                            break;
                        } else {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_love.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 1;
                        }
                    }
                } catch (SQLException | FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "icancion8":
                nombre_cancionrep.setText(cancion8.getText());
                nombre_artista.setText("J. Balvin");
                try {
                    Statement stmt = Base_Datos.conexion().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT cancion.titulo FROM cancion " +
                            "INNER JOIN guarda_cancion g ON cancion.id = g.cancion_id INNER JOIN usuario u ON u.id = g.usuario_id WHERE u.username LIKE '" + nombre_usuario.getText() + "'");
// Procesa los resultados
                    while (rs.next()) {
                        String tit = rs.getString("titulo");
                        if (tit.equals(nombre_cancionrep.getText())) {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_lover.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 0;
                            break;
                        } else {
                            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_love.png");
                            InputStream isImage = (InputStream) new FileInputStream(img);
                            corazon.setImage(new Image(isImage));
                            pe = 1;
                        }
                    }
                } catch (SQLException | FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @FXML
    void intro(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            System.out.println(buscar.getText());
            //hacer un for para recorrer toda la lista de canciones y si es igual que muestre resultados si no que muestre que no existe
        }
    }

    @FXML
    void premium(ActionEvent event) {
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT u.id FROM usuario u INNER JOIN free f ON (f.usuario_id = u.id) WHERE u.username LIKE '" + nombre_usuario.getText() + "'");
            int cont = 0;
// Procesa los resultados
            if (rs.next()) {
                String id_usuario = rs.getString("id");
                if (!id_usuario.isEmpty()) {
                    try {
                        LocalDate fecha_a = LocalDate.now();
                        LocalDate fecha_n = fecha_a.plusMonths(1);
                        ResultSet rse = stmt.executeQuery("SELECT id FROM usuario WHERE username LIKE '" + nombre_usuario.getText() + "'");
// Procesa los resultados
                        if (rse.next()) {
                            String id_usuariob = rse.getString("id");
                            stmt.executeUpdate("DELETE FROM free WHERE usuario_id = '" + id_usuariob + "'");
                            stmt.executeUpdate("INSERT INTO premium(fecha_renovación,usuario_id)" +
                                    "VALUES('" + fecha_n + "','" + id_usuariob + "')");
                            stmt.executeUpdate("INSERT INTO forma_pago values()");
                            stmt.executeUpdate("INSERT INTO suscripcion(fecha_inicio,fecha_fin,premium_usuario_id)" +
                                    "VALUES('" + fecha_a + "','" + fecha_n + "','" + id_usuariob + "')");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    cont++;
                    fxmlLoader = new FXMLLoader(Main.class.getResource("pagar.fxml"));
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
            if (cont == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setContentText("El usuario ya es premium");
                alert.show();
            }
            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void corazon(MouseEvent event) throws FileNotFoundException {

        if (pe == 1) {
            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_lover.png");
            InputStream isImage = (InputStream) new FileInputStream(img);
            corazon.setImage(new Image(isImage));
            pe = 0;
            try {
                Statement stmt = Base_Datos.conexion().createStatement();
                stmt.executeUpdate("INSERT INTO guarda_cancion(usuario_id,cancion_id)" +
                        "VALUES((SELECT id FROM usuario WHERE username LIKE'" + nombre_usuario.getText() + "'),(SELECT id FROM cancion WHERE titulo LIKE'" + nombre_cancionrep.getText() + "'))");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_love.png");
            InputStream isImage = (InputStream) new FileInputStream(img);
            corazon.setImage(new Image(isImage));
            pe = 1;
            try {
                Statement stmt = Base_Datos.conexion().createStatement();
                stmt.executeUpdate("DELETE FROM guarda_cancion WHERE usuario_id=(SELECT id FROM usuario WHERE username LIKE'" + nombre_usuario.getText() + "') AND cancion_id=(SELECT id FROM cancion WHERE titulo LIKE'" + nombre_cancionrep.getText() + "')");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void aleatorio(MouseEvent event) {

    }

    @FXML
    void adelante(MouseEvent event) {

    }

    @FXML
    void play(MouseEvent event) {
        CancionClase ca = tabla_album.getSelectionModel().getSelectedItem();
        CanciongustClase ca1 = tabla_cancionnesgustar.getSelectionModel().getSelectedItem();
        PodcastClase ca2 = tabla_podcast.getSelectionModel().getSelectedItem();
        if (panel_canciongusta.isVisible()) {
            nombre_cancionrep.setText(ca1.getNomgus());
            corazon.setVisible(true);
        } else if(panel_albumes.isVisible()){
            nombre_cancionrep.setText(ca.getNombre());
            corazon.setVisible(true);
        }else{
            nombre_cancionrep.setText(ca2.getTit());
            nombre_artista.setText(titulo_podcast.getText());
            corazon.setVisible(false);
        }
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cancion.titulo FROM cancion " +
                    "INNER JOIN guarda_cancion g ON cancion.id = g.cancion_id INNER JOIN usuario u ON u.id = g.usuario_id WHERE u.username LIKE '" + nombre_usuario.getText() + "'");
// Procesa los resultados
            while (rs.next()) {
                String tit = rs.getString("titulo");
                if (tit.equals(nombre_cancionrep.getText())) {
                    File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_lover.png");
                    InputStream isImage = (InputStream) new FileInputStream(img);
                    corazon.setImage(new Image(isImage));
                    pe = 0;
                    break;
                } else {
                    File img = new File("/home/dam/Escritorio/Trabajos/demo/Spotify/src/main/resources/Imagenes/ic_love.png");
                    InputStream isImage = (InputStream) new FileInputStream(img);
                    corazon.setImage(new Image(isImage));
                    pe = 1;
                }
            }
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT artista.* FROM artista " +
                    "INNER JOIN album a ON a.artista_id = artista.id " +
                    "INNER JOIN cancion c ON c.album_id = a.id WHERE c.titulo LIKE'" + nombre_cancionrep.getText() + "'");
// Procesa los resultados
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                nombre_artista.setText(nombre);
            }
            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void atras(MouseEvent event) {

    }

    @FXML
    void repetir(MouseEvent event) {

    }

    @FXML
    void iniciar_sesion(ActionEvent event) {
        ajustes1.setVisible(true);
        ajustes2.setVisible(true);
        playlist.setVisible(true);
        corazon.setVisible(true);
        boton_podcast_gust.setVisible(true);
        boton_seguir_podcast.setVisible(true);
        fxmlLoader = new FXMLLoader(Main.class.getResource("inicio_sesion.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Controller2 controllesinstancia = fxmlLoader.getController();
            controllesinstancia.recibe(Controlador1);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Inicio de sesion");
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void recibe(String prueba) {
        nombre_usuario.setText(prueba);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Controlador1 = this;
        ajustes.getItems().addAll("Idiomas", "Añadir amigo", "Seguir Artistas");
        canciones = FXCollections.observableArrayList();
        columna_can.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        numero_rep.setCellValueFactory(new PropertyValueFactory<>("numero_rep"));
        columna_dur.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        artistal = FXCollections.observableArrayList();
        columna_nombreal.setCellValueFactory(new PropertyValueFactory<>("nombreal"));
        columna_anio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        podcastl = FXCollections.observableArrayList();
        columna_titulop.setCellValueFactory(new PropertyValueFactory<>("tit"));
        columna_desc.setCellValueFactory(new PropertyValueFactory<>("des"));
        columna_fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        artistatodol = FXCollections.observableArrayList();
        columna_allartista.setCellValueFactory(new PropertyValueFactory<>("nombret"));
        playlistl = FXCollections.observableArrayList();
        columna_playnom.setCellValueFactory(new PropertyValueFactory<>("nompl"));
        canciongustl = FXCollections.observableArrayList();
        columna_cancionnom.setCellValueFactory(new PropertyValueFactory<>("nomgus"));
        usuariosil = FXCollections.observableArrayList();
        columna_user.setCellValueFactory(new PropertyValueFactory<>("nombreu"));
        usuariosiartl = FXCollections.observableArrayList();
        columna_art_si.setCellValueFactory(new PropertyValueFactory<>("nombreart"));
        podcasttodol = FXCollections.observableArrayList();
        columna_titulopodcasttodo.setCellValueFactory(new PropertyValueFactory<>("titulopod"));
        columna_desc_podcasttodo.setCellValueFactory(new PropertyValueFactory<>("descrip"));
        podcassiguel = FXCollections.observableArrayList();
        columna_titulopodcastsigue.setCellValueFactory(new PropertyValueFactory<>("titulopod"));
        columna_desc_podcastsigue.setCellValueFactory(new PropertyValueFactory<>("descrip"));
    }

    @FXML
    void ajustescombo(ActionEvent event) {
        if (ajustes.getValue().equals("Añadir amigo")) {
            panel_sigue_art.setVisible(false);
            panel_amigo.setVisible(true);
            panel_artistasforever.setVisible(false);
            panel_playlist_cancion.setVisible(false);
            panel_podcastc.setVisible(false);
            panel_artistas.setVisible(false);
            panel_albumes.setVisible(false);
            panel_playlist.setVisible(false);
            idiomas.setVisible(false);
            panel_explorar.setVisible(false);
            panel_podcastodo.setVisible(false);
            panel_podcastsigue.setVisible(false);
        } else if (ajustes.getValue().equals("Idiomas")) {
            panel_sigue_art.setVisible(false);
            idiomas.setVisible(true);
            panel_artistasforever.setVisible(false);
            panel_playlist_cancion.setVisible(false);
            panel_podcastc.setVisible(false);
            panel_artistas.setVisible(false);
            panel_albumes.setVisible(false);
            panel_playlist.setVisible(false);
            panel_explorar.setVisible(false);
            panel_amigo.setVisible(false);
            panel_playlist.setVisible(false);
            panel_explorar.setVisible(false);
            panel_podcastodo.setVisible(false);
            panel_podcastsigue.setVisible(false);
        } else if (ajustes.getValue().equals("Seguir Artistas")) {
            panel_sigue_art.setVisible(true);
            idiomas.setVisible(false);
            panel_artistasforever.setVisible(false);
            panel_playlist_cancion.setVisible(false);
            panel_podcastc.setVisible(false);
            panel_artistas.setVisible(false);
            panel_albumes.setVisible(false);
            panel_playlist.setVisible(false);
            panel_explorar.setVisible(false);
            panel_amigo.setVisible(false);
            panel_playlist.setVisible(false);
            panel_explorar.setVisible(false);
            panel_podcastodo.setVisible(false);
            panel_podcastsigue.setVisible(false);
        }
    }

    @FXML
    void Generos(ActionEvent event) {
        panel_generos.setVisible(true);
        panel_podcast.setVisible(false);
        panel_exitos.setVisible(false);
        panel_novedades.setVisible(false);
    }

    @FXML
    void Podcast_explorar(ActionEvent event) {
        panel_podcast.setVisible(true);
        panel_generos.setVisible(false);
        panel_exitos.setVisible(false);
        panel_novedades.setVisible(false);
    }

    @FXML
    void Exitos(ActionEvent event) {
        panel_exitos.setVisible(true);
        panel_generos.setVisible(false);
        panel_podcast.setVisible(false);
        panel_novedades.setVisible(false);
    }

    @FXML
    void Novedades(ActionEvent event) {
        panel_novedades.setVisible(true);
        panel_generos.setVisible(false);
        panel_podcast.setVisible(false);
        panel_exitos.setVisible(false);
    }

    @FXML
    void intro_amigo(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            try {
                Statement stmt = Base_Datos.conexion().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT username FROM usuario");
                while (rs.next()) {
                    String usu = rs.getString("username");
                    if (buscador_usuario.getText().equals(usu)) {
                        texto_usuario.setText(buscador_usuario.getText());
                        foto_usuario_amigo.setVisible(true);
                        texto_usuario.setVisible(true);
                        seguir.setVisible(true);
                        break;
                    } else {
                        texto_usuario.setText("Usuario no encontrado");
                        foto_usuario_amigo.setVisible(true);
                        texto_usuario.setVisible(true);
                        seguir.setVisible(false);
                    }
                }
                Base_Datos.conexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            //hacer un for para recorrer toda la lista de canciones y si es igual que muestre resultados si no que muestre que no existe
        }
    }

    @FXML
    void seguir(ActionEvent event) {
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            stmt.executeUpdate("INSERT INTO sigue_usuario(usuario_id,usuario_seguido_id)" +
                    "VALUES((SELECT id FROM usuario WHERE username LIKE '" + nombre_usuario.getText() + "'),(SELECT id FROM usuario WHERE username LIKE '" + texto_usuario.getText() + "'))");

            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void ingles(ActionEvent event) {
        idioma_pre.setText("Ingles");
    }

    @FXML
    void frances(ActionEvent event) {
        idioma_pre.setText("Frances");
    }

    @FXML
    void italiano(ActionEvent event) {
        idioma_pre.setText("Italiano");
    }

    @FXML
    void aleman(ActionEvent event) {
        idioma_pre.setText("Aleman");
    }

    @FXML
    void espaniol(ActionEvent event) {
        idioma_pre.setText("Español");
    }

    @FXML
    void anade_playlist(ActionEvent event) {
        try {
            LocalDateTime fecha_h = LocalDateTime.now();
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT u.id,c.id,p.id FROM usuario u,cancion c,playlist p WHERE u.username LIKE '" + nombre_usuario.getText() + "' AND c.titulo LIKE '" + cancion_para_playlist.getText() + "' AND p.titulo LIKE '" + titulo_playlist.getText() + "'");
            if (rs.next()) {
                String playlist_id = rs.getString(3);
                String cancion_id = rs.getString(2);
                String usuaqrio_id = rs.getString(1);
                stmt.executeUpdate("INSERT INTO anyade_cancion_playlist(playlist_id,cancion_id,usuario_id,fecha_anyadida)" +
                        "VALUES('" + playlist_id + "','" + cancion_id + "','" + usuaqrio_id + "','" + fecha_h + "')");
            }
            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void crear_playlistt(ActionEvent event) {
        if (titulo_playlist.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setContentText("No has rellenado el campo");
            alert.show();
        } else {
            try {
                LocalDate fecha = LocalDate.now();
                Statement stmt = Base_Datos.conexion().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id FROM usuario WHERE username LIKE '" + nombre_usuario.getText() + "'");
// Procesa los resultados
                if (rs.next()) {
                    String id_usuario = rs.getString("id");
                    stmt.executeUpdate("INSERT INTO playlist(titulo,numero_canciones,fecha_creacion,usuario_id)" +
                            "VALUES('" + titulo_playlist.getText() + "',0,'" + fecha + "','" + id_usuario + "')");
                    stmt.executeUpdate("INSERT INTO sigue_playlist(usuario_id,playlist_id)" +
                            "VALUES((SELECT id FROM usuario WHERE username LIKE '" + nombre_usuario.getText() + "'),(SELECT id FROM playlist WHERE titulo LIKE '" + titulo_playlist.getText() + "'))");
                }
                Base_Datos.conexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            panel_playlist.setVisible(false);
            panel_playlist_cancion.setVisible(true);

        }
    }

    @FXML
    void buscar_cancion(KeyEvent event) {
        String titulo_cancion = cancion_para_playlist.getText();
        if (event.getCode() == KeyCode.ENTER) {
            try {
                Statement stmt = Base_Datos.conexion().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT titulo FROM cancion");
// Procesa los resultados
                while (rs.next()) {
                    String nombre_can = rs.getString("titulo");
                    if (titulo_cancion.equals(nombre_can)) {
                        nombre_cancion.setText(titulo_cancion);
                        anade_playlist.setVisible(true);
                        break;
                    } else {
                        nombre_cancion.setText("Cancion no encontrada");
                        anade_playlist.setVisible(false);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void entrar_album(ActionEvent event) {
        ArtistaClase ar = tabla_artista.getSelectionModel().getSelectedItem();
        canciones.clear();
        titulo_album.setText(ar.getNombreal());
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cancion.* FROM cancion " +
                    "INNER JOIN album a ON cancion.album_id = a.id WHERE a.titulo LIKE'" + titulo_album.getText() + "'");
// Procesa los resultados
            while (rs.next()) {
                String tit = rs.getString("titulo");
                int nr = rs.getInt("numero_reproducciones");
                int dura = rs.getInt("duracion");
                CancionClase c = new CancionClase(tit, nr, dura);
                canciones.add(c);
            }
            tabla_album.setItems(canciones);
            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panel_artistasforever.setVisible(false);
        panel_playlist_cancion.setVisible(false);
        panel_podcastc.setVisible(false);
        panel_artistas.setVisible(false);
        panel_albumes.setVisible(true);
        panel_playlist.setVisible(false);
        idiomas.setVisible(false);
        panel_explorar.setVisible(false);
        panel_amigo.setVisible(false);
        panel_podcastodo.setVisible(false);
        panel_podcastsigue.setVisible(false);
    }

    @FXML
    void todo_artistas(ActionEvent event) {
        artistatodol.clear();
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM artista");

// Procesa los resultados
            while (rs.next()) {
                String titus = rs.getString("nombre");
                ArtistaaasClase e = new ArtistaaasClase(titus);
                artistatodol.add(e);
            }
            tabla_artistaas.setItems(artistatodol);
            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panel_artistasforever.setVisible(true);
        panel_playlist_cancion.setVisible(false);
        panel_podcastc.setVisible(false);
        panel_artistas.setVisible(false);
        panel_albumes.setVisible(false);
        panel_playlist.setVisible(false);
        idiomas.setVisible(false);
        panel_explorar.setVisible(false);
        panel_amigo.setVisible(false);
        panel_podcastodo.setVisible(false);
        panel_podcastsigue.setVisible(false);
    }

    @FXML
    void entrar_artista(ActionEvent event) {
        ArtistaaasClase art = tabla_artistaas.getSelectionModel().getSelectedItem();
        artistal.clear();
        titulo_artista.setText(art.getNombret());
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT album.* FROM album " +
                    "INNER JOIN artista a ON album.artista_id = a.id WHERE a.nombre LIKE'" + titulo_artista.getText() + "'");
// Procesa los resultados
            while (rs.next()) {
                String tit = rs.getString("titulo");
                int an = rs.getInt("anyo");
                ArtistaClase b = new ArtistaClase(tit, an);
                artistal.add(b);
            }
            tabla_artista.setItems(artistal);
            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panel_artistasforever.setVisible(false);
        panel_playlist_cancion.setVisible(false);
        panel_podcastc.setVisible(false);
        panel_artistas.setVisible(true);
        panel_albumes.setVisible(false);
        panel_playlist.setVisible(false);
        idiomas.setVisible(false);
        panel_explorar.setVisible(false);
        panel_amigo.setVisible(false);
        panel_podcastodo.setVisible(false);
        panel_podcastsigue.setVisible(false);
    }

    @FXML
    void clicktabla(MouseEvent event) {
        PlaylistClase arti = tabla_nombres_playlist.getSelectionModel().getSelectedItem();
        canciones.clear();
        titulo_album.setText(arti.getNompl());
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cancion.* FROM cancion " +
                    "INNER JOIN anyade_cancion_playlist a ON cancion.id = a.cancion_id INNER JOIN playlist p ON p.id = a.playlist_id WHERE p.titulo LIKE'" + titulo_album.getText() + "'");
// Procesa los resultados
            while (rs.next()) {
                String tit = rs.getString("titulo");
                int nr = rs.getInt("numero_reproducciones");
                int dura = rs.getInt("duracion");
                CancionClase c = new CancionClase(tit, nr, dura);
                canciones.add(c);
            }
            tabla_album.setItems(canciones);
            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panel_artistasforever.setVisible(false);
        panel_playlist_cancion.setVisible(false);
        panel_podcastc.setVisible(false);
        panel_artistas.setVisible(false);
        panel_albumes.setVisible(true);
        panel_playlist.setVisible(false);
        idiomas.setVisible(false);
        panel_explorar.setVisible(false);
        panel_amigo.setVisible(false);
        panel_podcastodo.setVisible(false);
        panel_podcastsigue.setVisible(false);
    }

    @FXML
    void botonparaplaylist(ActionEvent event) {
        panel_playlistn.setVisible(true);
        playlistl.clear();
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT playlist.* FROM playlist INNER JOIN sigue_playlist sp ON playlist.id = sp.playlist_id INNER JOIN usuario u ON sp.usuario_id = u.id WHERE u.username LIKE'" + nombre_usuario.getText() + "'");
// Procesa los resultados
            while (rs.next()) {
                String t = rs.getString("titulo");
                PlaylistClase j = new PlaylistClase(t);
                playlistl.add(j);
            }
            tabla_nombres_playlist.setItems(playlistl);
            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void dejar_de_seguir(ActionEvent event) {
        UsuarioClase a = tabla_sigue_usuario.getSelectionModel().getSelectedItem();
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            stmt.executeUpdate("DELETE FROM sigue_usuario WHERE usuario_id =" +
                    "(SELECT id FROM usuario WHERE username LIKE '" + nombre_usuario.getText() + "') AND usuario_seguido_id = (SELECT id FROM usuario WHERE username LIKE '" + a.getNombreu() + "')");

            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void actualiza(ActionEvent event) {
        usuariosil.clear();
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT usuario.username FROM usuario INNER JOIN sigue_usuario s ON usuario.id = s.usuario_seguido_id WHERE s.usuario_id =(SELECT id From usuario Where username LIKE '" + nombre_usuario.getText() + "')");
// Procesa los resultados
            while (rs.next()) {
                String to = rs.getString("username");
                UsuarioClase j = new UsuarioClase(to);
                usuariosil.add(j);
            }
            tabla_sigue_usuario.setItems(usuariosil);
            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void actualiza_art(ActionEvent event) {
        usuariosiartl.clear();
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT artista.nombre FROM artista INNER JOIN sigue_artista s ON artista.id = s.artista_id WHERE s.usuario_id =(SELECT id From usuario Where username LIKE '" + nombre_usuario.getText() + "')");
// Procesa los resultados
            while (rs.next()) {
                String ton = rs.getString("nombre");
                ArtistaSigueClase k = new ArtistaSigueClase(ton);
                usuariosiartl.add(k);
            }
            tabla_sigue_artista.setItems(usuariosiartl);
            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void dejar_de_seguir_art(ActionEvent event) {
        ArtistaSigueClase a = tabla_sigue_artista.getSelectionModel().getSelectedItem();
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            stmt.executeUpdate("DELETE FROM sigue_artista WHERE usuario_id =" +
                    "(SELECT id FROM usuario WHERE username LIKE '" + nombre_usuario.getText() + "') AND artista_id = (SELECT id FROM artista WHERE nombre LIKE '" + a.getNombreart() + "')");

            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void seguir_art(ActionEvent event) {
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            stmt.executeUpdate("INSERT INTO sigue_artista(usuario_id,artista_id)" +
                    "VALUES((SELECT id FROM usuario WHERE username LIKE '" + nombre_usuario.getText() + "'),(SELECT id FROM artista WHERE nombre LIKE '" + texto_artista_si.getText() + "'))");

            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void intro_artista(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            try {
                Statement stmt = Base_Datos.conexion().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT nombre FROM artista");
                while (rs.next()) {
                    String usu = rs.getString("nombre");
                    if (buscador_artista.getText().equals(usu)) {
                        texto_artista_si.setText(buscador_artista.getText());
                        foto_usuario_artista.setVisible(true);
                        texto_artista_si.setVisible(true);
                        seguir_art.setVisible(true);
                        break;
                    } else {
                        texto_artista_si.setText("Artista no encontrado");
                        foto_usuario_artista.setVisible(true);
                        texto_artista_si.setVisible(true);
                        seguir_art.setVisible(false);
                    }
                }
                Base_Datos.conexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void todo_podcast(ActionEvent event) {
        panel_podcastc.setVisible(false);
        panel_podcastodo.setVisible(true);
        podcasttodol.clear();
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT podcast.* FROM podcast");
// Procesa los resultados
            while (rs.next()) {
                String h = rs.getString("titulo");
                String o = rs.getString("descripcion");
                PodcastTodoClase p = new PodcastTodoClase(h,o);
                podcasttodol.add(p);
            }
            tabla_todo_podcast.setItems(podcasttodol);
            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void seguir_podcast(ActionEvent event) {
        PodcastTodoClase al = tabla_podcast_sigue.getSelectionModel().getSelectedItem();
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            stmt.executeUpdate("INSERT INTO podcast_usuario(usuario_id,podcast_id)" +
                    "VALUES((SELECT id FROM usuario WHERE username LIKE'" + nombre_usuario.getText() + "'),(SELECT id FROM podcast WHERE titulo LIKE'" + titulo_podcast.getText() + "'))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panel_sigue_art.setVisible(false);
        panel_canciongusta.setVisible(false);
        panel_artistasforever.setVisible(false);
        panel_playlist_cancion.setVisible(false);
        panel_podcastc.setVisible(true);
        panel_artistas.setVisible(false);
        panel_albumes.setVisible(false);
        panel_playlist.setVisible(false);
        idiomas.setVisible(false);
        panel_explorar.setVisible(false);
        panel_amigo.setVisible(false);
        panel_podcastodo.setVisible(false);
        panel_podcastsigue.setVisible(false);
    }

    @FXML
    void ver_podcast_sigo(ActionEvent event) {
            podcassiguel.clear();
            try {
                Statement stmt = Base_Datos.conexion().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT podcast.* FROM podcast " +
                        "INNER JOIN podcast_usuario pu ON podcast.id = pu.podcast_id INNER JOIN usuario u ON pu.usuario_id = u.id WHERE u.username LIKE'" + nombre_usuario.getText() + "'");
// Procesa los resultados
                while (rs.next()) {
                    String titu = rs.getString("titulo");
                    String desc = rs.getString("descripcion");
                    PodcastTodoClase am = new PodcastTodoClase(titu, desc);
                    podcassiguel.add(am);
                }
                tabla_podcast_sigue.setItems(podcassiguel);
                Base_Datos.conexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            panel_sigue_art.setVisible(false);
            panel_canciongusta.setVisible(false);
            panel_artistasforever.setVisible(false);
            panel_playlist_cancion.setVisible(false);
            panel_podcastc.setVisible(false);
            panel_artistas.setVisible(false);
            panel_albumes.setVisible(false);
            panel_playlist.setVisible(false);
            idiomas.setVisible(false);
            panel_explorar.setVisible(false);
            panel_amigo.setVisible(false);
            panel_podcastodo.setVisible(false);
            panel_podcastsigue.setVisible(true);
        }

    @FXML
    void clicktablapodcast(MouseEvent event) {
        PodcastTodoClase al = tabla_todo_podcast.getSelectionModel().getSelectedItem();
        podcastl.clear();
        titulo_podcast.setText(al.getTitulopod());
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT capitulo.* FROM capitulo " +
                    "INNER JOIN podcast p ON capitulo.podcast_id = p.id WHERE p.titulo LIKE'" + titulo_podcast.getText() + "'");
// Procesa los resultados
            while (rs.next()) {
                String titu = rs.getString("titulo");
                String desc = rs.getString("descripcion");
                Date fe = rs.getDate("fecha");
                PodcastClase a = new PodcastClase(titu, desc, fe);
                podcastl.add(a);
            }
            tabla_podcast.setItems(podcastl);
            Base_Datos.conexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panel_sigue_art.setVisible(false);
        panel_canciongusta.setVisible(false);
        panel_artistasforever.setVisible(false);
        panel_playlist_cancion.setVisible(false);
        panel_podcastc.setVisible(true);
        panel_artistas.setVisible(false);
        panel_albumes.setVisible(false);
        panel_playlist.setVisible(false);
        idiomas.setVisible(false);
        panel_explorar.setVisible(false);
        panel_amigo.setVisible(false);
        panel_podcastodo.setVisible(false);
        panel_podcastsigue.setVisible(false);
    }

    @FXML
    void dejar_de_seguir_podcast(ActionEvent event) {
        PodcastTodoClase al = tabla_podcast_sigue.getSelectionModel().getSelectedItem();
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            stmt.executeUpdate("DELETE FROM podcast_usuario WHERE usuario_id = (SELECT id FROM usuario WHERE username LIKE'" + nombre_usuario.getText() + "') AND podcast_id = (SELECT id FROM podcast WHERE titulo LIKE'" + al.getTitulopod() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panel_sigue_art.setVisible(false);
        panel_canciongusta.setVisible(false);
        panel_artistasforever.setVisible(false);
        panel_playlist_cancion.setVisible(false);
        panel_podcastc.setVisible(false);
        panel_artistas.setVisible(false);
        panel_albumes.setVisible(false);
        panel_playlist.setVisible(false);
        idiomas.setVisible(false);
        panel_explorar.setVisible(false);
        panel_amigo.setVisible(false);
        panel_podcastodo.setVisible(false);
        panel_podcastsigue.setVisible(true);
    }
    @FXML
    void dejar_de_seguir_playlist(ActionEvent event) {
        PlaylistClase ali = tabla_nombres_playlist.getSelectionModel().getSelectedItem();
        panel_albumes.setVisible(false);
        try {
            Statement stmt = Base_Datos.conexion().createStatement();
            stmt.executeUpdate("DELETE FROM sigue_playlist WHERE usuario_id = (SELECT id FROM usuario WHERE username LIKE '" + nombre_usuario.getText() + "') AND playlist_id = (SELECT id FROM playlist WHERE titulo LIKE '" + ali.getNompl() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}