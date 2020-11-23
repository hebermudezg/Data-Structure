package app.controladores;
import app.App;
import app.Autor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class IngresarAutorController {

    @FXML
    public TextField textCedula;
    @FXML
    public TextField textNombre;
    @FXML
    public TextField textEdad;

    @FXML
    public Label warningMessageCedula;
    @FXML
    public Label warningMessageNombre;
    @FXML
    public Label warningMessageEdad;
    @FXML
    public Label warningMessageGeneral;

    @FXML
    public void enviar(ActionEvent event) throws IOException {
        cleanWarnings();
        int edad;
        String cedula = "",nombre = "";
        if(textCedula.getText().trim().equals("") || textEdad.getText().trim().equals("") || textNombre.getText().trim().equals("")){
            warningMessageGeneral.setText("¡ Los campos no pueden estar vacios !");
            return;
        }
        cedula = textCedula.getText().trim();
        nombre = textNombre.getText().trim();
        try{
            edad = Integer.parseInt(textEdad.getText().trim());
        }catch (Exception e){
            warningMessageEdad.setText("La edad tiene que ser un numero");
            return;
        }
        if(edad < 5){
            warningMessageEdad.setText("La edad no es valida");
            return;
        }
        if(Autor.autores.containsKey(cedula)){
            warningMessageCedula.setText("La cedula ya se encuentra registrada");
            return;
        }
        Autor nuevoAutor = new Autor(cedula,nombre,edad,App.generarCodigoAutor());


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creacion satisfactoria");
        alert.setHeaderText("Creacion satisfactoria");
        alert.setContentText("Se ha ingresado el autor satisfactoriamente:\n" + nuevoAutor.toString());
        alert.showAndWait();
        clean();
    }


    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("menu_principal");
    }

    @FXML
    private void clean(){
        textEdad.setText("");
        textNombre.setText("");
        textCedula.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings(){
        warningMessageCedula.setText("");
        warningMessageEdad.setText("");
        warningMessageNombre.setText("");
        warningMessageGeneral.setText("");
    }


}
