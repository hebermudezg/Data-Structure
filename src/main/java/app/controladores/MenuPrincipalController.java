package app.controladores;

import java.io.IOException;
import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuPrincipalController {
    public Button closeButton;
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void routeIngresarAutor(ActionEvent event) throws IOException {
        App.setRoot("ingresar_autor");
    }


    @FXML
    private void routeVerAutores(ActionEvent event) throws IOException {
        App.setRoot("ver_autores");
    }
    @FXML
    private void routeIngresarLibro(ActionEvent event) throws IOException {
        App.setRoot("ingresar_libro");
    }
    @FXML
    private void routeConsultarLibro(ActionEvent event) throws IOException {
        App.setRoot("consultar_libro");
    }
    @FXML
    private void routeVerLibros(ActionEvent event) throws IOException {
        App.setRoot("ver_libros");
    }


}
