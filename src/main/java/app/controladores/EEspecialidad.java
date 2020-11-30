package app.controladores;

import app.App;
import app.Especialidad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EEspecialidad implements Initializable {
    @FXML
    public TextField textCodigoE;
    @FXML
    public TextField textModificado;
    @FXML
    public ChoiceBox chiOpcion;
    @FXML
    public Label warningMessageGenral;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chiOpcion.getItems().removeAll(chiOpcion.getItems());
        chiOpcion.getItems().addAll("Codigo especialidad", "Encargado", "Numero entregas realizadad");
    }
    //organisar dependiendo lo que se necesite
    public void Enviar(ActionEvent event) throws IOException {
        // Informacion editar*****
        String Nit = textCodigoE.getText();
        // buscando la empresa
        Especialidad especialidadeditar = Especialidad.especialidades.get(Integer.parseInt(Nit));
        String value = (String) chiOpcion.getValue();
        String Modified = textModificado.getText();


        if (value.equals("Codigo especialidad")){
            boolean exito = especialidadeditar.editarcodigoespcialidad(Integer.parseInt(Modified));
            if (exito){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setContentText("se modifico correctamente" );
                alert.showAndWait();
                App.setRoot("MenuPrincipal");
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setContentText("No se modifico correctamente" );
                alert.showAndWait();
                App.setRoot("MenuPrincipal");
            }

        }else if (value.equals("Encargado")){
            boolean exito = especialidadeditar.editarencargado(Modified);
            if (exito){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setContentText("se modifico correctamente" );
                alert.showAndWait();
                App.setRoot("MenuPrincipal");
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setContentText("No se modifico correctamente" );
                alert.showAndWait();
                App.setRoot("MenuPrincipal");
            }

        }else if (value.equals("Numero entregas realizadad")){
            boolean exito = especialidadeditar.editarnumeroentregas(Integer.parseInt(Modified));
            if (exito){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setContentText("se modifico correctamente" );
                alert.showAndWait();
                App.setRoot("MenuPrincipal");
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setContentText("No se modifico correctamente" );
                alert.showAndWait();
                App.setRoot("MenuPrincipal");
            }
        }

    }




    @FXML
    private void clean(){
        textCodigoE.setText("");
        textModificado.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings(){
        warningMessageGenral.setText("");

    }
    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
}
