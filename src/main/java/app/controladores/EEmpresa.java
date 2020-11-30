package app.controladores;

import app.App;
import app.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

        // Informacion editar*****
        String Nit = textNit.getText();
        // buscando la empresa
        Empresa empresaeditar = Empresa.empresas.get(Nit);

        String value = (String) chiOpcion.getValue();
        String Modified = textModificado.getText();


        if (value.equals("Nit")){
            boolean exito = empresaeditar.editarNit(Modified);
            if (exito){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setContentText("se modifico correctamente" );
                alert.showAndWait();
                App.setRoot("MenuPrincipal");
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setContentText("No se modifico correctamente" );
                alert.showAndWait();
                App.setRoot("MenuPrincipal");
            }

        }else if (value.equals("Valor en bolsa")){
            boolean exito =empresaeditar.editarvalorenbolsa(Integer.parseInt(Modified));
            if (exito){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setContentText("se modifico correctamente" );
                alert.showAndWait();
                App.setRoot("MenuPrincipal");
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setContentText("No se modifico correctamente" );
                alert.showAndWait();
                App.setRoot("MenuPrincipal");
            }

        }else if (value.equals("Razon social")){
            boolean exito = empresaeditar.editarrazonsocial(Modified);
            if (exito){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setContentText("se modifico correctamente" );
                alert.showAndWait();
                App.setRoot("MenuPrincipal");
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setContentText("No se modifico correctamente" );
                alert.showAndWait();
                App.setRoot("MenuPrincipal");
            }
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
