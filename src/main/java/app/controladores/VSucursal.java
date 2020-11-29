package app.controladores;

import app.App;
import app.Sucursal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class VSucursal implements Initializable {
    @FXML
    public ListView listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void Enviar(ActionEvent event) throws IOException {
        listView.getItems().clear(); // limpiando
        Set<Object> sucursalesmostrar = App.graph.vertexSet();
        for(Object obj : sucursalesmostrar){
            if(obj instanceof Sucursal){
                listView.getItems().add((Sucursal) obj);
            }
        }

    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }


}