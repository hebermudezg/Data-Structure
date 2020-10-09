
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class LeerJSON {
    // Leer Usuarios *******************************************************
    public static LinkedList<Usuario> leerUsuariosJson(){
        LinkedList<Usuario> usuariosLeidos = new LinkedList<>();
        JSONParser jsonParser = new JSONParser(); //
        try (FileReader reader = new FileReader(EscribirJSON.ruta+"UsuariosJSON.json"))   {
            Object obj = jsonParser.parse(reader);
            JSONArray ListaUsuarios = (JSONArray)obj ;
            // Iprimiendo *****************************************
            System.out.println(ListaUsuarios);

            for(Object usuarioObjeto : ListaUsuarios){
                JSONObject usuarioJSON = (JSONObject) usuarioObjeto;
                usuariosLeidos.add(parseUsuario(usuarioJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return usuariosLeidos;
    }

    private static Usuario parseUsuario(JSONObject usuarioJSON)
    {
        JSONObject atributos = (JSONObject) usuarioJSON.get("Usuario");

        int documento = Integer.parseInt((String) atributos.get("documento"));
        String nombre = (String) atributos.get("nombre");
        String apellido = (String) atributos.get("apellido");
        String correo = (String) atributos.get("correo");
        String contraseña = (String) atributos.get("contraseña");

        Usuario usuarioLeido = new Usuario(documento,nombre,apellido,correo,contraseña);
        return usuarioLeido;
    }


    // Leer Empresas*****************************************************
    public static LinkedList<Empresa> leerEmpresasJson(){
        LinkedList<Empresa> empresasLeidas = new LinkedList<>();
        JSONParser jsonParserempresa = new JSONParser(); //
        try (FileReader reader = new FileReader(EscribirJSON.ruta+"EmpresasJSON.json"))   {
            Object obj = jsonParserempresa.parse(reader);
            JSONArray ListaEmpresas = (JSONArray)obj ;
            // Iprimiendo *****************************************
            System.out.println(ListaEmpresas);

            for(Object empresaObjeto : ListaEmpresas){
                JSONObject empresaJSON = (JSONObject) empresaObjeto;
                empresasLeidas.add(parseEmpresa(empresaJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return empresasLeidas;
    }

    private static Empresa parseEmpresa(JSONObject empresaJSON)
    {
        JSONObject atributos = (JSONObject) empresaJSON.get("Empresa");
        int Nit = Integer.parseInt((String) atributos.get("Nit"));
        String RazonSocial = (String) atributos.get("RazonSocial");
        String Presidente = (String) atributos.get("Presidente");

        Empresa empresaaLeida = new Empresa(Nit,RazonSocial,Presidente);
        return empresaaLeida;
    }



}
