package app.controladores;
import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import static app.App.selecionAccion;
import static app.App.selecionEntidad;


public class SelecionarEntidad {
    @FXML
    public void routeEmpresa(ActionEvent event) throws IOException {
        if(selecionAccion==0) {
            selecionEntidad=0;
            App.setRoot("MenuAdministracion");
        }else if (selecionAccion== 1) {
            selecionEntidad=0;
            App.setRoot("MenuBusqueda");
        }
    }

    @FXML
    public void routeSucursal(ActionEvent event) throws IOException {
        if(selecionAccion==0) {
            selecionEntidad=1;
            App.setRoot("MenuAdministracion");
        }else if (selecionAccion== 1) {
            selecionEntidad=1;
            App.setRoot("MenuBusqueda");
        }
    }

    @FXML
    public void routeEspecialidad(ActionEvent event) throws IOException {
        if(selecionAccion==0) {
            selecionEntidad=2;
            App.setRoot("MenuAdministracion");
        }else if (selecionAccion == 1) {
            selecionEntidad = 2;
            App.setRoot("MenuBusqueda");
        }
    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
}
