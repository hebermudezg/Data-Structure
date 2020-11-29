package app.controladores;

import app.App;
import app.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EEmpresa implements Initializable {
    @FXML
    public TextField textNit;
    @FXML
    public TextField textModificado;
    @FXML
    public ChoiceBox chiOpcion;
    @FXML
    public Label warningMessageGenral;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chiOpcion.getItems().removeAll(chiOpcion.getItems());
        chiOpcion.getItems().addAll("Nit", "Valor en bolsa", "Razon social");
        textModificado.getText();
    }


    public void Enviar(ActionEvent event) throws IOException {
        //cleanWarnings();
        //String Nit = "";

        /*if(textNit.getText().trim().equals("")||textModificado.getText().trim().equals("")){
            warningMessageGenral.setText("¡ No pueden estar vacios !");
            return;
        }*/

        // Informacion editar*****
        String Nit = textNit.getText();
        // buscando la empresa
        Empresa empresaeditar = Empresa.empresas.get(Nit);

        String value = (String) chiOpcion.getValue();
        String Modified = textModificado.getText();


        if (value.equals("Nit")){
            empresaeditar.editarNit(Modified);
        }else if (value.equals("Valor en bolsa")){
            empresaeditar.editarvalorenbolsa(Integer.parseInt(Modified));
        }else if (value.equals("Razon social")){
            //empresaeditar.editarrazonsocial();
        }

    }



    /*@FXML
    private void clean(){
        textNit.setText("");
        textModificado.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings(){
        warningMessageGenral.setText("");

    }*/
    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
}
