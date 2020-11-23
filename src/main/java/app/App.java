package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Hashtable;

/**
 * JavaFX App
 */
public class App extends Application {
    public static Hashtable<String, String> codigosSedes = new Hashtable<>();
    public static  int  semillaCodigoAutores =0;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("menu_principal"), 600, 400);
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

    public static void main(String[] args) {
        codigosSedes.put("Bogotá","23");
        codigosSedes.put("Medellín","19");
        codigosSedes.put("Manizales","17");
        codigosSedes.put("Orinoquia","13");
        codigosSedes.put("Amazonia","11");
        codigosSedes.put("Caribe","07");
        codigosSedes.put("Palmira","05");
        codigosSedes.put("Tumaco","02");

        launch();
    }

    public static String generarCodigoAutor(){
        String codigoBase = String.valueOf(semillaCodigoAutores);
        while(codigoBase.length() != 4){
            codigoBase = "0" + codigoBase;
        }
        semillaCodigoAutores++;
        return codigoBase;
    }

    public static String generarCodigoArticulo(int codigoArticulo){
        String codigoBase = String.valueOf(codigoArticulo);
        while(codigoBase.length() != 3){
            codigoBase = "0" + codigoBase;
        }
        return codigoBase;
    }

    public static String generarDigitoDeVerificacion(String codigoSede,String codigoAutor, String codigoArticulo){
        int A = Integer.parseInt(codigoSede);
        int B = Integer.parseInt(codigoAutor);
        int C = Integer.parseInt(codigoArticulo);

        int digitoVerificacion = ((A*B)/C)%9;
        return String.valueOf(digitoVerificacion);
    }

}