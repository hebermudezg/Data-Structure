package app.controladores;

import app.App;
import app.Especialidad;
import app.Sucursal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CEspecialidad{
    // los textBox
    @FXML
    public TextField textcodigoEspecialidad;
    @FXML
    public TextField textencargado;
    @FXML
    public TextField textnumero_entregas;
    @FXML
    public TextField textcodigoScursal;

    // Warnings
    @FXML
    public Label warningMessageCodigE;
    @FXML
    public Label warningMessageEncargado;
    @FXML
    public Label warningMessageEnfoque;
    @FXML
    public Label warningMessageCodigoSu;


    public void Enviar(ActionEvent event) throws IOException {
        Integer codigoEspecialidad = Integer.parseInt(textcodigoEspecialidad.getText());
        String encargado = textencargado.getText(); // validar
        Integer numero_entregas = Integer.parseInt(textnumero_entregas.getText());
        Integer codigoScursal = Integer.parseInt(textcodigoScursal.getText());
        //creando la especialidad
        new Especialidad(codigoEspecialidad,encargado,numero_entregas, Sucursal.sucursales.get(codigoScursal));
    }


    /*@FXML
    private void clean(){
        textCodigE.setText("");
        textEncargado.setText("");
        textEnfoque.setText("");
        textLAtencion.setText("");
        textCodigoSu.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings(){
        warningMessageCodigE.setText("");
        warningMessageEncargado.setText("");
        warningMessageEnfoque.setText("");
        warningMessageLAtencion.setText("");
        warningMessageCodigoSu.setText("");
    } */
    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
}