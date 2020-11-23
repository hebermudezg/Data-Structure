package app.controladores;

import app.App;
import app.Libro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VerLibrosController implements Initializable {

    public ListView listView;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Libro libro : Libro.libros.values()) {
            listView.getItems().add(new Label(libro.toString()));
        }
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("menu_principal");
    }


}
