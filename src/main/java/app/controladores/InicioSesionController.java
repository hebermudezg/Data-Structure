package app.controladores;

import app.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

import static app.App.RegistrosUsuarios;

public class InicioSesionController {

    @FXML
    public TextField textDoCorreo;
    @FXML
    public PasswordField textCotraseña;
    @FXML
    public Label warningMessageGeneral;

    // Iniciar sesion *************

    public void Enviar(ActionEvent event) throws IOException {
        // Limipiando lo Warnings
        cleanWarnings();
        int documento = 0;
        String contraseña = "",entrada = "";
        if(textDoCorreo.getText().trim().equals("") ||textCotraseña.getText().trim().equals("")){
            warningMessageGeneral.setText("¡No pueden estar vacios !");
            return;
        }
        contraseña = textCotraseña.getText().trim(); //opteniendo contraseña
        entrada = textDoCorreo.getText().trim(); // opteniendo correo
        Usuario inicio = null;
        Stack<Integer> pila = new Stack<>();
        String f = "";
        // verificando la arroba
        for (int i = 0; i < entrada.length(); i++) {
            f = entrada.substring(i, i + 1);
            if (f.equals("@")) {
                pila.push(i);
            }
        }
        if (pila.empty() != true) {
            for (Usuario RegistroUsuario : RegistrosUsuarios) {
                if (RegistroUsuario.correo.equals(entrada)) {
                    inicio = RegistroUsuario;
                    break;
                }
            }
        }  else if (isNumeric(entrada)) {
            documento = Integer.parseInt(entrada);
            for (Usuario RegistroUsuario : RegistrosUsuarios) {
                if (RegistroUsuario.documento == documento) {
                    inicio = RegistroUsuario;
                    break;
                }
            }
        }

        if (inicio == null) {
            warningMessageGeneral.setText("El documento o correo no fueron encontrados");
            return;
        } else if (!inicio.contraseña.equals(contraseña)) {
            warningMessageGeneral.setText("La contraseña es incorrecta");
            return;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inicio de sesion");
            alert.setHeaderText("Hola " + inicio.nombre);
            alert.setContentText("Bienvenido al sistema Empresa de entregas" );
            alert.showAndWait();
            clean();

            app.App.setRoot("MenuPrincipal");
        }



    }

    private void cleanWarnings(){
        warningMessageGeneral.setText("");
    }

    // Limpiar texts
    @FXML
    private void clean(){
        textDoCorreo.setText("");
        textCotraseña.setText("");
        cleanWarnings();
    }


    // Cerrar la ventana del IniciodSesion
    @FXML
    public Button  Buttonsalir;

    @FXML
    private void ButtonsalirAction(){
        Stage stage = (Stage) Buttonsalir.getScene().getWindow();
        stage.close();
    }

    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }




}
