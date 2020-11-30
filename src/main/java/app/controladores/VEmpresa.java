package app.controladores;
import app.App;
import app.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class VEmpresa implements Initializable {

    @FXML
    public ListView listView;

    @FXML
    public Label warningMessageGeneral;


    // Mostrar empresas al iniciar***
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Empresa.empresas.isEmpty()){
            warningMessageGeneral.setText("No hay empresas registradas");
        }else{
            listView.getItems().clear(); // limpiando
            Set<Object> empresasmostrar = App.graph.vertexSet();
            for(Object obj : empresasmostrar){
                if(obj instanceof Empresa){  // bucando en el grafo si es instancia de Empresa
                    listView.getItems().add((Empresa) obj);
                }
            }

        }

    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }

}
