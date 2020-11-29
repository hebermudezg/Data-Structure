package app.controladores;

import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EEspecialidad implements Initializable {
    @FXML
    public TextField textCodigoE;
    @FXML
    public TextField textModificado;
    @FXML
    public ChoiceBox chiOpcion;
    @FXML
    public Label warningMessageGenral;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chiOpcion.getItems().removeAll(chiOpcion.getItems());
        chiOpcion.getItems().addAll("Codigo", "Encargado", "Enfoque", "Linea de atencion");
    }
    //organisar dependiendo lo que se necesite
    public void Enviar(ActionEvent event) throws IOException {
        cleanWarnings();
        String nit = "";
        if(textCodigoE.getText().trim().equals("")||textModificado.getText().trim().equals("")){
            warningMessageGenral.setText("¡ No pueden estar vacios !");
            return;
        }
        nit = textCodigoE.getText().trim();
        /////////////IMPORTANTE PARA SABER EL VALOR DEL CHOICEBOX //////////

        String value = (String) chiOpcion.getValue();


        /*codigo de busqueda para eliminar
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).Nit.equals(nit)) {
                empresas.remove(i);
                System.out.println("¡ Se realizo la operacion correctamente !");
                return;
            }
        }
        alfinal poner que la operacion salio bien
         */

        clean();
    }
    @FXML
    private void clean(){
        textCodigoE.setText("");
        textModificado.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings(){
        warningMessageGenral.setText("");

    }
    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
}
