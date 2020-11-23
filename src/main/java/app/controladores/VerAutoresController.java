package app.controladores;

import app.App;
import app.Autor;
import app.Libro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VerAutoresController implements Initializable {
    public ListView listView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Autor autor : Autor.autores.values()) {
            listView.getItems().add(autor);
        }
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("menu_principal");
    }


}
