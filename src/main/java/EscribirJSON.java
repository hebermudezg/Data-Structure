import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.util.LinkedList;

// Escribir json que solo escribe usuaios
public class EscribirJSON {
    public static String ruta = "src/main/resources/database/";

    // Funcion para guardar usuarios
    public static void guardarUsuario(LinkedList<Usuario> usuario){
        JSONObject UsuarioDatos = new JSONObject();
        //UsuarioDatos.put("Documento", String.valueOf(usuario.get(1)));

        UsuarioDatos.put("Documento", String.valueOf(usuario.Documento));
        UsuarioDatos.put("Nombre", usuario.Nombre);
        UsuarioDatos.put("Apellido", usuario.Apellido);
        UsuarioDatos.put("Correo", usuario.Correo);
        UsuarioDatos.put("Contraseña", usuario.Contraseña);
        JSONObject UsuarioPerfil = new JSONObject();
        UsuarioPerfil.put("Usuario", UsuarioDatos); //Esrbiendo el usuario


        JSONArray UsuarioLista = new JSONArray();
        UsuarioLista.add(UsuarioPerfil);



        try (FileWriter file = new FileWriter(ruta+"UsuariosJSON.json")) {
            file.write(UsuarioLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }

}

/*
 JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", 100);

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        // Escribir el archivo
        try (FileWriter file = new FileWriter("src/main/resources/database/usuarios.json")) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(obj);
 */