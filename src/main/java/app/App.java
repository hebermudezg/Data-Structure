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
        Usuario nuevousuario = new Usuario(1,"admin","apell", "admin@","123");
        RegistrosUsuarios.add(nuevousuario);






        launch();
    }






}