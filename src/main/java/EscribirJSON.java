import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.util.LinkedList;

// Escribir json que solo escribe usuaios
public class EscribirJSON {
    public static String ruta = "src/main/resources/database/";

    // Funcion para guardar usuarios
    public static void guardarUsuario(LinkedList<Usuario> usuarios) {
        JSONObject UsuarioDatos = new JSONObject();
        JSONArray UsuarioLista = new JSONArray();
        for (Usuario usuario : usuarios) {
            UsuarioDatos.put("Documento", String.valueOf(usuario.Documento));
            UsuarioDatos.put("Nombre", usuario.Nombre);
            UsuarioDatos.put("Apellido", usuario.Apellido);
            UsuarioDatos.put("Correo", usuario.Correo);
            UsuarioDatos.put("Contraseña", usuario.Contraseña);
            JSONObject UsuarioPerfil = new JSONObject();
            UsuarioPerfil.put("Usuario", UsuarioDatos); //Esrbiendo el usuario
            UsuarioLista.add(UsuarioPerfil);
        }

        try (FileWriter file = new FileWriter(ruta+"UsuariosJSON.json")) {
            file.write(UsuarioLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }

}

