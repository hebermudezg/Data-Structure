package app.controladores;

import app.App;
import app.Empresa;
import app.Sucursal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    public Label warningMessageGeneral;;


    public void Enviar(ActionEvent event) throws IOException {
        if (textcodigoScursal.getText().trim().equals("") || textciudad.getText().trim().equals("") || textcantEmpleados.getText().trim().equals("") || textNit.getText().trim().equals("")) {
            warningMessageGeneral.setText("¡No pueden estar vacios !");
        }else if (Sucursal.sucursales.containsKey(textcodigoScursal.getText().trim()))
            warningMessageGeneral.setText("Código de sucursal ya está en uso");
        else if (!Empresa.empresas.containsKey(textNit.getText().trim())) {
            warningMessageGeneral.setText("Ingrese un NIT de una empresa registrada");
        } else {
            String codigoSucursal = textcodigoScursal.getText();
            String ciudad = textciudad.getText().toLowerCase(); // validar
            Integer cantEmpleados = Integer.parseInt(textcantEmpleados.getText());
            String Nit = textNit.getText();
            new Sucursal(codigoSucursal, ciudad, cantEmpleados, Empresa.empresas.get(Nit));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setContentText("Sucursal creada correctamente" );
            alert.showAndWait();

            App.setRoot("MenuPrincipal");
        }
    }


    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
}
