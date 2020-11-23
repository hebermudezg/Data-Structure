package app.controladores;

import app.App;
import app.Autor;
import app.Libro;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IngresarLibroController implements Initializable {
    @FXML
    private ChoiceBox choiceBoxCiudad;
    @FXML
    private TextField textCedula;
    @FXML
    private TextField textGenero;
    @FXML
    private TextField textNumeroPaginas;
    @FXML
    private TextField textNumeroArticulo;
    @FXML
    private TextField textNombre;

    @FXML
    private Label warningMessageCiudad;
    @FXML
    private Label warningMessageCedula;
    @FXML
    private Label warningMessageNumeroPaginas;
    @FXML
    private Label warningMessageNumeroArticulo;
    @FXML
    private Label warningMessageGeneral;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBoxCiudad.setItems(FXCollections.observableList(new ArrayList<>(App.codigosSedes.keySet())));

    }

    @FXML
    private void enviar(ActionEvent event) throws IOException {
        cleanWarnings();

        String ciudad, cedula, genero,nombre;
        int numeroPaginas, numeroArticuloInt;
        if(String.valueOf(choiceBoxCiudad.getValue()).equals("null") || textCedula.getText().trim().equals("") || textGenero.getText().trim().equals("") || textNumeroPaginas.getText().trim().equals("") || textNumeroArticulo.getText().trim().equals("") || textNombre.getText().trim().equals("")){
            warningMessageGeneral.setText("¡ Los campos no pueden estar vacios !");
            return;
        }

        ciudad = String.valueOf(choiceBoxCiudad.getValue());
        cedula = textCedula.getText().trim();
        genero = textGenero.getText().trim();
        nombre = textNombre.getText().trim();

        if(!Autor.autores.containsKey(cedula)){
            warningMessageCedula.setText("El autor no fue encontrado en el sistema");
            return;
        }

        try{
            numeroPaginas = Integer.parseInt(textNumeroPaginas.getText().trim());
        }catch (Exception e){
            warningMessageNumeroPaginas.setText("Numero de paginas tiene que ser un numero");
            return;
        }

        try{
            numeroArticuloInt = Integer.parseInt(textNumeroArticulo.getText().trim());
        }catch (Exception e){
            warningMessageNumeroArticulo.setText("Numero articulo tiene que ser un numero");
            return;
        }

        if(numeroArticuloInt<0 && numeroArticuloInt > 999){
            warningMessageNumeroArticulo.setText("El codigo valido esta entre 0 y 999 inclusive");
            return;
        }

        if(numeroPaginas<1){
            warningMessageNumeroArticulo.setText("Numero de paginas invalido, debe ser un numero mayor a 0");
            return;
        }

        Autor autorDelLibro =Autor.autores.get(cedula);
        String codigoSede = App.codigosSedes.get(ciudad);
        String codigoAutor = autorDelLibro.codigoUnicoAutor;
        String codigoArticulo =App.generarCodigoArticulo(numeroArticuloInt);
        String digitoVerificacion = App.generarDigitoDeVerificacion(codigoSede,codigoAutor,codigoArticulo);


        String UNSBN = codigoSede+codigoAutor+codigoArticulo+digitoVerificacion;
        if(Libro.libros.containsKey(UNSBN)){
            warningMessageNumeroArticulo.setText("El UNSBN generado no es valido, ingrese otro numero de articulo");
            warningMessageGeneral.setText("USBN generado : "+ UNSBN);
            return;
        }

        Libro nuevoLibro = new Libro(UNSBN,nombre,genero,numeroPaginas,autorDelLibro);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creacion satisfactoria");
        alert.setHeaderText("Creacion satisfactoria");
        alert.setContentText("Se ha ingresado el libro satisfactoriamente:\n" + nuevoLibro);
        alert.showAndWait();

        clean();

    }


    @FXML
    private void volver(ActionEvent event) throws IOException {
        clean();
        App.setRoot("menu_principal");
    }

    @FXML
    private void clean(){
        textCedula.setText("");
        textNombre.setText("");
        textGenero.setText("");
        textNumeroPaginas.setText("");
        textNumeroArticulo.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings(){
        warningMessageCiudad.setText("");
        warningMessageCedula.setText("");
        warningMessageNumeroPaginas.setText("");
        warningMessageNumeroArticulo.setText("");
        warningMessageGeneral.setText("");
    }
}
