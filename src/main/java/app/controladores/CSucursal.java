package app.controladores;

import app.App;
import app.Empresa;
import app.Sucursal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CSucursal {
    @FXML
    public TextField textcodigoScursal;
    @FXML
    public TextField textciudad;
    @FXML
    public TextField textcantEmpleados;
    @FXML
    public TextField textNit;

    // warnings
    @FXML
    public Label warningMessageCodigoS;
    @FXML
    public Label warningMessageCiudad;
    @FXML
    public Label warningMessageDirecion;
    @FXML
    public Label warningMessageCEmpleados;
    @FXML
    public Label warningMessageNitS;


    public void Enviar(ActionEvent event) throws IOException {
        Integer codigoSucursal = Integer.parseInt(textcodigoScursal.getText());
        String ciudad = textciudad.getText(); // validar
        Integer  cantEmpleados = Integer.parseInt(textcantEmpleados.getText());
        String Nit = textNit.getText();
        new Sucursal(codigoSucursal,ciudad,cantEmpleados,Empresa.empresas.get(Nit));
    }



    /*@FXML
    private void clean(){
        textCodigoS.setText("");
        textCiudad.setText("");
        textCEmpleados.setText("");
        textDirecion.setText("");
        textNitS.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings(){
        warningMessageCodigoS.setText("");
        warningMessageCiudad.setText("");
        warningMessageDirecion.setText("");
        warningMessageCEmpleados.setText("");
        warningMessageNitS.setText("");
    }*/

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
}
