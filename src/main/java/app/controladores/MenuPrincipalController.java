package app.controladores;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import static app.App.selecionAccion;


public class MenuPrincipalController {
    @FXML
    public Button closeButton;
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void routeAministra(ActionEvent event) throws IOException {
        selecionAccion=0;
        app.App.setRoot("SelecionarEntidad");
    }

    public void routeBusqueda(ActionEvent event) throws IOException {
        selecionAccion=1;
        app.App.setRoot("SelecionarEntidad");
    }

}
