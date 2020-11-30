package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.IOException;
import java.util.LinkedList;

/**
 * JavaFX App
 */
public class App extends Application {

    // Linked para guardar el unico usuario
    public static LinkedList<Usuario> RegistrosUsuarios = new LinkedList<>();

    public static int atributoBusqueda = 0;
    public static int selecionEntidad = 0;
    public static int selecionAccion = 0;
    public static int opcionAdministracion = 0;




    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("InicioSesion"), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    // grafo, Object: vertice, tipo de arista, DefaultEdge.class:clase par las aristas
    public static Graph<Object, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);


    public static void main(String[] args) {
        // Quemando el usuario (agragando en la linked)
        Usuario nuevousuario = new Usuario(1,"admin","apell", "admin@",
                "123");
        RegistrosUsuarios.add(nuevousuario);

        // Empresas
        Empresa empresa0 = new Empresa("123", 200000, "Envios Rapifacil");
        Empresa empresa1 = new Empresa("123456", 200000, "Envios Joselito");
        Empresa empresa2 = new Empresa("911456", 500000, "Logistica Triple A");
        Empresa empresa3 = new Empresa("912456", 200000, "Envios Integrados SAS");

        // Sucursales
        Sucursal sucursal1 = new Sucursal(123, "Ibagué", 200,empresa1);
        Sucursal sucursal2 = new Sucursal(124, "Bogotá", 200,empresa1);
        Sucursal sucursal3 = new Sucursal(125, "Cartgena", 200,empresa1);
        Sucursal sucursal4 = new Sucursal(126, "Barranquilla", 800,empresa1);
        Sucursal sucursal5 = new Sucursal(127, "Medellín", 100,empresa1);

        // Especialidades
        Especialidad especialidad1 = new Especialidad(982, "Esteban Bermudez",
                2000, sucursal1);
        Especialidad especialidad2 = new Especialidad(983, "Juan Maldonado",
                2000, sucursal1);
        Especialidad especialidad3 = new Especialidad(984, "Esteban Bermudez",
                2000, sucursal2);
        Especialidad especialidad4 = new Especialidad(985, "Juanes Aristizabal",
                3000, sucursal3);
        launch();
    }

}