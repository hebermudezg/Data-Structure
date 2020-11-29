package app.controladores;

import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ELSucursal{
    @FXML
    public TextField textUNSBN;
    @FXML
    public Label warningMessageResult;
    //organisar dependiendo lo que se necesite
    public void Eliminar(ActionEvent event) throws IOException {
        cleanWarnings();
        String nit = "";
        if(textUNSBN.getText().trim().equals("") ){
            warningMessageResult.setText("¡ No pueden estar vacios !");
            return;
        }
        nit = textUNSBN.getText().trim();
        /*codigo de busqueda para eliminar
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).Nit.equals(nit)) {
                empresas.remove(i);
                System.out.println("¡ Se realizo la operacion correctamente !");
                return;
            }
        }
        alfinal poner que la operacion salio bien
         */

        clean();
    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
    @FXML
    private void clean(){
        textUNSBN.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings(){
        warningMessageResult.setText("");

    }

}