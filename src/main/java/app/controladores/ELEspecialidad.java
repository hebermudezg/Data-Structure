package app.controladores;

import app.App;
import app.Especialidad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ELEspecialidad {
    @FXML
    public TextField textElimiEspeci;
    @FXML
    public Label warningMessageResult;


    //organisar dependiendo lo que se necesite
    public void Eliminar(ActionEvent event) throws IOException {
        String Nit = textElimiEspeci.getText();
        Especialidad expressed = Especialidad.especialidades.get(Integer.parseInt(Nit));
        expressed.eliminarespecialidad();
    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
    @FXML
    private void clean(){
        textElimiEspeci.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings(){
        warningMessageResult.setText("");

    }

}