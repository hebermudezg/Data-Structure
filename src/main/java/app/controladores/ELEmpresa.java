package app.controladores;

import app.App;
import app.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ELEmpresa {
    @FXML
    public TextField textNitElimi;
    @FXML
    public Label warningMessageResult;


    public void Eliminar(ActionEvent event) throws IOException {
        String Nit = textNitElimi.getText().trim();
        Empresa empresaeditar = Empresa.empresas.get(Nit);
        empresaeditar.eliminarempresa();

    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }


    /*@FXML
    private void clean(){
        textUNSBN.setText("");
        cleanWarnings();
    }*/

    @FXML
    private void cleanWarnings(){
        warningMessageResult.setText("");

    }

}
