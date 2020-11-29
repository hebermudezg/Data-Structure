package app.controladores;
import app.App;
import app.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
public class VEmpresa implements Initializable {

    @FXML
    public ListView listView;


    public void Enviar(ActionEvent event) throws IOException {
        listView.getItems().clear(); // limpiando
        Set<Object> empresasmostrar = App.graph.vertexSet();
        for(Object obj : empresasmostrar){
            if(obj instanceof Empresa){
                listView.getItems().add((Empresa) obj);
            }
        }

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }








}
