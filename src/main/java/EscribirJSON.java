import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.util.LinkedList;

// Escribir json que solo escribe usuaios
public class EscribirJSON {
    public static String ruta = "src/main/resources/database/";

    // Funcion para guardar usuarios
    public static void guardarUsuario(LinkedList<Usuario> usuarios) {
        JSONArray UsuarioLista = new JSONArray();
        for (Usuario usuario : usuarios) {
            JSONObject UsuarioDatos = new JSONObject();
            UsuarioDatos.put("documento", String.valueOf(usuario.documento));
            UsuarioDatos.put("nombre", usuario.nombre);
            UsuarioDatos.put("apellido", usuario.apellido);
            UsuarioDatos.put("correo", usuario.correo);
            UsuarioDatos.put("contraseña", usuario.contraseña);
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

    // Funcion para guardar empresas
    public static void guardarEmpresa(LinkedList<Empresa> empresas) {
        JSONArray EmpresaLista = new JSONArray();
        for (Empresa empresa : empresas) {
            JSONObject EmpresaDatos = new JSONObject();
            EmpresaDatos.put("Nit", String.valueOf(empresa.Nit));
            EmpresaDatos.put("RazonSocial", empresa.RazonSocial);
            EmpresaDatos.put("Presidente", empresa.Presidente);
            JSONObject EmpresaPerfil = new JSONObject();
            EmpresaPerfil.put("Empresa", EmpresaDatos); //Esrbiendo el usuario
            EmpresaLista.add(EmpresaPerfil);
        }

        try (FileWriter file = new FileWriter(ruta+"EmpresasJSON.json")) {
            file.write(EmpresaLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }


}

