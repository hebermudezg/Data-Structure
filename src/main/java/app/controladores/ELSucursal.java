package app.controladores;

import app.App;
import app.Sucursal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ELSucursal{
    @FXML
    public TextField textElimiSucur;

    @FXML
    public Label warningMessageResult;


    public void Eliminar(ActionEvent event) throws IOException {
        String codsucursal = textElimiSucur.getText().trim();
        Sucursal sucursaleditar = Sucursal.sucursales.get(Integer.parseInt(codsucursal));
        sucursaleditar.eliminarsucursal();

    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }


}