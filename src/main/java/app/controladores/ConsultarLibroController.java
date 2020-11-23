package app.controladores;

import app.App;
import app.Libro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.IOException;

public class ConsultarLibroController {
    @FXML
    public TextField textUNSBN;
    @FXML
    public Label textResult;
    @FXML
    public Label warningMessageGeneral;
    @FXML
    private void enviar(ActionEvent event) throws IOException {
        warningMessageGeneral.setText("");
        if(textUNSBN.getText().equals("")){
            warningMessageGeneral.setText("No puede estar vacio el UNSBN");
            return;
        }

        try{
            Integer.parseInt(textUNSBN.getText().trim());
        }catch (Exception e){
            warningMessageGeneral.setText("El codigo UNSBN tiene que ser un numero");
            return;
        }

        if(textUNSBN.getText().length() != 10){
            warningMessageGeneral.setText("El codigo UNSBN es un numero de 10 digitos");
            return;
        }
        if(Libro.libros.containsKey(textUNSBN.getText())){
            textResult.setText("El libro consultado : \n"+Libro.libros.get(textUNSBN.getText()));
        }else{
            textResult.setText("¡ No se encontro el resultado ! :( ");
        }
    }

    @FXML
    private void volver() throws IOException {
        App.setRoot("menu_principal");
    }
}
