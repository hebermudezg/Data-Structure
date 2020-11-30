package app.controladores;

import app.App;
import app.Sucursal;
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

public class ESucursal implements Initializable {
    @FXML
    public TextField textCodigoS;
    @FXML
    public TextField textModificado;
    @FXML
    public ChoiceBox chiOpcion;

    @FXML
    public Label warningMessageGenral;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chiOpcion.getItems().removeAll(chiOpcion.getItems());
        chiOpcion.getItems().addAll("Codigo sucursal", "Ciudad", "Cantidad de empleados");
    }
    //organisar dependiendo lo que se necesite
    public void Enviar(ActionEvent event) throws IOException {

        // Informacion editar*****
        String Nit = textCodigoS.getText();
        // buscando la empresa
        Sucursal sucursaleditar = Sucursal.sucursales.get(Nit);
        String value = (String) chiOpcion.getValue();
        String Modified = textModificado.getText();


        if (value.equals("Codigo sucursal")){
            boolean exito = sucursaleditar.editarcodigosucursal(Modified);
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

        }else if (value.equals("Ciudad")){
            boolean exito =sucursaleditar.editarciudad(Modified);
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

        }else if (value.equals("Cantidad de empleados")){
            boolean exito = sucursaleditar.editarcantempleados(Integer.parseInt(Modified));
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


    @FXML
    private void clean(){
        textCodigoS.setText("");
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
