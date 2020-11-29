package app.controladores;
import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static app.App.selecionEntidad;


public class MenuAdministracion implements Initializable {
    @FXML
    public Label textTitulo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (selecionEntidad==0) {
            textTitulo.setText("EMPRESAS");
        }else if (selecionEntidad==1) {
            textTitulo.setText("SUCURSALES");
        }else if (selecionEntidad==2) {
            textTitulo.setText("ESPECIALIDADES");
        }
    }

    @FXML
    public void routeVer(ActionEvent event) throws IOException {
        if (selecionEntidad==0) {
            App.setRoot("VEmpresa");
        }else if (selecionEntidad==1) {
            App.setRoot("VSucursal");
        }else if (selecionEntidad==2) {
            App.setRoot("VEspecialidad");
        }
    }

    @FXML
    public void routeCrear(ActionEvent event) throws IOException {
        if (selecionEntidad==0) {
            App.setRoot("CEmpresa");
        }else if (selecionEntidad==1) {
            App.setRoot("CSucursal");
        }else if (selecionEntidad==2) {
            App.setRoot("CEspecialidad");
        }
    }
    @FXML
    public void routeEliminar(ActionEvent event) throws IOException {
        if (selecionEntidad==0) {
            App.setRoot("ELEmpresa");
        }else if (selecionEntidad==1) {
            App.setRoot("ELSucursal");
        }else if (selecionEntidad==2) {
            App.setRoot("ELEspecialidad");
        }
    }
    @FXML
    public void routeEditar(ActionEvent event) throws IOException {
        if (selecionEntidad==0) {
            App.setRoot("EEmpresa");
        }else if (selecionEntidad==1) {
            App.setRoot("ESucursal");
        }else if (selecionEntidad==2) {
            App.setRoot("EEspecialidad");
        }
    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
}
