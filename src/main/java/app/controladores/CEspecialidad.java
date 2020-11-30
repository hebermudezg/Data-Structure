package app.controladores;

import app.App;
import app.Especialidad;
import app.Sucursal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    @FXML
    public Label warningMessageGeneral;


    public void Enviar(ActionEvent event) throws IOException {
        if (textcodigoEspecialidad.getText().trim().equals("") || textencargado.getText().trim().equals("") || textnumero_entregas.getText().trim().equals("") || textcodigoScursal.getText().trim().equals("")) {
            warningMessageGeneral.setText("¡Los campos no pueden estar vacios !");
        }
        else if (Especialidad.especialidades.containsKey(textcodigoEspecialidad.getText())) {
            warningMessageGeneral.setText("Código de especialidad ya está en uso");
        }
        else if (!Sucursal.sucursales.containsKey(textcodigoScursal.getText())) {
            warningMessageGeneral.setText("Ingrese un Sucursal que esté registrada");

        }
        else {
            String codigoEspecialidad = textcodigoEspecialidad.getText();
            String encargado = textencargado.getText().toLowerCase(); // validar
            Integer numero_entregas = Integer.parseInt(textnumero_entregas.getText());
            String codigoScursal = textcodigoScursal.getText();
            //creando la especialidad
            new Especialidad(codigoEspecialidad, encargado, numero_entregas, Sucursal.sucursales.get(codigoScursal));
            App.setRoot("MenuPrincipal");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setContentText("Especialidad creada correctamente" );
            alert.showAndWait();

            App.setRoot("MenuPrincipal");
        }
    }



    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
}