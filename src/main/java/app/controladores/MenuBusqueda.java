package app.controladores;
import app.App;
import app.Empresa;
import app.Especialidad;
import app.Sucursal;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class MenuBusqueda implements Initializable {

    public static String selectMenu;

    @FXML
    public ChoiceBox ChoiceEntidad;

    @FXML
    public ChoiceBox ChoiceAtrubuto;

    @FXML
    public TextField valor;

    @FXML
    public ListView  listview;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChoiceEntidad.getItems().removeAll(ChoiceEntidad.getItems());
        ChoiceAtrubuto.getItems().removeAll(ChoiceAtrubuto.getItems());
        ChoiceEntidad.setItems(FXCollections.observableArrayList("Empresa", "Sucursal", "Especialidad"));
        ChoiceEntidad.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                selectMenu = (String) ChoiceEntidad.getValue();
                if (newValue.intValue() == 0) {
                    ChoiceAtrubuto.setItems(FXCollections.observableArrayList("Nit", "Valor en la bolsa", "Razón social"));
                } else if (newValue.intValue() == 1) {
                    ChoiceAtrubuto.setItems(FXCollections.observableArrayList("Codigo", "Ciudad", "Cantidad de empleados"));
                } else if (newValue.intValue() == 2) {
                    ChoiceAtrubuto.setItems(FXCollections.observableArrayList("Codigo", "Encargado", "Número de entregas"));
                }

            }
        });
    }

    public void Buscar(ActionEvent event) throws IOException {
        listview.getItems().clear(); // limpiando
        if ("Empresa".equals((String) ChoiceEntidad.getValue())) {
            if ("Nit".equals((String) ChoiceAtrubuto.getValue())) {
               listview.getItems().add(Empresa.empresas.get(valor.getText()));
            } else if ("Valor en la bolsa".equals((String) ChoiceAtrubuto.getValue())) {
                LinkedList<Empresa> empresasamostrar = Empresa.valores_en_bolsa_busqueda.get(Integer.parseInt(valor.getText()));
                for (Empresa empresa : empresasamostrar) {
                    listview.getItems().add(empresa);
                }

            } else if ("Razón social".equals((String) ChoiceAtrubuto.getValue())){
                LinkedList<Empresa> empresasamostrar = Empresa.RazonSocial_busqueda.get(valor.getText().toLowerCase());
                for (Empresa empresa : empresasamostrar) {
                    listview.getItems().add(empresa);
                }
            }



        }else if("Sucursal".equals((String) ChoiceEntidad.getValue())){
            if ("Codigo".equals((String) ChoiceAtrubuto.getValue())) {
                listview.getItems().add(Sucursal.sucursales.get(valor.getText()));


            } else if ("Ciudad".equals((String) ChoiceAtrubuto.getValue())) {
                LinkedList<Sucursal> sucursalesamostrar = Sucursal.ciudad_busqueda.get(valor.getText().toLowerCase());
                for (Sucursal sucursal : sucursalesamostrar) {
                    listview.getItems().add(sucursal);
                }

            } else if ("Cantidad de empleados".equals((String) ChoiceAtrubuto.getValue())){
                LinkedList<Sucursal> sucursalesamostrar = Sucursal.cantEmpleados_busqueda.get(Integer.parseInt(valor.getText()));
                for (Sucursal sucursal : sucursalesamostrar) {
                    listview.getItems().add(sucursal);
                }
            }

        }else if("Especialidad".equals((String) ChoiceEntidad.getValue())){
            if ("Codigo".equals((String) ChoiceAtrubuto.getValue())) {
                listview.getItems().add(Especialidad.especialidades.get(valor.getText()));

            } else if ("Encargado".equals((String) ChoiceAtrubuto.getValue())) {
                LinkedList<Especialidad> sucursalesamostrar = Especialidad.encargados_buscar.get(valor.getText().toLowerCase());
                for (Especialidad especialidad : sucursalesamostrar) {
                    listview.getItems().add(especialidad);
                }

            } else if ("Número de entregas".equals((String) ChoiceAtrubuto.getValue())){
                LinkedList<Especialidad> sucursalesamostrar = Especialidad.numero_entregas_buscar.get(Integer.parseInt(valor.getText()));
                for (Especialidad especialidad : sucursalesamostrar) {
                    listview.getItems().add(especialidad);
                }
            }

        }
    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
}











