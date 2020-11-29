package app.controladores;

import app.App;
import app.Especialidad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class VEspecialidad implements Initializable {
    @FXML
    public ListView listView;

    @FXML
    public Label warningMessageGeneral;

    @FXML
    public Button volver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getItems().clear(); // limpiando
        Set<Object> especialidadesmostrar = App.graph.vertexSet();
        for(Object obj : especialidadesmostrar){
            if(obj instanceof Especialidad){
                listView.getItems().add((Especialidad) obj);
            }
        }
    }


    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }


}