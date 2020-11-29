package app.controladores;

import app.App;
import app.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CEmpresa {
    @FXML
    public TextField textNit;
    @FXML
    public TextField textValor_en_bolsa;
    @FXML
    public TextField textRazonSocial;

    // warnings
    @FXML
    public Label warningMessageNit;
    @FXML
    public Label warningMessageRazon;
    @FXML
    public Label warningMessagePresidente;

    @FXML
    public Label warningMessageGeneral;


    @FXML
    public void Enviar(ActionEvent event) throws IOException {

        if(textNit.getText().trim().equals("") || textValor_en_bolsa.getText().trim().equals("") || textRazonSocial.getText().trim().equals("")) {
            warningMessageGeneral.setText("¡No pueden estar vacios !");
        }else if(Empresa.empresas.containsKey(textNit.getText().trim())){
            warningMessageGeneral.setText("Ese Nit ya esta registrado");
        }else{
            String Nit = textNit.getText();
            Integer Valor_en_bolsa = Integer.parseInt(textValor_en_bolsa.getText()); // validar
            String RazonSocial = textRazonSocial.getText().toLowerCase();
            new Empresa(Nit, Valor_en_bolsa, RazonSocial);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setContentText("Empresa creada correctamente" );
            alert.showAndWait();

            App.setRoot("MenuPrincipal");

        }
    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }

}
