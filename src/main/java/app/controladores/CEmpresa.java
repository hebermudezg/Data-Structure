package app.controladores;

import app.App;
import app.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    public void Enviar(ActionEvent event) throws IOException {
        String Nit = textNit.getText();
        Integer Valor_en_bolsa = Integer.parseInt(textValor_en_bolsa.getText()); // validar
        String RazonSocial = textRazonSocial.getText();
        new Empresa(Nit, Valor_en_bolsa, RazonSocial);
        App.setRoot("MenuPrincipal");
    }

    /*@FXML
    private void clean(){
        textNit.setText("");
        textRazon.setText("");
        textPresidente.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings(){
        warningMessageNit.setText("");
        warningMessageRazon.setText("");
        warningMessagePresidente.setText("");

    } */
    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }


}
